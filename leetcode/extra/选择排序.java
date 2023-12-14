package extra;

import java.util.Arrays;

public class 选择排序 {
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
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }

            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
