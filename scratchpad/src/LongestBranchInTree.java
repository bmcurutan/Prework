import java.util.*;

public class LongestBranchInTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> longestBranch(TreeNode tree) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<Integer>(), tree);

        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> l : list) {
            if (l.size() > res.size()) {
                res = l;
            }
        }

        return res;
    }

    private static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, TreeNode tree) {
        if (tree == null) {
            res.add(curr);
            return;
        }

        curr.add(tree.val);
        helper(res, copy(curr), tree.left);
        helper(res, copy(curr), tree.right);
    }

    private static ArrayList<Integer> copy(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : a) {
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(4);
        test.left.right = new TreeNode(5);
        test.right = new TreeNode(3);
        test.right.right = new TreeNode(6);
        test.right.right.left = new TreeNode(7);

        ArrayList<Integer> res = longestBranch(test);
        for (int i : res) {
            System.out.print(i + " "); // 1 3 6 7
        }
        System.out.println();
    }
}
