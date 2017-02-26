package NotDone;

import java.util.*;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        if (a == 0) {
            return res;
        }

        ArrayList<String> board = new ArrayList<String>(a);
        for (int i = 0; i < a; i++) {
            String temp = "";
            for (int j = 0; j < a; j++) {
                temp += ".";
            }
            board.add(temp);
        }
        if (solveNQueens(res, board, 0) && checkBoard(board)) {
            res.add(board);
        }

        return res;
    }

    private boolean checkBoard(ArrayList<String> board) {
        /*for (String s : board) {
            if (s.indexOf("Q") < 0) {
                return false;
            }
        }*/
        return true;
    }

    private boolean solveNQueens(ArrayList<ArrayList<String>> res, ArrayList<String> board, int col) {
        if (col >= board.size()) {
            res.add(board);
            return true;
        }

        for (int i = 0; i < board.size(); i++) {
            if (canAddQueen(board, i, col)) {
                addQueen(board, i, col);

                if (solveNQueens(res, copy(board), col+1)) {
                    return true;
                }

                removeQueen(board, i, col);
            }
        }

        return false;
    }

    private boolean canAddQueen(ArrayList<String> board, int row, int col) {
        // Check up
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check left
        for (int j = 0; j < col; j++) {
            if (board.get(row).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < board.size() && j >= 0; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private ArrayList<String> copy(ArrayList<String> board) {
        ArrayList<String> board2 = new ArrayList<String>();
        board2.addAll(board);
        return board2;
    }

    private void addQueen(ArrayList<String> board, int row, int col) {
        String temp = "";
        for (int j = 0; j < board.size(); j++) {
            if (j == col) {
                temp += "Q";
            } else {
                temp += ".";
            }
        }
        board.set(row, temp);
    }

    private void removeQueen(ArrayList<String> board, int row, int col) {
        String temp = board.get(row);
        String[] array = temp.split("");
        array[col] = ".";
        board.set(row, Arrays.toString(array));
    }

    private void printNQueens(ArrayList<ArrayList<String>> res) {
        System.out.println("--- START ---");
        for (ArrayList<String> set : res) {
            for (int i = 0; i < set.size(); i++) {
                System.out.println(set.get(i));
            }
        }
        System.out.println("--- END ---\n");
    }

    public static void main(String[] args) {

        //Solution sol = new Solution();
        /*ArrayList<ArrayList<String>> test = sol.solveNQueens(0);
        sol.printNQueens(test);
        ArrayList<ArrayList<String>> test1 = sol.solveNQueens(1);
        sol.printNQueens(test1);
        ArrayList<ArrayList<String>> test2 = sol.solveNQueens(2);
        sol.printNQueens(test2);
        ArrayList<ArrayList<String>> test3 = sol.solveNQueens(3);
        sol.printNQueens(test3);*/
        //ArrayList<ArrayList<String>> test4 = sol.solveNQueens(4);
        //sol.printNQueens(test4);
    }
}
