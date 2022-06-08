package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author
 * @date 2022/6/7
 */
public class N1576 {

    char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    int length = 0;
    String str = null;

    /*
    执行用时：7 ms, 在所有 Java 提交中击败了5.04%的用户
    内存消耗：41.7 MB, 在所有 Java 提交中击败了6.29%的用户
     */
    public String modifyString(String s) {
        if(s.equals("?")) return "a";

        length = s.length();
        str = s;
        return dfs();
    }

    private String dfs() {
        int index = str.indexOf("?");
        if (index > -1) {

            String s1 = find(index);

            //str.substring(0, index - 1);

            str = str.replaceFirst("\\?", s1);
            dfs();
        }
        return str;
    }

    private String find(int index) {
        if (index == 0) {
            char c = str.charAt(1);
            for (char aChar : chars) {
                if (c != aChar) {
                    return String.valueOf(aChar);
                }
            }
            throw new RuntimeException();
        }
        if (index == length - 1) {
            char c = str.charAt(index - 1);
            for (char aChar : chars) {
                if (c != aChar) {
                    return String.valueOf(aChar);
                }
            }
            throw new RuntimeException();
        }

        char a = str.charAt(index - 1);
        char b = str.charAt(index + 1);

        for (char aChar : chars) {
            if (a != aChar && b != aChar) {
                return String.valueOf(aChar);
            }
        }
        throw new RuntimeException();
    }

    @Test
    void t() {
        System.out.println(modifyString("?a??b"));
    }

}
