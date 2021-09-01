package knapsack.zeroone;

import knapsack.KnapsackAbs;

public class CountOfSubsetsToGivenSum extends KnapsackAbs {
	private int count;

	/**
	 * Constructor
	 * 
	 * @param array of Items
	 * @param n     is size of array
	 * @param sum   is the target sum
	 */
	public CountOfSubsetsToGivenSum(int[] array, int n, int sum) {
		super(array, n, sum);
		this.count = 0;
	}

	@Override
	protected int recursiveApproach() {
		count = 0;
		return recursiveCountSubsets(wt, n, W);
	}

	@Override
	protected int memoizedApproach() {
		count = 0;
		return memoizedSoluiton(wt, n, W);
	}

	@Override
	protected int topDownApproach() {
		return topDownCountOfSubset(wt, n, W);
	}

	@Override
	protected void initializeMemoizationTable() {
		this.t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				t[i][j] = -1;
			}
		}
	}

	@Override
	protected void initializeTopDownTable() {
		this.t = new int[n + 1][W + 1];
		for (int j = 0; j <= W; j++) {
			t[0][j] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[i][0] = 1;
		}
	}

	/**
	 * Method to return count the number of subsets with the target sum
	 * 
	 * @param array of Items
	 * @param n     is size of the array
	 * @param sum   is the target sum
	 * @return the count of subsets which can be formed such that summation of each
	 *         subset element results to target sum
	 */
	private int recursiveCountSubsets(int[] array, int n, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (n == 0) {
			return count;
		} else {
			return (recursiveCountSubsets(array, n - 1, sum) + recursiveCountSubsets(array, n - 1, sum - array[n - 1]));
		}
	}

	/**
	 * Method to return count the number of subsets with the target sum
	 * 
	 * @param array of Items
	 * @param n     is size of the array
	 * @param sum   is the target sum
	 * @return the count of subsets which can be formed such that summation of each
	 *         subset element results to target sum
	 */
	private int memoizedSoluiton(int[] array, int n, int sum) {
		if (sum == 0) {
			t[n][sum] = 1;
			return t[n][sum];
		}
		if (n == 0) {
			t[n][sum] = 0;
			return t[n][sum];
		}
		if (sum < 0) {
			return 0;
		}
		if (t[n][sum] != -1) {
			return t[n][sum];
		} else {
			t[n][sum] = memoizedSoluiton(array, n - 1, sum) + memoizedSoluiton(array, n - 1, sum - array[n - 1]);
			return t[n][sum];
		}
	}

	/**
	 * Method to return count the number of subsets with the target sum
	 * 
	 * @param array of Items
	 * @param n     is size of the array
	 * @param sum   is the target sum
	 * @return the count of subsets which can be formed such that summation of each
	 *         subset element results to target sum
	 */
	private int topDownCountOfSubset(int[] array, int n, int sum) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if ((j - array[n - 1]) < 0) {
					t[i][j] = t[i - 1][j];
				} else
					t[i][j] = t[i - 1][j] + t[i - 1][j - array[i - 1]];
			}
		}
		return t[n][W];
	}

}
