import java.util.*;

/*
Time Planner

Implement a meeting planner that can schedule meetings between two persons at a time.

Time is represented by Unix format (also called Epoch) - a positive integer holding the seconds since January 1st, 1970 at midnight.

Planner input:

dur - Meeting duration in seconds (a positive integer).
timesA, timesB - Availability of each person, represented by an array of arrays.
Each sub-array is a time span holding the start (first element) and end (second element) times.
You may assume that time spans are disjointed.
Planner output:

Array of two items - start and end times of the planned meeting, representing the earliest opportunity for the two persons to meet for a dur length meeting.
If no possible meeting can be scheduled, return an empty array instead.
Design and implement an efficient solution and analyze its runtime and space complexity.

Hints & Tips
If your peer can't improve the naive solution, try to ask if you must check overlap between all possible time spans pair. Then you can ask how to perfom a more efficient iteration.

If that doesn't help, ask when pre-processing of the availability array can you make to improve efficiency.

Checking for overlap can be done in few ways and doesn't necessarily have to include min and max functions.  If the formulation of your peer seems cumbersome, try raise their awareness and ask how can you simplify the logic condition for overlap.

As in any array iteration, check for proper indices limit and for covering all elements within arrays.

On any case, solution is not completed if the complexity is more than linear O(n+m) once the availability arrays are sorted.

if you some time left after your peer has reached a proper solution, you can ask how would they handle a case where you can't assume that time spans are non-intersecting. On this case your peer should merge time spans by lexicographical order of start time and end time, on a linear scan.

Unix time format represents the GMT time zone. Therefore, your peer doesn't have to deal with time zone conversions.

Solution
A naive solution would loop through both availability arrays and check every possible pair of availability time spans for a minimal overlap of dur seconds.
Such a solution is not efficient and involves O(n⋅m) runtime complexity (when n and m are lengths of timesA and timesB), and O(1) space complexity.

We can do better than that if the availability arrays are sorted (always consider asking your interviewer if the input is sorted).
Even if availability arrays are not sorted, we can still do better by sorting them first.
Since we know nothing else about the times, we can sort each availability array by start times at O(n∙log n) time complexity (when n is the number of time slots in the array).

After taking care of sorting, we can iterate over both arrays at once.
We use one index for each array, while forwarding one index at a time.
At each step we check if:

No overlap exists:
One time span ends before the other starts.
In this case, increase the index of the array with the earlier time.
Overlap exists for at least dur seconds:
The minimum of both end times is more than dur seconds after the maximum of both start times.
In this case, we've found a meeting time.
Overlap exists for less than dur seconds:
we've eliminated both previous cases.
In this case, we increase the index of the array with the earlier start time of its next time span.
ia = 0
ib = 0
while (ia < timesA.length and ib < timesB.length):
   start = max(timesA[ia][0], timesB[ib][0])
   end = min(timesA[ia][1], timesB[ib][1])
   if (start + dur <= end):
      return [start, start + dur]
   else:
      if (timesA[ia][1] < timesB[ib][1]):
         ia = ia + 1
      else:
         ib = ib + 1
return []
Runtime Complexity: linear O(n+m) for sorted time arrays or O(n∙log n+m∙log m) for non-sorted arrays, where n and m are lengths of timesA and timesB.

Space Complexity: constant O(1) for either case.
 */

public class TimePlanner {

    public static int[] meetingTime(int dur, int[][] timesA, int[][] timesB) {
        int res[] = new int[2]; // start, end

        if (dur < 1 || timesA == null || timesA.length == 0 || timesB == null || timesB.length == 0) {
            return res;
        }

        int i = 0;
        int j = 0;
        while (i < timesA.length && j < timesB.length) {
            int start = Math.max(timesA[i][0], timesB[j][0]);
            int end = Math.min(timesA[i][1], timesB[j][1]);
            //System.out.println(timesA[i][0] + " " + timesA[i][1] + " : " + start + " " + end);
            if (start + dur <= end) {
                res[0] = start;
                res[1] = start + dur;
                return res;
            } else {
                if (timesA[i][1] < timesB[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] a1 = new int[0][0];
        int[][] b1 = new int[0][0];
        System.out.println("1: " + meetingTime(100, a1, b1)[0] + " " + meetingTime(100, a1, b1)[1]); // Nothing

        int[][] a2 = { {1, 2}, {4, 5}, {7, 10} };
        System.out.println("2: " + meetingTime(0, a2, b1)[0] + " " + meetingTime(0, a2, b1)[1]); // Nothing

        int [][] b2 = { {3, 4}, {6, 7}, {8, 10} };
        System.out.println("3: " + meetingTime(2, a2, b2)[0] + " " + meetingTime(2, a2, b2)[1]); // 8 10

        int[][] a3 = { {1, 2}, {3, 5} };
        int[][] b3 = { {3, 4}, {6, 7} };
        System.out.println("4: " + meetingTime(1, a3, b3)[0] + " " + meetingTime(1, a3, b3)[1]); // 3 4
    }
}



