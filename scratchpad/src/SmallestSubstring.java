import java.util.*;

public class SmallestSubstring {

/*
The "Smallest Substring of All Characters" Problem

Given an array with unique characters arr and a string str, find the smallest substring of str containing all characters of arr.

Example:
arr: [x,y,z], str: xyyzyzyx
result: zyx

Implement your solution and analyze the runtime complexity

function getShortestUniqueSubstring(arr, str):
   t = 0
   result = null
   uniqueCounter = 0
   countMap = new Map()
   # initialize countMap:
   for i from 0 to length(arr)-1:
      countMap.setValueOf(arr[i], 0)
   # scan str
   for h from 0 to length(str)-1:
      # handle the new head
      head = str.charAt(h)
      if countMap.keyExists(head) == false:
         continue
      headCount = countMap.getValueOf(head)
      if headCount == 0:
         uniqueCounter = uniqueCounter + 1
      countMap.setValueOf(head, headCount + 1)
      # push tail forward
      while uniqueCounter == length(arr):
         tempLength = h - t + 1
         if tempLength == arr.length:
            return str.substring(t, h)
         if (!result or tempLength < length(result)):
            result = str.substring(t, h)
         tail = str.charAt(t)
         if countMap.keyExists(tail):
            tailCount = countMap.getValueOf(tail) - 1
            if tailCount == 0:
               uniqueCounter = uniqueCounter - 1
            countMap.setValueFor(tail, tailCount)
         t = t + 1
   return result

}
 */

    // Pre: arr, s != null
    // Post: return smallest substring of All characters
    public static String smallestSubstring(char[] arr, String s) {
        String res = "";
        for (int i = 0; i <= s.length()-arr.length; i++) {
            Set<Character> temp = copy(arr);
            String substring = "";
            int k = i;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                substring += c;
                if (temp.contains(c)) {
                    temp.remove(c);
                }
                if (temp.isEmpty()) {
                    if (res.length() == 0 || substring.length() < res.length()) {
                        res = substring;
                    }
                    break;
                }
                if (temp.size() == arr.length-1) {
                    k = j;
                }
            }
            i = k;
        }
        return res;
    }

    private static Set<Character> copy(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }

    public static void main(String[] args) {
        char[] arr = {'x','y','z'};
        char[] arr2 = {'x'};
        System.out.println("1: " + smallestSubstring(arr, "xyyzyzyx")); // "zyx"
        System.out.println("2: " + smallestSubstring(arr, "xayayazyzayx")); // "zayx"
        System.out.println("3: " + smallestSubstring(arr, "xyyzyzyx")); // "zyx"
        System.out.println("4: " + smallestSubstring(arr2, "xyyzyzyx")); // "x"
        System.out.println("5: " + smallestSubstring(arr2, "abcabcabc")); // ""
    }
}
