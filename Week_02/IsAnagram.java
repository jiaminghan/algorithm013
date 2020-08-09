package com.company.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        for(int index = 0; index < sArr.length; index++){
            if(sArr[index] != tArr[index]){
                return false;
            }
        }
        return true;
    }
}
