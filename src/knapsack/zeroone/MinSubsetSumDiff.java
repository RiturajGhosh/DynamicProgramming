package knapsack.zeroone;

import java.util.stream.IntStream;

/**
* Solution of finding the minimum difference between any two subsets present in array, using subset sum problem
*
* @author Rituraj
*/
public class MinSubsetSumDiff extends SubsetSum {

	public MinSubsetSumDiff(int[] array, int n) {
		super(array, n, IntStream.of(array).sum() / 2);
	}

	public int minDiff() {
		super.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH);
		for (int i = W; i >= 0; i--) {
			if (t[n][i] == true) {
				return (IntStream.of(wt).sum() - 2 * i);
			}
		}
		return Integer.MAX_VALUE;
	}
}
