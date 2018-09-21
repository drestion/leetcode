package problems;

public class PaintHouseII {
	/*
	 * 11:55am 0921 started 12:02pm draft done. 12:03pm 1pass #enter a general case
	 * of Paint House I. dp[i][c] = min(dp[i-1][nc]) + costs[i][c];
	 *
	 */
	public int minCostII(int[][] costs) {
		if (costs == null || costs.length < 1 || costs[0].length < 1)
			return 0;

		if (costs.length > 1 && costs[0].length < 2)
			return 0;

		int xlen = costs.length, clen = costs[0].length;
		int[][] dp = new int[xlen][clen];

		for (int c = 0; c < clen; c++)
			dp[0][c] = costs[0][c];

		for (int i = 1; i < xlen; i++) {
			for (int c = 0; c < clen; c++) {
				int minc = Integer.MAX_VALUE;

				for (int nc = 0; nc < clen; nc++) {
					if (nc != c)
						minc = Math.min(dp[i - 1][nc], minc);
				}

				dp[i][c] = minc + costs[i][c];
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int c = 0; c < clen; c++) {
			ans = Math.min(ans, dp[xlen - 1][c]);
		}

		return ans;
	}
}
