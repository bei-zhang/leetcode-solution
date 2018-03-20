package dataStructure.StringAndArray;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * 
 *
 */
public class ReverseWordsInStringII {
	// Three step to reverse
	//Time complexity: O(n),   space complexity is O(1).
	class Solution {
		public void reverseWords(char[] s) {
			// 1, reverse the whole sentence
			reverse(s, 0, s.length - 1);
			// 2, reverse each word
			int start = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == ' ') {
					reverse(s, start, i - 1);
					start = i + 1;
				}
			}
			// 3, reverse the last word, if there is only one word this will solve the corner case
			reverse(s, start, s.length - 1);
		}
		public void reverse(char[] s, int start, int end) {
			while (start < end) {
				char temp = s[start];
				s[start] = s[end];
				s[end] = temp;
				start++;
				end--;
			}
		}

	}

}
