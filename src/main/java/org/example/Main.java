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
        int count = 0;

        for (String word : words) {
            if (hasEvenCharacterCount(word)) {
                count++;
                for (char c : word.toCharArray()) {
                    uniqueLetters.add(c);
                }
            }
            if (count == 2) {
                break;
            }
        }

        return uniqueLetters;
    }


// метод hasEvenCharacterCount перевіряє, чи кожен символ у слові має парну кількість входжень, використовуючи множину uniqueCharacters
    private static boolean hasEvenCharacterCount(String word) {
        Set<Character> uniqueCharacters = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (uniqueCharacters.contains(c)){
                uniqueCharacters.remove(c);
            }else {
                uniqueCharacters.add(c);
            }

        }
        return uniqueCharacters.isEmpty();

    }
}
