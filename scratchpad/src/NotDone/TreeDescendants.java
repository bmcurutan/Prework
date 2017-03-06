package NotDone;

import java.util.*;

/*
Given a relationship tree, traverse the tree and find individuals in it
who has a specified number of descendants in it.
 */

public class TreeDescendants {
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

    public static List<TreeNode> nDesc(TreeNode root, int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();

        if (root == null || n == 0) {
            return res;
        }

        nDesc(root, n, res);
        return res;
    }

    private static void nDesc(TreeNode root, int n, List<TreeNode> list) {
        if (numDesc(root) == n) {
            list.add(root);
            return;
        }

        if (root.left != null) {
            nDesc(root.left, n, list);
        }
        if (root.right != null) {
            nDesc(root.right, n, list);
        }
    }

    // Calculate the number of descendants that a tree node has
    private static int numDesc(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return 1 + numDesc(root.left) + numDesc(root.right);
    }

    public static void main(String[] args) {
        System.out.println("TEST1");
        TreeNode test1 = new TreeNode(1);
        for (TreeNode t : nDesc(test1, 1)) { // empty
            System.out.println(t.val);
        }

        System.out.println("TEST2");
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        for (TreeNode t : nDesc(test2, 1)) { // 1
            System.out.println(t.val);
        }

        System.out.println("TEST3");
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.left.left = new TreeNode(4);
        test3.left.right = new TreeNode(5);
        test3.right = new TreeNode(3);
        test3.right.right = new TreeNode(6);
        test3.right.right.right = new TreeNode(7);
        for (TreeNode t : nDesc(test3, 1)) { // 2 6
            System.out.println(t.val);
        }
        System.out.println("TEST4");
        for (TreeNode t : nDesc(test3, 2)) { // 3
            System.out.println(t.val);
        }
    }
}
