package com.company.leetcode.homework;

public class Week06 {
    /**
     * leetcode: 32. 最长有效括号
     * @param s 一个只包含 '(' 和 ')' 的字符串
     * @return 最长的包含有效括号的子串的长度
     */
    public int longestValidParentheses(String s) {
        //重复性：problem(s)->problem(s.subString(0, s.length() - 1)) + 计算最后一个字符后增加的长度
        //状态数组：dp为一维数组，分别为s字符串从0到index范围内字符串的最长有效括号的子字符串长度
        //DP方程：dp[i] = 0(当第i个字符为‘（’时)
        // dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2](有限制条件，见代码)
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length];
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 1; i < length; i++) {
            int preMatch = i - dp[i - 1] - 1;
            if (chars[i] == ')' && preMatch >= 0 && chars[preMatch] == '(') {
                dp[i] = dp[i - 1] + 2;
                int prePos = i - dp[i - 1] - 2;
                if (prePos >= 0) {
                    dp[i] += dp[prePos];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * leetcode 64. 最小路径和
     * @param grid 一个包含非负整数的 m x n 网格
     * @return 从左上角到右下角的路径，使得路径上的数字总和为最小
     */

    public int minPathSum(int[][] grid) {
        //重复性 problem(i, j) = min(problem(i + 1, j), problem(i, j + 1)) + grid[i][j]
        //状态数组 dp[i][j] 为i，j到右下角的最小路径，初始化最后一行和最后一列
        //DP方程 dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j]
        if(null == grid || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] path = new int[row][column];
        path[row - 1][column - 1] = grid[row - 1][column - 1];
        for(int j = column - 2; j >= 0; j--){
            path[row - 1][j] = path[row - 1][j + 1] + grid[row - 1][j];
        }
        for(int i = row - 2; i >= 0; i--){
            path[i][column - 1] = path[i + 1][column - 1] + grid[i][column - 1];
        }
        for(int i = row - 2; i >= 0; i--){
            for(int j = column - 2; j >= 0; j--){
                path[i][j] = Math.min(path[i + 1][j], path[i][j + 1]) + grid[i][j];
            }
        }
        return path[0][0];
    }
}
