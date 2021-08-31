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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int topDownApproach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void initializeMemoizationTable() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initializeTopDownTable() {
		// TODO Auto-generated method stub

	}

	/**
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

}
