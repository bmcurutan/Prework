package NotDone;

/*Given a pattern and a string input - find if the string follows the same pattern and return 0 or 1.
Examples:
1) Pattern : "abab", input: "redblueredblue" should return 1.
2) Pattern: "aaaa", input: "asdasdasdasd" should return 1.
3) Pattern: "aabb", input: "xyzabcxzyabc" should return 0.
4) Pattern: "abcde", input: "abcde" should return 1.
*/

import java.util.*;

public class RedBlueBlueRed {
    public static int redBlueBlueRed(String pattern, String s) {

        // Null case
        if (null == pattern || null == s) {
            return 0;
        }

        // Base cases
        if ((pattern.length() == 0 && s.length() == 0) ||
                (pattern.length() == 1 && s.length() > 0)) {
            return 1;
        }

        // Empty case
        if (pattern.length() == 0 || s.length() == 0) {
            return 0;
        }

        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (int j = 1; j < s.length(); j++) {
            String curr = s.substring(0, j);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
            } else {
                map.put(curr, 1);
            }
        }

        for (String a : map.keySet()) {
            int aLen = a.length();
            String test = "";

            if (bCount > 0) {
                int bLen = (s.length() - aLen * aCount) / bCount;
                if (bLen >= 1) {
                    int start = pattern.indexOf("b") * aLen;
                    String b = s.substring(start, start + bLen);

                    for (int i = 0; i < pattern.length(); i++) {
                        char c = pattern.charAt(i);
                        if (c == 'a') {
                            test += a;
                        } else {
                            test += b;
                        }
                    }


                }
            } else {
                for (int i = 0; i < pattern.length(); i++) {
                    test += a;
                }
            }

            if (s.equals(test)) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(redBlueBlueRed("abab", "redblueredblue")); // 1
        System.out.println(redBlueBlueRed("abba", "redblueredblue")); // 0
        System.out.println(redBlueBlueRed("aaaa", "asdasdasdasd")); // 1
        System.out.println(redBlueBlueRed("aabb", "xyzabcxzyabc")); // 0
        System.out.println(redBlueBlueRed("aba", "redblackblue")); // 0
        System.out.println(redBlueBlueRed("aba", "redblackred")); // 1
    }
}
