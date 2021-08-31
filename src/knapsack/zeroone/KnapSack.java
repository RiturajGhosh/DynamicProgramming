package knapsack.zeroone;

import knapsack.KnapsackAbs;

/**
 * 0-1 knapsack problem Problem definition: there is an weight array wt and an
 * value array val, you have to maximize the value can be fit in knapsack, and
 * the maximum weight that can fit in knapsack is given, say W
 * 
 * @author Rituraj
 *
 */
public class KnapSack extends KnapsackAbs {

	/**
	 * Constructor to be used irrespective of the approaches
	 * 
	 * @param n is the number of Items
	 * @param W is the capacity of knapsack
	 * 
	 */
	public KnapSack(int[] wt, int[] val, int n, int w) {
		super(wt, val, n, w);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapSackInterface#recursiveApproach(int[], int[], int, int)
	 */
	@Override
	protected int recursiveApproach() {
		return knapsack(wt, val, n, W);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapSackInterface#memoizedApproach(int[], int[])
	 */
	@Override
	protected int memoizedApproach() {
		return memoizedKnapsack(wt, val, n, W);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see knapsack.KnapSackInterface#topDownApproach(int[], int[], int, int)
	 */
	@Override
	protected int topDownApproach() {
		return topDownKnapSack(wt, val, n, W);
	}

	/**
	 * Recursive approach to solve the 0-1 knapsack problem
	 * 
	 * @param wt  is the weight array
	 * @param val is the value array
	 * @param n   is equal to the length of the weight array or to the value arrray
	 * @param W   is the capacity of the knapsack
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	private int knapsack(int[] wt, int[] val, int n, int W) {
		if (W == 0 || n == 0)
			return 0;
		if (wt[n - 1] > W) {
			return knapsack(wt, val, n - 1, W);
		} else {
			return Math.max(knapsack(wt, val, n - 1, W), val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1]));
		}
	}

	/**
	 * Memoized approach to solve the 0-1 knapsack problem
	 * 
	 * @param wt  is the weight array
	 * @param val is the value array
	 * @param n   is equal to the length of the weight array or to the value arrray
	 * @param W   is the capacity of the knapsack
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	private int memoizedKnapsack(int[] wt, int[] val, int n, int W) {
		if (W == 0 || n == 0) {
			return 0;
		}
		if (t[n][W] != -1) {
			return t[n][W];
		}
		if (wt[n - 1] > W) {
			t[n][W] = memoizedKnapsack(wt, val, n - 1, W);
			return t[n][W];
		} else {
			t[n][W] = Math.max(knapsack(wt, val, n - 1, W), val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1]));
			return t[n][W];
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
					t[i][j] = Math.max(t[i - 1][j], val[i - 1] + t[i - 1][j - wt[i - 1]]);
				}
			}
		}
		return t[n][W];
	}

	/**
	 * Method to initialize the memoization table
	 */
	protected void initializeMemoizationTable() {
		this.t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				t[i][j] = -1;
			}
		}
	}

	/**
	 * Method to initialize the top down table
	 */
	protected void initializeTopDownTable() {
		this.t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= W; j++) {
			t[0][j] = 0;
		}
	}
}
