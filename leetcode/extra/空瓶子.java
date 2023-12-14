package extra;

public class 空瓶子 {
    public static void main(String[] args) {
        int a = 2;
        int ans = f(a);
        System.out.println(ans);
    }

    //
    private static int f(int a) {

        int ans = a;
        int tmp = a;
        int mol = 0;

        while (tmp != 0) {
            int temp = (tmp + mol) / 3;
            mol = (tmp + mol) % 3;
            tmp = temp;
            ans += tmp;
        }
        return ans;
    }
}
