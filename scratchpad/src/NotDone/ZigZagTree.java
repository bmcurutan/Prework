package NotDone;

import java.util.*;

public class ZigZagTree {
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

    // Print to the right, then left
    public static void printZigzag(TreeNode t) {
        if (t == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);
        Stack<TreeNode> s = new Stack<>();
        while (!q.isEmpty()) {
            TreeNode pop = q.poll();
            System.out.print(pop.val + " ");
            if (pop.left != null) {
                q.add(pop.left);
            }
            if (pop.right != null) {
                q.add(pop.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode test1 = null;
        System.out.println("Test 1");
        printZigzag(test1);

        TreeNode test2 = new TreeNode(1);
        System.out.println("Test 2");
        printZigzag(test2); // 1

        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.println("Test 3");
        printZigzag(test3); // 1 3 2

        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.left.left = new TreeNode(4);
        test4.left.left.left = new TreeNode(8);
        test4.left.left.right = new TreeNode(9);
        test4.left.right = new TreeNode(5);
        test4.left.right.left = new TreeNode(10);
        test4.left.right.right = new TreeNode(11);
        test4.right = new TreeNode(3);
        test4.right.left = new TreeNode(6);
        test4.right.right = new TreeNode(7);
        System.out.println("Test 4");
        printZigzag(test4); // 1 3 2 4 5 6 7 11 10 9 8
    }
}
