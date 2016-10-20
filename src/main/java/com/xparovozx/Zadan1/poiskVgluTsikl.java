package com.xparovozx.Zadan1;

/**
 * Created by Vlad on 14.10.2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class poiskVgluTsikl {
    private Map<Integer, Integer> colors;
    private OrGraf OrGraf;
    private void setAllColors(Set<Integer> vertIds, int color) {
        for (int id : vertIds)
            if (colors.containsKey(id))
                colors.replace(id, color);
            else
                colors.put(id, color);
    }
    private List<List<Integer>> result;


    public List<List<Integer>> getCycles(OrGraf diGraph)
    {
        this.OrGraf = diGraph;
        colors = new HashMap<Integer, Integer>();
        result = new ArrayList<List<Integer>>();
        Set<Integer> ids = diGraph.getAllVertices().keySet();
        for (int verId: ids) {
            setAllColors(ids, 1);
            depthFirstSearchForCycles(verId, verId, new ArrayList<Integer>());
        }
        return result;
    }


    private void depthFirstSearchForCycles(int begId, int endId, List<Integer> cycle) {
        if (begId != endId)
            colors.replace(begId, 2);
        else if (cycle.size() > 0) {
            if (!resultContainsSuchCycle(cycle)) {
                cycle.add(0, cycle.get(cycle.size()-1));
                result.add(cycle);
            }
            return;
        }
        for (Integer vertId : OrGraf.getAdjacentVerticesIds(begId))
            if (colors.get(vertId) == 1) {
                List<Integer> cycleNew = new ArrayList<Integer>(cycle);
                cycleNew.add(vertId);
                depthFirstSearchForCycles(vertId, endId, cycleNew);
                colors.replace(vertId, 1);
            }
    }

    /**
     * Содержатся ли все элементы pathA в pathB и содержатся ли все элементы pathB в pathA
     * @param pathA Список A
     * @param pathB Список B
     */
    private boolean pathComp(List<Integer> pathA, List<Integer> pathB) {
        for (int item : pathA)
            if (!pathB.contains(item))
                return false;
        for (int item : pathB)
            if (!pathA.contains(item))
                return false;
        return true;
    }

    /**
     * Содержит ли результирующий список циклов цикл cycle
     * @param cycle Цикл
     */
    private boolean resultContainsSuchCycle(List<Integer> cycle) {
        for (List<Integer> path : result)
            if (pathComp(path, cycle))
                return true;
        return false;
    }
}
