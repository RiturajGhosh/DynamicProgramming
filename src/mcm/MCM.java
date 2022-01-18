package mcm;

/**
 * This class is to solve the problem of matrix chain multiplication Say we have
 * an array of size N, given arr[] = {a0,a1,a2,a3}, these are the dimention of
 * N-1 matrices The matrices are A1= a0*a1, A2= a1*a2, A3= a2*a3; Now we have to
 * find the minimum cost of multiplying these matrices. N.B: The cost of two
 * matrix multiplication each of dimension a1*a2, a2*a3 is a1*a2*a3
 * 
 * @author Rituraj
 *
 */
public class MCM {
	private Integer[] arr;
	private int i;
	private int j;
	private static Integer min = Integer.MAX_VALUE;

	public MCM(Integer[] arr) {
		this.arr = arr;
		extractIJ(arr);
	}

	private void extractIJ(Integer[] array) {
		if (array != null) {
			this.i = 1;
			this.j = array.length - 1;
		}
	}

	public int mcmR() {
		return mcmInRecursiveApproach(this.arr, this.i, this.j);
	}

	private int mcmInRecursiveApproach(Integer[] array, int i, int j) {
		if (i >= j) {
			return 0;
		}
		for (int k = i; k < j; k++) {
			int val = mcmInRecursiveApproach(array, i, k) + mcmInRecursiveApproach(array, k + 1, j)
					+ array[i - 1] * array[k] * array[j];
			min = Math.min(val, min);
		}
		return min;

	}
}
