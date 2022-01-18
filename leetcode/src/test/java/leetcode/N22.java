package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @date 2022/1/18
 */
public class N22 {

    // todo zsx
    public List<String> generateParenthesis(int n) {
        if (n == 1){
            return Arrays.asList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis(n - 1)){
            for (int i = 0; i <= str.length()/2; i++) {
                set.add(str.substring(0,i) + "()" + str.substring(i,str.length()));
            }
        }
        return new ArrayList<>(set);
    }

    @Test void t(){
        List<String> list = generateParenthesis(6);
        list.forEach(System.out::println);
    }
}
