package NotDone;

// Binary tree where each node value is the sum of node.val + left.val + right.val
// Find new value of the root in the tree

public class SumNodeBinaryTree {
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

    private static int value;

    public static int newRootValue(TreeNode tree) {
        int sum = tree.val;

        if (tree.left == null && tree.right == null) {
            return sum;
        }

        if (tree.left != null) {
            sum += newRootValue(tree.left);
        }
        if (tree.right != null) {
            sum += newRootValue(tree.right);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(4);
        test.left.right = new TreeNode(5);
        test.right = new TreeNode(3);
        test.right.right = new TreeNode(6);
        test.right.right.left = new TreeNode(7);

        System.out.println(newRootValue(test)); // 28
    }
}
