/**
 * 36. 有效的数独
 * 难度
 * 中等
 * <p>
 * 1062
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class LeetCode36 {

    public static boolean isValidSudoku(char[][] board) {
        //行
        boolean[][] row = new boolean[9][10];
        //列
        boolean[][] col = new boolean[9][10];
        //桶
        boolean[][] bucker = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int buckerIdx = 3 * (i / 3) + (j / 3);
                    if (row[i][num] || col[j][num] || bucker[buckerIdx][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucker[buckerIdx][num] = true;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
