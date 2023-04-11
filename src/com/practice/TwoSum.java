package com.practice;

public class TwoSum {
    /*
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        var length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (target == nums[i] + nums[j]) {
                    int[] result = new int[]{i, j};
                    return result;
                }
            }
        }
        return  new int[2];
    }


}
