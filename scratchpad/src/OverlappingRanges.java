public class OverlappingRanges {
    // Write a function to check if two ranges overlap

    public static boolean overlap(int a1, int a2, int b1, int b2) {
        // One element
        if (a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2) {
            return true;
        }

        // Subset
        else if ((a1 <= b1 && a2 >= b2) || (b1 <= a1 && b2 >= a2)) {
            return true;
        }

        // Overlap
        else if ((a1 <= b1 && b1 <= a2) || (a1 <= b2 && b2 <= a2) || (b1 <= a1 && a1 <= b2) || (b1 <= a2 && a2 <= b2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(overlap(0, 1, 2, 3)); // false
        System.out.println(overlap(0, 0, 1, 1)); // false
        System.out.println(overlap(0, 1, 1, 2)); // true (one element)
        System.out.println(overlap(1, 2, 0, 1)); // true (one element)
        System.out.println(overlap(1, 10, 2, 3)); // true (subset)
        System.out.println(overlap(1, 5, 3, 6)); // true (overlap)
    }
}
