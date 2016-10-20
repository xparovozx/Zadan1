/**
 * Created by Vlad on 14.10.2016.
 */
package com.xparovozx.Zadan1;

import java.util.Scanner;
import java.util.List;

public class Zadan1 {

    private static OrGraf readFromStdIn(Scanner scanner) {
        OrGraf OrGraf = new OrGraf();
        while (scanner.hasNextLine()) {
            String[] ids = scanner.nextLine().split("\\s");

            int begId = Integer.parseInt(ids[0]);
            int endId = Integer.parseInt(ids[1]);
            OrGraf.addEdge(new Vershina<Integer>(begId, begId), new Vershina<Integer>(endId, endId));
        }
        return OrGraf;
    }


    private static void writeToStdOut(List<List<Integer>> cycles) {
        for (List<Integer> path : cycles) {
            for (int item : path)
                System.out.print(item + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            OrGraf OrGraf = readFromStdIn(scanner);

            poiskVgluTsikl finder = new poiskVgluTsikl();
            List<List<Integer>> cycles = finder.getCycles(OrGraf);

            writeToStdOut(cycles);
        } catch (Exception error) {
            error.printStackTrace(System.err);
        }
    }
}

