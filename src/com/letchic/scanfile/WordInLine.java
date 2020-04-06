package com.letchic.scanfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordInLine {
    public static void print(String path) {
        Map<String, Set<Integer>> words = new HashMap<>();
        int lineno = 1;
        String line = null;
        try {
            BufferedReader breader = new BufferedReader(new FileReader(path));
            while ((line = breader.readLine()) != null) {
                for (String word : line.split("\\W+")) {
                    word = word.toLowerCase();
                    if (!words.containsKey(word)) {
                        Set<Integer> lines = new TreeSet<>();
                        lines.add(lineno);
                        words.put(word, lines);
                    } else {
                        words.get(word).add(lineno);
                    }
                }
                lineno++;
            }

            words.forEach((k, v) -> {
                System.out.println("word: " + k);
                String sep = "";
                for (int str : v) {
                    System.out.printf("%s%d", sep, str);
                    sep = ", ";
                }
                System.out.println();
            });
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
