package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = {"мама", "тато", "їж їжак желе"};
        Set<Character> uniqueLetters = findUniqueLetters(words);
        System.out.println(uniqueLetters);
    }

    public static Set<Character> findUniqueLetters(String[] words) {
        Set<Character> uniqueLetters = new HashSet<>();

        // Знаходимо перші два слова, в яких кожна літера трапляється парну кількість разів
        int count = 0;
        for (int i = 0; i < words.length && count < 2; i++) {
            String word = words[i];
            count = 0;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                int letterCount = countOccurrences(word, ch);
                if (letterCount % 2 != 0) {
                    count = 0;
                    break;
                }
                count++;
            }
        }

        // Знаходимо набір унікальних символів у словах
        if (count >= 2) {
            for (String word : words) {
                char[] chars = word.toCharArray();
                for (char ch : chars) {
                    uniqueLetters.add(ch);
                }
            }
        }

        return uniqueLetters;
    }

    private static int countOccurrences(String word, char target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
}
