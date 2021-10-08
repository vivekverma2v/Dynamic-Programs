package com.learning.dynamic;

/*
 *  Given an integer array nums, return the length of the longest strictly increasing subsequence.

	A subsequence is a sequence that can be derived from an array by deleting some or no elements without 
	changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

	Example 1:

		Input: nums = [10,9,2,5,3,7,101,18]
		Output: 4
		Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
		
	Example 2:

		Input: nums = [0,1,0,3,2,3]
		Output: 4
		
	Example 3:

		Input: nums = [7,7,7,7,7,7,7]
		Output: 1
 

	Constraints:

	1 <= nums.length <= 2500
	-104 <= nums[i] <= 104
 

	Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * 
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,7,101,18 };
		System.out.println(lengthOfLIS(arr));
	}
	
	public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return getMax(nums, -1, 0, dp);
        
    }
    
    static int getMax(int[] arr, int prev, int curr, int[][] dp) {
        if (arr.length == 1)
            return 1;
        
        if (curr == arr.length)
            return 0;
        
        if (prev != -1 && dp[prev][curr] != 0)
            return dp[prev][curr];
        
        int op1 = 0;
        if (prev == -1 || arr[prev] < arr[curr]) {
            op1 = 1 + getMax(arr, curr, (curr + 1), dp);
        }
        
        int op2 = getMax(arr, prev, (curr + 1), dp);
        
        if (prev != -1)
            dp[prev][curr] = Math.max(op1, op2);
        return Math.max(op1, op2);
        
    }

}
