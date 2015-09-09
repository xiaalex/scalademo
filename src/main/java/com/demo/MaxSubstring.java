package com.demo;

import java.util.HashMap;

public class MaxSubstring {

    public String uniqueChars(String s) {
        int prevLen = 0;
        String prevStr = "";
        int currLen = 0;
        String currStr = "";
        char prevChar = '\0';
        char currChar = '\0';

        currLen = 1;
        currChar = s.charAt(0);
        currStr = String.valueOf(currChar);
        prevChar = currChar;
        for (int i = 1; i < s.length(); i++) {
            currChar = s.charAt(i);
            // compare prev
            if (currChar == prevChar) {
                currLen++;
                currStr = currStr + String.valueOf(s.charAt(i));
            }
            else {
                if (currLen > prevLen) {        // take max
                    prevLen = currLen;
                    prevStr = currStr;
                }
                // clean current
                currLen = 1;
                currStr = String.valueOf(currChar);
                prevChar = currChar;
            }
        }
        if (currLen > prevLen)
            return currStr;
        else
            return prevStr;
    }

    public String kuniqueChars(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        String maxstr = "";
     
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            end = i;
            
            if (map.size() > k) {
                String sub = s.substring(start, end);
                if (sub.length() > maxstr.length()) 
                    maxstr = sub;
                    
                // move left point to right to keep only k chars
                System.out.printf("%d %d \n", start, end);
                char first = s.charAt(start);
                start = map.get(first) + 1;
                map.remove(first);
            }
        }
        if (maxstr.length() == 0)
            maxstr = s;

        return maxstr;
    }

}
