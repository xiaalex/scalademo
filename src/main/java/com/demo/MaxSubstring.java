package com.demo;

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
}
