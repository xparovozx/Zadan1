package com.xparovozx.Zadan1;

/**
 * Created by Vlad on 14.10.2016.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class OrGraf {

    private Map<Integer, Vershina> vertices = new HashMap();

    private Map<Integer, List<Integer>> adjacency = new HashMap();

    public void addEdge(Vershina<Integer> begVert, Vershina<Integer> endVert) {
        if (!containsEdge(begVert.getId(), endVert.getId()))
        {
            if (!vertices.containsKey(begVert.getId()))
                vertices.put(begVert.getId(), begVert);
            if (!adjacency.containsKey(begVert.getId()))
                adjacency.put(begVert.getId(), new ArrayList<Integer>());
            if (!vertices.containsKey(endVert.getId()))
                vertices.put(endVert.getId(), endVert);
            if (!adjacency.containsKey(endVert.getId()))
                adjacency.put(endVert.getId(), new ArrayList<Integer>());
            adjacency.get(begVert.getId()).add(endVert.getId());
        }
    }


    public boolean containsEdge(int begId, int endId) {
        boolean result = false;
        if (adjacency.containsKey(begId)) {
            List<Integer> adjIds = adjacency.get(begId);
            for (int item : adjIds)
                if (endId == item) {
                    result = true;
                    break;
                }
        }
        return result;
    }


    public Map<Integer, Vershina> getAllVertices() { return vertices; }


    public List<Vershina> getAdjacentVertices(int id) {
        List<Vershina> adj = new ArrayList<Vershina>();
        List<Integer> adjIds = adjacency.get(id);
        for (int adjId: adjIds) {
            adj.add(vertices.get(adjId));
        }
        return adj;
    }


    public List<Integer> getAdjacentVerticesIds(int id) {
        return adjacency.get(id);
    }
}
