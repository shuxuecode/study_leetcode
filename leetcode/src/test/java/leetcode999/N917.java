package leetcode999;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @date 2022/2/23
 */
public class N917 {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            while (i < j && !check(chars[i])) {
                i++;
            }
            while (i < j && !check(chars[j])) {
                j--;
            }
            if (i < j && check(chars[i]) && check(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }

    private boolean check(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    @Test
    void t() {
        String s = "Test1ng-Leet=code-Q!";
        String res = reverseOnlyLetters(s);
        System.out.println(res);
        Assertions.assertEquals("Qedo1ct-eeLg=ntse-T!", res, "错误");
    }

}
