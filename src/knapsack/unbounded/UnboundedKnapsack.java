package knapsack.unbounded;

import knapsack.KnapsackAbs;

/**
 * The idea behind unbounded knapsack is we can choose one Item unlimited number
 * of times from the given array to maximize the profit
 * 
 * @author Rituraj
 *
 */
public class UnboundedKnapsack extends KnapsackAbs {

	/**
	 * Constructor to be used irrespective of the approaches
	 * 
	 * @param n is the number of Items
	 * @param W is the capacity of knapsack
	 * 
	 */
	public UnboundedKnapsack(int[] wt, int[] val, int n, int w) {
		super(wt, val, n, w);
	}

	@Override
	protected int recursiveApproach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int memoizedApproach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int topDownApproach() {
		return topDownKnapSack(wt, val, n, W);
	}

	@Override
	protected void initializeMemoizationTable() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initializeTopDownTable() {
		this.t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= W; j++) {
			t[0][j] = 0;
		}
	}

	/**
	 * Top down approach to solve the 0-1 knapsack problem
	 * 
	 * @param wt  is the weight array
	 * @param val is the value array
	 * @param n   is equal to the length of the weight array or to the value arrray
	 * @param W   is the capacity of the knapsack
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	private int topDownKnapSack(int[] wt, int[] val, int n, int W) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] > j || (j - wt[i - 1]) < 0) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = Math.max(t[i - 1][j], val[i - 1] + t[i][j - wt[i - 1]]);
				}
			}
		}
		return t[n][W];
	}

}
