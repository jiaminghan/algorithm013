package com.company.leetcode.easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] nums = new int[]{0,0};
        for(int index = 0; index < bills.length; index++){
            switch (bills[index]){
                case 5:{
                    nums[0]++;
                    break;
                }
                case 10:{
                    if(nums[0] > 0){
                        nums[0]--;
                        nums[1]++;
                    } else {
                        return false;
                    }
                    break;
                }
                case 20:{
                    if(nums[1] > 0
                            && nums[0] > 0){
                        nums[1]--;
                        nums[0]--;
                    } else if(nums[0] >= 3){
                        nums[0]-=3;
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}
