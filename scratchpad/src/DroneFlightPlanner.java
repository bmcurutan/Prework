public class DroneFlightPlanner {
    /* https://www.pramp.com/question/BrLMj8M2dVUoY95A9x3X
     * Example: Completing the route [{x:0, y:2, z:10}, {x:3, y:5, z:0}, {x:9, y:20, z:6},
     * {x:10, y:12, z:15}, {x:10, y:10, z:8}] requires a minimum of 5 liters of fuel.
     */

    public static int basicPlanner(int[] a) {
        if (null == a || a.length == 0) {
            return 0;
        }

        int fuel = 0;
        int count = 0;
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            if (curr < prev) {
                count -= Math.abs(curr-prev);
            } else if (curr > prev) {
                count += Math.abs(curr-prev);
            }
            if (count > fuel) {
                fuel = count;
            }
            prev = a[i];
        }

        return fuel;
    }

    public static int simplerPlanner(int[] a) {
        if (null == a || a.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > count) {
                count = a[i];
            }
        }

        return count - a[0];
    }

    public static void main(String[] args) {
        int[] a = {10, 0, 6, 15, 8};
        System.out.println(DroneFlightPlanner.basicPlanner(a));
        //System.out.println(DroneFlightPlanner.simplerPlanner(a));
    }
}
