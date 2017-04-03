public class KElement2SortedArrays {

    // Find the kth element in 2 sorted arrays

    public static int kthElement(int k, int[] a, int[] b) {
        int i = 0;
        int j = 0;

        int currCount = 0;
        int currVal = -1;
        while (currCount < k) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    currVal = a[i];
                    i++;
                } else { // >=
                    currVal = b[j];
                    j++;
                }
            } else if (i < a.length) {
                currVal = a[i];
                i++;
            } else if (j < b.length) {
                currVal = b[j];
                j++;
            }
            currCount++;
        }

        return currVal;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {2, 2, 3, 7, 8};

        System.out.println(kthElement(7, a, b)); // 4
        System.out.println(kthElement(1, a, b)); // 1
        System.out.println(kthElement(9, a, b)); // 6
    }
}
