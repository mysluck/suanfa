/**
 * 37. 解数独
 * 难度
 * 困难
 * <p>
 * 1564
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 */
public class LeetCode37 {

    public static void solveSudoku(char[][] board) {
        //行
        boolean[][] row = new boolean[9][10];
        //列
        boolean[][] col = new boolean[9][10];
        //桶
        boolean[][] bucker = new boolean[9][10];

        initMap(row, col, bucker, board);

        process(board, 0, 0, row, col, bucker);
    }

    //
    private static boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucker) {
        if (i == 9) {
            return true;
        }
        int nexti = j != 8 ? i : i + 1;
        int nextj = j == 8 ? 0 : j + 1;
        if (board[i][j] != '.') {
            return process(board, nexti, nextj, row, col, bucker);
        } else {
            for (int k = 1; k < 10; k++) {
                if (!row[i][k] && !col[j][k] && !bucker[3 * (i / 3) + (j / 3)][k]) {
                    row[i][k] = true;
                    col[j][k] = true;
                    bucker[3 * (i / 3) + (j / 3)][k] = true;
                    board[i][j] = (char) (k + '0');
                    if (process(board, nexti, nextj, row, col, bucker)) {
                        return true;
                    }
                    row[i][k] = false;
                    col[j][k] = false;
                    bucker[3 * (i / 3) + (j / 3)][k] = false;
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }


    //初始化map
    public static void initMap(boolean[][] row, boolean[][] col, boolean[][] bucker, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int cur = board[i][j] - '0';
                    row[i][cur] = true;
                    col[j][cur] = true;
                    bucker[3 * (i / 3) + (j / 3)][cur] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(board);
    }
}
