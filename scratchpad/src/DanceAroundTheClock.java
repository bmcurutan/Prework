/*
Problem

The owner of a prestigious ballroom has painted a beautiful circular clock on the dance floor, and a
group of D dancers numbered 1 through D are about to literally "dance around the clock". They are
standing in a circle, with dancer 1 at the 12:00 position of the circle and the other dancers going
clockwise around the circle in increasing numerical order. The number of dancers is even.

The dance will go on for N turns. On the i-th turn (counting starting from 1), the following will happen:

If i is odd, then the dancer currently at the 12:00 position will swap positions with the next dancer
in clockwise order. Then, going past those two, the next pair of dancers in clockwise order will swap
positions, and so on, all the way around the ring clockwise, until all dancers have participated in
exactly one swap.
If i is even, then the dancer currently at the 12:00 position will swap positions with the next dancer
in counterclockwise order. Then, going past those two, the next pair of dancers in counterclockwise
order will swap positions, and so on, all the way around the ring counterclockwise, until all dancers
have participated in a swap.
For example, this diagram shows the initial state and two turns of a dance with eight people.


Which two dancers will be next to dancer number K when the dance is over?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one
line with three integers D, K, and N: the total number of dancers, the number of one of the dancers, and
the number of turns the dance will go on for.

Output

For each test case, output one line containing Case #x: y z, where:

x is the test case number (starting from 1).
y is the number of the dancer who will be standing to dancer number K's left (that is, one step away in
clockwise order) when the dance is over.
z is the number of the dancer who will be standing to dancer number K's right (that is, one step away in
counterclockwise order) when the dance is over.
Limits

1 ≤ T ≤ 100.
D is even.
1 ≤ K ≤ D.
Small dataset

4 ≤ D ≤ 10.
1 ≤ N ≤ 10.
Large dataset

4 ≤ D ≤ 108.
1 ≤ N ≤ 108.
Sample


Input

Output

3
8 3 1
8 4 2
4 1 8

Case #1: 6 4
Case #2: 1 7
Case #3: 2 4
For Cases #1 and #2, refer to the illustration above. In Case #1, after 1 turn, dancer 6 is to dancer
3's left, and dancer 4 is to dancer 3's right. In Case #2, after 2 turns, dancer 1 is to dancer 4's left,
and dancer 7 is to dancer 4's right. Remember that you're looking from the dancer's perspective; it may
help to think in terms of clockwise and counterclockwise instead of left and right.

In Case #3, after eight turns, the arrangement looks the same as the initial arrangement, with dancer 2
to dancer 1's left, and dancer 4 to dancer 1's right.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DanceAroundTheClock {
    public static String dance(int num, int dancer, int turns) {
        int[] dancers = new int[num];
        for (int i = 0; i < num; i++) {
            dancers[i] = i+1;
        }
        //printArr(dancers);

        for (int i = 1; i <= turns%num; i++) {
            if (i % 2 == 1) { // odd
                dancers = oddTurn(dancers);
                //printArr(dancers);
            } else {
                dancers = evenTurn(dancers);
                //printArr(dancers);
            }
        }

        for (int i = 0; i < num; i++) {
            if (dancers[i] == dancer) {
                int clockwise = i+1 < dancers.length ? dancers[i+1] : dancers[0];
                int counterclockwise = i-1 >= 0 ? dancers[i-1] : dancers[dancers.length-1];
                return clockwise + " " + counterclockwise;
            }
        }

        return "";
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] oddTurn(int[] arr) {
        // 1-2, 3-4, 5-6, 7-8
        for (int i = 0; i < arr.length-1; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        return arr;
    }

    private static int[] evenTurn(int[] arr) {
        //2-3, 4-5, 6-7, 8-1
        for (int i = 1; i < arr.length-2; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        int temp = arr[arr.length-1];
        arr[arr.length-1] = arr[0];
        arr[0] = temp;
        return arr;
    }

    //private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/B-small-practice.in";
    //private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/B-small-practice.out";
    private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/B-large-practice.in";
    private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/B-large-practice.out";

    public static void main(String[] args) {
        /*int[] test1 = { 8, 3, 1 };
        //System.out.println(dance(test1)); // 6 4

        int[] test2 = { 8, 4, 2 };
        System.out.println(dance(test2)); // 1 7*/

        //System.out.println(dance(4, 1, 8%4)); // 2 4

        BufferedReader br = null;
        FileReader fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            pw = new PrintWriter(OUTFILENAME, "UTF-8");

            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {
                String line = br.readLine();
                String[] tokens = line.split(" ");

                int num = Integer.parseInt(tokens[0]);
                int dancer = Integer.parseInt(tokens[1]);
                int turns = Integer.parseInt(tokens[2]);

                pw.println("Case #" + (i+1) + ": " + dance(num, dancer, turns));
            }

            /*String currentLine;
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
                if (pw != null)
                    pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
