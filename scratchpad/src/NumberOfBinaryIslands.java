// Count the number of islands (groups of 1s) on a binary nxn matrix

public class NumberOfBinaryIslands {
    public static int numberOfIslands(int[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    matrix[i][j] = 2;
                    findConnections(matrix, i, j);
                }
            }
        }
        return count;
    }

    private static void findConnections(int[][] matrix, int i, int j) {
        int n = matrix.length;
        // Right
        if (inRange(i, n) && inRange(j+1, n) && matrix[i][j+1] == 1) {
            matrix[i][j+1] = 2;
            findConnections(matrix, i, j+1);
        }
        // Left-Bottom
        if (inRange(i+1, n) && inRange(j-1, n) && matrix[i+1][j-1] == 1) {
            matrix[i+1][j-1] = 2;
            findConnections(matrix, i+1, j-1);
        }
        // Bottom
        if (inRange(i+1, n) && inRange(j, n) && matrix[i+1][j] == 1) {
            matrix[i+1][j] = 2;
            findConnections(matrix, i+1, j);
        }

        // Right-Bottom
        if (inRange(i+1, n) && inRange(j+1, n) && matrix[i+1][j+1] == 1) {
            matrix[i+1][j+1] = 2;
            findConnections(matrix, i+1, j+1);
        }
    }

    private static boolean inRange(int i, int n) {
        if (i >= 0 && i < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1,1,0,0,0},
                            {0,1,0,0,1},
                            {1,0,0,1,1},
                            {0,0,0,0,0},
                            {1,0,1,0,1}};
        System.out.println(numberOfIslands(matrix)); // 5
    }
}


