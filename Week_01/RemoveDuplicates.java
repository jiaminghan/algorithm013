package com.company.leetcode.easy;

public class RemoveDuplicates {

    public static void main(String[] args){
        RemoveDuplicates remove = new RemoveDuplicates();
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = remove.removeDuplicates(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; index < length; index++){
            stringBuilder.append(arr[index]).append(", ");
        }
        System.out.println(stringBuilder);
    }

    public int removeDuplicates(int[] nums) {
        if(null == nums){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        int cur = 0;
        for(int index = 1; index < nums.length; index++){
            if(nums[cur] != nums[index]){
                nums[++cur] = nums[index];
            }
        }
        return cur + 1;
    }
}
