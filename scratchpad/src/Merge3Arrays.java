public class Merge3Arrays {
    public static int[] merge(int[] a, int[] b, int[] c) {
        int[] res = new int[a.length + b.length + c.length];

        int ai = 0;
        int bi = 0;
        int ci = 0;

        for (int i = 0; i < res.length; i++) {
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
            if (0 <= ai && ai < a.length) {
                x = a[ai];
            }
            if (0 <= bi && bi < b.length) {
                y = b[bi];
            }
            if (0 <= ci && ci < c.length) {
                z = c[ci];
            }

            if (x <= Math.min(y, z)) {
                res[i] = x;
                ai++;
            } else if (y <= Math.min(x, z)) {
                res[i] = y;
                bi++;
            } else if (z <= Math.min(x, y)) {
                res[i] = z;
                ci++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7};
        int[] b = {2, 5, 8, 10};
        int[] c = {3, 6, 9};

        int[] test = Merge3Arrays.merge(a, b, c);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
