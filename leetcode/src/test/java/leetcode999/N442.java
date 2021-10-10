package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N442 {

    // 击败了90%
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);

            if (nums[num - 1] < 0) {
                res.add(num);
            } else {
                nums[num - 1] = -nums[num - 1];
            }
        }
        return res;
    }


    // 只击败了18.5%
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();


        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    @Test
    void t() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> list = findDuplicates(nums);

        System.out.println(list);
    }
}
