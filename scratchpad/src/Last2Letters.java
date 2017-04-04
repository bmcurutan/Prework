import java.util.*;

public class Last2Letters {
    // Given a list of strings, group them by the last two letters

    public static Map<String, ArrayList<String>> groupByLastTwoLetters(String[] a) {
        Map<String, ArrayList<String>> res = new HashMap<>();
        for (String s : a) {
            String key = s.substring(s.length()-2, s.length());
            ArrayList<String> temp = new ArrayList<>();
            if (res.containsKey(key)) {
                temp = res.get(key);
            }
            temp.add(s);
            res.put(key, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = { "top", "hat", "cat", "bop", "cop", "tray", "phone"};
        Map<String, ArrayList<String>> res = groupByLastTwoLetters(test);

        for (String key : res.keySet()) {
            System.out.print(key + ": ");
            for (String s : res.get(key)) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }

        // op: top, bop, cop
        // at: hat, cat
        // ay: tray
        // ne: phone
    }
}
