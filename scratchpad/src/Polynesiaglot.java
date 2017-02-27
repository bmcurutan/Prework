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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Polynesiaglot {
    public static int poly(int c, int v, int len) { // consonants, vowels, length
        int res = 0;

        if (len == 0) {
            return res;
        }

        Set<ArrayList<String>> set = new HashSet<>();
        polyRec(new ArrayList<String>(), set, c, v, len);
        return set.size() % 1000000007;
    }

    private static void polyRec(ArrayList<String> word, Set<ArrayList<String>> set, int c, int v, int len) {
        //System.out.println(word);
        if (word.size() == len) {
            if (isValid(word)) {
                set.add(word);
                //System.out.println(word);
            }
            return;
        }

        for (int i = 0; i < c; i++) {
            if (word.size() > 0 && word.get(word.size()-1).contains("c")) {
                // Do nothing, can't have two consonants side by side
            } else {
                word.add("c" + i);
                polyRec(word, set, c, v, len);
                word.remove(word.size()-1);
            }
        }
        for (int j = 0; j < v; j++) {
            word.add("v" + j);
            polyRec(word, set, c, v, len);
            word.remove(word.size()-1);
        }
    }

    private static boolean isValid(ArrayList<String> word) {
        // All words consist of letters. Letters are either consonants or vowels.
        // Any consonant in a word must be immediately followed by a vowel.
        if (word == null || word.size() == 0 || word.get(word.size()-1).contains("c")) {
            return false;
        }

        for (int i = 0; i < word.size()-1; i++) {
            if (word.get(i).contains("c") && !word.get(i+1).contains("v")) {
                return false;
            }
        }

        return true;
    }

    //private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/C-small-practice-1.in";
    //private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/C-small-practice-1.out";
    private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/C-small-practice-2.in";
    private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/C-small-practice-2.out";

    public static void main(String[] args) {
        //System.out.println(poly(1, 1, 4)); // 5
        //System.out.println(poly(1, 2, 2)); // 6
        System.out.println(poly(43, 47, 15));

        BufferedReader br = null;
        FileReader fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            pw = new PrintWriter(OUTFILENAME, "UTF-8");

            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {
                String line = br.readLine();
                String[] tokens = line.split(" ");

                int c = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                int len = Integer.parseInt(tokens[2]);

                pw.println("Case #" + (i+1) + ": " + poly(c, v, len));
            }

            /*String currentLine;
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
                if (pw != null)
                    pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
