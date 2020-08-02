package com.company.leetcode.easy;

import com.company.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args){
        int[] arr = new int[]{3,2,4};
        int[] result = twoSum(arr, 6);
        Utils.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length < 2){
            return new int[0];
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++){
            int value = nums[index];
            if(valueIndexMap.containsKey(target - value)){
                return new int[]{valueIndexMap.get(target - value), index};
            }
            valueIndexMap.put(value, index);
        }
        return new int[0];
    }
}
