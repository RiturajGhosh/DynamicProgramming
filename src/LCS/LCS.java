package LCS;

/**
 * <strong>Longest Common subsequence problem</strong>
 * <p>
 * Problem statemet:Find the longest common subsequence(not necessary to be
 * contiguous) between two given String. eg, str1="abgre", str2= "abref" o/p=4
 * length of abre. <br/>
 * A subsequence sb of a string str is such that sb|j comes after sb|i then in
 * str also char at str|j comes after char at str|i, means the relative order of
 * the characters are same in both string and the subsequence
 * </p>
 * 
 * @author Rituraj
 *
 */
public class LCS {

	private static int[][] t;

	/**
	 * Method to solve LCS using recursive Approach
	 * 
	 * @param ch1
	 * @param ch2
	 * @param n
	 * @param m
	 * @return
	 */
	private int recursiveApproach(char[] ch1, char[] ch2, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		} else {
			if (ch1[n - 1] == ch2[m - 1]) {
				return 1 + recursiveApproach(ch1, ch2, n - 1, m - 1);
			} else {
				return Math.max(recursiveApproach(ch1, ch2, n, m - 1), recursiveApproach(ch1, ch2, n - 1, m));
			}
		}
	}

	private int topDownApproach(char[] ch1, char[] ch2, int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (ch1[i - 1] == ch2[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}
		return t[n][m];
	}

	private void initializeTable(int n, int m) {
		t = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			t[0][i] = 0;
		}
	}

	public int topDownLCS(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int n = ch1.length;
		int m = ch2.length;
		initializeTable(n, m);
		return topDownApproach(ch1, ch2, n, m);
	}

	public int recursiveLCS(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int n = ch1.length;
		int m = ch2.length;
		return recursiveApproach(ch1, ch2, n, m);
	}
}
