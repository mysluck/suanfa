package extra;

public class 快速排序 {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 2, 10, 3};
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr);
        System.out.println(arr);
    }

    public static void quickSort(int[] arr) {
        int index = 0;
        int comNum = arr[arr.length - 1];
        int less = 0;
        while (index < arr.length) {
            if (arr[index] <= comNum) {
                swap(arr, index++, less++);
            } else {
                index++;
            }
        }

    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}