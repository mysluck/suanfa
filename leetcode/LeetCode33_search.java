/**
 * * URL:https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 33. 搜索旋转排序数组
 */
public class LeetCode33_search {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int sea = 1;
        System.out.println(search(arr, sea));
    }

    //二分查找
    //L M R不相等才能二分 判断L M R 大小判断
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = -1;

        int L = 0;
        int R = nums.length-1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (nums[M] == target) {
                return M;
            }
            if (nums[L] == nums[M] && nums[R] == nums[M]) {
                while (L != M && nums[L] == nums[M]) {
                    L++;
                    if (L == M) {
                        L = M + 1;
                        continue;
                    }
                }
            }

            if (nums[L] != nums[M]) {
                //L>M 右边有序  ex:4 5 1 2 3
                if (nums[L] > nums[M]) {
                    if (target > nums[M] && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else { //[L]<[M] 左侧有序 1 2 3 4 5
                    if (target >= nums[L] && target < nums[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            } else { //L==M M！=R M>R  5 1 2 3 4
                if (nums[M] < nums[R]) {
                    if (target > nums[M] && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    //M>R  4 5 1 2 3
                    if (target >= nums[L] && target < nums[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }

            }
        }

        return ans;
    }


}
