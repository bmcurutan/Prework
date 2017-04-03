import java.util.*;

// Generate all subsets of a string

public class StringSubsets {

    public static Set<String> subsets(String s) {
        Set<String> res = new HashSet<>();
        helper(res, "", s);
        return res;
    }

    private static void helper(Set<String> res, String sub, String s) {
        res.add(sub);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            helper(res, sub + c, sWithoutCharAtI(s, i));
        }
    }

    private static String sWithoutCharAtI(String s, int i) {
        String res = "";
        //for (int j = 0; j < s.length(); j++) { // Use this if order doesn't matter
        for (int j = i+1; j < s.length(); j++) { // Use this if order matters
            //if (j != i) {
                res += s.charAt(j);
            //}
        }
        return res;
    }

    public static void main(String[] args) {
        Set<String> res = subsets("Abc");
        for (String s : res) {
            System.out.println(s);
        }
        /*
         * ""
         * A
         * b
         * c
         * Ab
         * bc
         * Ac
         * Abc
        */
    }

}
