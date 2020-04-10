package com.letchic.dijkstra;

import java.util.*;

public class Dijkstra {
    private static int endPoint, firstPoint;
    public static final long INF = Long.MAX_VALUE / 10;

    public static void dijkstra(int[][] arr, String[] citiNames, String start, String end) {

        int n = arr.length;
        Graph graph = new Graph(n);
        for (int i = 0; i < n; i++) {
            if (citiNames[i].equals(start)) firstPoint = i;
            if (citiNames[i].equals(end)) endPoint = i;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    graph.addEdge(i, j, arr[i][j]);
                }
            }
        }

        long[] prio = new long[graph.n];
        int[] pred = new int[graph.n];

        Arrays.fill(pred, -1);
        Arrays.fill(prio, INF);
        prio[firstPoint] = 0;
        Queue<Neighbor> q = new PriorityQueue<Neighbor>();
        q.add(new Neighbor(0, firstPoint));
        while (!q.isEmpty()) {
            Neighbor cur = q.poll();
            if (cur.dist != prio[cur.v]) {
                continue;
            }

            for (Edge e : graph.nodeEdges[cur.v]) {
                long nprio = prio[cur.v] + e.cost;
                if (prio[e.to] > nprio) {
                    prio[e.to] = nprio;
                    pred[e.to] = cur.v;
                    q.add(new Neighbor(nprio, e.to));
                }
            }
        }

        System.out.println("Shortest path: " + prio[endPoint]);
        printPath(pred, endPoint, citiNames);
    }

    public static void printPath(int[] map, int point, String[] citiNames) {
        StringBuilder result = new StringBuilder();
        while (true) {
            result.insert(0, citiNames[point]);
            point = map[point];
            if (point < 0) {
                break;
            }
            result.insert(0, " - ");
        }
        System.out.print(result);
    }
}