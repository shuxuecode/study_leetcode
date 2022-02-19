package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**todo
 * @date 2022/2/19
 */
public class N969 {
    int[] array;
    List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        array = arr;
        for (int i = array.length; i > 0; i--) {
            int num = i;
            if (array[num - 1] == num) {
                continue;
            }
            int index = find(num);
            if (index == 0) {
                reverse(num - 1);
            } else {
                reverse(index);
                reverse(num - 1);
            }
        }
        return res;
    }

    public int find(int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return 0;
    }


    public void reverse(int n) {
        res.add(n + 1);
        int i = 0, j = n;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    void t() {
        List<Integer> list = pancakeSort(new int[]{3, 2, 4, 1});
        list.stream().forEach(System.out::println);
    }
}
