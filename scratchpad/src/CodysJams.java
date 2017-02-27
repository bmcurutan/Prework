/*
Problem

Cody, the owner of the legendary Cody's Jams store, is planning a huge jam sale. To make things simple,
he has decided to sell every item in his store at a 25% discount — that is, each item's sale price is
exactly 75% of its regular price. Since all of his regular prices happened to be integers divisible by
four, his sale prices are conveniently also all integers.

To prepare for the sale, he placed an order to print new labels for all of his items at their sale prices.
He also placed an order to print new labels for all of his items at their regular prices, to use once the
sale is over.

Cody just came back from picking up his order. Unfortunately, the printer gave him both orders in one
combined stack, sorted by price. Both the sale price and the regular price label for each item are present
somewhere in the stack. However, both types of labels look the same, and since he does not remember the
price of every item, he is not sure which labels are the sale price labels. Can you figure that out?

For instance, if the regular prices were 20, 80, and 100, the sale prices would be 15, 60, and 75, and the
printer's stack would consist of the labels 15, 20, 60, 75, 80, and 100.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists
of two lines. The first line contains a single integer N, the number of items in Cody's store. The second
line contains 2N integers P1, P2, ..., P2N in non-decreasing order by the price printed on each label given
by the printer.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
and y is a list of N integers: the labels containing sale prices, in non-decreasing order.

Limits

1 ≤ T ≤ 100.
1 ≤ Pi ≤ 109, for all i.
Pi ≤ Pi+1, for all i. (The prices are in non-decreasing order.)
It is guaranteed that a unique solution exists.
Small dataset

1 ≤ N ≤ 4.
Large dataset

1 ≤ N ≤ 100.
Sample


Input

Output

2
3
15 20 60 75 80 100
4
9 9 12 12 12 15 16 20

Case #1: 15 60 75
Case #2: 9 9 12 15
Case #1 is the one described in the problem statement.

Notice in Case #2 that it is possible for multiple items to have the same price, and for an item to have a
regular price that equals the sale price of another item.
 */

import java.util.*;
import java.io.*;

public class CodysJams {
    public static String salePrices(int[] arr) {
        String res = "";
        if (arr == null || arr.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int price = arr[i];
            if (map.containsKey(price) && map.get(price) > 0) {
                map.put(price, map.get(price) - 1);
                int regPrice = (int) (price / 0.75);
                if (map.containsKey(regPrice) && map.get(regPrice) > 0) {
                    res += " " + arr[i];
                    map.put(regPrice, map.get(regPrice) - 1);
                }
            }
        }

        return res;
    }

    //private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/A-small-practice.in";
    //private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/A-small-practice.out";
    private static final String FILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/A-large-practice.in";
    private static final String OUTFILENAME = "/Users/biancacurutan/Documents/bmcurutan/scratchpad/scratchpad/src/IO/A-large-practice.out";

    public static void main(String[] args) {
        //int[] test1 = { 15, 20, 60, 75, 80, 100 };
        //System.out.println("Case #1:" + salePrices(test1));

        //int[] test2 = { 9, 9, 12, 12, 12, 15, 16, 20 };
        //System.out.println("Case #2:" + salePrices(test2));

        //int[] test2 = { 750000000, 1000000000 };
        //System.out.println("Case #3:" + salePrices(test2));

        BufferedReader br = null;
        FileReader fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            pw = new PrintWriter(OUTFILENAME, "UTF-8");

            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {
                int numPrices = Integer.parseInt(br.readLine())*2;
                int[] prices = new int[numPrices];

                String line = br.readLine();
                String[] tokens = line.split(" ");

                for (int j = 0; j < numPrices; j++) {
                    prices[j] = Integer.parseInt(tokens[j]);
                }

                pw.println("Case #" + (i+1) + ":" + salePrices(prices));
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
