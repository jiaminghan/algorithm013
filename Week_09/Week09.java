package com.company.leetcode.homework;

public class Week09 {

}

class NumDecodings{
    /**
     * 91. 解码方法
     */
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        return numDecodingsHelper(s.toCharArray(), 0, cache);
    }

    private int numDecodingsHelper(char[] chars, int start, int[] cache){
        if(start >= chars.length){
            return 1;
        }
        if(cache[start] > 0){
            return cache[start];
        }
        int result = 0;
        if(chars[start] >= '1' && chars[start] <= '9'){
            result += numDecodingsHelper(chars, start + 1, cache);
        }
        if(start < chars.length - 1){
            if(chars[start] == '1'){
                result += numDecodingsHelper(chars, start + 2, cache);
            } else if(chars[start] == '2' && chars[start + 1] < '7'){
                result += numDecodingsHelper(chars, start + 2, cache);
            }
        }
        cache[start] = result;
        return result;
    }
}

class FirstUniqChar{
    /**
     * 387. 字符串中的第一个唯一字符
     */
    public int firstUniqChar(String s) {
        int[] cntArr = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            cntArr[c - 'a']++;
        }
        for(int i = 0; i < chars.length; i++){
            if(cntArr[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

}

class LongestPalindrome{
    /**
     * 5. 最长回文子串
     */
    public String longestPalindrome(String s) {
        String result = "";
        if(null == s || s.length() == 0){
            return result;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(chars[i] == chars[j]){
                    dp[i][j] = (j - i < 2) || (dp[i + 1][j - 1]);
                    if(dp[i][j] && result.length() < j - i + 1){
                        result = s.substring(i, j + 1);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }
}
