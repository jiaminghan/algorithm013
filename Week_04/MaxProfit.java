package com.company.leetcode.easy;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int index = 1; index < prices.length; index++){
            if(prices[index] > prices[index-1]){
                profit += (prices[index] - prices[index-1]);
            }
        }
        return profit;
    }
}
