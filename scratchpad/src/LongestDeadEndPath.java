// Find the longest path from root to a deadend node
// In a BST, a node is a deadend if it's not possible to add a number before or after it
// Assumptions: unique, positive integers

import java.util.*;

public class LongestDeadEndPath {

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

    private static int max;

    public static int longestPath(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        max = 0;
        helper(set, root, 0);
        return max;
    }

    private static void helper(Set<Integer> set, TreeNode root, int path) {
        if (root == null) {
            return;
        } else {
            set.add(root.val);
            path++;
        }

        // dead end leaf
        if (root.left == null && root.right == null) {
            if (set.contains(root.val-1) && set.contains(root.val+1)) {
                max = Math.max(path, max);
            }
            return;
        }

        helper(set, root.left, path);
        helper(set, root.right, path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(10);

        System.out.println(longestPath(root)); // 4
    }

    /*
                8
            5          10
        2     6
    1
    Output: 4*/

    // null = 0

    // 1
    // = 1

    //      2
    //  1      3
    //   = 2

    //       4
    //     3
    // 1
    //   2
}

