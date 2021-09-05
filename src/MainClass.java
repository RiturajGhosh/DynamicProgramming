
import knapsack.KnapsackAbs;
import knapsack.KnapsackAbs.Type;
import knapsack.zeroone.CountOfSubsetsToGivenDiff;
import knapsack.zeroone.CountOfSubsetsToGivenSum;
import knapsack.zeroone.KnapSack;
import knapsack.zeroone.MinSubsetSumDiff;
import knapsack.zeroone.SubsetSum;

public class MainClass {

	public static void main(String[] args) {
		KnapsackAbs knapSack = new KnapSack(new int[] { 1, 2, 3 }, new int[] { 2, 2, 3 }, 3, 3);
		System.out.println(knapSack.orchestrateBetweenApproaches(Type.RECURSIVE_APPROACH));
		System.out.println(knapSack.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH));
		System.out.println(knapSack.orchestrateBetweenApproaches(Type.MEMOIZED_APPROACH));
		KnapsackAbs subsetSum = new SubsetSum(new int[] { 1, 4, 2, 5 }, 4, 3);
		System.out.println(subsetSum.orchestrateBetweenApproaches(Type.RECURSIVE_APPROACH));
		System.out.println(subsetSum.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH));
		KnapsackAbs countOfSubsetSumToGivenSum = new CountOfSubsetsToGivenSum(new int[] { 1, 2, 2, 2 }, 4, 4);
		System.out.println(countOfSubsetSumToGivenSum.orchestrateBetweenApproaches(Type.RECURSIVE_APPROACH));
		System.out.println(countOfSubsetSumToGivenSum.orchestrateBetweenApproaches(Type.MEMOIZED_APPROACH));
		System.out.println(countOfSubsetSumToGivenSum.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH));
		MinSubsetSumDiff minSubsetSumDiff = new MinSubsetSumDiff(new int[] { 1, 5, 6, 11 }, 4);
		System.out.println(minSubsetSumDiff.minDiff());
		CountOfSubsetsToGivenDiff countOfSubsetsToGivenDiff = new CountOfSubsetsToGivenDiff(new int[] { 1, 8, 5, 4, 7 },
				5, 3);
		System.out.println(countOfSubsetsToGivenDiff.count());
		KnapsackAbs unboundedKnapSack = new KnapSack(new int[] { 1, 2, 3 }, new int[] { 2, 2, 3 }, 3, 3);
		System.out.println(unboundedKnapSack.orchestrateBetweenApproaches(Type.TOP_DOWN_APPROACH));

	}

}
