package extra;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 8, 2};
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        method(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void method(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        //第一个个第二个对比 大的靠后 第二个和第三个对比
        for (int i = 0 ;i <length; i++) {
//        for (int i = length - 1; i > 0; i--) {
//        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {

                int next = arr[j + 1];
                int cur = arr[j];
                if (next < cur) {
                    swap(arr, j + 1, j);
                }
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
