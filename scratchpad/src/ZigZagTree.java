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
            System.out.println();
            return;
        }

        Map<TreeNode, Boolean> map = new LinkedHashMap <>(); // true go to the right, false go to the left
        map.put(t, true);
        String temp = "";
        while (!map.isEmpty()) {
            Map.Entry<TreeNode, Boolean> entry = map.entrySet().iterator().next();
            map.remove(entry.getKey());

            if (entry.getValue()) {
                System.out.print(temp);
                temp = "";
                System.out.print(entry.getKey().val + " ");
            } else {
                temp = entry.getKey().val + " " + temp;
                //System.out.println(temp);
            }

            if (entry.getKey().left != null) {
                map.put(entry.getKey().left, !entry.getValue());
            }
            if (entry.getKey().right != null) {
                map.put(entry.getKey().right, !entry.getValue());
            }

            /*for(Map.Entry<TreeNode, Boolean> e : map.entrySet()) {
                System.out.print(e.getKey().val + " * ");
            }
            System.out.println();*/
        }

        System.out.print(temp);
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode test1 = null;
        System.out.print("Test 1: ");
        printZigzag(test1);

        TreeNode test2 = new TreeNode(1);
        System.out.print("Test 2: ");
        printZigzag(test2); // 1

        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.print("Test 3: ");
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
        System.out.print("Test 4: ");
        printZigzag(test4); // 1 3 2 4 5 6 11 10 9 8
    }
}
