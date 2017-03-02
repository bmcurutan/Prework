public class FirstNonNegativeInteger {

    /*The "Getting a Different Number" Problem

    Given an array arr of n unique non-negative integers, how can you most efficiently find a non-negative integer that is not in the array?

    Your solution should return such an integer or null if arr contains all possible integers.
    Analyze the runtime and space complexity of your solution.

    class Pramp {
        public static void main(String[] args) {
            String pramp = "Practice Makes Perfect";
            System.out.println(pramp);
        }
    }*/

    public static int firstNonNeg(int[] a) {
        if (a != null || a.length == 0) {
            return 0;
        }

        // 0 1 2 3 4
        int expectedSum = 0;
        for (int i = 0; i <= a.length; i++) {
            expectedSum += i;
        }

        // 0 1 2 3 4
        boolean isZero = false;
        int actualSum = 0;
        for (int j = 0; j < a.length; j++) {
            actualSum += a[j];
            if (a[j] == 0) {
                isZero = true;
            }
        }

        if (expectedSum == actualSum && isZero) {
            return a.length + 1;
        }

        return expectedSum - actualSum;
    }

}
