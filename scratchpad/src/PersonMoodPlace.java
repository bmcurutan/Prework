import java.util.*;

public class PersonMoodPlace {

    /* Permutations (18)
     * {Valerie, John, David} was in a {good, bad} mood and went to the {beach, party, library}
     * Valerie good beach
     * Valerie good party
     * Valerie good library
     * Valerie bad beach
     * Valerie bad party
     * Valerie bad library
     */

    public static Set<String> perms(String[] person, String[] mood, String[] place) {
        Set<String> res = new HashSet<>();
        helper(res, person, mood, place);
        return res;
    }

    private static void helper(Set<String> res, String[] person, String[] mood, String[] place) {
        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < mood.length; j++) {
                for (int k = 0; k < place.length; k++) {
                    res.add(person[i] + " " + mood[j] + " " + place[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] person = {"Valerie", "John", "David"};
        String[] mood = {"good", "bad"};
        String[] place = {"beach", "party", "library"};
        Set<String> res = perms(person, mood, place);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
