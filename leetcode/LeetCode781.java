/**
 * 781. 森林中的兔子
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
 * <p>
 * 给你数组 answers ，返回森林中兔子的最少数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：answers = [1,1,2]
 * 输出：5
 * 解释：
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
 * 示例 2：
 * <p>
 * 输入：answers = [10,10,10]
 * 输出：11
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= answers.length <= 1000
 * 0 <= answers[i] < 1000
 */
public class LeetCode781 {

    public static int numRubbit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 1 1 1 2 3 3 3 3 3 3 3
        int ans = 0;
        int cur = arr[0];
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            //遍历数组 如果value相同 说明是同一组 数量+1 不是同一组 则结算上一组
            if (arr[i] == cur) {
                size++;
            } else {
                //判断是几只兔子逻辑  假如 1 1 1 则是4只， 1 1 和1 1 ，如何计算？
                // 判断出来是2组 如何计算2组？ 3/2向上取整  （3+（2-1））/2
                //总数如何计算？ size+（cur+1） 2*（1+1）
                ans += ((size + cur) / (cur + 1)) * (cur + 1);
                cur = arr[i];
                size = 1;
            }
        }
        ans += ((size + cur) / (cur + 1)) * (cur + 1);
        return ans;
    }

    public static void main(String[] args) {

    }
}
