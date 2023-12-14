package extra;

public class 荷兰国旗 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 8, 6, 3, 9, 12, 4, 7, 7};
        solution2(arr);
//        solution(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 将小于等于k的放左边
     *
     * @param arr
     * @param k
     */
    public static void solution(int[] arr, int k) {
        int N = arr.length;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= k) {
                index++;
                swap(arr, i, index);
            }
        }
    }


    /**
     * 将小于等于k的放左边
     *
     * @param arr
     */
    public static void solution(int[] arr) {
        int k = arr[arr.length - 1];
        solution(arr, k);
    }

    /**
     * 小于k放左边 等于k放中间 大于k放右边
     *
     * @param arr
     */
    public static void solution2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int N = arr.length;
        int k = arr[N - 1];
        int firstIndex = -1;
        int lastIndex = N;
        int i = 0;
        while (i < lastIndex) {
            if (arr[i] < k) {
                firstIndex++;
                swap(arr, i, firstIndex);
                i++;
            } else if (arr[i] == k) {
                i++;
            } else if (arr[i] > k) {
                lastIndex--;
                swap(arr, i, lastIndex);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}