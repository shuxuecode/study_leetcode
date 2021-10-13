package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/10/13
 */
public class N412 {

    String Fizz = "Fizz";
    String Buzz = "Buzz";

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder str;
        for (int i = 1; i <= n; i++) {
            str = new StringBuilder();
            if (i % 3 == 0) str.append(Fizz);
            if (i % 5 == 0) str.append(Buzz);
            if (str.length() == 0) str.append(i);
            res.add(str.toString());
        }
        return res;
    }

    @Test
    void t() {
        List<String> list = fizzBuzz(19);
        for (String str : list) {
            System.out.println(str);
        }
    }


}
