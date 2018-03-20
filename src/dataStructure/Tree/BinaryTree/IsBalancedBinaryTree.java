package dataStructure.Tree.BinaryTree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * http://www.lintcode.com/en/problem/balanced-binary-tree/#
 *
 */
public class IsBalancedBinaryTree {

	class Solution {
	    public boolean isBalanced(TreeNode root) {
	     return maxDepth(root) !=-1;
	    }
	    
	    private int maxDepth(TreeNode root){
	        if(root ==null){
	            return 0;
	        }
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
	            return -1;
	        }
	        
	        return Math.max(left,right) + 1;
	    }
	}
	
}
