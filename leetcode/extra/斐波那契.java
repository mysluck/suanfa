package extra;

/**
 * n的阶乘*n-1的阶乘。。。*1
 */
public class 斐波那契 {
    public static void main(String[] args) {
        int x = 4;
        int sum = 0;
        int cur = 1;
        for (int i = 1; i <= x; i++) {
            cur = cur * i;
            sum = sum + cur;
        }
        System.out.println(sum);
    }

}
