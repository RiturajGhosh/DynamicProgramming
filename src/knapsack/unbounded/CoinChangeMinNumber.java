package knapsack.unbounded;

/**
 * Have to find the minimum number of coins to be selected to have a given value
 * Solution: f(i)=min(1+f(i-Coins(j))) where j varries from 0 to Coins.length
 * for each value of i
 * 
 * @author Rituraj
 *
 */
public class CoinChangeMinNumber {
	/**
	 * We will use 1d unbounded knapsack concept here, here the look up table will
	 * be one dimensional
	 */
	private int[] table;
	private int[] coins;
	private int value;

	/**
	 * Constructor
	 * 
	 * @param coins is the array containing coins we are having
	 * @param value is the value we have to arrange using those coins
	 */
	public CoinChangeMinNumber(int[] coins, int value) {
		this.table = new int[value + 1];
		this.coins = coins;
		this.value = value;
		initializeTable();
	}

	/**
	 * table[0] we initialized with zero as the base case
	 */
	private void initializeTable() {
		for (int i = 1; i <= this.value; i++) {
			this.table[i] = Integer.MAX_VALUE - 1;
		}
	}

	/**
	 * This mehtod if returns Integer.MAX_VALUE-1 it means there is no possible
	 * coins we can return
	 * 
	 * @return the minimum number of coins required to have some value
	 */
	public int minNumberOfCoinsReq() {
		for (int i = 1; i <= value; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i)
					continue;
				min = Math.min(1 + table[i - coins[j]], min);
			}
			table[i] = min;
		}
		return table[value];
	}

}
