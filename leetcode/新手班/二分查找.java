package 新手班;

public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 4, 7, 8, 10};
        System.out.println(select(arr, 1));
        System.out.println(select1(arr, 1));
    }

    //二分查找
    private static int select(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }


    //二分查找查询<num 最左位置 【 1，1，3，5，7，8，8，10】 查找小于2 最右位置 返回1
    private static int select1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid] > num) {
                R = mid - 1;
            } else {
                ans = mid;
                L = mid + 1;
            }
        }
        return ans;
    }


}
