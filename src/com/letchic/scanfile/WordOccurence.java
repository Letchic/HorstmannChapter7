package com.letchic.scanfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordOccurence {
    public static void wordOcc(String path) {
        Map<String, Integer> counts = new TreeMap<>();
        try {
            String str = null;
            BufferedReader breader = new BufferedReader(new FileReader(path));
            while ((str = breader.readLine()) != null) {
                for (String word : str.split(" ")) {
                    counts.merge(word.toLowerCase(), 1, Integer::sum);
                }
            }
            breader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        counts.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
