package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2022/1/28
 */
public class N1996 {

    // 超出时间限制
    public int numberOfWeakCharacters2(int[][] properties) {
        // 先排序
        Arrays.sort(properties, (a, b) -> {
            return a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0;
        });

        int ans = 0;
        for (int i = 1; i < properties.length; i++) {

            for (int j = i; j < properties.length; j++) {
                if (properties[i - 1][0] < properties[j][0] && properties[i - 1][1] < properties[j][1]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    // todo
    public int numberOfWeakCharacters(int[][] properties) {
        // 先按攻击力排序（升序），然后倒序遍历，记录后面最大的防御力
        // 这里排序要注意一下，如果有相同攻击力的，我们让防御力低的排在后面
        // 这样就可以避免出现 [攻击力相同，防御力不同] 数据的干扰
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 反向遍历，只要后面有更大的防御力，当前角色就是弱角色
        int ans = 0, max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < max) {
                ans++;
            } else {
                max = properties[i][1];
            }
        }

        return ans;
    }

    @Test
    void t() {
        int[] arr1 = {5, 5};
        int[] arr2 = {4, 4};
        int[] arr3 = {3, 3};
        int[][] properties = {arr2, arr1, arr3};

        //System.out.println(numberOfWeakCharacters(properties));


        int[] arr11 = {7, 7};
        int[] arr12 = {1, 2};
        int[] arr13 = {9, 7};
        int[] arr14 = {7, 3};
        int[] arr15 = {3, 10};
        int[] arr16 = {9, 8};
        int[] arr17 = {8, 10};
        int[] arr18 = {4, 3};
        int[] arr19 = {1, 5};
        int[] arr20 = {1, 5};
        int[][] arr21 = {arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20};

        System.out.println(numberOfWeakCharacters(arr21));
    }
}
