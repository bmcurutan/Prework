package NotDone;

// Given a menu, find items that sum to value k exactly

import java.util.*;

public class menuWithTotal {
    public static ArrayList<ArrayList<String>> menuItems(Map<String, Double> menu, double total) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        return null;
    }

    private static void helper (ArrayList<ArrayList<String>> res, ArrayList<String> curr, double amount, double total) {
        if (amount == total) {
            res.add(curr);
            return;
        } else if (amount > total) {
            return;
        }


    }

    public static void main(String[] args) {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Turkey sandwich", 5.00);
        menu.put("Chicken wrap", 3.00);
        menu.put("Burger", 10.00);
        menu.put("Dessert", 2.00);
        menu.put("Pop", 1.00);
        menu.put("Fries", 2.00);

        for (ArrayList<String> list : menuItems(menu, 10)) {
            for (String item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
