package com.demo;

import java.lang.Character;
import java.util.HashMap;
import java.util.BitSet;

/**
 */
public class IsomorphicString {

    /* For example,"foo" and "app" are isomorphic because there is f-a, o-p
       and "bar" "foo" are not
     */
    public boolean isForm1(String s, String t) {
        if(s.length() != t.length())
            return false;

        // track unique mapping f-a, o-p 
        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
     
            if(map.containsKey(c1)){
                if(c2 != map.get(c1))
                    return false;
            }else{
                map.put(c1,c2);
            }
        }
        return true;
    }

    // isomorphism of sets: cat vs act, same set but diff structure
    // only for unique char
    public boolean isForm2(String s, String t) {
        if(s.length() != t.length())
            return false;

        BitSet bit_s = new BitSet(26);
        BitSet bit_t = new BitSet(26);
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
     
            bit_s.set((int)c1 - 97);
            bit_t.set((int)c2 - 97);
        }
        if (bit_s.equals(bit_t))
            return true;
        return false;
    }
}

