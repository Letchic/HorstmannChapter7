package com.letchic.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public final int n;
    public List<Edge>[] nodeEdges;

    public Graph(int n) {
        this.n = n;
        nodeEdges = new List[n];
        for (int i = 0; i < n; i++) {
            nodeEdges[i] = new ArrayList<Edge>();
        }
    }

    void addEdge(int s, int t, int cost) {
        nodeEdges[s].add(new Edge(s, t, cost));
    }
}
