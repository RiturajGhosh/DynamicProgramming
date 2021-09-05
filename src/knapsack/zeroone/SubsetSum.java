package knapsack.zeroone;

import knapsack.KnapsackAbs;

/**
 * We have to find if a target sum can be formed from summation of any subset
 * present in the array
 * 
 * @author Rituraj
 *
 */
public class SubsetSum extends KnapsackAbs {
	protected boolean[][] t;

	public SubsetSum(int[] wt, int n, int sum) {
		super(wt, n, sum);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapsackAbs#recursiveApproach()
	 */
	@Override
	protected int recursiveApproach() {
		boolean output = recursiveSubsetSum(wt, n, W);
		if (output)
			return 1;
		else
			return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapsackAbs#memoizedApproach()
	 */
	@Override
	protected int memoizedApproach() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapsackAbs#topDownApproach()
	 */
	@Override
	protected int topDownApproach() {
		if (topDownSubsetSum(wt, n, W))
			return 1;
		else
			return -1;
	}

	/**
	 * Method to return whether the target sum can be formed from summation of any
	 * subset of the array
	 * 
	 * @param array of integers
	 * @param n     is the numberof items
	 * @param sum   is the target, which we have to tell if can be formed from a
	 *              subArray's sum
	 * @return true if sum can be formed else false
	 */
	private boolean topDownSubsetSum(int[] array, int n, int sum) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - array[i - 1] < 0) {
					t[i][j] = t[i - 1][j];
				} else
					t[i][j] = t[i - 1][j] || t[i - 1][j - array[i - 1]];
			}
		}
		return t[n][sum];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapsackAbs#initializeMemoizationTable()
	 */
	@Override
	protected void initializeMemoizationTable() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapsackAbs#initializeTopDownTable()
	 */
	@Override
	protected void initializeTopDownTable() {
		// TODO Auto-generated method stub
		this.t = new boolean[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		}
	}

	/**
	 * Method to return whether the target sum can be formed from summation of any
	 * subset of the array
	 * 
	 * @param array of integers
	 * @param n     is the numberof items
	 * @param sum   is the target, which we have to tell if can be formed from a
	 *              subArray's sum
	 * @return true if sum can be formed else false
	 */
	private boolean recursiveSubsetSum(int[] array, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		else {
			return (recursiveSubsetSum(array, n - 1, sum - array[n - 1]) || recursiveSubsetSum(array, n - 1, sum));
		}
	}

}
