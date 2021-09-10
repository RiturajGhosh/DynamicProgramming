package knapsack.unbounded;

import knapsack.KnapsackAbs;

/**
 * We have to maximize the value of a sliced rod, where the value varries with
 * each slice's length
 * 
 * @author Rituraj
 *
 */
public class RodCuttingProblem extends KnapsackAbs {

	/**
	 * Constructor
	 * 
	 * @param lt  is the array of lengths
	 * @param val contains price for each length given in lt array. lt[i] lenght's
	 *            price will be val[i]
	 * @param n   length of the lt array
	 * @param N   is the total length of the rod
	 */
	public RodCuttingProblem(int[] lt, int[] val, int n, int N) {
		super(lt, val, n, N);
	}

	@Override
	protected int recursiveApproach() {
		return rodCutRecursive(wt, val, n, W);
	}

	@Override
	protected int memoizedApproach() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int topDownApproach() {
		return rodCutTopDownSolution(wt, val, n, W);
	}

	@Override
	protected void initializeMemoizationTable() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initializeTopDownTable() {
		super.t = new int[n + 1][W + 1];
		for (int i = 0; i <= W; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
	}

	private int rodCutTopDownSolution(int[] lt, int[] val, int n, int N) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= N; j++) {
				if (j - lt[i - 1] < 0) {
					t[i][j] = t[i - 1][j];
				} else
					t[i][j] = Math.max(t[i - 1][j], val[i - 1] + t[i][j - lt[i - 1]]);
			}
		}
		return t[n][N];
	}

	private int rodCutRecursive(int[] lt, int[] val, int n, int N) {
		if (N == 0 || n <= 0) {
			return 0;
		}
		if (lt[n - 1] > N) {
			return rodCutRecursive(lt, val, N, n - 1);
		} else {
			return Math.max(rodCutRecursive(lt, val, n - 1, N),
					val[n - 1] + rodCutRecursive(lt, val, n, N - lt[n - 1]));
		}
	}

}
