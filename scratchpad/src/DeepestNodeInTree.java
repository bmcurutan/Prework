// Given a tree, find and return the deepest node

public class DeepestNodeInTree {

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

    private static int deepestLevel = 0;
    private static TreeNode deepestNode = null;

    public static TreeNode deepestNode(TreeNode root) {
        deepestNode = root;

        if (root.left != null) {
            helper(1, root.left);
        }
        if (root.right != null) {
            helper(1, root.right);
        }

        return deepestNode;
    }

    private static void helper(int currLevel, TreeNode tree) {
        if (tree == null) {
            return;
        }

        if (currLevel > deepestLevel) {
            deepestNode = tree;
        }

        if (tree.left != null) {
            helper(currLevel, tree.left);
        }
        if (tree.right != null) {
            helper(currLevel, tree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.left.right = new TreeNode(7);
        System.out.println(deepestNode(tree).val); // 7
    }
}
