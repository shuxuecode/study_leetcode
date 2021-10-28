package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @date 2021/10/28
 */
public class N869 {

    // 记录所有可能出现的2的幂的数字，重新排列后的字符串
    HashSet<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        if (n == 1) return true;
        init();
        String str = sort(n);
        return set.contains(str);
    }

    // 得到所有指定范围内数字重新排序后的字符串
    public void init() {
        int n = 2;
        double max = Math.pow(10, 9);
        while (n <= max) {
            set.add(sort(n));
            n = n * 2;
        }
    }

    public String sort(int n) {
        String str = String.valueOf(n);

        // 将数字转成数组
        List<Integer> list = new ArrayList<>();

        for (int i = 0, len = str.length(); i < len; i++) {
            int num = str.charAt(i) - '0';
            list.add(num);
        }

        // 对数组进行排序
        list.sort(Comparator.naturalOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : list) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    @Test
    void t() {
        System.out.println(reorderedPowerOf2(46));

        init();

        System.out.println(set);
        
    }
}
