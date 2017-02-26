// Search for string in unbalanced binary tree

public class HasString {
    public static class TreeNode {
        private String val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean hasString(TreeNode root, String s) {
        if (root == null) {
            return false;
        }

        if (root.val.equalsIgnoreCase(s)) {
            return true;
        }

        return hasString(root.left, s) || hasString(root.right, s);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1");

        root.left = new TreeNode("two");
        root.left.left = new TreeNode("4");

        root.right = new TreeNode("3");
        root.right.left = new TreeNode("SiX");
        root.right.left.left = new TreeNode("7");
        root.right.left.right = new TreeNode("8");
        root.right.right = new TreeNode("five");

        HasString sol = new HasString();
        System.out.println("TEST: " + sol.hasString(root, "SiX1"));
    }
}
