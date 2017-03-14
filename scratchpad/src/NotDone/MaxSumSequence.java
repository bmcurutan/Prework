package NotDone;

public class MaxSumSequence {

    private static int maxSum;

    public static int maxSum(int[] a) {
        if (null == a || a.length == 0) {
            return 0;
        } else if (a.length == 1) {
            return a[0];
        }

        maxSum = a[0];
        for (int i = 0; i < a.length; i++) {
            helper(a, i+2, a[i]);
        }

        return maxSum;
    }

    private static void helper(int[] a, int i, int currSum) {
        if (i >= a.length) {
            return;
        }

        if (currSum + a[i] > currSum) {
            currSum += a[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            System.out.println("1: " + currSum);
            helper(a, i+2, currSum);
        }

        System.out.println("2: " + currSum);
        helper(a, i+1, currSum);
    }

    public static void main(String[] args) {
        int[] test1 = new int[0];
        //System.out.println("Test1: " + maxSum(test1)); // 0

        int[] test2 = { 1 } ;
        //System.out.println("Test2: " + maxSum(test2)); // 1

        int[] test3 = { -1, -2, 4, -3, 5, 6 };
        System.out.println("Test3: " + maxSum(test3)); // 10 TODO

        int[] test4 = { -1, -2, -3 };
        //System.out.println("Test4: " + maxSum(test4)); // -1

        int[] test5 = { 1, -1, -1, -1, 2 };
        //System.out.println("Test5: " + maxSum(test5)); // 3

        int[] test6 = { 1, 9, 3, 4, 2, 5 };
        System.out.println("Test6: " + maxSum(test6)); // 18 TODO
    }

}

/*1 9 3 4 2 5
        9 + 4 + 5 = 18
        [] = 0
        [1] = 1
        [ -1 -2 4 -3 5 6 ] = 10
        [ -1 -2 -3 ] = -1
        [ 1 -1 -1 -1 2 ] = 3*/




