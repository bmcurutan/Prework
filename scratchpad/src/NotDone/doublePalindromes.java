package NotDone;

// Given an array of strings, return list of strings that form a palindrome when two strings are combined
// Should be in linear time

import java.util.*;

public class doublePalindromes {
    // Brute force solution
    public static Set<String> brutePalindromes(String[] list) {
        Set<String> res = new HashSet<>();

        if (list == null || list.length < 2) {
            return res;
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                String word = list[i] + list[j];
                if (isPalindrome(word)) {
                    res.add(word);
                }
            }
        }

        return res;
    }

    // Better solution
    public static Set<String> betterPalindromes(String[] list) {
        Set<String> res = new HashSet<>();

        if (list == null || list.length < 2) {
            return res;
        }

        Set<String> reversed = new HashSet<>();
        for (String word : list) {
            String temp = reverseWord(word);
            if (reversed.contains(temp)) {
                res.add(word + temp);
            } else {
                reversed.add(word);
            }
        }

        return res;
    }

    private static String reverseWord(String word) {
        String res = "";
        for (int i = word.length()-1; i >= 0; i--) {
            res += word.charAt(i);
        }
        return res;
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i <= word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] test1 = { "a", "dog", "god", "cat", "tac", "hat", "help", "sigh", "aaaa" };
        System.out.println("TEST1");
        for (String word : brutePalindromes(test1)) {
            System.out.println(word); // doggod cattac aaaa
        }

        System.out.println("\nTEST2");
        for (String word : betterPalindromes(test1)) {
            System.out.println(word); // doggod cattac aaaa
        }
    }
}
