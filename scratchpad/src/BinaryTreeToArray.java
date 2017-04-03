import java.util.*;

public class BinaryTreeToArray {
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

    public static ArrayList<Integer> binaryTreeToArray(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return res;
    }

    public static void printArray(ArrayList<Integer> a) {
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        test1.right = new TreeNode(3);
        test1.right.right = new TreeNode(6);
        printArray(binaryTreeToArray(test1)); // 1 2 3 4 5 6
    }
}
