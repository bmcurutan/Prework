// Get the longest shared substring of two strings
public class LongestSubstring {
    public String longestSub(String a, String b) {
        String longest = "";
        String s = "";
        if (a == null || b == null) {
            return s;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf("" + a.charAt(i)) != -1) {
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        s += a.charAt(i);
                        if (s.length() > longest.length()) {
                            longest = s;
                        }
                        i++;
                        if (i == a.length()) {
                            break;
                        }
                    }
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        System.out.println("---START---");
        System.out.println(test.longestSub(null, null));
        System.out.println(test.longestSub("ABCDEFGHIJKLM", "DFGHIJKLMNOPQ")); // DEFGHIJKLM
        System.out.println(test.longestSub("ABCDE", "FGHIJK"));
        System.out.println("---END---");
    }
}
