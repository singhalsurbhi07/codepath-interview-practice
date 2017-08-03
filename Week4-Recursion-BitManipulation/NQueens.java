/*Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

public class NQueens {

    private void getResult(ArrayList<ArrayList<String>> result, int [][] visited, int a) {
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < a; j++) {
                if (visited[i][j] == -1) {
                    b.append("Q");
                } else {
                    b.append(".");
                }
            }
            output.add(b.toString());
        }

        result.add(output);
    }

    private boolean canPutQueen(int r, int c, int[][] visited, int a) {
        int row = r;
        while(row >= 0) {
            if (visited[row][c] == -1) {
                return false;
            }

            row -= 1;
        }

        int col = c;
        while(col >= 0) {
            if (visited[r][col] == -1) {
                return false;
            }

            col -= 1;
        }

        int i;
        int j;
        for (i=r, j = c; i>=0 && j>=0; i--, j--) {
            if (visited[i][j] == -1) {
                return false;
            }
        }

        for (i=r, j = c; i>=0 && j<a; i--, j++) {
            if (visited[i][j] == -1) {
                return false;
            }
        }

        return true;


    }

    private void NQueensUtil(ArrayList<ArrayList<String>> result, int a, int currentRow,
                             int [][] visited) {
        if (currentRow == a) {
            getResult(result, visited, a);
            return;
        }
        for (int i = 0; i < a; i++) {
            if (canPutQueen(currentRow, i, visited, a)) {
                visited[currentRow][i] = -1;
                NQueensUtil(result, a, currentRow + 1, visited);
                visited[currentRow][i] = 0;
            }
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        if (a == 0) {
            return null;
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int [][] visited = new int[a][a];
        NQueensUtil(result, a, 0, visited);
        return result;
    }
}