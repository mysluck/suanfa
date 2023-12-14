package extra;

//获取36-67范围随机数有序 0-31
public class 随机数有序 {

    //1-5范围内有序
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    //获取0，1等比随机
    public static int f1() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    //随机返回0-127数字
    public static int f2() {
        return (f1() << 2) + (f1() << 1) + f1();
    }

    //返回0-6
    public static int f3() {
        int ans = 0;
        do {
            ans = f2();
        } while (ans == 7);
        return ans;
    }

    //返回1-7
    public static int f4() {
        return f3() + 1;
    }

    public static void main(String[] args) {
        int count = 1000;
        int[] result = new int[100];
        for (int i = 0; i < count; i++) {
            int x = f4();
            result[x]++;
        }
        print(result);
    }

    public static void print(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("数字：" + i + "出现次数：" + arr[i]);

        }
    }

}
