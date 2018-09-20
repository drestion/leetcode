package problems;

public class PalindromePermutation {

	/*
	 * 12:33pm 0920 started 
	 * 12:37pm draft done. 
	 * 12:38pm 1pass
	 *
	 *
	 */
	public boolean canPermutePalindrome(String s) {
		int[] cnts = new int[128]; // total # of ascii chars
		
		for (char c : s.toCharArray()) {
			if (cnts[c] == 0) {
				cnts[c]++;
			} else {
				cnts[c]--;
			}
		}

		int sum = 0;
		for (int n : cnts) {
			sum += n;
		}

		return sum == 0 || sum == 1;

	}
}
