package LCS;

/**
 * Problem: Find the longest common substring from two given string
 * 
 * @author Rituraj
 *
 */
public class LongestCommonSubString {
	/**
	 * Method to get the Length of longest common substring.</br>
	 * This method uses bottomUp approach to solve using dp
	 * 
	 * @param str1
	 * @param str2
	 * @return Length of longest common substring
	 */

	public int longestCommonSubStr(String str1, String str2) {
		int[][] t = new int[str1.length() + 1][str2.length() + 1];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
					result = Math.max(result, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return result;
	}
}
