package com.letchic.swap;

import java.util.List;
import java.util.RandomAccess;

public class Swap {

    public static void swap(List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            swapHelper(list, i, j);
        } else {
            nonRandomSwapHelper(list, i, j);
        }
    }
    private static <T> void swapHelper(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    private static <T> void nonRandomSwapHelper(List<T> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
