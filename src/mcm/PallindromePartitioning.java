package mcm;

/**
 * We will be given a String str, we have to find the minimum number of
 * partition we can make to make each of the partitions of the string a
 * pallindrome
 * 
 * ex: str= "abcdcg" this string can be partitioned a|b|cdc|g so that each of
 * the partition is pallindrome, so here we have to make minimum of 3 partitions
 * 
 * @author Rituraj
 *
 */
public class PallindromePartitioning {

	private String str;
	private int i;
	private int j;

	public PallindromePartitioning(String str) {
		this.str = str;
		extractIJ();
	}

	private void extractIJ() {
		if (str != null) {
			this.i = 0;
			this.j = str.length() - 1;
		}
	}

	private boolean isPallindrome(String str, int i, int j) {
		String tempStr = str.substring(i, j + 1);
		StringBuilder sb = new StringBuilder(tempStr).reverse();
		return sb.toString().equalsIgnoreCase(tempStr);
	}

	/**
	 * Recursice approach to solve pallindrome partitioning problem
	 * 
	 * @return int
	 */
	public int ppR() {
		return pallindromPartitioning(this.str, this.i, this.j);
	}

	private int pallindromPartitioning(String str, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (isPallindrome(str, i, j)) {
			return 0;
		}
		Integer min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = pallindromPartitioning(str, i, k) + pallindromPartitioning(str, k + 1, j) + 1;
			min = Math.min(temp, min);
		}
		return min;
	}

}
