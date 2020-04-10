package com.letchic;

import com.letchic.dijkstra.Dijkstra;
import com.letchic.scanfile.WordInLine;
import com.letchic.scanfile.WordOccurence;
import com.letchic.sieve.SieveOfErathostenes;
import com.letchic.swap.Swap;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Ex1
        System.out.println(SieveOfErathostenes.sieve(100));
        System.out.println(SieveOfErathostenes.sieveWithHash(100));

        //Ex5
        Swap s = new Swap();
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        Swap.swap(letters, 1, 2);
        System.out.println(letters);

        List<Integer> primes = new LinkedList<>();
        primes.add(5);
        primes.add(7);
        primes.add(11);
        Swap.swap(primes, 1, 2);
        System.out.println(primes);

        //Ex6
        Map<String, Set<Integer>> content = new HashMap<>();
        HashSet<Integer> pages = new HashSet<>();
        pages.add(1);
        pages.add(2);
        pages.add(3);
        content.put("First catalog",pages);

        //Ex7
        WordOccurence.wordOcc("Война и мир. Том 1.txt");

        //Ex8
        WordInLine.print("Война и мир. Том 1.txt");

        //Ex10
         final int [][] arr =  {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

         final String[] citiNames = { "Paris",
                "London",
                "New York",
                "Moscow",
                "Berlin",
                "Bagdad",
                "Tel Aviv",
                "Praga",
                "Beijing",
                "San Francisco" };

        Dijkstra.dijkstra(arr, citiNames, "Moscow", "Tel Aviv");


    }
}