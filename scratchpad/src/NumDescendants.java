import java.util.*;

// Given a relationship tree, traverse the tree and find individuals
// in it who has a specified number of descendants in it.

public class NumDescendants {
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

    public static ArrayList<TreeNode> nodes(TreeNode tree, int goal) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();

        if (tree == null) {
            return res;
        }

        nodes(res, tree, goal);

        return res;
    }

    private static void nodes(ArrayList<TreeNode> res, TreeNode tree, int goal) {
        if (numDescendants(tree) == goal) {
            res.add(tree);
        }

        if (tree.left != null) {
            nodes(res, tree.left, goal);
        }
        if (tree.right != null) {
            nodes(res, tree.right, goal);
        }
    }

    private static int numDescendants(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return 0;
        }

        int num = 0;
        if (tree.left != null) {
            num += 1 + numDescendants(tree.left);
        }
        if (tree.right != null) {
            num += 1 + numDescendants(tree.right);
        }

        return num;
    }

    private static void printList(ArrayList<TreeNode> list) {
        for (TreeNode t : list) {
            System.out.print(t.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode test1 = null;
        System.out.println("TEST 1");
        printList(nodes(test1, 0)); //

        TreeNode test2 = new TreeNode(1);
        System.out.println("TEST 2");
        printList(nodes(test2, 0)); // 1

        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.println("TEST 3");
        printList(nodes(test3, 2)); // 1

        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.left.left = new TreeNode(4);
        test4.right = new TreeNode(3);
        System.out.println("TEST 4a");
        printList(nodes(test4, 1)); // 2
        System.out.println("TEST 4b");
        printList(nodes(test4, 2)); //
        System.out.println("TEST 4c");
        printList(nodes(test4, 3)); // 1
    }
}
