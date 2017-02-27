package NotDone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
Problem

You just bought your young nephew Andrey a complete set of 26 English wooden alphabet letters from A to Z. Because the
letters come in a long, linear package, they appear to spell out a 26-letter message.

You use N different passwords to log into your various online accounts, and you are concerned that this message might
coincidentally include one or more of them. Can you find any arrangement of the 26 letters, such that no password
appears in the message as a continuous substring?

Solving this problem

This problem has 2 Small inputs and no Large input. You must solve the first Small input before you can attempt the
second Small input. You will be able to retry either of the Small inputs (with a time penalty).

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with an
integer N, and then another line with N different strings of uppercase English letters P1, P2, ..., PN, which are the
passwords.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a
permutation of the entire uppercase English alphabet that contains no password as a continuous substring, or the word
IMPOSSIBLE if there is no such permutation.

Limits

1 ≤ T ≤ 100.
1 ≤ length of Pi ≤ 26, for all i. (Each password is between 1 and 26 letters long.)
Pi ≠ Pj for all i ≠ j. (All passwords are different.)
Small dataset 1

N = 1.
Small dataset 2

1 ≤ N ≤ 50.
Sample


Input

7
1
ABCDEFGHIJKLMNOPQRSTUVWXYZ
1
X
1
QQ
5
XYZ GCJ OMG LMAO JK
3
AB YZ NM
6
C PYTHON GO PERL RUBY JS
2
SUBDERMATOGLYPHIC UNCOPYRIGHTABLES



Output

Case #1: QWERTYUIOPASDFGHJKLZXCVBNM
Case #2: IMPOSSIBLE
Case #3: ABCDEFGHIJKLMNOPQRSTUVWXYZ
Case #4: ABCDEFGHIKLMNOPQRSTUVWXYJZ
Case #5: ZYXWVUTSRQPOMNLKJIHGFEDCBA
Case #6: IMPOSSIBLE
Case #7: THEQUICKBROWNFXJMPSVLAZYDG

For each of the non-IMPOSSIBLE cases, the sample output shows only one possible answer. There are many valid answers
for these inputs.

Note that only sample cases #1, #2, and #3 would appear in Small dataset 1. Any of the sample cases could appear in
Small dataset 2.
 */

// Pre: arr not null
public class PasswordSecurity {
    public static String encrypt(String in) {
        String[] pwds = in.split(" ");
        String res = null;

        // Pre-process to check for early exit
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean containsPwd = false;
        for (int j = 0; j < pwds.length; j++) {
            if (pwds[j].length() == 1) {
                return "IMPOSSIBLE";
            }
            if (alpha.contains(pwds[j])) {
                containsPwd = true;
            }
        }

        if (res == null) {
            if (!containsPwd) {
                res = alpha; // Just use the default alphabet
            } else {
                List<String> list = new ArrayList<>();
                encryptRec(new ArrayList<>(), list, pwds);
                if (list.size() > 0) {
                    return list.get(0);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return res;
    }

    private static String actualLetters(List<Integer> letters) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        map.put(4, "E");
        map.put(5, "F");
        map.put(6, "G");
        map.put(7, "H");
        map.put(8, "I");
        map.put(9, "J");
        map.put(10, "K");
        map.put(11, "L");
        map.put(12, "M");
        map.put(13, "N");
        map.put(14, "O");
        map.put(15, "P");
        map.put(16, "Q");
        map.put(17, "R");
        map.put(18, "S");
        map.put(19, "T");
        map.put(20, "U");
        map.put(21, "V");
        map.put(22, "W");
        map.put(23, "X");
        map.put(24, "Y");
        map.put(25, "Z");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.size(); i++) {
            sb.append(map.get(letters.get(i)));
        }

        return sb.toString();
    }

    private static void encryptRec(List<Integer> letters, List<String> list, String[] pwds) {
        if (list.size() > 0) {
            return;
        }

        if (letters.size() == 26) {
            if (!containsPwds(letters, pwds)) {
                list.add(actualLetters(letters));
            }
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (!letters.contains(i)) {
                letters.add(i);
                if (!containsPwds(letters, pwds)) {
                    encryptRec(letters, list, pwds);
                }
                letters.remove(letters.size() - 1);
            }
        }
    }

    private static boolean containsPwds(List<Integer> letters, String[] pwds) {
        boolean res = false;
        for (int i = 0; i < pwds.length; i++) {
            String p = pwds[i];
            if (actualLetters(letters).contains(p)) {
                res = true;
            }
        }
        return res;
    }

    /*public static void main(String[] args) {
        String test1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("1: " + encrypt(test1));

        String test2 = "X";
        System.out.println("2: " + encrypt(test2)); // IMPOSSIBLE - works

        String test3 = "QQ";
        System.out.println("3: " + encrypt(test3)); // A..Z - works

        String test4 = "XYZ GCJ OMG LMAO JK";
        System.out.println("4: " + encrypt(test4)); // A..Z - works

        String test5 = "AB YZ NM";
        System.out.println("5: " + encrypt(test5));

        String test6 = "C PYTHON GO PERL RUBY JS";
        System.out.println("6: " + encrypt(test6)); // IMPOSSIBLE

        String test7 = "SUBDERMATOGLYPHIC UNCOPYRIGHTABLES";
        System.out.println("7: " + encrypt(test7)); // A..Z
    }*/

    //private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/D-small-practice-1.in";
    //private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/D-small-practice-1.out";
    private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/D-small-practice-2.in";
    private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/D-small-practice-2.out";

    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            pw = new PrintWriter(OUTFILENAME, "UTF-8");

            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {
                String n = br.readLine();
                String line = br.readLine();
                pw.println("Case #" + (i+1) + ": " + encrypt(line));
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
