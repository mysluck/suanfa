package 新手班;

//获取36-67范围随机数有序 0-31
public class 范围内最小值 {

    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 2, 9};
        System.out.println(method(arr));
    }

    public static int method(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length;
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[length - 1] < arr[length - 2]) {
            return length - 1;
        }
        int L = 0;
        int R = length;
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] > arr[R] ? R : L;
    }

}
