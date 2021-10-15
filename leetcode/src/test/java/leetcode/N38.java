package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/15
 */
public class N38 {


    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = dfs(str);
        }
        return str;
    }

    public String dfs(String num) {
        StringBuilder res = new StringBuilder();

        char[] chars = num.toCharArray();

        // 初始化
        char str = chars[0];
        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                res.append(count);
                res.append(str);
                continue;
            }

            if (chars[i] != chars[i + 1]) {
                res.append(count);
                res.append(str);
                // 标记下一个字符
                str = chars[i + 1];
                count = 1;
            } else {
                count++;
            }
        }
        return res.toString();
    }


    @Test
    void t() {
        //String dfs = dfs("1");
        //System.out.println(dfs);

        String s = countAndSay(5);
        System.out.println(s);
    }
}
