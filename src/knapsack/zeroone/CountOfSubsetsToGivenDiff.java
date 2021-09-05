package knapsack.zeroone;

import java.util.stream.IntStream;

/**
 * Problem- Count the number of subsets who are having a given difference
 * between them
 * 
 * @author Rituraj
 *
 */
public class CountOfSubsetsToGivenDiff extends CountOfSubsetsToGivenSum {

	/**
	 * This variable will hold the summation of each element of the array passed
	 **/
	private int sum;
	/** Given difference **/
	private int diff;

	/**
	 * Constructor
	 * 
	 * @param array is the array of items
	 * @param n     is number of Items in array
	 * @param diff
	 */
	public CountOfSubsetsToGivenDiff(int[] array, int n, int diff) {
		super(array, n, IntStream.of(array).sum());
		this.sum = IntStream.of(array).sum();
	}

	/**
	 * Method to count of subsets whose summation's difference is equal to the given
	 * difference
	 * 
	 * @return the count of subsets whose summation's difference is equal to the
	 *         given difference
	 */
	public int count() {
		super.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH);
		return getCountFromTopDownTable(t);

	}

	/**
	 * Method to get count of subsets from topdown table of a particular summation
	 * value
	 * 
	 * @param t is the top down table got from the super class's solution of topdown
	 *          approach
	 * @return the count of subsets
	 */
	private int getCountFromTopDownTable(int[][] t) {
		int target = (sum + diff) / 2;
		return t[n][target];
	}
}
