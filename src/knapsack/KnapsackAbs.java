package knapsack;

/**
 * This abstract class can be extended to any 2d knapsack solution class
 * 
 * @author Rituraj
 *
 */
public abstract class KnapsackAbs {

	/** weight array **/
	protected int[] wt;
	/** value array **/
	protected int[] val;
	/** Number of Items **/
	protected int n;
	/** Capacity of the knapsack **/
	protected int W;
	/** DP table **/
	protected int[][] t;

	/**
	 * Type denotes the variation of different approaches
	 * 
	 * @author Rituraj
	 *
	 */
	public enum Type {
		MEMOIZED_APPROACH, TOP_DOWN_APPROACH, RECURSIVE_APPROACH
	}

	/**
	 * Constructor for 1D knapsack problem
	 * 
	 * @param n is the Number of Items
	 * @param w is the capacity of the Knapsack
	 */
	public KnapsackAbs(int[] wt, int n, int w) {
		this(wt, null, n, w);
	}

	/**
	 * Constructor for 2D knapsack problem
	 * 
	 * @param wt  is the weight array
	 * @param val is the value array
	 * @param n   is equal to the length of the weight array or to the value arrray
	 * @param W   is the capacity of the knapsack
	 */
	public KnapsackAbs(int[] wt, int[] val, int n, int w) {
		this.wt = wt;
		this.val = val;
		this.n = n;
		this.W = w;
	}

	/**
	 * Recursive approach to solve knapsack problem. In case of true false answer
	 * expectation -1 indicates false, 1 indicates true
	 * 
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	protected abstract int recursiveApproach();

	/**
	 * Memoized approach to solve knapsack problem
	 * 
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	protected abstract int memoizedApproach();

	/**
	 * Top down approach to solve knapsack problem *
	 * 
	 * @return the max value that can be fit inside knapsack with max weight as W
	 */
	protected abstract int topDownApproach();

	/**
	 * Method to initialize memoization table
	 */
	protected abstract void initializeMemoizationTable();

	/**
	 * Method to initialize topdown table
	 */
	protected abstract void initializeTopDownTable();

	/**
	 * Method to orchestrate between different approaches of Knapsack problem
	 * 
	 * @param type is to choose between different approaches to the solution
	 * @return the max value that can be fit inside knapsack with max weight as W,
	 *         -1 for abnormal execution
	 */
	public int orchestrateBetweenApproaches(Type type) {
		if (type == Type.MEMOIZED_APPROACH) {
			initializeMemoizationTable();
			return memoizedApproach();
		}
		if (type == Type.TOP_DOWN_APPROACH) {
			initializeTopDownTable();
			return topDownApproach();
		}
		if (type == Type.RECURSIVE_APPROACH) {
			return recursiveApproach();
		} else
			return -1;
	}
}
