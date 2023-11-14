/**
 * * URL: https://leetcode.cn/problems/valid-sudoku/?envType=study-plan-v2&envId=top-interview-150
 * 36. 有效的数独
 */
public class LeetCode36_isValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        //
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] temp = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int bid = 3 * (i / 3) + (j / 3);
                    int number = c - '0';
                    if (row[i][number] || col[j][number] || temp[bid][number]) {
                        return false;
                    }
                    row[i][number] = true;
                    col[j][number] = true;
                    temp[bid][number] = true;
                }
            }

        }
        return true;

    }

}
