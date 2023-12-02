import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LeetCode54_spiralOrder {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while (x1 <= x2 && y1 <= y2) {
            process(matrix, x1++, y1++, x2--, y2--, ans);
        }
        return ans;
    }

    private static void process(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if (x1 == x2) {
            while (y1 <= y2) {
                ans.add(matrix[x1][y1++]);
            }
        } else if (y1 == y2) {
            while (x1 <= x2) {
                ans.add(matrix[x1++][y1]);
            }
        } else {
            int tempX = x1;
            int tempy = y1;
            while (tempy < y2) {
                ans.add(matrix[x1][tempy++]);
            }
            while (tempX < x2) {
                ans.add(matrix[tempX++][y2]);
            }
            while (y1 < y2) {
                ans.add(matrix[x2][y2--]);
            }
            while (x1 < x2) {
                ans.add(matrix[x2--][y1]);
            }
        }
    }

}
