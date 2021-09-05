package knapsack.zeroone;

import java.util.stream.IntStream;

public class CountOfSubsetsToGivenDiff extends CountOfSubsetsToGivenSum {
	private int sum;
	private int diff;

	public CountOfSubsetsToGivenDiff(int[] array, int n, int diff) {
		super(array, n, IntStream.of(array).sum());
		this.sum = IntStream.of(array).sum();
	}

	public int count() {
		super.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH);
		return getCountFromTopDownTable(t);

	}

	private int getCountFromTopDownTable(int[][] t) {
		int target = (sum + diff) / 2;
		return t[n][target];
		/*
		 * int[] array = t[n]; int count = 0; Set<Integer> set = new HashSet<>(); for
		 * (int i = 0; i <= sum; i++) { if (set.contains(array[i] + diff) ||
		 * set.contains(array[i] - diff)) { count++; } set.add(array[i]); }
		 * 
		 * return count;
		 */
	}
}
