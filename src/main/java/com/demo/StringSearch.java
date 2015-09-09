package com.demo;

import java.lang.Math;

/* Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 */
public class StringSearch {
    // track only one char in match
    public int instr(String haystack, String needle) {
        int next = needle.length();
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(0) == needle.charAt(i)) {
                next = Math.min(next, i);
                break;
            }
        }
        
        int i = 0;
        int m = 0;
        while (i < haystack.length()) {
            while (m < needle.length()) {
                if (haystack.charAt(i+m) == needle.charAt(m))
                    m++;
                else
                    break;
            }
            if (m == needle.length())
                return i;
            if (i+m >= haystack.length()-1)
                if (m == needle.length()-1)
                    return i;
                else 
                    return -1;

            if (m == 0)
                i++;
            else 
                i = i + Math.min(next, m);
            m = 0;
        }
        return -1;
    }
}

