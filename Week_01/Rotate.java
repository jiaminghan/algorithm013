package com.company.leetcode.easy;

public class Rotate {

    public static void main(String[] args){
        Rotate r = new Rotate();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums, 3);
        for(int index = 0; index < nums.length; index++){
            System.out.print(nums[index] + ", ");
        }
    }

    public void rotate(int[] nums, int k){
        if(null == nums || nums.length < 2){
            return;
        }
        int N = nums.length;
        k %= N;
        int move = 0;
        for(int start = 0; move < N;start++){
            int currentIndex = start;
            int currentValue = nums[currentIndex];
            do{
                int nextIndex = (currentIndex + k) % N;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = currentValue;
                currentIndex = nextIndex;
                currentValue = nextValue;
                move++;
            } while (currentIndex != start);
        }
    }
}
