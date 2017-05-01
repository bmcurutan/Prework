// Find the median of two sorted arrays

public class Median2SortedArrays {
    public static double median(int[] a, int[] b) {
        int total = a.length + b.length;
        int idx1 = total/2 - 1, idx2 = -1;

        if (total % 2 == 0) {
            idx2 = idx1 + 1;
        }

        double median = 0.0; // default

        int curr = 0, i = 0, j = 0;
        while (curr < idx1) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i < a.length) {
                i++;
            } else if (j < b.length) {
                j++;
            }
            curr++;
        }

        if (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                median = a[i];
                i++;
            } else {
                median = b[j];
                j++;
            }
        } else if (i < a.length) {
            median = a[i];
            i++;
        } else {
            median = b[j];
            j++;
        }

        if (idx2 != -1) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    median = (a[i] + median) / 2;
                } else {
                    median = (b[j] + median) / 2;
                }
            } else if (i < a.length) {
                median = (a[i] + median) / 2;
            } else {
                median = (b[j] + median) / 2;
            }
        }

        return median;
    }

    public static void main(String[] args) {
        int[] a1 = {1};
        int[] b1 = new int[0];
        System.out.println(median(a1, b1)); // 1

        int[] a2 = {1};
        int[] b2 = {2};
        System.out.println(median(a2, b2)); // 1.5

        int[] a3 = {1, 2};
        int[] b3 = {2, 4, 5};
        System.out.println(median(a3, b3)); // 2

        int[] a4 = {1, 2, 3};
        int[] b4 = {2, 4, 5};
        System.out.println(median(a4, b4)); // 2.5
    }
}
