package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

 * https://leetcode.com/problems/coin-change
 * 
 *
 */
public class CoinChange {
	//Dynamic programming - Bottom up  - (recommended)
	//Time: O(amount * coins.length), Space: O(amount)
	class Solution {
	    public int coinChange(int[] coins, int amount) {
	        if(coins == null || coins.length ==0 || amount <0){
	            return -1;
	        }
	        //DP方程 - dp[i]: save the fewest number of coins that we need to make up the amount of i.   
	        int[] dp = new int[amount+1];
	        int sum=0;
	        while(++sum <= amount){
	            int min = amount +1;//initialize to max value first
	            for(int coin: coins){
	                if(coin<= sum && dp[sum - coin] >=0){	                    
	                    min = Math.min(min, dp[sum-coin] + 1);
	                }
	            }
	            dp[sum] = min > amount ? -1 : min;
	        }
	        
	        return dp[amount];            
	    }
	}
	
//////////////////////////////////////
	/**
	 * Dynamic programming - Top down
	 * Recursive Solution:
The idea is very classic dynamic programming: think of the last step we take. 
Suppose we have already found out the best way to sum up to amount a, then for the last step, 
we can choose any coin type which gives us a remainder r where r = a-coins[i] for all i's. 
For every remainder, go through exactly the same process as before 
until either the remainder is 0 or less than 0 (meaning not a valid solution). 
With this idea, the only remaining detail is to store the minimum number of coins needed to sum up to r 
so that we don't need to recompute it over and over again.
	 *
	 */
	public class Solution2 {
		public int coinChange(int[] coins, int amount) {
		    if(amount<1) return 0;
		    return helper(coins, amount, new int[amount]);
		}

		//rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
		private int helper(int[] coins, int rem, int[] count) { 
		    if(rem<0) return -1; // not valid
		    if(rem==0) return 0; // completed
		    if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
		    int min = Integer.MAX_VALUE;
		    for(int coin : coins) {
		        int res = helper(coins, rem-coin, count);
		        if(res>=0 && res < min)
		            min = 1+res;
		    }
		    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
		    return count[rem-1];
		}
		}
	
	
    public static void main(String[] args){
    }
}
