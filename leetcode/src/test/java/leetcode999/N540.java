package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2022/2/14
 */
public class N540 {

    int[] arr;
    int i;
    int j;
    int ans;

    public int singleNonDuplicate(int[] nums) {
        ans = nums[0];
        if (nums.length == 1) {
            return ans;
        }

        //int mid = nums.length / 2;
        arr = nums;
        i = 0;
        j = arr.length - 1;

        dfs();


        return ans;
    }


    // todo zsx 单数 偶数的比较
    public void dfs() {
        if (j - i > 3) {
            int mid = (j + i) / 2;
            if (arr[mid - 1] == arr[mid]) {
                j = mid - 2;
                dfs();
            } else if (arr[mid] == arr[mid + 1]) {
                i = mid + 2;
                dfs();
            } else {
                ans = arr[mid];
            }
        } else {
            for (int k = i; k <= j; k++) {
                //if (arr[])
            }
        }
    }


    @Test
    void t() {
        //System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        //System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
