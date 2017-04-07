import java.util.*;

public class WaysToScore {
    /*
     How many ways are there to score (exactly) a target score
     Possible points at a time - 2, 3, 7

     e.g., target = 10, {[5,0,0], [0,1,1], [2,2,0]}
    */

    // iterative solution
    public static Map<String, int[]> waysToScoreIter(int target) {
        Map<String, int[]> res = new HashMap<>();

        if (target < 2) {
            return res;
        }

        for (int two = 0; two <= target/2; two++) {
            for (int three = 0; three <= target/3; three++) {
                for (int seven = 0; seven <= target/7; seven++) {
                    int[] curr = {two, three, seven};
                    String key = "" + curr[0] + curr[1] + curr[2];
                    if (sum(curr) == target && !res.containsKey(key)) {
                        res.put(key, curr);
                    }
                    if (sum(curr) >= target) {
                        break;
                    }
                }
            }
        }

        return res;
    }

    // recursive solution
    public static Map<String, int[]> waysToScoreRec(int target) {
        Map<String, int[]> res = new HashMap<>();

        if (target < 2) {
            return res;
        }

        recHelper(res, new int[3], target);
        return res;
    }

    private static void recHelper(Map<String, int[]> res, int[] curr, int target) {
        String key = "" + curr[0] + curr[1] + curr[2];
        if (sum(curr) == target && !res.containsKey(key)) {
            res.put(key, curr);
        }
        if (sum(curr) >= target) {
            return;
        }

        int[] curr0 = copy(curr);
        curr0[0] = curr0[0] + 1;
        recHelper(res, curr0, target);

        int[] curr1 = copy(curr);
        curr1[1] = curr1[1] + 1;
        recHelper(res, curr1, target);

        int[] curr2 = copy(curr);
        curr2[2] = curr2[2] + 1;
        recHelper(res, curr2, target);
    }

    private static int[] copy(int[] curr) {
        int[] res = { curr[0], curr[1], curr[2] };
        return res;
    }

    private static int sum(int[] curr) {
        return curr[0] * 2 + curr[1] * 3 + curr[2] * 7;
    }

    public static void printResults(Map<String, int[]> res) {
        for (int[] arr : res.values()) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }
    public static void main(String[] args) {
        // Recursive
        System.out.println("RECURSIVE");
        System.out.println("TEST 1");
        printResults(waysToScoreRec(0)); // (nothing)
        System.out.println("TEST 2");
        printResults(waysToScoreRec(2)); // {[1,0,0]}
        System.out.println("TEST 3");
        printResults(waysToScoreRec(10)); // {[5,0,0], [0,1,1], ...}

        // Iterative
        System.out.println("ITERATIVE");
        System.out.println("TEST 4");
        printResults(waysToScoreIter(0)); // (nothing)
        System.out.println("TEST 5");
        printResults(waysToScoreIter(2)); // {[1,0,0]}
        System.out.println("TEST 6");
        printResults(waysToScoreIter(10)); // {[5,0,0], [0,1,1], [2,2,0]}
    }
}
