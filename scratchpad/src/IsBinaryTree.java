// Determine if a tree is a BST

public class IsBinaryTree {
    public boolean isBinaryTree(TreeNode t) {
        if (t == null || (t.left == null && t.right == null)) {
            return true;
        }

        if (t.left != null && t.left.val > t.val) {
            return false;
        }
        if (t.right != null && t.right.val < t.val) {
            return false;
        }

        return isBinaryTree(t.left) && isBinaryTree(t.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);

        IsBinaryTree bt = new IsBinaryTree();
        System.out.println(bt.isBinaryTree(t)); // false

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        t2.left.left = new TreeNode(2);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(6);
        t2.right.left = new TreeNode(5);

        System.out.println(bt.isBinaryTree(t2)); // true
    }
}
