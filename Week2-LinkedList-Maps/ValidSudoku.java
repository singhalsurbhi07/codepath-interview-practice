/**Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

 The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



 The input corresponding to the above configuration :

 ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/

public class Solution {

    private String getBoxKey(int row, int col) {
        return String.valueOf(row/3) + "_" + String.valueOf(col/3);
    }

    private boolean isValid(char c, int row, int col, Map<Integer,List<Character>> row_map,
                            Map<Integer, List<Character>> col_map, Map<String, List<Character>> inner_box_map) {
        if (row_map.containsKey(row)) {
            List<Character> existing = row_map.get(row);
            if (existing.contains(c)) {
                return false;
            }
        }

        if (col_map.containsKey(col)) {
            List<Character> existing = col_map.get(col);
            if (existing.contains(c)) {
                return false;
            }
        }

        String inner_box_key = getBoxKey(row, col);
        if (inner_box_map.containsKey(inner_box_key)) {
            List<Character> existing = inner_box_map.get(inner_box_key);
            if (existing.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private void addCharToMaps(char c, int row, int col, Map<Integer,List<Character>> row_map,
                               Map<Integer, List<Character>> col_map, Map<String, List<Character>> inner_box_map) {
        if (row_map.containsKey(row)) {
            row_map.get(row).add(c);
        } else {
            List<Character> newList = new ArrayList<>();
            newList.add(c);
            row_map.put(row, newList);
        }

        if (col_map.containsKey(col)) {
            col_map.get(col).add(c);
        } else {
            List<Character> newList = new ArrayList<>();
            newList.add(c);
            col_map.put(col, newList);
        }

        String inner_box_key = getBoxKey(row, col);
        if (inner_box_map.containsKey(inner_box_key)) {
            inner_box_map.get(inner_box_key).add(c);
        } else {
            List<Character> newList = new ArrayList<>();
            newList.add(c);
            inner_box_map.put(inner_box_key, newList);
        }
    }

    public int isValidSudoku(final List<String> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        int len = a.size();
        Map<Integer,List<Character>> row_map = new HashMap<>();
        Map<Integer, List<Character>> col_map = new HashMap<>();
        Map<String, List<Character>> inner_box_map = new HashMap<>();

        for (int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                char c = a.get(i).charAt(j);
                if (c != '.') {
                    if (!isValid(c, i, j, row_map, col_map, inner_box_map)) {
                        return 0;
                    } else {
                        addCharToMaps(c, i, j, row_map, col_map, inner_box_map);
                    }
                }

            }
        }

        return 1;
    }
}
