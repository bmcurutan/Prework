package NotDone;// Assign sibling pointers for two nodes in a binary tree

import java.util.*;

public class SiblingTreeNode {
    public static class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;
        ArrayList<TreeNode2> siblings;
        ArrayList<TreeNode2> sameLevel; // across whole tree

        public TreeNode2(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.siblings = new ArrayList<>();
            this.sameLevel = new ArrayList<>();
        }
    }

    public void assignSiblings(TreeNode2 a) {
        if (a == null) {
            return;
        }
        if (a.left != null && a.right != null) {
            a.left.siblings.add(a.right);
            a.right.siblings.add(a.left);
        }

        assignSiblings(a.left);
        assignSiblings(a.right);
    }

    public void sameLevel(TreeNode2 a) {
        // TODO can modify Tree to include "level" and recurse with a parameter that +1 every time it's called
        // TODO or can keep external storage to keep track of level
    }

    public void printTree(TreeNode2 a) {
        if (a == null) {
            return;
        }

        System.out.print(a.val + " ");

        //for (TreeNode2 s : a.siblings) {
        for (TreeNode2 s : a.sameLevel) {
            System.out.print(s.val + " ");
        }
        System.out.println();

        printTree(a.left);
        printTree(a.right);
    }

    public static void main(String[] args) {
        SiblingTreeNode test = new SiblingTreeNode();

        TreeNode2 t2 = new TreeNode2(5);
        t2.left = new TreeNode2(3);
        t2.left.left = new TreeNode2(2);
        t2.left.right = new TreeNode2(4);
        t2.right = new TreeNode2(6);
        t2.right.left = new TreeNode2(5);

        test.printTree(t2);

        //test.assignSiblings(t2);
        test.sameLevel(t2);

        System.out.println();
        test.printTree(t2);
    }
}
