package extra;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 8, 2};
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        method(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    //for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
//        for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
//            swap(arr, j, j + 1);
//        }
//    }
    //保证第一个有序 第1。2有序 1。2。3有序
    private static void method(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
