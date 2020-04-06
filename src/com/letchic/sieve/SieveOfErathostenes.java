package com.letchic.sieve;

import java.util.*;

public class SieveOfErathostenes {
    public static List<Integer> sieve(int n) {
        BitSet A = new BitSet(n);
        for (int i = 0; i < n; i++) {
            A.set(i, true);
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (A.get(i)) {
                for (int j = i * i, k = 0; j <= n; k++, j = (i * i)+(k * i)) {
                    A.set(j, false);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (A.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static Set<Integer> sieveWithHash(int n) {
        Set<Integer> result = new HashSet<>();
        for (int i = 2; i < n; i++) {
            result.add(i);
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (result.contains(i)) {
                for (int j = i * i, k = 0; j <= n; k++, j = (i * i)+(k * i)) {
                    result.remove(j);
                }
            }
        }
        return result;
    }

}