package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/11
 */
public class N273 {


    String[] 个位 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] 十几 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] 几十 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();


        if (num >= 1000000000) {
            res.append(dfs(num / 1000000000));
            num %= 1000000000;
            res.append(" Billion");
        }

        if (num >= 1000000) {
            res.append(" ");
            res.append(dfs(num / 1000000));
            num %= 1000000;
            res.append(" Million");
        }

        if (num >= 1000) {
            res.append(" ");
            res.append(dfs(num / 1000));
            num %= 1000;
            res.append(" Thousand");
        }

        res.append(" ");
        res.append(dfs(num));

        return res.toString().trim();
    }

    public String dfs(int num) {
        StringBuilder res = new StringBuilder();

        int 百 = num / 100;
        int 十 = num % 100 / 10;
        int 个 = num % 10;

        if (百 > 0) {
            res.append(个位[百 - 1]);
            res.append(" Hundred");
        }

        if (十 == 1) {
            res.append(" ");
            res.append(十几[个]);
            return res.toString().trim(); // 防止一个十几的数，那么就会有前置空格了
        } else if (十 >= 2) {
            res.append(" ");
            res.append(几十[十 - 2]);
        }

        if (个 > 0) {
            res.append(" ");
            res.append(个位[个 - 1]);
        }

        return res.toString().trim();
    }

    @Test
    void t() {
        String s = numberToWords(13);
        System.out.println(s);
    }
}
