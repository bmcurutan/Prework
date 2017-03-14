package NotDone;

import java.util.*;

// Given an array of length n, find k number of elements that sum to 0

public class KSum0NArray {
    public static ArrayList<ArrayList<Integer>> kElements(int[] a, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (a == null || a.length == 0 || k <= 0) {
            return res;
        }

        ArrayList<Integer> curr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            curr.add(a[i]);
            helper(res, curr, a[i], k-1);
            curr.remove(a[i]);
        }

        return res;
    }

    private static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, int currSum, int k) {
        if (k == 0) {
            if (currSum == 0) {
                res.add(curr);
            }
            return;
        }

        ArrayList<Integer> curr2 = copy(curr);
        //curr2.add();
        //helper(res, )
    }

    private static ArrayList<Integer> copy(ArrayList<Integer> a) {
        ArrayList<Integer> b = new ArrayList<>();

        if (a == null || a.size() == 0) {
            return b;
        }

        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i));
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
