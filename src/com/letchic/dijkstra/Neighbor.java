package com.letchic.dijkstra;

public class Neighbor implements Comparable<Neighbor> {
    long dist;
    int v;

    public Neighbor(long prio, int v) {
        this.dist = prio;
        this.v = v;
    }
    public int compareTo(Neighbor q) {
        return dist < q.dist ? -1 : dist > q.dist ? 1 : 0;
    }
}