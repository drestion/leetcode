package techniques;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome t = new Palindrome();
		String[] tests = {"abc","","a","aa","abba","aaaa","ab","abbc"};
		for(String s : tests) {
			System.out.println(s+" "+t.isPalindromeLib(s));
			System.out.println(s+" "+t.isPalindrome(s));
			System.out.println(s+" "+t.isPalindromeNonRecur(s));
		}
	}

	public boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	public boolean isPalindrome(String s, int i, int j) {
		if (i >= 0 && i <= j && j < s.length()) {
			if (i + 1 <= j - 1)
				return s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
			else
				return s.charAt(i) == s.charAt(j);
		}
		return true;
	}

	public boolean isPalindromeNonRecur(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}
	
	 public boolean isPalindromeLib(String s) {
     return s.equals(new StringBuffer(s).reverse().toString());
 }

}
