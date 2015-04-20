package com.demo;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordBreakTest {
    String[] words = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango" };
    List<String> dict = Arrays.asList(words);

    @Test
    public void testbreak1() {
        String str = "i like sam sung";
        List<String> result = Arrays.asList(str.split(" "));
        String input = "ilikesamsung";

        WordBreak breaker = new WordBreak();
        assertEquals(breaker.break1(input, dict), result);
    }

    @Test
    public void testbreak2() {
        String input = "ilikesamsung";

        String str1 = "i like samsung";
        List<String> lst1 = Arrays.asList(str1.split(" "));
        String str2 = "i like sam sung";
        List<String> lst2 = Arrays.asList(str2.split(" "));
        List<List<String>> result = new ArrayList<List<String>>();
        result.add(lst1);
        result.add(lst2);

        WordBreak breaker = new WordBreak();
        assertEquals(result, breaker.break2(input, dict));
    }

}

