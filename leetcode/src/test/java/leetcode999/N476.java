package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/18
 */
public class N476 {


    public int findComplement(int num) {
        String str = Integer.toBinaryString(num); // 101
        str = str.replaceAll("1", "2"); // 202
        str = str.replaceAll("0", "1"); // 212
        str = str.replaceAll("2", "0"); // 010

        return Integer.valueOf(str, 2);
    }

    @Test
    void t() {
        int res = findComplement(5);

        System.out.println(res);


        //System.out.println(Integer.toBinaryString(5));
        //
        //String s = Integer.valueOf("101", 2).toString();
        //System.out.println(s);


    }

}
