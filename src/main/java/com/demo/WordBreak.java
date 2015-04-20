package com.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public class WordBreak {
    
    public List<String> break1(String s, List<String> dict) {
        List<String> result = new ArrayList<String>();
        int p = 0;      // match pointer

        for (int i = 0; i < s.length(); i++) {
            if (i < p)
                continue;

            for (String w : dict) {
                int start = i;
                int end = w.length() + i;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(w)) {        // substr will include i but NOT end
                    p = end;
                    result.add(w);
                    break;
                }
            }
        }
        if (p == s.length())
            return result;
        else {
            result.clear();
            return result;
        }
    }

    // return all possible matches
    public List<List<String>> break2(String s, List<String> dict) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("-", 0);
        break2Help(map, "-", s, dict);

        List<List<String>> result = new ArrayList<List<String>>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == s.length()) {
                String str = (entry.getKey()).substring(2);
                List<String> lst = Arrays.asList(str.split(" "));                
                result.add(lst);
            }
        }
        return result;
    }

    private void break2Help(Map<String, Integer> map, String key, String s, List<String> dict) {
        for (String w : dict) {
            int end = w.length();
            if (end > s.length())
                continue;

            if (s.substring(0, end).equals(w)) {
                String newkey = key + " " + w;
                map.put(newkey, map.get(key) + end);
                if (end < s.length())
                    break2Help(map, newkey, s.substring(end), dict);
            }
        }
    }

}


