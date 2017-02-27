package NotDone;

/*
Problem C. Polynesiaglot
This contest is open for practice. You can try every problem as many times as you like, though we won't
keep track of which problems you solve. Read the Quick-Start Guide to get started.
Small input 1
5 points
Solve C-small-1
Small input 2
10 points
Solve C-small-2
Large input
10 points
Solve C-large
Problem

Ursula is a big fan of constructing artificial languages. Today, she is starting to work on a language
inspired by real Polynesian languages. The only rules she has established are:

All words consist of letters. Letters are either consonants or vowels.
Any consonant in a word must be immediately followed by a vowel.
For example, in a language in which a is the only vowel and h is the only consonant, a, aa, aha, aaha,
and haha are valid words, whereas h, ahh, ahah, and ahha are not. Note that the rule about consonants
disallows ending a word in a consonant as well as following a consonant with another consonant.

If Ursula's new language has C different consonants and V different vowels available to use, then how
many different valid words of length L are there in her language? Since the output can be a really big
number, we only ask you to output the remainder of dividing the result by the prime 109+7 (1000000007).

Solving this problem

This problem has 2 Small inputs and 1 Large input. You must solve the first Small input before you can
attempt the second Small input. You will be able to retry either of the Small inputs (with a time
penalty). You will be able to make a single attempt at the Large, as usual, only after solving both
Small inputs.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of
one line with three integers C, V, and L.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from
1) and y is the number of different valid words of length L in the language, modulo the prime 109+7
(1000000007).

Limits

Small dataset 1

T = 15.
C = 1.
V = 1.
1 ≤ L ≤ 15.
Small dataset 2

1 ≤ T ≤ 100.
1 ≤ C ≤ 50.
1 ≤ V ≤ 50.
1 ≤ L ≤ 15.
Large dataset

1 ≤ T ≤ 100.
1 ≤ C ≤ 50.
1 ≤ V ≤ 50.
1 ≤ L ≤ 500.
Sample


Input

Output

2
1 1 4
1 2 2

Case #1: 5
Case #2: 6

In Case #1, suppose that the only vowel is a and the only consonant is h. Then the possible valid words
of length 4 are: aaaa, aaha, ahaa, haaa, haha.

In Case #2 (which would not appear in the Small dataset 1), suppose that the two vowels are a and e and
the only consonant is h. Then the possible valid words of length 2 are: aa, ae, ea, ee, ha, he.
 */

import java.util.*;

public class Polynesiaglot {
    public static int poly(int c, int v, int len) { // consonants, vowels, length
        int res = 0;

        if (len == 0) {
            return res;
        }

        Set<String> set = new HashSet<>();
        polyRec("", set, c, v, len);
        return set.size() % 1000000007;
    }

    private static void polyRec(String word, Set<String> set, int c, int v, int len) {
        if (word.length() == len) {
            if (isValid(word)) {
                set.add(word);
                System.out.println(word);
            }
            return;
        }

        polyRec(word + "c", set, c, v, len);
        polyRec(word + "v", set, c, v, len);
    }

    private static boolean isValid(String word) {
        // All words consist of letters. Letters are either consonants or vowels.
        // Any consonant in a word must be immediately followed by a vowel.
        if (word == null || word.length() == 0 || word.charAt(word.length()-1) == 'c') {
            return false;
        }

        for (int i = 0; i < word.length()-1; i++) {
            if (word.charAt(i) == 'c' && word.charAt(i+1) != 'v') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //System.out.println(poly(1, 1, 4)); // 5
        System.out.println(poly(1, 2, 2)); // 6
    }
}
