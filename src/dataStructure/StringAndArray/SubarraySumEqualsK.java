package dataStructure.StringAndArray;

/**
 * 560. Subarray Sum Equals K
 * 
 * 类似题目:MaximumSizeSubarraySumEqualsK
 * 
 */
public class SubarraySumEqualsK {
	

	//Brute Force - Time:O(n^2), Space: O(1)
	public class Solution1 {
	    public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            int sum=0;
	            for (int j = i; j < nums.length; j++) {
	                sum+=nums[j];
	                if (sum == k)
	                    count++;
	            }
	        }
	        return count;
	    }
	}
	
}
