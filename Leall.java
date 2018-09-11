import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Leall {

	public Leall() {
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] + nums[j] == target && i != j) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] { 0, 0 };
	}

	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// 06/01/2018 2:55PM
	// 06/01/2018 3:29pm
	// Compared to the best unofficial solution, i think i was dealing with a
	// more difficult solution that no new lists were allowed.
	// If new lists were allowed, the solution is much easier.
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// ListNode pl1 = l1, pl2 = l2;
		// ListNode oldpl1Next = null;
		//
		// if (l1 == null) {
		// return l2;
		// }
		// if (l2 == null) {
		// return l1;
		// }
		//
		// while (pl1.next != null && pl2.next != null) {
		// if(pl1.val <= pl2.val) {
		//
		// }
		// else {
		//
		// }
		// oldpl1Next = pl1.next;
		// ListNode newnode = new ListNode(pl2.val);
		// pl1.next = newnode;
		// newnode.next = oldpl1Next;
		//
		// pl1 = pl1.next;
		// pl2 = pl2.next;
		//
		// }
		//
		// return l1;

		// The key to figure out the following unofficial best solution
		// is to 1) figure out that you can return a new list
		// 2) have a simple clear image of the whole process of "merging"
		// Get the tail first
		// Whenever dealing with list, always find their head first.
		ListNode tail = new ListNode(Integer.MIN_VALUE);
		// A common trick is to return the tail.next as the final result
		ListNode result = tail;
		while (l1 != null & l2 != null) {
			if (l1.val > l2.val) {
				tail.next = l2;
				l2 = l2.next;
			} else {
				tail.next = l1;
				l1 = l1.next;
			}
			tail = tail.next;
		}

		// Always check why it finished.
		// Concate unfinished list
		if (l1 == null) {
			tail.next = l2;
		} else {
			tail.next = l1;
		}

		return result.next;
	}

	// 3:47pm 06/01
	// input int[] a={2,3,3,4}, 3
	// return int[] b={2,4,?,?} , size = 2
	// 4:31pm 06/01
	// Compared to the official solution, i think this is still a
	// linked list question
	// the key is to have that "pointer" concept. This is quite similar
	// to the mergeList's "new list" design, you just track the tail.
	// and whenever you add too many condition check, you are not
	// on the right track.
	public int removeElement(int[] nums, int val) {

		// int finalLength = 0;
		// int i = 0;
		//
		// while(i < nums.length) {
		// boolean moved = false;
		// if(nums[i] == val) {
		// nums[i] = val -1;
		// for(int j=i+1; j < nums.length; j++) {
		// nums[j-1] = nums[j];
		// }
		// moved = true;
		// }
		// else{
		// finalLength++;
		// }
		// if(moved== true) {
		// i--;
		// if(i < 0) {
		// i = 0;
		// }
		// }else {
		// i++;
		// }
		// }
		//
		// return finalLength;

		int pointer = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[pointer] = nums[i];
				pointer++;
			}
		}

		return pointer;

	}

	// 4:43 pm 06/01
	// 5:23 pm
	// The issue with your solution is that, it can not gurantee
	// the continuity. The best way to gurantee a continuity is to
	// use a for loop and make sure it can executes completely without relying
	// on any conditions.
	public int strStr(String haystack, String needle) {

		// The following is my solution after i reviewed the official solution
		// I imagined a stick moving along with another stick step by step
		// and also imagined in a perfect situation where a match happens, what
		// will the two sticks look like.
		// Then during the actual implementation, i just carefully check what
		// happen if the index increases, for example, exceed the length of the string.
		if (needle.length() == 0) {
			return 0;
		}

		int hayPtr = 0;
		int needlePtr = 0;

		while (hayPtr < haystack.length()) {
			// Compare the stick and move it one char each time
			if (haystack.charAt(hayPtr) == needle.charAt(0)) {
				// The first char match happens
				while (needlePtr < needle.length()) {
					// We want the match to continue for the needle
					if (hayPtr + needlePtr >= haystack.length()) {
						// hayPtr + needlePtr models the "move along with" situation
						return -1;
					}
					if (haystack.charAt(hayPtr + needlePtr) != needle.charAt(needlePtr)) {
						// the needle and hay does not match
						break;
					} else {
						// keep moving the needle
						needlePtr++;
					}
				}

				if (needlePtr == needle.length()) {
					return hayPtr;
				} else {
					needlePtr = 0;
				}
			}
			hayPtr++;
		}

		return -1;
		// The official solution:
		// The sequence of the three IFs is very important.
		// for(int i=0; ; i++){
		// for(int j=0; ; j++){
		// if( j == needle.length()) {
		// return i;
		// }
		// if( i +j == haystack.length()) {
		// return -1;
		// }
		//
		// if( haystack.charAt(i+j) != needle.charAt(j)) {
		// break;
		// }
		// }
		// }

	}

	/*
	 * 9:56 pm 0602
	 * 
	 * My first one-pass correct case! I figured out this by IMAGING an intuitic
	 * way.
	 * 
	 * The official solution offers a classicial binary search tree faster, but not
	 * as intuitive as mine.
	 */
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

	/*
	 * 12:30pm 0603
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < n; i++) {
			int insert = searchInsert(nums1, nums2[i]);
			shift(nums1, insert);
			nums1[insert] = nums2[i];
		}

		/*
		 * The official solution: It shows that, merging starts from the end. it also
		 * shows the corect way of shifting elements to the end.
		 * 
		 * it also shows a good example of reverse thinking: insert from the end.
		 */
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		// you know m > n
		while (j >= 0)
			nums1[k--] = nums2[j--];
	}

	private void shift(int[] arr, int loc) {
		for (int i = arr.length - 1; i >= loc; i--) {
			arr[i] = arr[i - 1];
		}
	}

	/*
	 * 1:33PM 0603 Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4]
	 * 
	 * for get divide and conquer?
	 */
	public void rotate(int[] nums, int k) {

		// Solution 1
		// time: o(n2) but easy to understand
		if (nums.length > 1) {
			while (k > 0) {
				int holder = nums[nums.length - 1];
				for (int i = nums.length - 1; i > 0; i--) {
					nums[i] = nums[i - 1];
				}
				nums[0] = holder;
				k--;
			}
		}

		// Solution 2
		// if(nums.length > 1 + k) {
		//
		// int[] result = new int[nums.length];
		// int wPtr = result.length - 1;
		// for(int j = nums.length - k - 1; j >= 0; ) {
		// result[wPtr--] = nums[j--];
		// }
		// for(int j = nums.length - 1; wPtr >=0;) {
		// result[wPtr--] = nums[j--];
		// }
		// }
		// else {
		//
		// }
	}

	public void reorderList(ListNode head) {
		ListNode newHead = new ListNode(0);
		ListNode p1 = head;
		ListNode p2 = null;

		while (p1 != null && p1.next != null) {
			p2 = p1.next;
		}
		p1 = head;

		while (p1 != null && p1.next != p2) {
			newHead.next = p1;
			newHead.next.next = p2;

			newHead = newHead.next;
			p1 = p1.next;

		}

	}

	/*
	 * 3:42 pm starting the "top interview questions" 3:49 pm done the 1st solution.
	 * 3:58 pm done the 2nd solution
	 */
	public String reverseString(String s) {
		// Solution 1
		// int j = 0;
		// char[] result = new char[s.length()];
		// for(int i = s.length()-1; i >= 0;) {
		// result[j++] = s.charAt(i--);
		// }
		// return new String(result);

		// Solution 2
		char[] result = s.toCharArray();
		for (int ph = 0, pt = result.length - 1; ph < pt; ph++, pt--) {
			char temp = result[ph];
			result[ph] = result[pt];
			result[pt] = temp;
		}
		return new String(result);
	}

	/*
	 * 4:09pm 4:20pm done the solution.
	 */
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < n + 1; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		return result;
	}

	/*
	 * 4:22 pm failed... due to not familiar with numbers.
	 * 
	 * abc= a*(size)*size + b*size +c
	 * 
	 * size can be 10, 16 or 26 in this case.
	 * 
	 * 7:00pm 0610 restarted 7:09pm 1pass
	 */
	public int titleToNumber(String s) {
		String[] ltrs = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		//
		// HashMap<String, Integer> dict = new HashMap();
		// for (int i = 0; i < ltrs.length; i++) {
		// dict.put(ltrs[i], i + 1);
		// }
		//
		// char[] chars = s.toCharArray();
		// int result = 0;
		// for (int i = chars.length - 1, j = 1; i >= 0; i--, j++) {
		// result += dict.get(String.valueOf(chars[i])) * (ltrs.length ^ (j));
		//
		// }
		//
		// return result;

		// 0610 redo
		char[] chars = s.toCharArray();
		if (chars.length == 0)
			return 0;
		int result = 0;
		for (int i = 0; i < chars.length; i++) {
			int ind = Arrays.binarySearch(ltrs, String.valueOf(chars[i])) + 1;
			result = result * 26 + ind;
		}

		return result;

	}

	/*
	 * 5:46 done after fixing 1 bug.
	 * 
	 * remember to minimize the changes of the loop variable
	 */
	public int firstUniqChar(String s) {
		int i = 0, j = 0;
		for (; i < s.length(); i++) {
			for (j = 0; j < s.length(); j++) {
				if (i != j) {
					if (s.charAt(i) == s.charAt(j))
						break;
				}
			}
			if (j == s.length())
				return i;
		}
		return -1;
	}

	/*
	 * 5:55pm failed... but leanred the techniques of removing duplicates: using the
	 * pointer to itself as a reference.
	 * 
	 * 4:18pm 0614 redo 4:28pm 1pass
	 * 
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		// int len = 0;
		//
		// for (int i = nums.length - 1; i > 0; i--) {
		// if (nums[i - 1] == nums[i]) {
		// for (int j = i - 1; j < nums.length - 1 - len; j++) {
		// nums[j] = nums[j + 1];
		// }
		// }
		// len++;
		// }
		//
		// return len;
		if (nums == null)
			return 0;
		if (nums.length < 1) {
			return 0;
		}

		int currVal = nums[0];
		int ii = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != currVal) {
				nums[++ii] = nums[i];
				currVal = nums[i];
			}
		}

		return ++ii;
	}

	/*
	 * 6:24 done in one pass. you can see that the design was borrowed from
	 * removeDuplicates's official solution: use a pointer to point to itself. and
	 * it turns out that this solution is the same as the official solution.
	 * 
	 * actually this technique is called : Insert index.
	 */
	public void moveZeroes(int[] nums) {
		int storageInd = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[storageInd++] = nums[j];
			}
		}
		while (storageInd < nums.length) {
			nums[storageInd++] = 0;
		}
	}

	/*
	 * 7:25pm 0602 failed. again, not familiar with all these number operations.
	 * 
	 * 
	 * 10:47am 0725 revisit watch for things like 999999 and INTEGER.MAX - 1 so you
	 * can not transform it back to integer. 10:59am draft done. 11:11am rewrite
	 * using list, better. 1pass
	 * 
	 * #TODO just to remember that in the 10base system, the carry you can get is
	 * either 1 or 0.
	 */
	public int[] plusOne(int[] digits) {
		// int num = 0;
		// int[] result = digits;
		// for (int i = 0; i < digits.length; i++) {
		// num = num * 10 + digits[i];
		// }
		// System.out.println(num);
		// num++;
		// for (int i = digits.length - 1; i >= 0; i--) {
		// result[i] = num % 10;
		// num = num / 10;
		// }
		//
		// return result;

		if (digits == null)
			return new int[0];
		List<Integer> result = new ArrayList<Integer>();
		int carry = 1;
		int sum = 0;

		for (int i = digits.length - 1; i >= 0; i--) {
			sum = carry + digits[i];
			carry = sum / 10;
			result.add(sum % 10);
		}
		if (carry == 1) {
			result.add(carry);
		}

		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(result.size() - 1 - i);
		}
		return r;
	}

	/*
	 * 7:50pm 7:58pm done.
	 */
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> dict = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (dict.containsKey(nums[i])) {
				Integer cnt = dict.get(nums[i]) + 1;
				dict.put(nums[i], cnt);
			} else {
				dict.put(nums[i], 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (dict.get(nums[i]) > Math.floor(nums.length / 2))
				return nums[i];
		}
		return -1;
	}

	public boolean containsDuplicate(int[] nums) {
		// o(n2)
		// for(int i=0; i < nums.length; i++) {
		// for(int j = 0; j < nums.length; j++) {
		// if(i != j && nums[i] == nums[j]) return true;
		// }
		// }
		// return false;

		HashMap<Integer, Integer> dict = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (dict.containsKey(nums[i]))
				return true;
			dict.put(nums[i], 1);
		}
		return false;
	}

	/*
	 * 12:19pm 06/04 12:31pm draft done 12:31pm passed. Need to watch the recursive
	 * video list from: https://www.youtube.com/watch?v=_OmRGjbyzno&list=
	 * PL2_aWCzGMAwLz3g66WrxFGSXvSsvyfzCO to gain more understanding of it.
	 * basically i followed his idea: first check the head node, then left, then
	 * right.
	 */

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null) {

			return 1 + maxDepth(root.right);
		} else if (root.right == null) {

			return 1 + maxDepth(root.left);
		} else {
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);
			if (leftDepth > rightDepth)
				return 1 + leftDepth;
			else
				return 1 + rightDepth;
		}

	}

	/*
	 * 1:35pm 06/04 1:45pm draft done
	 * 
	 * 2:06pm found that it deals with tricks in bits operation. will do it later.
	 * 
	 * 4:42pm 0725 revisit
	 * 
	 * the key is the >>> for unsigned shift. i think the reason the original
	 * solution failed is because it causes overflow but i do not know how the
	 * system would accept somthing like INteger.max.
	 */
	public int reverseBits(int n) {

		// long[] bits = new long[32];
		// int insInd = 0;
		// long result = 0;
		//
		// while (n > 0) {
		// bits[insInd++] = n % 2;
		// n /= 2;
		// }
		//
		// for (int i = 0; i < 32; i++) {
		// result = result * 2 + bits[i];
		// }
		// return result;

		int t = 0;
		int r = 0;

		for (int i = 0; i < 32; i++) {
			t = n & 1;
			r = r * 2 + t;
			n >>>= 1;
		}

		return r;

	}

	/*
	 * 2:11pm 06/04 2:25pm draft done 2:25pm 1pass
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		// solution 1
		TreeNode head = new TreeNode(0);

		if (nums.length == 0) {
			return null;
		} else if (nums.length == 1) {
			head.val = nums[0];
			head.left = null;
			head.right = null;
			return head;
		} else if (nums.length == 2) {
			int mid = nums.length / 2;
			head.val = nums[mid];
			head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
			return head;
		} else if (nums.length > 2) {
			int mid = nums.length / 2;
			head.val = nums[mid];
			head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
			head.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
			return head;
		} else {
			return null;
		}

		// solution 2
		// if(nums.length == 0) {
		// return null;
		// }
		//
		// TreeNode head = new TreeNode(0);
		// int mid = nums.length / 2;
		// while(mid > 0) {
		// head.val = nums[mid];
		// head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		// head.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
		// }
	}

	/*
	 * 3:02 pm 0604 3:25 draft1 done. 3:29 one pass accepted after fixing root==null
	 * return true.
	 * 
	 * from this question, you need to learn more about the iterative version of
	 * recursion.
	 */

	public boolean isSymmetric(TreeNode root) {
		ArrayList<Integer> leftVal = new ArrayList<Integer>();
		ArrayList<Integer> rightVal = new ArrayList<Integer>();

		if (root == null) {
			return true;
		}

		leftVal = helperLeft(root.left);
		rightVal = helperRight(root.right);

		Iterator<Integer> it1 = leftVal.iterator();
		Iterator<Integer> it2 = rightVal.iterator();
		while (it1.hasNext() && it2.hasNext()) {
			if (it1.next() != it2.next())
				return false;
		}
		if (it1.hasNext() || it2.hasNext())
			return false;

		return true;

	}

	private ArrayList<Integer> helperLeft(TreeNode root) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if (root == null) {
			nums.add(-1);
			return nums;
		}
		nums.addAll(helperLeft(root.left));
		nums.addAll(helperLeft(root.right));
		nums.add(root.val);
		return nums;
	}

	private ArrayList<Integer> helperRight(TreeNode root) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if (root == null) {
			nums.add(-1);
			return nums;
		}
		nums.addAll(helperRight(root.right));
		nums.addAll(helperRight(root.left));
		nums.add(root.val);
		return nums;
	}

	/*
	 * 4:16pm 0604 4:20pm 1 pass
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		// Solution 1, recursion
		List<Integer> result = new ArrayList<Integer>();
		// if(root == null) {
		//
		// return result;
		// }
		//
		// result.addAll(inorderTraversal(root.left));
		// result.add(root.val);
		// result.addAll(inorderTraversal(root.right));
		//
		// return result;

		// Solution 2 ,iterative
		// List<Integer> result = new ArrayList<Integer>();
		//
		// if (root == null)
		// return result;
		//
		// while (root.left != null) {
		// if (root.left.left == null) {
		// result.add(root.left.val);
		// if (root.left.right != null) {
		// result.add(root.left.right.val);
		// }
		// }
		//
		// }
		//
		return result;

	}

	/*
	 * 04:40pm failed from the following official solution, i learned that
	 * reordering the linked list should focus on changing the lists, not the nodes,
	 * especially when the question emphasize time o(n) and no extra storage.
	 * 
	 * however, when not limiting the storage, you can just create a new list with
	 * two pointers.
	 */
	/*
	 * 03:00pm 0620 redo the algorithm is to keep two pointers, one to the head of
	 * the original head. another to the first even head. then another two ptrs to
	 * the tails. then the two individual lists keep growning until one's next is
	 * null. finally, merge the odd's tail with the even's head. 03:22pm draft done.
	 * 03:23pm 1pass
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;

		ListNode hOdd = head;
		ListNode hEven = head.next;
		ListNode tOdd = hOdd;
		ListNode tEven = hEven;

		while (tOdd != null && tEven != null) {
			tOdd.next = tEven.next;
			if (tOdd.next == null)
				break;
			tOdd = tOdd.next;
			tEven.next = tOdd.next;
			tEven = tEven.next;
		}

		tOdd.next = hEven;

		return hOdd;

	}
	// public ListNode oddEvenList(ListNode head) {
	// if (head != null) {
	//
	// ListNode odd = head, even = head.next, evenHead = even;
	//
	// while (even != null && even.next != null) {
	// odd.next = odd.next.next;
	// even.next = even.next.next;
	// odd = odd.next;
	// even = even.next;
	// }
	// odd.next = evenHead;
	// }
	// return head;
	// }

	/*
	 * 7:31pm a non-interview but new question 7:41pm 1st draft done. 7:52pm 1st
	 * passing after fixing two bugs. 7:53pm 2nd solution pause at 8:00pm for kids
	 * resume at 8:42pm
	 * 
	 * 8:48pm solution 3 from back;
	 */

	public boolean backspaceCompare(String S, String T) {
		// Solution 1 linkedlist
		char[] s = new char[S.length()];
		char[] t = new char[T.length()];

		int si = 0;
		int ji = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				si--;
				if (si < 0) {
					si = 0;
				}
			} else {
				s[si++] = S.charAt(i);
			}
		}

		for (int j = 0; j < T.length(); j++) {
			if (T.charAt(j) == '#') {
				ji--;
				if (ji < 0) {
					ji = 0;
				}
			} else {
				t[ji++] = T.charAt(j);
			}
		}

		if (si-- != ji--)
			return false;

		while (si >= 0) {
			if (s[si--] != t[ji--]) {
				return false;
			}
		}

		return true;

		// //solution 2: stack failed
		// Stack<String> s = new Stack<String>();
		// Stack<String> t = new Stack<String>();
		//
		// for(int i=0; i < S.length(); i++ ) {
		// if(S.charAt(i) == '#') {
		// if(!s.empty()) s.pop();
		// }
		// else {
		// s.push(String.valueOf(S.charAt(i)));
		// }
		// }
		//
		// for(int j=0; j < T.length(); j++) {
		// if(T.charAt(j) == '#') {
		// if(!t.empty()) t.pop();
		// }
		// else {
		// t.push(String.valueOf(T.charAt(j)));
		// }
		// }
		//
		// if(s.size() != t.size()) return false;
		//
		// while(!s.empty()) {
		// if(s.pop() != t.pop()) {
		// return false;
		// }
		// }
		//
		// return true;

		// // solution 3
		// int si = S.length()-1;
		// int ti = T.length()-1;
		//
		// while(true) {
		// if(S.charAt(si) == T.charAt(ti))
		// }

	}

	/*
	 * 9:01 pm 10:02 pm failed. kind of feel exahusted at this moment. need fresh
	 * mind for challenges
	 * 
	 * 09:23am 06/05 restarted after consulting the official algorithm basically,
	 * you just need to add a sort algorithm 09:37am done, passed after fixing bug
	 * 1.
	 */
	public List<Interval> merge(List<Interval> intervals) {
		// List<Interval> result = new ArrayList<Interval>();
		//
		// if(intervals == null || intervals.size() < 2) return intervals;
		//
		// int[] s = new int[intervals.size()];
		// int[] e = new int[intervals.size()];
		// int i = 0;
		// int j = 0;
		// int k = 1;
		//
		// for(Interval l:intervals) {
		// s[i++] = l.start;
		// e[j++] = l.end;
		// }
		//
		// i = 0;
		// j = 0;
		// int mins = s[0];
		// while(i+k < s.length ) {
		// if (e[j] >= s[i+k] ) {
		// j++;
		// k++;
		// mins = mins > s[i+k] ? s[i+k] : mins;
		// }
		// else {
		// result.add(new Interval(mins, e[j]));
		// i = i+k;
		// j = i;
		// k = 1;
		// }
		// }
		//
		//
		// result.add(new Interval(s[i], e[j]));
		// return result;
		if (intervals.size() < 2) {
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();

		// Using the java8 lambda expression to sort
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		int iStart = intervals.get(0).start;
		int iEnd = intervals.get(0).end;

		for (Interval l : intervals) {
			if (iEnd >= l.start) {
				// #bug 1:
				// iEnd = l.end;

				// in case the first interval contains the second interval, use Max
				// sorting can only gurantee that l1.start <= l2.start
				// sorting can not gurantee that l1.end <= l2.end
				iEnd = Math.max(l.end, iEnd);
			} else {
				result.add(new Interval(iStart, iEnd));
				iStart = l.start;
				iEnd = l.end;
			}
		}

		result.add(new Interval(iStart, iEnd));
		return result;
	}

	/*
	 * 9:43am 0605 9:54am 1st draft done. 9:58am turns out to be a DP question
	 * 
	 * 
	 * 3:20pm 0710 restarted 3:55pm failed.
	 * 
	 * 2:32pm 0712 restarted
	 * 
	 */

	// public boolean wordBreak(String s, List<String> wordDict) {
	//
	// // wordDict.sort((w1, w2) -> (Integer.compare(w2.length(), w1.length())));
	// // String ms = s;
	// // for (String w : wordDict) {
	// // ms = ms.replaceAll(w, "");
	// // }
	// //
	// // // bug 1 should use ms.isEmpty()
	// // // return ms == "";
	// //
	// // return ms.isEmpty();
	//
	// }

	public int rob(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}

	/*
	 * 10:00am 0605 10:05am pause 10:18am resume 11:12am failed.
	 * 
	 * the reason is you didnt recognize the property of BST: BST is SORTED. so to
	 * get the kth smallest, simply do an in order traversal of the tree and get
	 * nums[k-1];
	 * 
	 * 12:09pm replement the inorder traversal algorithm. 12:13pm 1 pass.
	 */

	public int kthSmallest(TreeNode root, int k) {

		List<Integer> vals = inOrderTraversal(root);

		return vals.get(k - 1);

	}

	private List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		result.addAll(inOrderTraversal(root.left));
		result.add(root.val);
		result.addAll(inOrderTraversal(root.right));

		return result;
	}

	/*
	 * 12:21 pm 12:25 pm 1 pass however , solution 1 is o(n2) o(n) and it does not
	 * use the "sorted" property of the matrix.
	 * 
	 * 12:51pm started solution 2 1:56pm failed.
	 * 
	 * after reading the official solution, i think the key is to use binary search
	 * whenever you need to find/search a sorted stuff.
	 * 
	 * 
	 */

	public int kthSmallest(int[][] matrix, int k) {
		// //Solution 1
		// List<Integer> nums = new ArrayList<Integer>();
		//
		// for(int i = 0; i < matrix.length; i++) {
		// for(int j = 0; j < matrix.length; j++) {
		// nums.add(Integer.valueOf(matrix[i][j]));
		// }
		// }
		//
		// nums.sort((v1, v2) -> Integer.compare(v1, v2));
		//
		// return nums.get(k - 1);

		// Solution 2
		/*
		 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
		 * 
		 * return 13.
		 */
		// if(matrix.length < 2) return matrix[0][0];
		//
		// int p1x = 0, p1y = 1;
		// int p2x = 1, p2y = 0;
		// int px = 0, py = 0;
		//
		// int kMin = matrix[0][0];
		//
		// for(int i = 0; i < k; i++) {
		// if(matrix[px][py] > kMin) {
		// kMin = matrix[px][py];
		// if(matrix[p1x][p1y] > matrix[p2x][p2y]) {
		// px = p2x;
		// py = p2y;
		// p2x++;
		// }
		// else {
		// px = p1x;
		// py = p1y;
		// p1
		// }
		// }
		// }
		return 0;
	}

	/*
	 * 3:58pm 4:17pm figured out that i just dont know the algorithm then copied
	 * from the official answer and implemented it: /* clockwise rotate first
	 * reverse up to down, then swap the symmetry 1 2 3 7 8 9 7 4 1 4 5 6 => 4 5 6
	 * => 8 5 2 7 8 9 1 2 3 9 6 3 4:28pm draft done 4:45pm after fixing that index
	 * bug
	 * 
	 * Another lesson learned is that java do pass-by-value. so do not use those
	 * swap methods. you have to do it in place
	 */
	public void rotate(int[][] matrix) {

		int n = matrix.length;
		int mid = n / 2;
		int len = matrix.length;

		// step 1: reverse
		for (int i = 0; i < mid; i++) {
			for (int j = 0; j < len; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[len - 1 - i][j];
				matrix[len - 1 - i][j] = t;
			}
		}

		// step2: swap the symmetry
		for (int i = 0; i < len; i++) {
			// bug 1
			// for(int j = 0; j < len; j++) {
			for (int j = i + 1; j < len; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
	}

	/*
	 * 2:48pm 06/07 2:56pm first draft done 3:00pm after fixing the indexing bug,
	 * accepted.
	 */
	public void setZeroes(int[][] matrix) {
		if (matrix.length > 0) {
			List<Integer> mi = new ArrayList<Integer>();
			List<Integer> ni = new ArrayList<Integer>();

			// for (int i = 0; i < matrix[0].length; i++) {
			// for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						mi.add(i);
						ni.add(j);
					}
				}
			}
			for (Integer m : mi) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[m][j] = 0;
				}
			}

			for (Integer n : ni) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][n] = 0;
				}
			}
		}
	}

	/*
	 * 3:10pm 33. Search in Rotated Sorted Array Input: nums = [4,5,6,7,0,1,2],
	 * target = 0 Output: 4 3:32pm first draft done 3:38pm failed due to
	 * infamilarity with bst search.
	 * 
	 * 
	 * 8:49pm 0715 revisited after reading cci
	 * 
	 * The idea is to find the interval where nums[low] > nums[high], so that the
	 * changing point is in it. then search for the part before the chaning point
	 * and after the chaning point.
	 * 
	 * 
	 * 9:30pm draft done.
	 * 
	 * 9:58pm findChangingPoint failed. it can not work if there is no changing
	 * point.
	 * 
	 * #TODO practice binary search.
	 */

	public int search(int[] nums, int target) {
		// if (nums.length < 1)
		// return -1;
		//
		// int low = 0;
		// int high = nums.length - 1;
		//
		// return search_help(nums, target, low, high);

		int changingPoint = search_helper_findChangingPoint(nums);
		if (changingPoint == -1) {
			return binarySearch(nums, 0, nums.length, target);
		}
		int leftIndex = binarySearch(nums, 0, changingPoint, target);
		if (leftIndex == -1) {
			return binarySearch(nums, changingPoint, nums.length, target);
		} else
			return leftIndex;
	}

	int binarySearch(int[] nums, int inclusiveStart, int exclusiveEnd, int target) {
		int s = inclusiveStart, e = exclusiveEnd - 1;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (nums[mid] == target)
				return mid;
			else {
				if (nums[mid] > target) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}
		}

		return -1;

	}

	int search_helper_findChangingPoint(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) / 2;
		while (low < high) {
			if (nums[mid] > nums[high]) {
				if (nums[mid + 1] < nums[mid]) {
					return mid + 1;
				} else {
					low = mid;
				}
			} else {
				high = mid;
			}
		}
		return -1;
	}

	public int search_help(int[] nums, int target, int low, int high) {

		int mid = (low + high) / 2;

		while (low < high) {
			if (nums[low] == target)
				return low;
			if (nums[high] == target)
				return high;
			if (nums[mid] == target)
				return mid;
			if (nums[low] < target) {
				// low = low + mid + 1;
				// return search_help(nums, target, low, high);
				high = mid;
				return search_help(nums, target, low, high);
			} else {
				// high = mid;
				// return search_help(nums, target, low, high);
				low = low + mid + 1;
				return search_help(nums, target, low, high);
			}
		}
		if (low == high && nums[low] == target) {
			return low;
		}
		return -1;
	}

	public void swap(int a, int b) {
		int t = a;
		a = b;
		b = t;
	}

	public void swapLine(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			swap(a[i], b[i]);
		}
	}

	/*
	 * 5:10 pm 5:28pm first draft done 5:53pm failed. perhaps the idea is not
	 * correct also this is a backtracking problem. 6:13pm debugging found this
	 * algorithm is not correct: (()(())) this is because the algorithm neglected
	 * the meaning of "well-formed" parenthese. it must satisfy the closure property
	 * 0, 2*c+1 must form a pair.
	 */
	public List<String> generateParenthesis(int n) {
		Set<String> result = new HashSet<String>();
		result.addAll(generateParenthesis_helper(n));
		return new ArrayList<String>(result);
	}

	public List<String> generateParenthesis_helper(int n) {
		List<String> result = new ArrayList<String>();
		String l = "(", r = ")", f = "()";

		if (n == 1) {
			result.add(f);
		} else {
			// result.add(f);
			List<String> rresult = generateParenthesis_helper(n - 1);
			for (String p : rresult) {
				// result.add(p + f);
				result.add(l + p + r);
				result.add(p + f);
				result.add(f + p);

			}
		}
		return result;
	}

	/*
	 * 11:28 pm 11:49 pm failed. figured out its probably a back tracking algorithm.
	 * so i could figure out the problem, but i dont know a way to implement it.
	 */

	// public boolean wordexist(char[][] board, String word) {
	// List<Pair> seeds = new ArrayList<Pair>();
	// int wi = 0;
	//
	// if (word.equals(""))
	// return false;
	//
	// if (board.length < 1)
	// return false;
	//
	// for (int i = 0; i < board[0].length; i++) {
	// for (int j = 0; j < board.length; j++) {
	// if (board[i][j] == word.charAt(wi)) {
	// seeds.add(new Pair(i, j));
	// }
	// }
	// }
	// //
	// // wi++;
	// //
	// // while (wi < word.length()) {
	// // for (Pair sd : seeds) {
	// // List<Pair> seeds_next = new ArrayList<Pair>();
	// //
	// // if (board[sd.left + i][sd.right + j] == word.charAt(wi)) {
	// // seeds_next.add(new Pair(sd.left + i, sd.right + j));
	// // }
	// //
	// // }
	// //
	// // return true;
	// // }
	//
	// }

	class Pair {
		int left;
		int right;

		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override

		public boolean equals(Object obj) {

			return (this.left == (((Pair) obj).left) && this.right == (((Pair) obj).right));

		}

	}

	/*
	 * 2:35pm 06/08 3:04pm restart 3:09 failed, this is a backtracking problem
	 * 
	 * 04:23pm 0703 restarted. Copied this very nice summary here for your
	 * reference: This structure might apply to many other backtracking questions,
	 * but here I am just going to demonstrate Subsets, Permutations, and
	 * Combination Sum.
	 * 
	 * Subsets : https://leetcode.com/problems/subsets/
	 * 
	 * public List<List<Integer>> subsets(int[] nums) { List<List<Integer>> list =
	 * new ArrayList<>(); Arrays.sort(nums); backtrack(list, new ArrayList<>(),
	 * nums, 0); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list , List<Integer> tempList, int
	 * [] nums, int start){ list.add(new ArrayList<>(tempList)); for(int i = start;
	 * i < nums.length; i++){ tempList.add(nums[i]); backtrack(list, tempList, nums,
	 * i + 1); tempList.remove(tempList.size() - 1); } }
	 * 
	 * Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
	 * 
	 * public List<List<Integer>> subsetsWithDup(int[] nums) { List<List<Integer>>
	 * list = new ArrayList<>(); Arrays.sort(nums); backtrack(list, new
	 * ArrayList<>(), nums, 0); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int
	 * [] nums, int start){ list.add(new ArrayList<>(tempList)); for(int i = start;
	 * i < nums.length; i++){ if(i > start && nums[i] == nums[i-1]) continue; //
	 * skip duplicates tempList.add(nums[i]); backtrack(list, tempList, nums, i +
	 * 1); tempList.remove(tempList.size() - 1); } }
	 * 
	 * Permutations : https://leetcode.com/problems/permutations/
	 * 
	 * public List<List<Integer>> permute(int[] nums) { List<List<Integer>> list =
	 * new ArrayList<>(); // Arrays.sort(nums); // not necessary backtrack(list, new
	 * ArrayList<>(), nums); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int
	 * [] nums){ if(tempList.size() == nums.length){ list.add(new
	 * ArrayList<>(tempList)); } else{ for(int i = 0; i < nums.length; i++){
	 * if(tempList.contains(nums[i])) continue; // element already exists, skip
	 * tempList.add(nums[i]); backtrack(list, tempList, nums);
	 * tempList.remove(tempList.size() - 1); } } }
	 * 
	 * Permutations II (contains duplicates) :
	 * https://leetcode.com/problems/permutations-ii/
	 * 
	 * public List<List<Integer>> permuteUnique(int[] nums) { List<List<Integer>>
	 * list = new ArrayList<>(); Arrays.sort(nums); backtrack(list, new
	 * ArrayList<>(), nums, new boolean[nums.length]); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int
	 * [] nums, boolean [] used){ if(tempList.size() == nums.length){ list.add(new
	 * ArrayList<>(tempList)); } else{ for(int i = 0; i < nums.length; i++){
	 * if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	 * used[i] = true; tempList.add(nums[i]); backtrack(list, tempList, nums, used);
	 * used[i] = false; tempList.remove(tempList.size() - 1); } } }
	 * 
	 * Combination Sum : https://leetcode.com/problems/combination-sum/
	 * 
	 * public List<List<Integer>> combinationSum(int[] nums, int target) {
	 * List<List<Integer>> list = new ArrayList<>(); Arrays.sort(nums);
	 * backtrack(list, new ArrayList<>(), nums, target, 0); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int
	 * [] nums, int remain, int start){ if(remain < 0) return; else if(remain == 0)
	 * list.add(new ArrayList<>(tempList)); else{ for(int i = start; i <
	 * nums.length; i++){ tempList.add(nums[i]); backtrack(list, tempList, nums,
	 * remain - nums[i], i); // not i + 1 because we can reuse same elements
	 * tempList.remove(tempList.size() - 1); } } }
	 * 
	 * Combination Sum II (can't reuse same element) :
	 * https://leetcode.com/problems/combination-sum-ii/
	 * 
	 * public List<List<Integer>> combinationSum2(int[] nums, int target) {
	 * List<List<Integer>> list = new ArrayList<>(); Arrays.sort(nums);
	 * backtrack(list, new ArrayList<>(), nums, target, 0); return list;
	 * 
	 * }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int
	 * [] nums, int remain, int start){ if(remain < 0) return; else if(remain == 0)
	 * list.add(new ArrayList<>(tempList)); else{ for(int i = start; i <
	 * nums.length; i++){ if(i > start && nums[i] == nums[i-1]) continue; // skip
	 * duplicates tempList.add(nums[i]); backtrack(list, tempList, nums, remain -
	 * nums[i], i + 1); tempList.remove(tempList.size() - 1); } } }
	 * 
	 * Palindrome Partitioning :
	 * https://leetcode.com/problems/palindrome-partitioning/
	 * 
	 * public List<List<String>> partition(String s) { List<List<String>> list = new
	 * ArrayList<>(); backtrack(list, new ArrayList<>(), s, 0); return list; }
	 * 
	 * public void backtrack(List<List<String>> list, List<String> tempList, String
	 * s, int start){ if(start == s.length()) list.add(new ArrayList<>(tempList));
	 * else{ for(int i = start; i < s.length(); i++){ if(isPalindrome(s, start, i)){
	 * tempList.add(s.substring(start, i + 1)); backtrack(list, tempList, s, i + 1);
	 * tempList.remove(tempList.size() - 1); } } } }
	 * 
	 * public boolean isPalindrome(String s, int low, int high){ while(low < high)
	 * if(s.charAt(low++) != s.charAt(high--)) return false; return true; }
	 * 
	 * #TODO why do i feel connections between graph traversal and bt?
	 * 
	 * 10:22am 0705 copied the official solution
	 * 
	 * 
	 */
	// public List<List<Integer>> subsets(int[] nums) {
	//
	// List<List<Integer>> result = new ArrayList<List<Integer>>();
	// if (nums == null)
	// return result;
	//
	// Map<Integer, List<List<Integer>>> memo = new HashMap<Integer,
	// List<List<Integer>>>();
	// return subsets_Helper(nums, memo);
	// }

	// public List<List<Integer>> subsets(int[] nums) {
	// List<List<Integer>> list = new ArrayList<>();
	// Arrays.sort(nums);
	// backtrack(list, new ArrayList<>(), nums, 0);
	// return list;
	// }
	/*
	 * 1:24pm 0724 revisited after reading the cci book
	 *
	 * 1:36pm draft done. 1:56pm debugging done... brain is not clear. 1:57pm passed
	 */
	public List<List<Integer>> subsets(int[] nums) {

		List<List<List<Integer>>> result = new ArrayList<>();
		List<List<List<Integer>>> nextresult = new ArrayList<>();
		List<List<Integer>> r0 = new ArrayList<>();
		if (nums == null || nums.length < 1)
			return r0;

		List<Integer> r00 = new ArrayList<>();
		r0.add(r00);
		r00 = new ArrayList<>();
		r00.add(nums[0]);
		r0.add(r00);

		result.add(r0);

		for (int i = 1; i < nums.length; i++) {
			r0 = new ArrayList<>();
			for (List<List<Integer>> _r : result) {
				for (List<Integer> _rr : _r) {
					r00 = new ArrayList<>(_rr);
					r00.add(nums[i]);
					r0.add(r00);
				}
				r0.addAll(_r);
				nextresult.add(r0);
			}
			result.clear();
			result.addAll(nextresult);
			nextresult.clear();

		}

		return result.get(0);
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public List<List<Integer>> subsets_Helper(int[] nums, Map<Integer, List<List<Integer>>> memo) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null)
			return result;
		// Arrays.sort(nums);

		if (nums.length == 1) {
			List<Integer> r = new ArrayList<Integer>();
			r.add(nums[0]);
			result.add(r);
		} else if (nums.length > 1) {
			if (memo.containsKey(nums.length)) {
				return memo.get(nums.length);
			} else {
				for (int i = 0; i < nums.length; i++) {
					for (List<Integer> l : subsets_Helper(removeElements(nums, nums[i]), memo)) {
						List<Integer> r = new ArrayList<Integer>(l);
						r.add(nums[i]);
						result.add(r);
					}
				}
			}
		}

		memo.put(nums.length, result);
		return result;

	}

	public int[] removeElements(int[] nums, int element) {
		int[] result = new int[nums.length - 1];
		int si = 0;
		for (int n : nums) {
			if (n != element)
				result[si++] = n;
		}

		return result;
	}

	public List<List<Integer>> subsets_helper(int[] nums, int start) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();

		if (nums.length == 1) {
			r.add(nums[0]);
			result.add(r);
		} else {
			r.add(nums[0]);

			for (List<Integer> l : subsets_helper(nums, start + 1)) {
				r.addAll(l);
				result.add(r);
				r = new ArrayList<Integer>();
			}
		}

		return result;
	}

	/*
	 * 3:14pm 06/08 3:26pm draft done. 1 pass the same as the official solution but
	 * is quite verbosome.
	 */

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();

		for (int i = 0; i < strs.length; i++) {
			char[] cs = strs[i].toCharArray();
			Arrays.sort(cs);
			String t = String.valueOf(cs);
			if (dict.containsKey(t)) {
				List<Integer> r = dict.get(t);
				r.add(i);
				dict.put(t, r);
			} else {
				List<Integer> r = new ArrayList<Integer>();
				r.add(i);
				dict.put(t, r);
			}
		}

		for (String k : dict.keySet()) {
			List<String> r = new ArrayList<String>();
			for (Integer ind : dict.get(k)) {
				r.add(strs[ind]);
			}
			result.add(r);
		}

		return result;
	}

	/*
	 * 3:45pm 0608 preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] 4:20pm draft
	 * done; but failed. probably due to index minors. brain is really tired, not
	 * really in the good mode.
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int[] inorderind = new int[inorder.length];

		if (preorder == null || inorder == null)
			return new TreeNode(0);

		if (preorder.length != inorder.length)
			return new TreeNode(0);

		return buildTree_helper(preorder, inorder, 0, preorder.length - 1, inorderind);

	}

	public TreeNode buildTree_helper(int[] preorder, int[] inorder, int preInd_low, int inInd_high, int[] inorderInd) {

		if (preInd_low < preorder.length && preInd_low <= inInd_high) {
			TreeNode tl = new TreeNode(preorder[preInd_low]);

			int ind = Arrays.binarySearch(inorder, preorder[preInd_low]);
			inorderInd[ind] = 1;

			int leftSize = 0;
			for (int i = 0; i <= ind; i++) {
				if (inorderInd[i] != 1) {
					leftSize++;
				}
			}

			tl.left = buildTree_helper(preorder, inorder, preInd_low + 1, preInd_low + leftSize, inorderInd);
			tl.right = buildTree_helper(preorder, inorder, preInd_low + leftSize + 1, inInd_high, inorderInd);
			return tl;
		}

		return null;
	}

	public void changeArrayVal(int[] a) {
		a[0] = 999;
	}

	/*
	 * 8:52pm 8:56pm pause
	 * 
	 * 9:09 resume Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. 9:12 draft done. 9:24pm fixed the length == n situation. 9:37pm
	 * fixed by adding a permanent "result" head to gurantee that n < list.length;
	 * 
	 * however, the follow up shows that this type of question always uses a two
	 * pointer with a N gap style design. need to figure it out.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int currLength = 0;

		ListNode result = new ListNode(0);
		result.next = head;
		ListNode currNode = result;
		ListNode probeNode = currNode;

		while (currNode != null) {
			while (probeNode.next != null) {
				probeNode = probeNode.next;
				currLength++;
			}
			if (currLength > n) {
				currNode = currNode.next;
				probeNode = currNode;
				currLength = 0;
			} else if (currLength == n) {
				currNode.next = currNode.next.next;
				return result.next;
			} else {
				return result.next;
			}
		}

		return result.next;
	}

	/*
	 * 10:01pm 0608 started 10:20pm failed due to bst
	 * 
	 * 03:01pm 0709 resumed
	 * 
	 * The algorithm is a modified binary search. the search stops when the lower ==
	 * higher == target. then combine all resulting ranges. 03:13pm pause 03:28pm
	 * resume
	 * 
	 * 
	 * 3:50pm draft done 3:59pm 3pass after fixing two bugs #TODO practice more on
	 * binary search algorithm.
	 */

	public int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		Set<Integer> rr = searchRange_helper(nums, 0, nums.length - 1, target);
		if (rr.isEmpty()) {
			result[0] = -1;
			result[1] = -1;
			return result;
		} else {
			result[0] = Collections.min(rr);
			result[1] = Collections.max(rr);
			return result;
		}
	}

	public Set<Integer> searchRange_helper(int[] nums, int low, int high, int target) {
		Set<Integer> result = new HashSet<Integer>();
		if (nums == null)
			return result;
		if (low > high || low < 0 || high < 0 || low > nums.length - 1 || high > nums.length - 1)
			return result;

		if (nums[low] == target && nums[high] == target) {
			result.add(low);
			result.add(high);
			return result;
		} else {
			// bug 1
			// int middle = (high - low) / 2;
			int middle = (high - low) / 2 + low;
			if (nums[middle] < target) {
				return searchRange_helper(nums, middle + 1, high, target);
			} else if (nums[middle] > target) {
				return searchRange_helper(nums, low, middle - 1, target);
			} else {
				Set<Integer> left = searchRange_helper(nums, low, middle, target);
				// bug 2
				// left.addAll(searchRange_helper(nums, middle, high, target));
				left.addAll(searchRange_helper(nums, middle + 1, high, target));
				result.add(Collections.min(left));
				result.add(Collections.max(left));
				return result;
			}
		}
	}

	/*
	 * 11:41pm started. Example:
	 * 
	 * X X X X X O O X X X O X X O X X
	 * 
	 * After running your function, the board should be:
	 * 
	 * X X X X X X X X X X X X X O X X
	 * 
	 * 9:05am 0609 resumed 9:37pm draft done. 10:20pm
	 */
	public void solve1(char[][] board) {
		// step 0. find all o.
		// step 1. find all boundary o.
		// step 2. recursively find all connected o
		// step 3. for each area, remove it if it contains any boundary o found in step
		// 1.

		if (board != null && board.length > 0 && board[0] != null) {
			int bxLength = board[0].length;
			int byLength = board.length;

			// Step 0
			int[][] boInds = new int[bxLength][byLength];
			for (int i = 0; i < bxLength; i++) {
				if (board[0][i] == 'o') {
					boInds[0][i] = 1;
				}
				if (board[byLength - 1][i] == 'o') {
					boInds[byLength - 1][i] = 1;
				}
			}

			for (int j = 0; j < byLength; j++) {
				if (board[j][0] == 'o') {
					boInds[j][0] = 1;
				}
				if (board[j][bxLength - 1] == 'o') {
					boInds[j][bxLength - 1] = 1;
				}
			}

			// Step 1
			int[][] oInds = new int[bxLength][byLength];
			for (int i = 1; i < bxLength - 1; i++) {
				for (int j = 1; j < byLength - 1; j++) {
					if (board[i][j] == 'o') {
						oInds[i][j] = 1;
					}
				}
			}

			// step 2. recursively find all connected o
			List<List<Pair>> areas = new ArrayList<List<Pair>>();
			for (int i = 1; i < bxLength - 1; i++) {
				for (int j = 1; j < byLength - 1; j++) {
					if (oInds[i][j] == 1) {
						areas.add(addO(board, i, j));
					}
				}
			}

			List<List<Pair>> result = new ArrayList<List<Pair>>();
			for (int i = 0; i < bxLength; i++) {
				for (int j = 0; j < byLength; j++) {
					if (boInds[i][j] == 1) {
						for (List<Pair> lp : areas) {
							if (!(lp.contains(new Pair(i, j)))) {
								result.add(lp);
							}
						}
					}
				}
			}

			for (List<Pair> lp : result) {
				for (Pair p : lp) {
					board[p.left][p.right] = 'X';
				}
			}
		}

	}

	public List<Pair> addO(char[][] boards, int i, int j) {
		int bxLength = boards[0].length;
		int byLength = boards.length;

		List<Pair> areas = new ArrayList<Pair>();
		if (i < 0 || i > byLength - 1 || j < 0 || j > bxLength - 1) {
			return areas;
		}
		if (boards[i][j] == 'c') {
			areas.add(new Pair(i, j));
			areas.addAll(addO(boards, i - 1, j));
			areas.addAll(addO(boards, i, j - 1));
			areas.addAll(addO(boards, i + 1, j));
			areas.addAll(addO(boards, i, j + 1));
		} else {
			return areas;
		}
		return areas;
	}

	/*
	 * 5:35pm started dp problem
	 */
	// public int numDecodings(String s) {
	//
	// }

	/*
	 * 5:50pm started 6:02pm 1st draft 6:12pm failed inorder traversal problem
	 */
	/*
	 *
	 * 7:15pm 0722 revisited 7:24pm pause 8:48pm resume 8:56pm draft done 9:10PM
	 * FAILED #TODO many tree problems can be solved using variants of Inorder
	 * trasversal, post order traversal. etc.
	 */
	public boolean isValidBST(TreeNode root) {
		// boolean valid = true;
		// if(root == null) {
		// return true;
		// }

		// if(root.left != null) {
		// valid = root.val > root.left.val && isValidBST(root.left);
		// }

		// if(root.right != null) {
		// valid = valid && root.val < root.right.val && isValidBST(root.right);
		// }

		// return valid;
		if (root == null)
			return true;
		return isValidBST_helper_left(root.left, root.val) && isValidBST_helper_right(root.right, root.val);
	}

	public boolean isValidBST_helper_left(TreeNode root, int parentVal) {
		if (root == null)
			return true;

		if (root.val >= parentVal)
			return false;

		return isValidBST_helper_left(root.left, root.val) && isValidBST_helper_right(root.right, root.val);
	}

	public boolean isValidBST_helper_right(TreeNode root, int parentVal) {
		if (root == null)
			return true;

		if (root.val <= parentVal)
			return false;

		return isValidBST_helper_left(root.left, root.val) && isValidBST_helper_right(root.right, root.val);
	}

	public boolean isValidBST_h(TreeNode root, int prev) {
		boolean valid = true;
		if (root == null) {
			valid = true;
		}

		if (root.left != null) {
			valid = root.val > root.left.val && isValidBST_h(root.left, root.val);
		}

		if (root.right != null) {
			valid = valid && root.val < root.right.val && isValidBST_h(root.right, root.val);
		}

		return valid;

	}

	/*
	 * 5:26pm 0612 started the idea is to catch every rising slope.
	 * 
	 * 5:35pm 1pass
	 * 
	 * 4:13pm 0724 revisit solved using brutal force
	 * 
	 * 
	 */

	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices == null)
			return profit;

		int buyPrice = 0;
		int sellPrice = 0;
		boolean bought = false;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i] && bought == false) {
				// buy
				buyPrice = prices[i];
				bought = true;
			} else if (prices[i + 1] < prices[i] && bought == true) {
				// sell
				sellPrice = prices[i];
				profit += (sellPrice - buyPrice);
				buyPrice = 0;
				sellPrice = 0;
				bought = false;
			}
		}

		if (bought == true) {
			sellPrice = prices[prices.length - 1];
			profit += (sellPrice - buyPrice);
		}

		return profit;
	}

	/*
	 * 5:40pm 0612 started [[1,1],2,[1,1]], 6:25pm 1st draft. 1pass
	 */
	// public class NestedIterator implements Iterator<Integer> {
	//
	// Queue<Integer> qu = null;
	//
	// public NestedIterator(List<NestedInteger> nestedList) {
	// this.qu = new LinkedList<Integer>();
	// for (NestedInteger nn : nestedList) {
	// this.qu.addAll(nestedAddEle(nn));
	// }
	// }
	//
	// private Queue<Integer> nestedAddEle(NestedInteger nestedList) {
	// Queue<Integer> q = new LinkedList<Integer>();
	// NestedInteger curr = nestedList;
	//
	// if (curr.isInteger()) {
	// q.add(curr.getInteger());
	// } else {
	// for (NestedInteger nn : curr.getList()) {
	// q.addAll(nestedAddEle(nn));
	// }
	// }
	//
	// return q;
	// }
	//
	// @Override
	// public Integer next() {
	// if (hasNext()) {
	// return qu.poll();
	// }
	// return null;
	// }
	//
	// @Override
	// public boolean hasNext() {
	// return qu.size() > 0;
	// }
	// }

	/*
	 * 8:49am 0613 started 8:51am draft done.1 pass
	 */
	public boolean isAnagram(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ts = t.toCharArray();

		Arrays.sort(cs);
		Arrays.sort(ts);

		String ns = String.valueOf(cs);
		String nt = String.valueOf(ts);

		return ns.equals(nt);
	}

	/*
	 * 9:12am 0613 started 9:17am pause. 9:28am draft done. the result was 51234.
	 * not what the question wanted. 9:31am restarted.
	 * 
	 * 1:40pm 0618 restarted 2:04pm draft done. accepted after fixing 3 bugs. the 3
	 * bugs are due to no-check of input and incomplete coverage of if else. 2:29pm
	 * solution 2 draft. 2:30pm 1pass
	 * 
	 * 
	 * 04:23pm 0709 revisited
	 * 
	 */
	public ListNode reverseList(ListNode head) {

		// ListNode tail = head;
		// ListNode currTail = tail;
		// ListNode curr = head;
		// ListNode currNext = curr.next;
		//
		// if(head == null) return head;
		//
		// while(tail.next != null) {
		// tail = tail.next;
		// }
		//
		// if(tail == head) return head;
		//
		// currTail = tail;
		//
		// while(curr != tail) {
		// currTail.next = curr;
		// currTail = curr;
		// curr.next = null;
		// curr = currNext;
		// currNext = curr.next;
		// }
		//
		// return tail;
		// ListNode curr = head;
		// ListNode result = reverseList_once(head);
		// curr = result.next;
		// while (curr != null) {
		// curr = reverseList_once(curr);
		// curr = curr.next;
		// }
		//
		// return result;

		// // solution 0618
		// //bug 2
		// if(head == null) return head;
		//
		// ListNode result = new ListNode(-1);
		// ListNode oHead = head;
		// ListNode currTail = head;
		// ListNode tail = result;
		// int len = 0;
		// int currInd = 0;
		// while(currTail != null) {
		// currTail = currTail.next;
		// len++;
		// }
		// //bug 3
		// if(len == 1) return head;
		//// while(len > 1) {
		// // bug 1
		// while(len > 1) {
		// currTail = oHead;
		// while(++currInd < len) {
		// currTail = currTail.next;
		// }
		//
		// tail.next = currTail;
		// currTail.next = oHead;
		// tail = currTail;
		//
		// currInd = 0;
		// len--;
		// }
		//
		// // bug 1
		// oHead.next = null;
		// return result.next;

		// // solution 0618 recursively
		// if (head == null)
		// return null;
		//
		// if (head.next == null)
		// return head;
		//
		// ListNode dummy = null;
		// ListNode currTail = head;
		//
		// while (currTail.next.next != null) {
		// currTail = currTail.next;
		// }
		//
		// dummy = currTail.next;
		// currTail.next = null;
		// dummy.next = reverseList(head);
		//
		// return dummy;

		// solution 0709

		// if(head == null) return head;
		// if(head.next == null) return head;
		// ListNode p = head;
		// ListNode pp = reverseList(head.next);
		// ListNode pp2 = pp;
		//
		// while(pp.next != null) {
		// pp = pp.next;
		// }
		// p.next = null;
		// pp.next = p;
		// return pp2;

		// solution 0709 iterative
		// #TODO the idea is to actually reverse the links, not to rearrange the nodes.
		if (head == null)
			return head;

		ListNode prevCurr = null;
		ListNode curr = head;
		ListNode next = head.next;

		while (curr != null) {
			curr.next = prevCurr;
			prevCurr = curr;
			curr = next;
			if (curr == null)
				break;
			next = next.next;
		}

		return prevCurr;

	}

	public ListNode reverseList_once(ListNode head) {
		ListNode tail = head;
		ListNode currTail = tail;
		ListNode curr = head;
		ListNode currNext = curr.next;

		if (head == null)
			return head;

		while (tail.next != null) {
			tail = tail.next;
		}

		if (tail == head)
			return head;

		currTail = tail;

		while (curr != tail) {
			currTail.next = curr;
			currTail = curr;
			curr.next = null;
			curr = currNext;
			currNext = curr.next;
		}

		return tail;
	}

	/*
	 * 10:12am 0613 started 10:21am draft done; 1 pass after fixing the sum != 0 bug
	 */
	public boolean isHappy(int n) {
		List<Integer> digits = new ArrayList<Integer>();
		HashMap<Integer, Integer> appearedSum = new HashMap<Integer, Integer>();
		int sum = 0;
		int num = n;

		while (true) {
			digits = numToDigits(num);
			for (Integer i : digits) {
				sum += i * i;
			}
			if (sum == 1) {
				return true;
			} else {
				if (appearedSum.containsKey(sum)) {
					return false;
				} else {
					appearedSum.put(sum, 0);
				}
			}
			num = sum;
			// bug 1 reset sum
			sum = 0;
		}

	}

	/*
	 * 10:37am 0613 started 10:50am failed. fibbonaci numbers. had a feeling but not
	 * familiar with fib nums.
	 * 
	 * 
	 * 3:16pm 0712 revisited 3:21pm draft done 3:22pm TIME LIMIT EXCEEDED 3:27pm DP
	 * draft done 3:35pm TIME LIMIT EXCEEDED
	 * 
	 * 3:35PM DP2
	 * 
	 * 
	 * 3:45pm dp2 done
	 * 
	 */

	public int climbStairs(int n) {

		// int total = 0;
		//
		// if (n < 1)
		// return 0;
		//
		// if (n == 1) {
		// return 1;
		// } else {
		// for (int i = 1; i <= n; i++) {
		// total += climbStairs(i) + climbStairs(n - i);
		// }
		// }
		//
		// return total;
		// int[] ways = new int[n+1];
		// initiate1DArray(ways, Integer.MAX_VALUE);
		// return climbStairs_helper(n, ways);

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {

			dp[i] = dp[i - 1] + dp[i - 2];

		}

		return dp[n];
	}

	public int climbStairs_helper(int n, int[] ways) {
		if (n < 0) {
			return 0;
		}
		if (n <= 1) {
			ways[n] = 1;
			return 1;
		}
		if (ways[n] != Integer.MAX_VALUE)
			return ways[n];

		else {
			ways[n] = climbStairs(n - 1) + climbStairs(n - 2);
			return ways[n];
		}
	}

	/*
	 * 10:57am 0613 started 11:02am 1st draft done after consulting the answers.
	 * 11:05am 1pass
	 * 
	 */
	public void sortColors(int[] nums) {
		int cntR, cntW, cntB;
		cntR = cntW = cntB = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				cntR++;
			else if (nums[i] == 1)
				cntW++;
			else if (nums[i] == 2)
				cntB++;
		}

		while (cntB > 0) {
			nums[cntR + cntW + --cntB] = 2;
		}

		while (cntW > 0) {
			nums[cntR + --cntW] = 1;
		}

		while (cntR > 0) {
			nums[--cntR] = 0;
		}

	}

	public List<Integer> numToDigits(int num) {
		List<Integer> digits = new ArrayList<Integer>();
		while (num != 0) {
			digits.add(num % 10);
			num = num / 10;
		}

		Collections.reverse(digits);

		return digits;
	}

	/*
	 * 11:13am 0613 started 11:25am draft done. 11:46am pass after fixe 1 of the
	 * corner case;
	 * 
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;

		int yLength = matrix.length;
		if (yLength < 1)
			return false;
		int xLength = matrix[0].length;

		int[] xArray = new int[xLength];
		int[] yArray = new int[yLength];

		// Fix 1
		// for(int i = 0; i < yLength; i++) {
		for (int i = 0; i < yLength && i < xLength; i++) {
			for (int j = i; j < xLength; j++)
				xArray[j] = matrix[i][j];
			for (int k = i; k < yLength; k++)
				yArray[k] = matrix[k][i];
			if (Arrays.binarySearch(xArray, target) >= 0)
				return true;
			if (Arrays.binarySearch(yArray, target) >= 0)
				return true;
		}

		return false;
	}

	public int matrixXLength(int[][] matrix) {
		int yLength = matrix.length;
		if (yLength < 1)
			return 0;
		return matrix[0].length;
	}

	public int matrixYLength(int[][] matrix) {
		return matrix.length;
	}

	/*
	 * 12:12pm 0613 started 12:24pm pause 1:19pm resume 1:32pm draft done. 1 pass
	 * accepted
	 */
	public boolean isValidSudoku(char[][] board) {
		char[] arr = new char[9];
		int si = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[si++] = board[i][j];
			}
			if (!lineIsValid(arr))
				return false;
			si = 0;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[si++] = board[j][i];
			}
			if (!lineIsValid(arr))
				return false;
			si = 0;
		}

		for (int i = 1; i < 9; i += 3) {
			for (int j = 1; j < 9; j += 3) {
				for (int k = i - 1; k < i + 2; k++) {
					for (int l = j - 1; l < j + 2; l++) {
						arr[si++] = board[k][l];
					}
				}
				if (!lineIsValid(arr))
					return false;
				si = 0;
			}
		}

		return true;
	}

	/*
	 * 1:45pm 0613 started 2:12pm draft done. 2:15PM FAILED. the algorithm can find
	 * solutiosn, but not the min. a perfect example that local min != global min.
	 */

	public int numSquares(int n) {
		int remain = n;
		int num = 0;
		int i = 1;
		int min1 = findMinMulti(n);

		while (remain > 0) {
			while (true) {
				if (i * i > remain)
					break;
				i++;
			}
			num++;
			i--;
			remain -= i * i;
			i = 1;
		}

		return Math.min(min1, num);
	}

	public int findMinMulti(int n) {
		int i = 0;
		int j = 0;
		int p = 0;
		int minStep = Integer.MAX_VALUE;

		while (true) {
			i++;
			p = i * i;
			if (p > n)
				break;
			else if (p == n)
				return 1;
			else {
				j = 0;
				while (true) {
					j++;
					if (j * p > n)
						break;
					else if (j * p == n)
						minStep = minStep > j ? j : minStep;
				}
			}
		}

		return minStep;
	}

	public boolean lineIsValid(char[] chars) {
		char[] validDigits = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int[] dict = new int[9];
		char c = '.';
		char dot = '.';

		for (int i = 0; i < chars.length; i++) {
			c = chars[i];
			if (c != dot) {
				if (Arrays.binarySearch(validDigits, c) >= 0) {
					dict[c - '1']++;
					if (dict[c - '1'] > 1)
						return false;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public void resetArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			nums[i] = 0;
	}

	/*
	 * 2:24PM 0613 started 2:51pm draft done. 3:01pm after fixing bug 1 1pass
	 * accepted. exactly the same as the best official solution.
	 */
	public int numIslands(char[][] grid) {
		if (grid == null)
			return 0;
		int yLength = grid.length;
		if (yLength < 1)
			return 0;
		int xLength = grid[0].length;

		if (xLength < 1 && yLength < 1)
			return 0;

		char mark = '1';

		for (int i = 0; i < yLength; i++) {
			for (int j = 0; j < xLength; j++) {
				if (grid[i][j] == '1') {
					markUp(grid, i, j, ++mark);

				}
			}

		}

		return mark - '1';
	}

	public void markUp(char[][] grid, int i, int j, char mark) {
		// Bug 1
		// if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {

		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = mark;
			markUp(grid, i - 1, j, mark);
			markUp(grid, i, j - 1, mark);
			markUp(grid, i + 1, j, mark);
			markUp(grid, i, j + 1, mark);
		}
	}

	/*
	 * 2:40pm 0614 started 3:21pm draft done. 1 pass accepted after fixing fix 1
	 * after consulting the official answer, i found the relationship between
	 * recursion and tree and bfs and dfs.
	 */

	Map<String, Set<String>> dict = new HashMap<String, Set<String>>();

	public void prepareDict() {
		String[] ltrs = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		for (int i = 2; i <= 9; i++) {
			char[] cs = ltrs[i - 2].toCharArray();
			Set<String> ll = new HashSet<String>();
			for (int j = 0; j < cs.length; j++) {
				ll.add(String.valueOf(cs[j]));
			}
			this.dict.put(String.valueOf(i), ll);
		}
	}

	public List<String> letterCombinations(String digits) {
		if (digits == null)
			return null;
		// fix 1
		// if (digits.length() < 1)
		// return null;
		if (digits.length() < 1 || digits.equals(""))
			return new ArrayList<String>();

		this.prepareDict();
		char[] cs = digits.toCharArray();
		List<String> result = new ArrayList<String>();
		result.addAll(lc_helper(cs));

		return result;
	}

	public Set<String> lc_helper(char[] digits) {
		Set<String> result = new HashSet<String>();
		char[] cs = digits;

		if (cs.length == 0) {
			return result;
		} else if (cs.length == 1) {
			return this.dict.get(String.valueOf(cs[0]));
		} else {
			Set<String> currLtrs = this.dict.get(String.valueOf(cs[0]));
			for (String currLtr : currLtrs) {
				for (String nextLtr : (lc_helper(Arrays.copyOfRange(cs, 1, cs.length)))) {
					result.add(currLtr + nextLtr);
				}
			}
		}

		return result;
	}

	/*
	 * 04:53pm 0614 started 04:56pm draft done. but passed time limit.
	 * 
	 * 
	 * 11:02am 0717 revisit
	 * 
	 * dp, dp[i][j] = number of numbers > j at nums[i];
	 * 
	 * 11:24am failed. could not figure out the details, i was hungary. could not
	 * focus.
	 * 
	 */

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null)
			return result;
		if (nums.length < 1)
			return result;

		for (int i = 0; i < nums.length; i++) {
			Integer cnt = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					cnt++;
				}
			}
			result.add(cnt);
		}

		return result;
		// Queue<TreeNode> queue = new LinkedList<>();
		// List<Integer> result = new ArrayList<>();
		//
		//
		//
		//
		//
		// List<Integer> result = new ArrayList<>();
		// if(nums == null || nums.length < 1) return result;
		//
		// int len = nums.length;
		// int[][] dp = new int[len][len];
		//
		// for(int i = 0; i < Integer.MAX_VALUE; i++) {
		//
		// }
		// for(int i = 1; i < len; i++ ) {
		// if(nums[i] )
		// }
		//
	}

	/*
	 * 08:38am 0615 08:47am draft done. i think the algorithm is correct but
	 * exceeded time limit o(n2)
	 * 
	 * 
	 * 10:13am 0717 revisit
	 * 
	 * dp, track max[i][j] and min[i][j]
	 * 
	 * 10:20am failed.
	 */
	public int maxArea(int[] height) {
		int maxArea = 0;
		int currArea = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (height[i] < height[j]) {
					currArea = height[i] * (j - i);
				} else {
					currArea = height[j] * (j - i);
				}
				maxArea = currArea > maxArea ? currArea : maxArea;
			}
		}

		return maxArea;
		// int len = height.length;
		// int[][] maxHeight = new int[len][len];
		// int[][] minHeight = new int[len][len];

	}

	/*
	 * 9:27am 0615 about tree traversal:
	 * https://blog.csdn.net/fansongy/article/details/6798278 failed as did not read
	 * that all pointers were initially set to null.
	 * 
	 */
	// too difficult to understand
	/*
	 * 06:55pm 0722 started 07:03pm draft done 9:22pm 2pass after fixing bug 1 #TODO
	 * Always make sure you have DONE things for EVERY element in an array. bfs
	 */
	public void connect(TreeLinkNode root) {
		List<TreeLinkNode> currVerts = new ArrayList<>();
		List<TreeLinkNode> nextVerts = new ArrayList<>();

		if (root != null) {
			currVerts.add(root);
		}

		while (!currVerts.isEmpty()) {
			if (currVerts.size() >= 2) {
				for (int i = 0; i < currVerts.size() - 1; i++) {
					currVerts.get(i).next = currVerts.get(i + 1);
					processNode(currVerts.get(i), nextVerts);
				}
				// bug 1
				processNode(currVerts.get(currVerts.size() - 1), nextVerts);
			} else {
				processNode(currVerts.get(0), nextVerts);
			}

			currVerts.clear();
			currVerts.addAll(nextVerts);
			nextVerts.clear();
		}
	}

	private void processNode(TreeLinkNode node, List<TreeLinkNode> list) {
		TreeLinkNode left = node.left;
		TreeLinkNode right = node.right;
		if (left != null)
			list.add(left);
		if (right != null)
			list.add(right);
	}
	// public List<List<TreeLinkNode>> bfs(TreeLinkNode root){
	// List<List<TreeLinkNode>> result = new ArrayList<List<TreeLinkNode>>();
	//
	// if(root == null) {
	// return result;
	// }
	//
	//
	//
	// }

	/*
	 * 12:33pm 0615 started 12:48pm draft done. 12:58pm check done. 1:07pm failed. i
	 * think the algorithm is correct but could not find the reason. i also think
	 * the official solution kindof simplified real cases.
	 * 
	 * 10:31pm 0704 restarted
	 * 
	 * The algorithm is to use a deque, endeque left parts, dedeque right parts. if
	 * any pair is different, return false;
	 * 
	 * 10:45pm 2pass after fixing bug 1. my first Beat 100% solution.
	 * 
	 * 
	 */

	public boolean isValid(String s) {
		Deque<String> p = new ArrayDeque<String>();

		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
			case '{':
			case '[':
				p.offer(String.valueOf(c));
				break;
			default:
				String left = p.pollLast();
				// #TODO Do not use str != str2
				if (!String.valueOf(reversePa(c)).equals(left))
					return false;
				break;
			}
		}

		// bug 1
		// return true;
		return p.isEmpty();

	}

	public boolean isValidWithNonParen(String s) {
		String filtered = "";

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
			case ')':
			case '{':
			case '}':
			case '[':
			case ']':
				filtered += s.charAt(i);
				break;
			}
		}
		return isValid(filtered);
	}

	// public boolean isValid(String s) {
	// if (s == null)
	// return true;
	// if (s.isEmpty())
	// return true;
	// return isValid_helper(s.toCharArray(), 0, s.length());
	// }
	//
	// public Map<String, String> getParenMap() {
	// Map<String, String> dict = new HashMap<String, String>();
	// dict.put("(", ")");
	// dict.put("[", "]");
	// dict.put("{", "}");
	//
	// return dict;
	// }
	//
	public char reversePa(char p) {
		switch (p) {
		case '}':
			return '{';
		case ']':
			return '[';
		case ')':
			return '(';
		}

		return 'x';
	}
	//
	// public boolean isValid_helper(char[] s, int startI, int endI) {
	//
	// if (startI >= endI || startI > s.length - 1 || endI > s.length || startI < 0
	// || endI < 1) {
	// return false;
	// }
	//
	// char c = s[startI];
	// int indP = 0;
	// for (int i = endI - 1; i >= startI; i--) {
	// indP = 2 * i + 1;
	// if (indP < endI) {
	// if (reversePa(s[indP]) == c) {
	// if (indP == endI - 1) {
	// return isValid_helper(s, startI + 1, endI - 1);
	// } else {
	// return isValid_helper(s, startI + 1, indP) && isValid_helper(s, indP + 1,
	// endI);
	// }
	// }
	// }
	//
	// }
	//
	// return false;
	// }

	/*
	 * 1:22pm 0615 started 1:36pm draft done. 1:40pm after fixing bug 1 and bug 2
	 * 2pass.
	 * 
	 * 2:08pm 0710 revisited
	 * 
	 * 2"0
	 */

	public String longestCommonPrefix(String[] strs) {
		// if (strs == null)
		// return "";
		// if (strs.length < 1)
		// return "";
		// if (strs.length < 2)
		// return strs[0];
		//
		// Set<String> cs = new HashSet<String>();
		// String alphaStr = strs[0];
		// int i = 0;
		//
		// for (i = 0; i < alphaStr.length(); i++) {
		// for (int j = 0; j < strs.length; j++) {
		// // bug 2
		// // for (int j = 1; j < strs.length; j++) {
		// if (i < strs[j].length()) {
		// cs.add(String.valueOf(strs[j].charAt(i)));
		// if (cs.size() > 1) {
		// if (i == 0)
		// return "";
		// return alphaStr.substring(0, i);
		// }
		// } else {
		// if (i == 0)
		// return "";
		// return alphaStr.substring(0, i);
		// }
		// }
		// cs.clear();
		// }
		//
		// // bug 1
		// // return "";
		// return alphaStr;

		// 0710 solution
		if (strs == null)
			return "";
		if (strs.length < 1)
			return "";
		if (strs.length < 2)
			return strs[0];

		if (strs[0].isEmpty())
			return "";

		for (int i = 1; i < strs.length; i++) {
			if (strs[i].isEmpty())
				return "";
			if (!strs[i - 1].substring(0, 1).equals(strs[i].substring(0, 1)))
				return "";
		}

		String commonStr = strs[0].substring(0, 1);
		String[] subStrs = new String[strs.length];

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < 2) {
				return commonStr;
			} else {
				subStrs[i] = strs[i].substring(1);
			}
		}

		return commonStr + longestCommonPrefix(subStrs);

	}

	/*
	 * 2:09pm started 2:16pm draft done 2:17pm time limit exceeded. i think the
	 * algorithm is correct though. after consulting the answer: TODO: Stack Queue
	 * etc. poll. offer?
	 */
	class MedianFinder {
		List<Integer> nums = null;
		int mid = 0;
		double median = 0;

		/** initialize your data structure here. */
		public MedianFinder() {
			nums = new ArrayList<Integer>();
		}

		public void addNum(int num) {
			nums.add(num);
			Collections.sort(nums);
			mid = nums.size() / 2;
			if (nums.size() % 2 == 0) {
				median = (nums.get(mid) + nums.get(mid - 1)) / 2.0;
			} else {
				median = nums.get(mid);
			}
		}

		public double findMedian() {
			return median;
		}
	}

	/*
	 * 2:30pm 0615 started 3:03pm draft done. 3:11pm failed due to incorrect
	 * handling of overflow
	 */
	public int myAtoi(String str) {
		if (str == null)
			return 0;
		if (str.isEmpty())
			return 0;

		int result = 0;
		int num = 0;
		int sign = 0;
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		char curr = 'x';
		char prev = 'x';

		boolean started = false;
		for (int i = 0; i < str.length(); i++) {
			curr = str.charAt(i);
			num = Arrays.binarySearch(digits, curr);
			if (num < 0) {
				if (started)
					break;
				else {
					if (str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) != ' ')
						return 0;
				}
			} else {
				if (!started) {
					started = true;
					if (prev == '-') {
						sign = -1;
					} else {
						sign = 1;
					}
				}
				// bug 1
				// result += 10*result + num;
				result = 10 * result + num;
				// OVERFLOW and underflow
				if (result < 0) {
					if (sign > 0) {
						return Integer.MAX_VALUE;
					} else {
						return Integer.MIN_VALUE;
					}
				}

			}
			prev = curr;
		}
		// fix 1
		if (sign < 0) {
			if (-1 * result > 0) {
				return Integer.MIN_VALUE;
			} else {
				return -1 * result;
			}
		}
		return result;
	}

	/*
	 * 3:21pm 0615 started
	 * 
	 */
	// public int numDecodings(String s) {
	//
	// }

	/*
	 * 6:46pm 0616 started the algorithm is to first search for seeds. then search
	 * from those seeds 6:57pm pause 8:55pm resumed 9:06pm draft done. exeeded time
	 * limit.
	 * 
	 * 
	 * 10:47am 0716 revisited
	 * 
	 * dp
	 * 
	 * 11:39am failed.
	 * 
	 * 
	 * 
	 */
	public String longestPalindrome(String s) {
		if (s == null)
			return s;
		if (s.isEmpty())
			return s;
		if (s.length() < 2)
			return s;

		Pair[] dp = new Pair[s.length()];
		dp[0] = new Pair(0, 0);

		int m, n;
		if (s.charAt(0) == s.charAt(1)) {
			m = 0;
			n = 1;
		} else {
			m = 1;
			n = 1;
		}
		dp[1] = new Pair(m, n);

		for (int i = 2; i < s.length(); i++) {
			m = dp[i - 1].left;
			n = dp[i - 1].right;
			if (m - 1 >= 0) {
				if (i == n + 1 && s.charAt(m - 1) == s.charAt(n + 1)) {
					dp[i] = new Pair(m - 1, n + 1);
				} else if (i == n + 1 && s.charAt(m) == s.charAt(n + 1)) {
					if (isPalindrome(s.substring(m, i + 1))) {
						dp[i] = new Pair(m, i);
					} else {
						dp[i] = dp[i - 1];
					}
				} else if (i != n + 1 && s.charAt(m) == s.charAt(i)) {
					if (isPalindrome(s.substring(m, i + 1))) {
						dp[i] = new Pair(m, i);
					} else {
						dp[i] = dp[i - 1];
					}
				} else {
					dp[i] = dp[i - 1];
				}
			} else {
				if (isPalindrome(s.substring(m, i + 1))) {
					dp[i] = new Pair(m, i);
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		Pair p = dp[s.length() - 1];
		return s.substring(p.left, p.right + 1);

		// if (s == null)
		// return "";
		// if (s.isEmpty())
		// return "";
		// List<Integer> oddSeeds = new ArrayList<Integer>();
		// List<Integer> evenSeeds = new ArrayList<Integer>();
		// int maxL = 0;
		//
		// for (int i = 0; i < s.length(); i++) {
		// if (i - 1 >= 0 && i + 1 < s.length()) {
		// if (s.charAt(i - 1) == s.charAt(i + 1)) {
		// oddSeeds.add(i);
		// }
		// if (s.charAt(i) == s.charAt(i + 1)) {
		// evenSeeds.add(i);
		// }
		// }
		// }
		//
		// int ext = 1;
		// int seed = 0;
		//
		// for (Integer i : oddSeeds) {
		// while (i - ext >= 0 && i + ext < s.length()) {
		// if (s.charAt(i - ext) == s.charAt(i + ext)) {
		// ext++;
		// }
		// }
		// if (2 * ext + 1 > maxL) {
		// maxL = 2 * ext + 1;
		// seed = i;
		// }
		// ext = 1;
		// }
		//
		// ext = 0;
		// for (Integer i : evenSeeds) {
		// while (i - ext >= 0 && i + ext + 1 < s.length()) {
		// if (s.charAt(i - ext) == s.charAt(i + ext + 1)) {
		// ext++;
		// }
		// }
		// if (2 * (ext + 1) > maxL) {
		// maxL = 2 * (ext + 1);
		// seed = i;
		// }
		// ext = 0;
		// }
		//
		// if (maxL % 2 == 0) {
		// ext = (maxL / 2) - 1;
		// return s.substring(seed - ext, seed + ext + 2);
		// } else {
		// ext = (maxL - 1) / 2;
		// return s.substring(seed - ext, seed + ext + 1);
		// }

	}

	/*
	 * 9:19pm 0616 started 9:59pm failed due to lack of familarity of BFS.
	 * 
	 */
	/*
	 * 1:55pm 0716 started
	 * 
	 * 
	 * dfs, tree pruning 2:35pm draft and test done.
	 * 
	 * 2:45pm TLE. it seems the pruning is not quick enough.
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord == null || endWord == null || wordList == null)
			return 0;

		if (wordList.contains(endWord)) {
			Map<String, Integer> dict = new HashMap<String, Integer>();
			ladderLength_helper(beginWord, endWord, wordList, 0, new ArrayList<String>(), new ArrayList<String>(), dict);
			int len = dict.get(beginWord);
			return len == Integer.MAX_VALUE ? 0 : 1 + len;
		}

		return 0;
	}

	public int ladderLength_helper(String beginWord, String endWord, List<String> wordList, int lenSoFar,
			List<String> pathSoFar, List<String> visited, Map<String, Integer> cache) {
		if (cache.containsKey(beginWord))
			return cache.get(beginWord);

		List<String> choices, newPath;
		int currMin = Integer.MAX_VALUE, r;
		String currW = beginWord;
		pathSoFar.add(currW);
		choices = getWordChoices(currW, wordList);

		if (choices.size() < 1) {
			cache.put(beginWord, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		} else {
			lenSoFar++;
			if (choices.contains(endWord)) {
				cache.put(beginWord, 1);
				return 1;
			}
			for (String cs : choices) {
				if (pathSoFar.contains(cs))
					continue;
				newPath = new ArrayList<>(pathSoFar);
				newPath.add(cs);
				r = ladderLength_helper(cs, endWord, wordList, lenSoFar, newPath, visited, cache);
				if (r == Integer.MAX_VALUE)
					continue;
				currMin = Math.min(currMin, 1 + r);
			}

			cache.put(beginWord, currMin);
			return currMin;
		}
	}

	public List<String> getWordChoices(String beginWord, List<String> wordList) {
		int cnt = 0;
		List<String> result = new ArrayList<>();

		for (String w : wordList) {
			if (beginWord.equals(w))
				continue;
			for (int i = 0; i < w.length(); i++) {
				cnt += beginWord.charAt(i) == w.charAt(i) ? 0 : 1;
			}
			if (cnt == 1)
				result.add(w);
			cnt = 0;
		}

		return result;
	}
	// public int ladderLength(String beginWord, String endWord, List<String>
	// wordList) {
	// // if (beginWord == null || endWord == null)
	// // return 0;
	// //
	// // List<String> result = ladderLength_helper(beginWord, endWord, wordList);
	// // if(result.contains(beginWord))
	// int len = ladderLength_helper(beginWord, endWord, wordList,
	// Integer.MAX_VALUE, new ArrayList<String>());
	// return len == Integer.MAX_VALUE ? 0 : 1 + len;
	// }
	//
	// public int ladderLength_helper(String beginWord, String endWord, List<String>
	// wordList, int lenSoFar,
	// List<String> pathSoFar) {
	// if (pathSoFar.size() + 1 < lenSoFar) {
	// List<String> rawCandidates = getWordChoices(beginWord, wordList);
	// rawCandidates = filterVisitedWords(rawCandidates, pathSoFar);
	// int currLen = Integer.MAX_VALUE;
	// if (rawCandidates.contains(endWord)) {
	// pathSoFar.add(endWord);
	// return pathSoFar.size();
	// } else {
	// for (String w : rawCandidates) {
	// List<String> newPath = new ArrayList<>(pathSoFar);
	// newPath.add(w);
	// currLen = ladderLength_helper(w, endWord, wordList, lenSoFar, newPath);
	// lenSoFar = Math.min(lenSoFar, currLen);
	// }
	// return lenSoFar;
	// }
	// }
	// return Integer.MAX_VALUE;
	// }
	//
	// private List<String> filterVisitedWords(List<String> rawCandidates,
	// List<String> pathSoFar) {
	// List<String> result = new ArrayList<>();
	// for (String w : rawCandidates) {
	// if (!pathSoFar.contains(w))
	// result.add(w);
	// }
	// return result;
	// }
	//
	// public List<String> getWordChoices(String beginWord, List<String> wordList) {
	// int cnt = 0;
	// List<String> result = new ArrayList<>();
	//
	// for (String w : wordList) {
	// for (int i = 0; i < w.length(); i++) {
	// cnt += beginWord.charAt(i) == w.charAt(i) ? 0 : 1;
	// }
	// if (cnt == 1)
	// result.add(w);
	// cnt = 0;
	// }
	//
	// return result;
	// }
	//
	// public List<String> ladderLength_helper(String beginWord, String endWord,
	// List<String> wordList) {
	// List<String> result = null;
	// List<String> tmp = null;
	// List<String> cpWL = new ArrayList<String>();
	// cpWL.addAll(wordList);
	//
	// int len = Integer.MAX_VALUE;
	//
	// for (String w : oneDiffWords(endWord, wordList)) {
	//
	// if (oneDiffWord(w, beginWord)) {
	// result = new ArrayList<String>();
	// result.add(w);
	// result.add(beginWord);
	// return result;
	// }
	// cpWL.remove(w);
	// tmp = ladderLength_helper(beginWord, w, cpWL);
	//
	// if (tmp.size() < len) {
	// if (oneDiffWord(beginWord, tmp.get(tmp.size()))) {
	// result = new ArrayList<String>();
	// result.add(w);
	// result.addAll(tmp);
	// return result;
	// }
	// }
	//
	// }
	//
	// return result;
	// }

	public List<String> oneDiffWords(String word, List<String> wordList) {
		List<String> result = new ArrayList<String>();

		int diffCnt = 0;
		for (String w : wordList) {
			diffCnt = 0;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != w.charAt(i))
					diffCnt++;
			}
			if (diffCnt == 1)
				result.add(w);
		}

		return result;
	}

	public boolean oneDiffWord(String m, String n) {

		int diffCnt = 0;

		for (int i = 0; i < m.length(); i++) {
			if (n.charAt(i) != m.charAt(i))
				diffCnt++;
		}
		return diffCnt == 1;
	}

	// public List<List<String>> permutations(char[] chars, int begini, int endi) {
	// List<List<String>> result = new ArrayList<List<String>>();
	// if (begini > endi) {
	// return result;
	// }
	//
	// }

	/*
	 * 5:33pm 0617 started 5:42pm draft done. 5:56pm 4pass after fixing several
	 * bugs. my brain is weird these days. the algorithm is right.
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode currL1Digit = l1;
		ListNode currL2Digit = l2;
		ListNode currRDigit = result;
		ListNode preDigit = null;
		int sum = 0;
		int d1 = 0;
		int d2 = 0;

		while (currL1Digit != null || currL2Digit != null) {
			if (currL1Digit == null) {
				sum = currRDigit.val + currL2Digit.val;
				currL2Digit = currL2Digit.next;
			} else if (currL2Digit == null) {
				sum = currRDigit.val + currL1Digit.val;
				currL1Digit = currL1Digit.next;
			} else {
				sum = currL1Digit.val + currL2Digit.val + currRDigit.val;
				currL1Digit = currL1Digit.next;
				currL2Digit = currL2Digit.next;
			}
			d1 = sum % 10;
			d2 = sum / 10;
			// bug 1
			// currRDigit.val = currRDigit.val + d1;
			currRDigit.val = currRDigit.val + d1;
			currRDigit.next = new ListNode(d2);
			preDigit = currRDigit;
			currRDigit = currRDigit.next;
		}
		if (preDigit.next.val == 0) {
			preDigit.next = null;
		}
		return result;
	}

	/*
	 * 9:52am 0618 started 10:15am draft done. failed because i didnt stick to my
	 * original idea.
	 * 
	 * 1:23pm 0711 restarted
	 * 
	 */

	public int strCompare(String str1, String str2) {

		String s1 = str1 + str2;
		String s2 = str2 + str1;
		return s1.compareTo(s2); // reverse order here, so we can do append() later

	}

	public String largestNumber(int[] nums) {
		// String r = "";
		// List<Integer> result = new ArrayList<Integer>();
		// int level = 1;
		// int ind = -1;
		// while (result.size() < nums.length) {
		// ind = maxDigitNumInd(nums, level++);
		// result.add(nums[ind]);
		// nums[ind] = -1;
		// }
		//
		// for (Integer i : result) {
		// r += i;
		// }
		// return r;

		if (nums == null)
			return "";
		if (nums.length < 2)
			return String.valueOf(nums[0]);

		String[] dp = new String[nums.length];
		dp[0] = String.valueOf(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (strCompare(dp[i - 1], String.valueOf(nums[i])) > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i] + dp[i - 1];
			}

		}

		return dp[nums.length - 1];
	}

	public int getStringNumHighestDigit(String s) {
		return s.charAt(0) - '0';
	}

	public int maxDigitNumInd(int[] nums, int level) {
		int max = -1;
		int maxI = 0;
		int td = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				td = getTopDigit(nums[i], level);
				if (td > max) {
					max = td;
					maxI = i;
				}
			}
		}

		return maxI;
	}

	public int getTopDigit(int num, int level) {
		int n = num;
		int r = level;
		List<Integer> t = new ArrayList<Integer>();
		while (n > 0) {
			t.add(n % 10);
			n = n / 10;
		}
		return t.get(t.size() - level);
	}

	/*
	 * 11:47am 0618 started 12:03pm draft done. 12:22pm the main bone is correct but
	 * some tiny paces were wrong.
	 */
	public boolean exist(char[][] board, String word) {
		List<Pair> seeds = new ArrayList<Pair>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					seeds.add(new Pair(i, j));
				}
			}
		}

		for (Pair seed : seeds) {
			if (exist_word(board, word, seed))
				return true;
		}

		return false;
	}

	public boolean exist_word(char[][] board, String word, Pair seed) {
		int y = seed.left, x = seed.right;

		if (y >= 0 && y < board.length && x >= 0 && x < board[0].length) {
			if (board[y][x] == word.charAt(0)) {

				if (word.length() == 1)
					return true;
				else if (exist_word(board, word.substring(1), new Pair(y - 1, x))) {
					return true;
				} else if (exist_word(board, word.substring(1), new Pair(y, x - 1))) {
					return true;
				} else if (exist_word(board, word.substring(1), new Pair(y + 1, x))) {
					return true;
				} else if (exist_word(board, word.substring(1), new Pair(y, x + 1))) {
					return true;
				}
			} else {
				return false;
			}
		} else
			return false;
		return false;
	}

	/*
	 * 12:26pm 0618 started the algorithm is to first unify the case, remove
	 * non-alphanumerical chars. spaces etc. then find the center of the string,
	 * then do symmetrical comparison 12:38pm draft done. 12:42pm accepted after
	 * fixing bug 1. bug 1 was introduced while changing the logic of i.
	 */
	public boolean isPalindrome(String s) {
		StringBuilder goodS = new StringBuilder();

		for (char c : s.toLowerCase().toCharArray()) {
			if ((c - '0' <= 9 && c - '0' >= 0) || (c - 'a' <= 26 && c - 'a' >= 0)) {
				goodS.append(c);
			}
		}

		String ss = goodS.toString();
		int mid = ss.length() / 2;
		int i = 0, j = 0;
		if (ss.length() % 2 > 0) {
			while (i <= mid) {
				// bug 1
				// if (ss.charAt(mid - i--) != ss.charAt(mid + j++))
				if (ss.charAt(mid - i++) != ss.charAt(mid + j++))
					return false;
			}
		} else {
			while (i < mid) {
				// bug 1
				// if (ss.charAt(mid -1 - i--) != ss.charAt(mid + j++))
				if (ss.charAt(mid - 1 - i++) != ss.charAt(mid + j++))
					return false;
			}
		}
		return true;
	}

	/*
	 * 9:36am 0720 started 9:43am draft done. 9:47am 1pass.
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;

		List<Integer> digits = new ArrayList<>();
		while (x != 0) {
			digits.add(x % 10);
			x /= 10;
		}

		int mid = (digits.size() - 1) / 2;
		for (int i = 0; i <= mid; i++) {
			if (digits.get(i) != digits.get(digits.size() - i - 1))
				return false;
		}

		return true;
	}

	/*
	 * 12:47pm 0618 started the algorithm is to get individual digits of the number.
	 * then control the overflow or underflow 12:58pm draft done.
	 */

	public int reverse(int x) {
		if (x == Integer.MIN_VALUE)
			return 0;

		int num = 0;
		int result = 0;

		if (x < 0)
			num = -x;
		else
			num = x;

		List<String> digits = new ArrayList<String>();

		while (num > 0) {
			digits.add(String.valueOf(num % 10));
			num /= 10;
		}

		for (String d : digits) {
			num = result * 10 + Integer.valueOf(d);
			// this is how to control overflow.
			if ((num - Integer.valueOf(d)) / 10 != result) {
				return 0;
			} else
				result = num;
		}

		if (x < 0) {
			return -result;
		}

		return result;
	}

	/*
	 * 1:14pm 0618 the algorithm is to fix one number and use TwoSum for the rest.
	 * the difficulty is to remove duplciates efficiently. consult the offical
	 * solution for how to do it.
	 * 
	 * 
	 * 9:57am 0716 revisit
	 * 
	 * solution 1: use hashtable, for three sum. 10:22am could not find an elegant
	 * way to avoid duplicates.
	 * 
	 */

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums == null)
			return result;

		if (nums.length < 3)
			return result;

		Map<Integer, Pair> m = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++) {
				Pair p = new Pair(i, j);
				m.put(nums[i] + nums[j], p);
			}

		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(-1 * nums[i])) {
				List<Integer> r = new ArrayList<>();
				Pair p = m.get(-1 * nums[i]);
				r.add(nums[p.left]);
				r.add(nums[p.right]);
				r.add(nums[i]);
				result.add(r);
			}
		}

		return result;

	}

	/*
	 * 1:18pm 0618 dp problem
	 * 
	 * 
	 * 
	 * 10:21am 0710 restarted
	 * 
	 * build a 2d matrix to record the sum and use brutal force, starting from
	 * arr.len = 1
	 * 
	 * 10:42am draft done 10:44am 200/202 cases passed. memory limit exceeded at 201
	 * #TODO the issue is, you have to figure out how not to repeat calculations.
	 * #TODO there are usually more than one ways to connect sub problems.
	 * 
	 */

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;

		if (nums == null)
			return max;

		int[][] sum = new int[nums.length][nums.length];
		initiate2DArray(sum, Integer.MIN_VALUE);

		for (int i = 0; i < nums.length; i++) {
			// bug 1
			// for(int j = 0; j < nums.length; j++) {
			for (int j = i; j < nums.length; j++) {
				if (sum[i][j] == Integer.MIN_VALUE) {
					sum[i][j] = arraySum(nums, i, j);
				}
				max = max < sum[i][j] ? sum[i][j] : max;
			}
		}

		return max;
	}

	public void initiate1DArray(int[] nums, int val) {
		for (int i = 0; i < nums.length; i++)
			nums[i] = val;
	}

	public void initiate2DArray(int[][] nums, int val) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				nums[i][j] = val;
			}
		}
	}

	public int arraySum(int[] nums, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end && i < nums.length; i++)
			sum += nums[i];

		return sum;
	}

	/*
	 * 1:19pm 0618 bit problem this problem has a very good solution that summarize
	 * all major bit tricks.
	 */
	// public int getSum(int a, int b) {
	//
	// }

	/*
	 * 9:02am 0619 started 9:30am failed. backtracking issue. the official answer
	 * summarizes these types of questions.
	 * 
	 * 09:19am 0705 copied the official answer.
	 * 
	 * 2:17pm 0724 revisit this after reading the cci book the idea is to put
	 * num[i+1] into every location of the previous generated set. * 2:24pm draft
	 * done. 2:28pm pass after fixing.
	 */

	public List<List<Integer>> permute(int[] num) {
		// List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// if (num.length == 0)
		// return ans;
		// List<Integer> l0 = new ArrayList<Integer>();
		// l0.add(num[0]);
		// ans.add(l0);
		// for (int i = 1; i < num.length; ++i) {
		// List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
		// for (int j = 0; j <= i; ++j) {
		// for (List<Integer> l : ans) {
		// List<Integer> new_l = new ArrayList<Integer>(l);
		// new_l.add(j, num[i]);
		// new_ans.add(new_l);
		// }
		// }
		// ans = new_ans;
		// }
		// return ans;

		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<List<Integer>> newAns = new ArrayList<List<Integer>>();
		if (num == null || num.length < 1)
			return ans;

		List<Integer> l0 = new ArrayList<Integer>();

		l0.add(num[0]);
		ans.add(l0);

		for (int i = 1; i < num.length; i++) {
			for (List<Integer> l : ans) {
				for (int j = 0; j <= l.size(); j++) {
					l0 = new ArrayList<Integer>(l);
					l0.add(j, num[i]);
					newAns.add(l0);
				}
			}
			ans.clear();
			ans.addAll(newAns);
			newAns.clear();
		}

		return ans;

	}

	// public List<List<Integer>> permute(int[] nums) {
	// return permute_helper(nums, 0, nums.length);
	// }

	public List<List<Integer>> permute_helper(int[] nums, int startInd, int endInd) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		if (nums == null)
			return result;
		if (nums.length == 0)
			return result;

		r.add(nums[0]);

		if (nums.length == 1) {
			result.add(r);
			return result;
		} else {
			int n = nums[startInd];
			for (int i = startInd + 1; i < endInd; i++) {
				for (List<Integer> l : permute_helper(nums, startInd, i)) {
					for (List<Integer> m : permute_helper(nums, i, endInd)) {
						r.addAll(l);
						r.add(n);
						r.addAll(m);
					}
					result.add(r);
					r = new ArrayList<Integer>();
				}

			}
		}

		return result;

	}

	/*
	 * 09:42am 0619 after consulting the official answers
	 */
	public int missingNumber(int[] nums) {
		// int sum = (0 + nums.length)*(nums.length + 1) /2;
		//
		// for(int n : nums) {
		// sum -= n;
		// }
		//
		// return sum;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ i ^ nums[i];
		}
		return result;
	}

	/*
	 * 10:16am 0619 a random question from glassdoor Given an array, write a
	 * function to in-place move all the 0s to the front of the array. this question
	 * is similar to a leetcode move zeros, but in opposite directions. 10:27am i
	 * think it is 1pass
	 */

	public void moveZeros(int[] nums) {
		// solution 1
		if (nums != null) {
			if (nums.length > 1) {
				int insInd = nums.length - 1;
				int temp = 0;
				for (int i = 0; i < insInd; i++) {
					if (nums[i] != 0) {
						while (i < insInd) {
							if (nums[insInd] != 0)
								insInd--;
							else
								break;
						}
						temp = nums[i];
						nums[i] = 0;
						nums[insInd--] = temp;
					}
				}
			}
		}

		// solution 2 similar to the leetcode official solution
		if (nums != null) {
			if (nums.length > 1) {
				int si = nums.length - 1;
				for (int i = nums.length - 1; i >= 0; i--) {
					if (nums[i] != 0) {
						nums[si--] = nums[i];
					}
				}

				while (si >= 0)
					nums[si--] = 0;
			}
		}
	}

	/*
	 * 10:36am 0619 a random question from glassdoor interviews Write a boolean
	 * function on whiteboard to check if the individual digits in a number are in
	 * sorted order or not. the algorithm is to first get all the digits of the num.
	 * then check the top and least digits to determine its sort order. then sort
	 * the digits according to the order. then reassemble the digits into a number
	 * and see if it equals the original num.
	 */
	// public boolean isSortedDigits(int num) {
	//
	// }

	/*
	 * 02:07pm 0620 started the looping way, keep mod 3 until it is zero 2:11pm
	 * draft done. algorithm failed. you are not clear with the numbers...
	 */

	public boolean isPowerOfThree(int n) {
		while (n > 3) {
			n /= 3;
		}

		return n == 3;
	}

	/*
	 * 2:22pm 0620 started the algorithm is for every non boundary element, it
	 * equals to the previous row 's left and right neighbor. 2:35pm draft done.
	 * 2:43pm passed after fixing 2 bugs. brain tired.
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();

		int n = numRows;
		if (n < 1)
			return result;

		r.add(1);
		result.add(r);
		if (n == 1) {
			return result;
		} else {
			r = new ArrayList<Integer>();
			r.add(1);
			r.add(1);
			result.add(r);
			if (n == 2) {
				return result;

			} else {
				// bug 2
				// for (int i = 3; i <= n; i++) {
				for (int i = 2; i < n; i++) {
					List<Integer> pr = result.get(i - 1);
					r.add(1);
					// bug 1
					// for (int j = 1; j < i - 1; j++) {
					for (int j = 1; j < i; j++) {
						r.add(pr.get(j - 1) + pr.get(j));
					}
					r.add(1);
					result.add(r);
					r = new ArrayList<Integer>();
				}
				return result;
			}
		}

	}

	/*
	 * 2:44pm 0620 started the algorithm is to keep moding and dividing. 2:47pm
	 * draft done turns out that for java, this algorithm wont work on anything
	 * larger than max_value.
	 * 
	 * 4:29pm 0725 revisit the key is the >>> for unsigned shift. and >> for signed
	 * shift.
	 * 
	 */
	// TODO: Bit manipulation
	public int hammingWeight(int n) {
		int cnt = 0;
		// TODO DO not use n > 0, use n != 0
		while (n != 0) {
			cnt += n & 1;
			n >>>= 1;
		}

		return cnt;
	}

	/*
	 * 10:19pm 0621 started the algorithm is to check for 1-k, if nums[i] ==
	 * nums[i+k] 10:23pm pause 10:35pm resumed 10:37pm draft done 10:38pm 1pass
	 * after consulting the official answer, many used hashmap. remember, if the
	 * question does not limit storage, always use a spare storage to reduce time
	 * complexity.
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		while (k > 0) {
			for (int i = 0; i < nums.length - k; i++) {
				if (nums[i] == nums[i + k]) {
					return true;
				}
			}
			k--;
		}

		return false;
	}

	/*
	 * 9:09pm 0622 started the algorithm is to have two pointers, one to the tail,
	 * another to tail - k, if len > k; if len = k, return the same. if len < k, it
	 * is equal to move k % len. 9:15pm pause 11:45pm resume 11:58pm draft done i
	 * think the algorithm is correct, but somehow the implementation is faulty when
	 * list = [1, 2] and k = 1
	 */
	public ListNode rotateRight(ListNode head, int k) {
		ListNode hPtr = head, tPtr = head;
		ListNode result = null;

		int len = 0;

		// bug 1
		// if(head == null) return head;
		if (head == null || k == 0)
			return head;

		while (tPtr.next != null) {
			tPtr = tPtr.next;
			len++;
		}
		len++;
		// bug 2
		if (len < 2 || k == len)
			return head;
		// if(len == 0 || k == len) return head;

		if (len < k)
			k %= len;

		while (k-- > 0) {
			hPtr = hPtr.next;
		}

		result = hPtr.next;
		hPtr.next = null;
		tPtr.next = head;

		return result;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * 11:08am 0623 started 11:30am failed. the algorithm was not clear. i were in a
	 * rush to prepare food for the babies and was in a losing steak for some
	 * reason.
	 * 
	 */
	public int removeDuplicates2(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length < 2)
			return nums.length;

		int si = 0;
		int dupCnt = 0;
		int currVal = 0;
		currVal = nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				dupCnt++;
			} else {
				if (dupCnt > 2) {
					nums[si++] = currVal;
					nums[si++] = currVal;
					currVal = nums[i + 1];
				} else {
					nums[si++] = currVal;
				}
				dupCnt = 0;
			}
		}

		return si;
	}

	/*
	 * 08:03am 0624 9:19am failed. the algorithm is correct, but finding the head
	 * turns out to be disastrous. the trick is to search from the tail, so that you
	 * gurantee you find the closest whitespace.
	 * 
	 * 12:51pm 0721 revisited
	 *
	 * 12:55pm draft done. 13:00pm pass after fixing bug 1
	 */
	public int lengthOfLastWord(String s) {
		if (s == null)
			return 0;
		if (s.isEmpty())
			return 0;

		int firstWordEnd = -1, firstEmptySpaceFromRight = -1;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				firstWordEnd = i;
				break;
			}
		}

		for (int i = firstWordEnd; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				firstEmptySpaceFromRight = i;
				break;
			}
		}

		// Added for bug 1 #TODO always check why the loop stopped.
		if (firstEmptySpaceFromRight == -1) {
			return firstWordEnd + 1;
		}

		return firstWordEnd - firstEmptySpaceFromRight;

	}

	/*
	 * 10:48am 0625 started 10:59am draft done 11:04am after major fix, passed.
	 */
	public int minDepth(TreeNode root) {
		if (root != null) {
			if (root.left == null) {
				return 1 + minDepth(root.right);
			} else if (root.right == null) {
				return 1 + minDepth(root.left);
			} else {
				return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
			}
		} else {
			return 0;
		}
	}

	public int maxDepth2(TreeNode root) {
		if (root != null) {
			if (root.left == null) {
				return 1 + maxDepth2(root.right);
			} else if (root.right == null) {
				return 1 + maxDepth2(root.left);
			} else {
				return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
			}
		} else {
			return 0;
		}
	}
	/*
	 * 11:08am 0625 started the algorithm is to use the maxDepth function to compare
	 * each node's two subtrees's maxDepth, if it differs more than 1, return false;
	 * 11:16am draft done. 11:16am 1pass accepted.
	 * 
	 */

	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			if (Math.abs(maxDepth2(root.left) - maxDepth2(root.right)) > 1) {
				return false;
			} else {
				return isBalanced(root.left) && isBalanced(root.right);
			}
		} else {
			return true;
		}
	}

	/*
	 * 11:34am 0625 started the algorithm is to perform dft and record the sum. once
	 * it equals return true. 11:43am draft done. 11:52am passed after fixing bug 1
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		return runSum(root, sum, 0);
	}

	public boolean runSum(TreeNode root, int sum, int cSum) {
		if (root != null) {
			cSum += root.val;
			if (root.left == null && root.right == null && cSum == sum)
				return true;
			// bug 1 you cant rule out that the current node's subtree 's sum is zero!
			// do not preform pre-mature optimization.
			// else if(cSum == sum) {
			// return false;
			// }
			else {
				return runSum(root.left, sum, cSum) || runSum(root.right, sum, cSum);
			}
		}
		return sum == cSum;
	}

	/*
	 * 12:53pm 0625 started the algorithm is to add an additional storage to store
	 * all visited nodes, when the sum is correct, return the list. 1:03pm draft
	 * done. 1:03pm 1pass
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		return runSumWithNodes(root, sum, 0, new ArrayList<Integer>());
	}

	public List<List<Integer>> runSumWithNodes(TreeNode root, int sum, int cSum, List<Integer> currList) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root != null) {
			cSum += root.val;
			List<Integer> r = new ArrayList<Integer>(currList);
			r.add(root.val);
			if (root.left == null && root.right == null && cSum == sum) {
				result.add(r);
				return result;
			} else {
				result.addAll(runSumWithNodes(root.left, sum, cSum, r));
				result.addAll(runSumWithNodes(root.right, sum, cSum, r));
			}
		}
		return result;
	}

	/*
	 * 1:14pm 0625 started. if the csum + root node == sum, result+1, otherwise,
	 * result + lefttree + right tree i think the problem is not quite clear.
	 */
	public int pathSum3(TreeNode root, int sum) {
		return pathSumGD(root, sum, 0, 0);
	}

	public int pathSumGD(TreeNode root, int sum, int cSum, int cPath) {
		if (root != null) {
			cSum += root.val;
			if (cSum == sum) {
				return pathSumGD(root.left, sum, 0, cPath + 1) + pathSumGD(root.right, sum, 0, cPath + 1);
			} else {
				return pathSumGD(root.left, sum, cSum, cPath) + pathSumGD(root.right, sum, cSum, cPath);
			}
		}
		return 0;
	}

	/*
	 * 1:38pm 0625 started the algorithm is to travel to the parents of leaves, then
	 * attach its right leaf to the left leaf. finally, mirror the tree. 2:01pm
	 * failed.
	 */
	public void flatten(TreeNode root) {
		if (root != null) {
			flatternToLeft(root.left);
			flatternToRight(root.right);

		}
	}

	public TreeNode flatternToLeft(TreeNode root) {
		if (root != null) {
			if (isLeaf(root.left) && isLeaf(root.right)) {
				root.left.left = root.right;
			} else if (root.left == null && isLeaf(root.right)) {
				root.left = root.right;
			} else if (root.right != null) {
				root.left = flatternToLeft(root.left);
			}
		}
		return null;
	}

	public void flatternToRight(TreeNode root) {
		if (root != null) {
			if (isLeaf(root.left) && isLeaf(root.right)) {
				root.right.right = root.left;
			} else if (root.right == null && isLeaf(root.left)) {
				root.right = root.left;
			} else {
				flatternToRight(root.right);
			}
		}
	}

	public boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

	/*
	 * 2:22pm 0625 started their are 6 different ways to traverse a binary tree. we
	 * get the max of them. to save time, if the root.val is non positive, we would
	 * not include it. 2:40pm draft done. 3:00pm failed. i think yo uhave to
	 * understand that , although it says you dont have to go through a root. to
	 * visit any part of the tree, you still have to first go throught the "root" of
	 * that subtree!!!!
	 */
	public int maxPathSum(TreeNode root) {

		return maxPathSum_helper(root, 0);

	}

	public int maxPathSum_helper(TreeNode root, int currSum) {
		if (root != null) {
			int t1, t2;
			List<Integer> t = new ArrayList<Integer>();
			t.add(root.val);
			t1 = maxPathSum_helper(root.left, currSum + root.val);
			t2 = maxPathSum_helper(root.right, currSum + root.val);
			t.add(t1);
			t.add(t2);
			t.add(t1 + t2 - root.val);
			return Collections.max(t);
		}
		return 0;
	}

	/*
	 * 03:24pm 0625 03:33pm draft done. 3:39pm after fixing bug 1 pass. notice that
	 * you have been having this issue at least twice!!
	 * 
	 * dont plus dont plus!.
	 */
	public int sumNumbers(TreeNode root) {
		List<List<Integer>> result = sumNumbersHelper(root, new ArrayList<Integer>());
		int sum = 0, cSum = 0;
		for (List<Integer> r : result) {
			for (Integer i : r) {
				// bug 1
				// cSum += cSum*10 + i;
				cSum = cSum * 10 + i;
			}
			sum += cSum;
			cSum = 0;
		}

		return sum;
	}

	public List<List<Integer>> sumNumbersHelper(TreeNode root, List<Integer> currNode) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>(currNode);

		if (root != null) {
			r.add(root.val);
			if (root.left == null && root.right == null) {
				result.add(r);
			} else {
				result.addAll(sumNumbersHelper(root.left, r));
				result.addAll(sumNumbersHelper(root.right, r));
			}
			return result;
		}

		return result;
	}

	/*
	 * 3:43pm 0625 started the algorithm is to do bft of the tree and output the
	 * rightmost node, from the top. the difficulty is that you need to know when
	 * each level ends. 4:18pm restarted the levelPrint method. 4:26pm draft done.
	 * 1pass however, this algorithm does not utilize the benefits f binary tree.
	 * the official algorithm basically does this by adding the right most first
	 * node. so the core to this problem is the algorithm to print the boundaries
	 * nodes of a binary tree.
	 */

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> r = new ArrayList<Integer>();

		for (List<Integer> l : bft_levelPrint(root)) {
			r.add(l.get(l.size() - 1));
		}

		return r;
	}

	public List<List<Integer>> bft_levelPrint(TreeNode root) {
		int h = treeHeight(root);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 1; i <= h; i++) {
			result.add(printLevel(root, i));
		}
		return result;
	}

	public List<Integer> printLevel(TreeNode root, int level) {
		List<Integer> r = new ArrayList<Integer>();
		if (root != null) {
			if (level == 1) {
				r.add(root.val);
			} else if (level > 1) {
				r.addAll(printLevel(root.left, level - 1));
				r.addAll(printLevel(root.right, level - 1));
			}
		}
		return r;
	}

	public int treeHeight(TreeNode root) {
		if (root != null) {
			return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
		}
		return 0;
	}

	/*
	 * 4:37pm 0625 started basically a depth first traversal with leaf check. 4:48pm
	 * draft done. 4:52 pass after fixing bug 1.
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		return binaryTreePaths(root, new String(""));
	}

	public List<String> binaryTreePaths(TreeNode root, String curr) {
		List<String> r = new ArrayList<String>();

		// if (root != null) {
		// if (root.left == null && root.right == null) {
		// if (curr.isEmpty()) {
		// r.add(String.valueOf(root.val));
		// } else {
		// r.add(curr + "->" + root.val);
		// }
		// return r;
		// } else {
		// String l = null;
		// if (curr.isEmpty()) {
		// //bug1
		//// l = root.val+"->";
		// l = ""+root.val;
		// } else {
		// l = curr + "->" + root.val;
		// }
		// r.addAll(binaryTreePaths(root.left, l));
		// r.addAll(binaryTreePaths(root.right, l));
		// }
		// }

		if (root != null) {
			if (root.left == null && root.right == null) {

				r.add(curr + root.val);

				return r;
			} else {
				String l = curr + "->" + root.val + "->";
				r.addAll(binaryTreePaths(root.left, l));
				r.addAll(binaryTreePaths(root.right, l));
			}
		}
		return r;
	}

	/*
	 * 03:24pm 0628 started the algorithm is to count captials, capitals == lengh or
	 * capitals =0 or capitals =1 and first. 3:31pm draft done. 3:33pm 1pass
	 */

	public boolean detectCapitalUse(String word) {
		if (word == null)
			return false;

		int capCnt = 0;
		for (char c : word.toCharArray()) {
			if (isCapital(c)) {
				capCnt++;
			}
		}

		if (capCnt == 0) {
			return true;
		} else if (capCnt == 1 && isCapital(word.toCharArray()[0])) {
			return true;
		} else if (capCnt == word.length()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCapital(char c) {
		return c - 'A' >= 0 && c - 'A' <= 25;
	}

	/*
	 * 08:33am 0630 started many different algorithms available. 1. sort and get the
	 * diff 2. use hashmap and update the cnt.
	 * 
	 * 8:44am draft done. 8:44am 1pass
	 * 
	 */
	public char findTheDifference(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		int i = 0;
		for (; i < ss.length; i++) {
			if (ss[i] != tt[i]) {
				return tt[i];
			}
		}

		return tt[i];
	}

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	/*
	 * 8:00pm 0630 started the algorithm is similar to a graph traversal, follow the
	 * links, mark the visited. Each time, you will start with two nodes in the
	 * vertix sets, for each vertix, you visit its two pointers. the travel ends
	 * when all vertix has been visited once and when no vertix exist in the vertix
	 * set. Also you have to implement a equal() function to mark visited nodes.
	 * 
	 * 8:18pm paused 9:20pm resumed 9:28pm draft done
	 * 
	 * failed. i am still not solid on the #TODO graph traversal algorithm mentioned
	 * in that MIT youtube video: breadth first traversal by ed. I still think that
	 * algorithm will work.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;

		List<RandomListNode> visited = new ArrayList<RandomListNode>();
		Queue<RandomListNode> vertix = new LinkedList<RandomListNode>();

		RandomListNode result = new RandomListNode(head.label);
		RandomListNode currP = result;

		vertix.add(head);
		while (!vertix.isEmpty()) {
			RandomListNode currNode = vertix.poll();
			if (!visited.contains(currNode)) {
				if (currNode.next != null) {
					vertix.add(currNode.next);
					currP.next = new RandomListNode(currNode.next.label);
				} else {
					currP.next = null;
				}
				if (currNode.random != null) {
					vertix.add(currNode.random);
					currP.random = new RandomListNode(currNode.random.label);
				} else {
					currP.random = null;
				}

				currP = currP.next;
			}
			visited.add(currNode);
		}

		return result;
	}

	public RandomListNode deepCopyRLN(RandomListNode node) {
		if (node == null)
			return null;
		RandomListNode r = new RandomListNode(node.label);
		if (node.next != null) {
			r.next = deepCopyRLN(node.next);
		} else {
			r.next = null;
		}

		if (node.random != null) {
			r.next = deepCopyRLN(node.random);
		} else {
			r.random = null;
		}

		return r;
	}

	/*
	 * 12:17pm 0701 the algorithm is to keep a counter of each bills. if $5, no
	 * change, if $10, give $5; if $20, give 1 10 and 1 5. anytime if any counter
	 * falls negative, return false. 12:22pm draft done. 12:30pm pause fixing bug 1
	 * 2:25pm resumed 2:25pm 2pass
	 */
	public boolean lemonadeChange(int[] bills) {
		if (bills == null)
			return true;

		int[] changeCnt = { 0, 0 };

		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				changeCnt[0]++;
			} else if (bills[i] == 10) {
				changeCnt[1]++;
				if (changeCnt[0]-- == 0)
					return false;
			} else if (bills[i] == 20) {
				// bug 1
				// if(--changeCnt[0] < 0 || --changeCnt[1] < 0) return false;
				if (changeCnt[1] > 0) {
					changeCnt[1]--;
					if (changeCnt[0] > 0) {
						changeCnt[0]--;
					} else {
						return false;
					}
				} else {
					if (changeCnt[0] > 2) {
						changeCnt[0] -= 3;
					} else {
						return false;
					}
				}
			}
		}

		return true;

	}

	/*
	 * 3:11pm 0701 started the algorithm is to match b to a, then match the rest.
	 * 3:59pm draft done 4:00pm pass after fixing bug 1.
	 * 
	 * again. it doesnt hurt to rule out some corner cases first.
	 */
//	public boolean rotateString(String A, String B) {
//		if (A == null || B == null)
//			return false;
//		// bug 1
//		if (A.isEmpty() && B.isEmpty())
//			return true;
//		if (A.length() != B.length())
//			return false;
//
//		Deque<Integer> seeds = new ArrayDeque<Integer>();
//
//		for (int i = 0; i < B.length(); i++) {
//			if (A.charAt(i) == B.charAt(0))
//				seeds.add(i);
//		}
//
//		while (!seeds.isEmpty()) {
//			int seed = seeds.pollLast();
//			int j = 0;
//			int i = 0;
//			for (i = seed; i < A.length(); i++) {
//				if (A.charAt(i) == B.charAt(j))
//					j++;
//				else
//					break;
//			}
//			if (i == A.length()) {
//				for (i = 0; i < seed; i++) {
//					if (A.charAt(i) == B.charAt(j))
//						j++;
//					else
//						break;
//				}
//				if (i == seed)
//					return true;
//			}
//		}
//
//		return false;
//
//	}
  public boolean rotateString(String A, String B) {
    if(A == null || B == null) return false;
          if(A.isEmpty() && B.isEmpty()) return true;
    if(A.length() != B.length()) return false;
    
    String a = new String(A);
    StringBuilder ss = new StringBuilder();
       int len = A.length();
   for(int i = 0; i < len; i++){
       ss.append(a.substring(i));
       ss.append(a.substring(0, i));
       if(ss.toString().equals(B)) return true;
       ss.setLength(0);
   }
    return false;
  }
	/*
	 * 04:02pm 0701 started the algorithm is to find the diff = k - root; 04:05pm
	 * draft done. 04:08pm failed.
	 */
	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		int diff = k - root.val;
		TreeNode p = root;
		while (p != null) {
			if (p.val == diff && p != root)
				return true;
			else {
				if (diff > p.val)
					p = p.right;
				else
					p = p.left;
			}
		}

		return false;

	}

	/*
	 * 04:11pm 0701 started the algorithm is to traverse the tree in pre-order, add
	 * and close the parenthess whenever traversing deeper, check if the subtree if
	 * empty. 04:29pm draft done
	 */
	public String tree2str(TreeNode t) {
		String result = "";

		if (t != null) {
			result += t.val;
			String lt = tree2str(t.left);
			String rt = tree2str(t.right);
			if (lt.isEmpty() && !rt.isEmpty()) {
				result += "()" + "(" + rt + ")";
			} else {
				lt = lt.isEmpty() ? "" : "(" + lt + ")";
				rt = rt.isEmpty() ? "" : "(" + rt + ")";
				result += lt + rt;
			}
		}
		return result;
	}

	/*
	 * 4:56pm 0701 started the algorithm is to first write the reverse(), then find
	 * boundaries of the string, reverse each string and return the new string.
	 * 5:22pm draft done. 5:42pm draft failed. i tried to solve a general string
	 * reverse() where the number of spaces are not 1. 5:56pm revised algorithm
	 * worked.
	 * 
	 * The lesson learned is, #TODO prefer for over while. #TODO if it allows
	 * library functions use them!
	 */
	public String reverseWords(String s) {
		if (s == null)
			return s;
		if (s.isEmpty())
			return s;

		char[] result = new char[s.length()];
		int storageInd = 0;
		int currWordStart = 0;
		int currWordEnd = 0;

		// while (storageInd < result.length) {
		// while (s.charAt(currWordEnd) == ' ' && currWordEnd < s.length()) {
		// currWordEnd++;
		// }
		//
		// currWordStart = currWordEnd;
		// while (currWordEnd >= 0) {
		// result[storageInd] = ' ';
		// storageInd++;
		// currWordEnd--;
		// }
		// currWordEnd = currWordStart;
		//
		// while (s.charAt(currWordEnd) != ' ' && currWordEnd < s.length()) {
		// currWordEnd++;
		// }
		// currWordEnd--;
		// while (currWordEnd >= currWordStart) {
		// result[storageInd] = s.charAt(currWordEnd);
		// storageInd++;
		// currWordEnd--;
		// }
		// currWordEnd = storageInd;
		// }
		boolean strStarted = false;
		int i = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && strStarted == false) {
				result[storageInd++] = ' ';
			} else if (s.charAt(i) == ' ' && strStarted == true) {
				currWordEnd = i - 1;
				while (currWordStart <= currWordEnd) {
					result[storageInd++] = s.charAt(currWordEnd--);
				}
				strStarted = false;
				result[storageInd++] = ' ';
			} else {
				if (strStarted == false) {
					strStarted = true;
					currWordStart = i;
				}
			}
		}

		if (strStarted == true) {
			while (--i >= currWordStart)
				result[storageInd++] = s.charAt(i);
		}

		return String.valueOf(result);
	}

	public String reverseStr(String s) {
		if (s == null)
			return s;
		if (s.isEmpty())
			return s;

		char[] cs = s.toCharArray();
		String result = "";
		for (int i = cs.length - 1; i >= 0; i--) {
			result += cs[i];
		}

		return result;
	}

	/*
	 * 02:08PM 0703 started failed for some unknown reasons. could be a really
	 * simple one.
	 * 
	 */

	// public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	//
	// }

	/*
	 * 02:13pm 0703 started the algorithm is to map the 4 actions to 2 value pairs,
	 * if the action result is 0, then not moved.
	 * 
	 * 2:21pm draft done. 2:23pm 1pass
	 */

	public boolean judgeCircle(String moves) {

		if (moves == null)
			return false;
		if (moves.isEmpty())
			return true;

		List<Pair> coords = new ArrayList<Pair>();
		// steps = {R, U, L, D}
		Pair[] steps = { new Pair(1, 0), new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1) };
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'D':
				coords.add(steps[3]);
				break;
			case 'L':
				coords.add(steps[2]);
				break;
			case 'U':
				coords.add(steps[1]);
				break;
			case 'R':
				coords.add(steps[0]);
				break;
			}
		}
		int x = 0, y = 0;
		for (Pair s : coords) {
			x += s.left;
			y += s.right;
		}

		return x == 0 && y == 0;
	}

	/*
	 * 02:28pm 0703 started the algorithm is to sort the nums, then form the pairs
	 * back to back so that the numbers were offset to the minimal. which means you
	 * only need to sum the odd nums.
	 * 
	 * 02:39pm draft done.
	 */

	public int arrayPairSum(int[] nums) {
		if (nums == null)
			return 0;

		int sum = 0;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}

		return sum;
	}

	/*
	 * 02:44pm 0703 started tokenize all the domains, use a hashmap to make the
	 * dictionary and update the counts accordingly. 02:54pm draft done. 02:58pm
	 * fixing after rereading the question. 03:06pm 3pass after fixing several bugs
	 * #TODO notice how java escape literals like the dot.
	 * 
	 * 11:52am 0704 redo trying an recursive solution 12:13pm 2pass. #TODO I think
	 * dynamic programming , recursion and graph traversal are related. The key idea
	 * is : remember where you have been #TODO To avoid fixing corner cases, you
	 * need to define what correct cases look like and GO for them.
	 * 
	 */

	public List<String> subdomainVisits(String[] cpdomains) {
		// List<String> result = new ArrayList<String>();
		// if (cpdomains == null)
		// return result;
		//
		// Map<String, Integer> mmap = new HashMap<String, Integer>();
		// String d1, d2, d3;
		//
		// for (String s : cpdomains) {
		// String[] t1toks = s.split(" ");
		// Integer cnt = Integer.valueOf(t1toks[0]);
		// String[] toks = t1toks[1].split("\\.");
		//
		// d1 = t1toks[1];
		// if (toks.length == 2) {
		// d2 = toks[1];
		// putInMap(mmap, d2, cnt);
		// } else {
		// d2 = toks[1] + "." + toks[2];
		// d3 = toks[2];
		//
		// putInMap(mmap, d2, cnt);
		// putInMap(mmap, d3, cnt);
		// }
		// putInMap(mmap, d1, cnt);
		// }
		// for (String d : mmap.keySet()) {
		// result.add(mmap.get(d) + " " + d);
		// }
		// return result;
		List<String> result = new ArrayList<String>();
		if (cpdomains == null)
			return result;
		Map<String, Integer> mmap = new HashMap<String, Integer>();
		for (String s : cpdomains) {
			putInToMap(mmap, s);
		}
		for (String d : mmap.keySet()) {
			result.add(mmap.get(d) + " " + d);
		}
		return result;
	}

	public void putInToMap(Map<String, Integer> mmap, String domain) {
		if (!domain.isEmpty()) {
			String[] toks = domain.split(" ");
			Integer cnt = mmap.get(toks[1]);
			if (cnt == null) {
				cnt = 0;
			}
			mmap.put(toks[1], cnt + Integer.valueOf(toks[0]));

			int i = 0;
			while (i < toks[1].length() && toks[1].charAt(i++) != '.')
				;
			if (i != toks[1].length()) {
				putInToMap(mmap, toks[0] + " " + toks[1].substring(i));
			}
		}
	}

	public void putInMap(Map<String, Integer> mmap, String d1, Integer cnt) {
		Integer c = mmap.get(d1);
		if (c == null) {
			c = 0;
		}
		mmap.put(d1, cnt + c);
	}

	/*
	 * 03:10pm 0703 started the algorithm is to compare the root value with L, R, if
	 * not in the range trim it and use its left or right part as the new root.
	 * depth first traversal.
	 * 
	 * 03:26pm draft done. 03:29pm 2pass after fixing bug 1. #TODO bug1 is related
	 * to your body status, you need a break now.
	 */

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root != null) {
			if (root.val > R) {
				root.right = null;
				return trimBST(root.left, L, R);
			} else if (root.val == R) {
				root.right = null;
				// bug1
				root.left = trimBST(root.left, L, R);
			} else if (root.val < R) {
				if (root.val < L) {
					root.left = null;
					return trimBST(root.right, L, R);
				} else if (root.val == L) {
					root.left = null;
					// bug1
					root.right = trimBST(root.right, L, R);
				} else if (root.val > L) {
					root.left = trimBST(root.left, L, R);
					root.right = trimBST(root.right, L, R);
				}
			}
		}

		return root;
	}

	/*
	 * 08:23pm 0704 started BFS, once next level vertix is null, return current
	 * vertix list's head
	 * 
	 * 08:38pm draft done. 08:41pm 1pass after fixing issue 1 #TODO One solution
	 * shows that you can solve this without tracking by doing right to left
	 * traversal, yet another fantastic example of reverse-thinking.
	 */

	public int findBottomLeftValue(TreeNode root) {
		if (root == null)
			return -1;

		Queue<TreeNode> _v = new LinkedList<TreeNode>();
		Queue<TreeNode> _vv = new LinkedList<TreeNode>();

		_v.add(root);

		while (!_v.isEmpty()) {
			for (TreeNode r : _v) {
				if (r.left != null)
					_vv.add(r.left);
				if (r.right != null)
					_vv.add(r.right);
			}
			if (_vv.isEmpty())
				return _v.poll().val;
			else {
				// issue 1
				// _v = _vv
				// #TODO This wont work in java, it works in ruby though.
				_v.clear();
				_v.addAll(_vv);
				_vv.clear();
			}
		}

		return -1;
	}

	/*
	 * 10:04pm 0704 started
	 * 
	 * BFS and return the max
	 * 
	 * 10:12pm draft done. 10:13pm 1pass
	 */
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<TreeNode> nnodes = new LinkedList<TreeNode>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			int max = Integer.MIN_VALUE;
			for (TreeNode n : nodes) {
				max = max < n.val ? n.val : max;
				if (n.left != null)
					nnodes.add(n.left);
				if (n.right != null)
					nnodes.add(n.right);
			}
			result.add(max);
			nodes.clear();
			nodes.addAll(nnodes);
			nnodes.clear();
		}

		return result;
	}

	/*
	 * 10:21pm 0704 started
	 * 
	 * 
	 */
	// public int shortestPathLength(int[][] graph) {
	//
	// }

	/*
	 * 8:52am 0705 started
	 * 
	 * the number you can remove should be 2,4,6,8 or 1,3,5,7
	 * 
	 * we remove steps[i] parenthess and test if it is valid. 10:16am draft done.
	 * 1:06pm TLE. I think the algorithm is correct but as I guessed at the very
	 * beginning, it is way too slow.
	 * 
	 * 1:14pm try solution 2 the idea is to close all parenthess and process waht's
	 * left, permute all cases of the left and iterate from 1
	 * 
	 * 2:39pm failed.
	 * 
	 * 7:13pm 0713 revisited after watching huahuajiang's video #TODO The key frm
	 * huahua is when there is only one type of parenthess, e.g. (or ) you can
	 * simply count the number of ( and ) to determine if it its valid or not. #TODO
	 * where the parenthesis is invalid, you can make it valid by making #of (
	 * equals with #of ). This is quite contratry to my thinking, I overthought that
	 * the relative locations of parenthesis also matter.
	 */

	// public List<String> removeInvalidParentheses2(String s) {
	// List<String> result = new LinkedList<String>();
	//
	// if (s == null)
	// return result;
	//
	// if (isValidWithNonParen(s)) {
	// result.add(s);
	// return result;
	// }
	//
	// String nonClosed = keepOnlyPa(closePa(s));
	//
	// int[] pos = new int[nonClosed.length()];
	//
	// for (int i = 0; i < pos.length; i++)
	// pos[i] = i;
	//
	// for (int i = 1; i < pos.length; i++) {
	// List<int[]> possibleChoices = permutations(pos, i);
	// }
	//
	// }

	public List<int[]> permutations(int[] input, int k) {
		List<int[]> subsets = new ArrayList<>();

		int[] s = new int[k]; // here we'll keep indices
		// pointing to elements in input array

		if (k <= input.length) {
			// first index sequence: 0, 1, 2, ...
			for (int i = 0; (s[i] = i) < k - 1; i++)
				;
			subsets.add(getSubset(input, s));
			for (;;) {
				int i;
				// find position of item that can be incremented
				for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--)
					;
				if (i < 0) {
					break;
				}
				s[i]++; // increment this item
				for (++i; i < k; i++) { // fill up remaining items
					s[i] = s[i - 1] + 1;
				}
				subsets.add(getSubset(input, s));
			}
		}
		return subsets;
	}

	// generate actual subset by index sequence
	int[] getSubset(int[] input, int[] subset) {
		int[] result = new int[subset.length];
		for (int i = 0; i < subset.length; i++)
			result[i] = input[subset[i]];
		return result;
	}

	public String keepOnlyPa(String s) {
		String _s = "";
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
			case ')':
				_s += String.valueOf(c);
				break;
			}
		}

		return _s;
	}

	public String closePa(String s) {

		List<Integer> lPos = new ArrayList<Integer>();
		Deque<GPair<String, Integer>> pa = new ArrayDeque<GPair<String, Integer>>();

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				pa.add(new GPair<String, Integer>(String.valueOf(s.charAt(i)), i));
				break;
			case ')':
				if (!pa.isEmpty()) {
					GPair<String, Integer> gp = pa.pollLast();
					lPos.add(gp.t2);
					lPos.add(i);
				}
				break;
			}
		}

		return removeCharAt(s, lPos);

	}

	class GPair<Type1, Type2> {
		Type1 t1;
		Type2 t2;

		public GPair(Type1 t1, Type2 t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new LinkedList<String>();

		if (s == null)
			return result;

		if (isValidWithNonParen(s)) {
			result.add(s);
			return result;
		}

		List<Integer> paPos = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
			case ')':
				paPos.add(i);
				break;
			}
		}

		int sLen = paPos.size();

		int[] numToRemove = new int[1 + (sLen / 2)];
		if (sLen % 2 == 0) {
			for (int i = 1; i < numToRemove.length; i++)
				numToRemove[i] = i * 2;
		} else {
			for (int i = 1; i < numToRemove.length; i++)
				numToRemove[i] = i * 2 - 1;
		}

		int[] positions = new int[sLen];

		for (int i = 0; i < positions.length; i++)
			positions[i] = i;

		List<List<Integer>> allPossibleSteps = subsets(positions);
		boolean foundValid = false;
		for (int i = 1; i < numToRemove.length; i++) {
			if (!foundValid) {
				for (List<Integer> moves : allPossibleSteps) {
					if (moves.size() == numToRemove[i]) {
						String afterRemoval = removeCharAt(s, moves, paPos);
						if (isValidWithNonParen(afterRemoval)) {
							if (!result.contains(afterRemoval)) {
								result.add(afterRemoval);
							}
							foundValid = true;
						}
					}
				}
			}
		}

		if (!foundValid) {
			result.add(removeCharAt(s, paPos));
		}

		return result;
	}

	public String removeCharAt(String s, List<Integer> positions, List<Integer> locations) {
		char[] result = new char[s.length() - positions.size()];
		int si = 0;
		List<Integer> actualLocations = new ArrayList<Integer>();

		for (Integer i : positions)
			actualLocations.add(locations.get(i));

		for (int i = 0; i < s.length(); i++) {
			if (!actualLocations.contains(i))
				result[si++] = s.charAt(i);
		}

		return String.valueOf(result);
	}

	public String removeCharAt(String s, List<Integer> positions) {
		char[] result = new char[s.length() - positions.size()];
		int si = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!positions.contains(i))
				result[si++] = s.charAt(i);
		}

		return String.valueOf(result);
	}

	/*
	 * 1:12pm 0706 started use two hashmap, then iterate the smaller one to get the
	 * cnts, paste into the result array. 1:26pm draft done. 1:30pm 2pass after
	 * fixing bug 1 #TODO it is good to always test the minimal version of the
	 * question. #TODO DO NOT COPY PASTE CODE! use functions!
	 * 
	 * 1:35pm 0706 started solution 2 1:39pm draft done 1:42pm 1pass
	 */

	public int[] intersect(int[] nums1, int[] nums2) {
		// if (nums1 == null || nums2 == null)
		// return new int[0];
		//
		// if (nums1.length < 1 || nums2.length < 1)
		// return new int[0];
		//
		// Map<Integer, Integer> d1 = new HashMap<Integer, Integer>();
		// Map<Integer, Integer> d2 = new HashMap<Integer, Integer>();
		//
		// for (int n : nums1) {
		// Integer cnt = d1.get(n);
		// if (cnt == null)
		// cnt = 0;
		// d1.put(n, cnt + 1);
		// }
		//
		// for (int n : nums2) {
		// Integer cnt = d2.get(n);
		// if (cnt == null)
		// cnt = 0;
		// // bug 1
		// // d1.put(n, cnt+1);
		// d2.put(n, cnt + 1);
		// }
		//
		// Set<Integer> d1Num = d1.keySet();
		//
		// List<Integer> result = new ArrayList<Integer>();
		//
		// for (int d : d1Num) {
		// Integer cntD2 = d2.get(d);
		// if (cntD2 != null) {
		// Integer cntD = d1.get(d) > cntD2 ? cntD2 : d1.get(d);
		// while (cntD-- > 0)
		// result.add(d);
		// }
		// }
		//
		// int[] r = new int[result.size()];
		//
		// for (int i = 0; i < r.length; i++)
		// r[i] = result.get(i);
		//
		// return r;
		if (nums1 == null || nums2 == null)
			return new int[0];

		if (nums1.length < 1 || nums2.length < 1)
			return new int[0];

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int d1Ind = 0, d2Ind = 0;
		List<Integer> result = new ArrayList<Integer>();

		while (d1Ind < nums1.length && d2Ind < nums2.length) {
			if (nums1[d1Ind] == nums2[d2Ind]) {
				result.add(nums1[d1Ind]);
				d1Ind++;
				d2Ind++;
			} else if (nums1[d1Ind] < nums2[d2Ind]) {
				d1Ind++;
			} else {
				d2Ind++;
			}
		}

		int[] r = new int[result.size()];
		for (int i = 0; i < r.length; i++)
			r[i] = result.get(i);

		return r;
	}

	/*
	 * 1:32pm 0706 started the same as the previous one. but only output once.
	 * 1:33pm draft done. 1:33pm 1pass
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return new int[0];

		if (nums1.length < 1 || nums2.length < 1)
			return new int[0];

		Map<Integer, Integer> d1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> d2 = new HashMap<Integer, Integer>();

		for (int n : nums1) {
			Integer cnt = d1.get(n);
			if (cnt == null)
				cnt = 0;
			d1.put(n, cnt + 1);
		}

		for (int n : nums2) {
			Integer cnt = d2.get(n);
			if (cnt == null)
				cnt = 0;
			d2.put(n, cnt + 1);
		}

		Set<Integer> d1Num = d1.keySet();

		List<Integer> result = new ArrayList<Integer>();

		for (int d : d1Num) {
			Integer cntD2 = d2.get(d);
			if (cntD2 != null) {
				// Integer cntD = d1.get(d) > cntD2 ? cntD2 : d1.get(d);
				// while (cntD-- > 0)
				result.add(d);
			}
		}

		int[] r = new int[result.size()];

		for (int i = 0; i < r.length; i++)
			r[i] = result.get(i);

		return r;

	}

	/*
	 * 2:00pm 0706 started
	 * 
	 * The algorithm is to first traverse two lists and get the diff of length, then
	 * reposition the longer one so that the two start simultaneously. then you just
	 * check if their next nodes are the same.
	 * 
	 * 2:07pm draft done. 2:13pm 2pass after fixing two typos. beats 100%
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode pa = headA, pb = headB;
		int la = 0, lb = 0;

		while (pa.next != null) {
			pa = pa.next;
			la++;
		}

		while (pb.next != null) {
			pb = pb.next;
			lb++;
		}

		pa = headA;
		pb = headB;

		while (la > lb) {
			pa = pa.next;
			la--;
		}
		while (lb > la) {
			pb = pb.next;
			lb--;
		}

		while (pa != null && pb != null) {
			if (pa.val == pb.val) {
				return pa;
			} else {
				pa = pa.next;
				pb = pb.next;
			}
		}

		return null;
	}

	/*
	 * 3:23pm 0706 started push, pop, top, and retrieving the minimum element in
	 * constant time. 3:28pm draft done.
	 */
	class MinStack {
		int min_val;
		int min_val_ind;
		LinkedList<Integer> list;

		/** initialize your data structure here. */
		public MinStack() {
			min_val_ind = 0;
			min_val = Integer.MAX_VALUE;
			list = new LinkedList<Integer>();
		}

		public void push(int x) {
			if (x < min_val) {
				min_val_ind = 0;
				min_val = x;
			} else {
				min_val_ind++;
			}
			list.offerFirst(x);
		}

		public void pop() {
			if (min_val_ind == 0)
				list.pollFirst();
		}

		public int top() {
			return list.peek();
		}

		public int getMin() {
			return min_val;
		}
	}

	/*
	 * 09:13pm 0708 started 09:49pm draft done. 10:01pm draft done. 10:14pm 1pass
	 * after fixing that typo bug... #TODO any good ways to prevent such bugs?
	 */

	public int longestSubstring(String s, int k) {
		// if (s == null)
		// return 0;
		// if (s.isEmpty())
		// return 0;
		//
		// Map<String, Integer> charCnt = new HashMap<String, Integer>();
		//
		// for (char c : s.toCharArray()) {
		// Integer cnt = charCnt.get(String.valueOf(c));
		// if (cnt == null)
		// cnt = 0;
		// charCnt.put(String.valueOf(c), cnt + 1);
		// }
		//
		// boolean everyCharMoreThanK = true;
		// for (Integer c : charCnt.values()) {
		// if (c < k) {
		// everyCharMoreThanK = false;
		// }
		// }
		//
		// if (everyCharMoreThanK == true)
		// return s.length();
		//
		// List<String> subStrings = new ArrayList<String>();
		//
		// int l = 0;
		// int ls = 0;
		// boolean inStr = false;
		// while (l < s.length()) {
		// String currStr = String.valueOf(s.charAt(l));
		// if (charCnt.get(currStr) >= k && inStr == false) {
		// ls = l;
		// inStr = true;
		// } else if (charCnt.get(currStr) < k && inStr == true) {
		// inStr = false;
		// if (l - ls >= k) {
		// subStrings.add(s.substring(ls, l));
		// }
		// }
		// l++;
		// }
		//
		// // bug 1
		// // if (inStr = true)
		// if (inStr == true) {
		// subStrings.add(s.substring(ls));
		// inStr = false;
		// }
		//
		// int maxCnt = 0;
		// for (String ss : subStrings) {
		// int ssLength = longestSubstring(ss, k);
		// maxCnt = maxCnt < ssLength ? ssLength : maxCnt;
		// }
		//
		// return maxCnt;

		// Solution 2 trying to speed up
		if (s == null)
			return 0;
		if (s.isEmpty())
			return 0;

		int[] charCnt = new int[26];
		for (int i = 0; i < 26; i++)
			charCnt[i] = 0;

		for (char c : s.toCharArray()) {
			charCnt[c - 'a']++;
		}

		boolean everyCharMoreThanK = true;
		for (char c : s.toCharArray()) {
			if (charCnt[c - 'a'] < k) {
				everyCharMoreThanK = false;
				break;
			}
		}

		if (everyCharMoreThanK == true)
			return s.length();

		List<String> subStrings = new ArrayList<String>();

		int l = 0;
		int ls = 0;
		boolean inStr = false;
		while (l < s.length()) {
			int cnt = charCnt[s.charAt(l) - 'a'];
			if (cnt >= k && inStr == false) {
				ls = l;
				inStr = true;
			} else if (cnt < k && inStr == true) {
				inStr = false;
				if (l - ls >= k) {
					subStrings.add(s.substring(ls, l));
				}
			}
			l++;
		}

		// bug 1
		// if (inStr = true)
		if (inStr == true) {
			subStrings.add(s.substring(ls));
			inStr = false;
		}

		int maxCnt = 0;
		for (String ss : subStrings) {
			int ssLength = longestSubstring(ss, k);
			maxCnt = maxCnt < ssLength ? ssLength : maxCnt;
		}

		return maxCnt;
	}

	/*
	 * 1:16pm 0709 started the question is a find-a-path in a DAG. can solve it
	 * recursively. 1:57pm draft done. 2:15pm found algorithm incorrect. didnt
	 * really understand the problem
	 * 
	 * 2:35pm solution 2 draft done. 2:44pm failed. the main idea is correct: bfs.
	 * but not familiar with graph data processing. #TODO get familiar with graph
	 * representation.
	 */

	public int[] seq(int length) {
		int[] result = new int[length];
		for (int i = 0; i < length; i++)
			result[i] = i;
		return result;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// List<Integer> currPath = new ArrayList<Integer>();
		// currPath.add(0);
		// return findOrder_helper(numCourses, 0, prerequisites, currPath);

		if (prerequisites == null)
			return seq(numCourses);
		if (prerequisites.length < 1)
			return seq(numCourses);
		List<Integer> courseTotake = new ArrayList<Integer>();
		courseTotake.add(numCourses - 1);

		List<Integer> nextCourses = new ArrayList<Integer>();
		List<Integer> currCourses = new ArrayList<Integer>();
		nextCourses.add(numCourses - 1);
		while (!nextCourses.isEmpty()) {
			currCourses.clear();
			currCourses.addAll(nextCourses);
			nextCourses.clear();
			for (Integer n : currCourses) {
				for (int i = 0; i < prerequisites.length; i++) {
					if (prerequisites[i][0] == n) {
						nextCourses.add(prerequisites[i][1]);
						if (!courseTotake.contains(prerequisites[i][1]))
							courseTotake.add(prerequisites[i][1]);
					}
				}
			}
		}

		Collections.reverse(courseTotake);
		return listToArray(courseTotake);

	}

	public int[] findOrder_helper(int numCourses, int startingCourse, int[][] prerequisites, List<Integer> currPath) {
		int[] result = new int[numCourses];
		if (prerequisites == null)
			return new int[0];
		if (startingCourse > numCourses)
			return new int[0];

		List<Integer> nextCourses = new ArrayList<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			for (int j = 0; j < prerequisites[i].length; j++) {
				if (prerequisites[i][1] == startingCourse)
					nextCourses.add(prerequisites[i][0]);
			}
		}

		for (int i = 0; i < nextCourses.size(); i++) {
			List<Integer> newPath = new ArrayList<Integer>(currPath);
			newPath.add(nextCourses.get(i));
			if (nextCourses.get(i) == numCourses - 1) {
				return listToArray(newPath);
			} else {
				result = findOrder_helper(numCourses, startingCourse + 1, prerequisites, newPath);
				if (result.length == numCourses)
					if (result[numCourses - 1] == numCourses - 1)
						return listToArray(newPath);
			}
		}

		return new int[0];

	}

	int[] listToArray(List<Integer> l) {
		int[] result = new int[l.size()];

		for (int i = 0; i < l.size(); i++)
			result[i] = l.get(i);

		return result;

	}

	/*
	 * 06:35pm 0709 started the algorithm is to do level traverse and use a counter
	 * to control reversal.
	 * 
	 * 06:48pm draft done.
	 * 
	 * 6:52pm 1pass
	 */

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		Queue<TreeNode> vs = new LinkedList<TreeNode>();
		Queue<TreeNode> nextVS = new LinkedList<TreeNode>();

		vs.add(root);

		boolean leftToRight = true;

		List<Integer> r;
		while (!vs.isEmpty()) {
			r = new ArrayList<Integer>();
			while (!vs.isEmpty()) {
				TreeNode n = vs.poll();
				r.add(n.val);
				if (n.left != null)
					nextVS.add(n.left);
				if (n.right != null)
					nextVS.add(n.right);
			}
			if (leftToRight) {
				result.add(r);
				leftToRight = false;
			} else {
				Collections.reverse(r);
				result.add(r);
				leftToRight = true;
			}
			vs.addAll(nextVS);
			nextVS.clear();
		}

		return result;
	}

	/*
	 * 10:56am 0710 started
	 * 
	 * a trivial solution is to sort the array and get the kth element of the sorted
	 * array.
	 * 
	 * 10:59am 1pass
	 * 
	 * #TODO quicksort is involved in the best selection-algorithm.
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length - k];

	}

	/*
	 * 12:32pm 0710 started solution 1 dp: to reach any cell in the board, there are
	 * a+c unique ways, where a = ways to reach its left cell, c = ways to reach its
	 * top cell. we need to iteratively solve this solution.
	 * 
	 * 12:40pm draft done.
	 * 
	 * 12:52pm fixed algorithm 12:52pm 1pass. 12:55pm solution 2 recursive
	 * 
	 * 1:01PM Time limit exceeded. 1:13pm DP solution draft done 1:13pm 1pass.
	 */

	public int uniquePaths(int m, int n) {
		// if(m == 0 || n == 0) return 0;
		//
		// int[][] ways = new int[m][n];
		//
		// ways[0][0] = 1;// this is an exception.
		// for(int i = 0; i < m; i++) {
		// for(int j = 0; j < n; j++) {
		// if(i == 0 && j!=0){
		// ways[i][j] = 1;
		// }
		// else if (i != 0 && j == 0){
		// ways[i][j] = 1;
		// }
		// else if(i !=0 && j!= 0){
		// ways[i][j] = ways[i][j-1]+ways[i-1][j];
		// }
		// }
		// }
		//
		// return ways[m-1][n-1];

		// solution 2 resursion but time limit exceeded.

		// if(m < 1 || n < 1) return 0;
		//
		// if(m == 1 && n == 1) return 1;
		//
		// return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);

		// solution 3 dp
		int[][] paths = new int[m][n];
		initiate2DArray(paths, Integer.MIN_VALUE);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (i == 0 || j == 0)
					paths[i][j] = 1;

		return uniquePath_helper(m, n, paths);

	}

	public int uniquePath_helper(int m, int n, int[][] paths) {
		if (paths[m - 1][n - 1] == Integer.MIN_VALUE) {
			int result = uniquePath_helper(m - 1, n, paths) + uniquePath_helper(m, n - 1, paths);
			paths[m - 1][n - 1] = result;
			return result;
		}
		return paths[m - 1][n - 1];
	}

	/*
	 * 1:15pm 0710 started
	 * 
	 * 1:19pm draft done.
	 * 
	 * 1:23
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> vertix = new LinkedList<TreeNode>();
		Queue<TreeNode> nextVertix = new LinkedList<TreeNode>();
		if (root != null)
			vertix.add(root);

		while (!vertix.isEmpty()) {
			List<Integer> vals = new ArrayList<Integer>();
			while (!vertix.isEmpty()) {
				TreeNode n = vertix.poll();
				vals.add(n.val);
				if (n.left != null)
					nextVertix.add(n.left);
				if (n.right != null)
					nextVertix.add(n.right);
			}
			result.add(vals);
			vertix.addAll(nextVertix);
			nextVertix.clear();
		}

		return result;

	}

	/*
	 * 1:39pm 0710 started
	 * 
	 * brutal force. o(n^2) + o(n2)storage
	 * 
	 * 1:50pm draft done. 1:53pm 1pass
	 * 
	 * #TODO if it didnt say o(1) storage, always assume and use unlimited storage
	 * unless its o(2^n) storage.
	 */

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int cnt = 0;
		int n = A.length;
		int sum = 0;

		Map<Integer, Integer> sum1Map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sum2Map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				sum = A[i] + B[j];
				Integer p = sum1Map.get(sum);
				if (p == null)
					p = 0;
				sum1Map.put(sum, p + 1);
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				sum = C[i] + D[j];
				Integer p = sum2Map.get(sum);
				if (p == null)
					p = 0;
				sum2Map.put(sum, p + 1);
			}

		Set<Integer> sum2s = sum2Map.keySet();
		for (Integer abSum : sum1Map.keySet()) {
			if (sum2s.contains(-abSum)) {
				cnt += sum2Map.get(-abSum) * sum1Map.get(abSum);
			}
		}

		return cnt;

	}

	/*
	 * 09:51pm 0710 started
	 * 
	 * 10:29pm done after consulting several standard answers
	 * 
	 * #TODO The idea is very classic dynamic programming: think of the last step we
	 * take
	 */
	public int coinChange(int[] coins, int amount) {
		int[] d = new int[amount + 1];

		d[0] = 0;
		for (int i = 1; i <= amount; i++) {
			d[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && d[i - coins[j]] != Integer.MAX_VALUE) {
					d[i] = Integer.min(d[i], 1 + d[i - coins[j]]);
				}
			}
		}

		if (d[amount] != Integer.MAX_VALUE)
			return d[amount];
		else
			return -1;
	}

	/*
	 * 10:48am 0711 started
	 * 
	 * 11:21am pause
	 * 
	 * 11:54am resume
	 * 
	 * 12:21pm draft done. 12:45pm failed.
	 * 
	 * #TODO after reading the official answer, the key to these dp problems: 1.
	 * focus on how to get dp[n] from dp[n-1], but do not focus on how to get
	 * dp[n-1] 2. do not worry about dp[1]~dp[n-1]. they will form once you fixe
	 * dp[0] and the chain rule.
	 * 
	 * for this question, you know dp[0] = nums[0]. then when you get dp[n-1], to
	 * reach dp[n], divide max_product[n-1] into three scenarios:
	 * abs(max_product[n-1]) == 0, > 0 and < 0. if ==0, dp[n] = max(0, nums[i])
	 * etc.. you also do not worry if the two elements are adjacent to each other.
	 */

	public int maxProduct(int[] nums) {
		return -1;
		// if (nums.length < 2)
		// return nums[0];
		//
		// int[] d = new int[nums.length];
		// d[0] = nums[0];

		// if (nums == null)
		// return -1;
		// if (nums.length < 1)
		// return -1;
		//
		// int[][] dp = new int[nums.length][2];
		// int rightBoundary, prevProduct;
		// boolean gotZeroInBetween = false;
		// int productInBetween = 1;
		//
		// dp[0][1] = 0;
		// dp[0][0] = nums[0];
		//
		// for (int i = 1; i < nums.length; i++) {
		// rightBoundary = dp[i - 1][1];
		// prevProduct = dp[i - 1][0];
		// if (rightBoundary + 1 == i) {
		// // adjacent
		// if (prevProduct == 0 && nums[i] > 0) {
		// dp[i][1] = rightBoundary + 1;
		// dp[i][0] = nums[i];
		// } else if (prevProduct == 0 && nums[i] <= 0) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = prevProduct;
		// } else if (prevProduct > 0 && nums[i] > 0) {
		// dp[i][1] = rightBoundary + 1;
		// dp[i][0] = prevProduct * nums[i];
		// } else if (prevProduct > 0 && nums[i] <= 0) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = prevProduct;
		// }
		// else if(prevProduct < 0 && nums[i] > 0) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = prevProduct;
		// }
		// else if(prevProduct < 0 && nums[i] <= 0) {
		// dp[i][1] = rightBoundary + 1;
		// dp[i][0] = prevProduct * nums[i];
		// }
		// } else {
		// // not adjacent
		// if (prevProduct == 0) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = 0;
		// } else if (prevProduct > 0 && nums[i] > 0) {
		// if(prevProduct > nums[i]) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = prevProduct;
		// }
		// else {
		// dp[i][1] = i;
		// dp[i][0] = nums[i];
		// }
		//
		// }else if(prevProduct > 0 && nums[i] < 0) {
		// for (int j = rightBoundary + 1; j < i; j++) {
		// if (nums[j] == 0) {
		// gotZeroInBetween = true;
		// }
		// productInBetween *= nums[j];
		// }
		// if (gotZeroInBetween) {
		// dp[i][1] = rightBoundary;
		// dp[i][0] = prevProduct;
		// } else {
		// dp[i][1] = i;
		// dp[i][0] = prevProduct * productInBetween * nums[i];
		// }
		// }
		//
		// else if (prevProduct != 0 && nums[i] < 0) {
		//
		// }
		// }
		//
		// }
		//
		// return dp[nums.length - 1][0];
	}

	public void placeHolder() {
	}

	/*
	 * 02:47pm 0711 started
	 * 
	 * 03:12pm draft done.
	 */

	public int compress(char[] chars) {
		if (chars == null)
			return 0;
		if (chars.length < 1)
			return 0;

		int si = 0;
		char currChar = chars[0];
		int currCnt = 1;
		int cntStartInd = 0;

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == currChar) {
				currCnt++;
			} else {
				chars[si++] = currChar;
				currChar = chars[i];
				if (currCnt != 1) {
					cntStartInd = si;
					while (currCnt != 0) {
						chars[si++] = (char) (currCnt % 10 + '0');
						currCnt /= 10;
					}
					arrayReverse(chars, cntStartInd, si);
				}
				currCnt = 1;
			}
		}

		// bug 1
		// #TODO Do not forget the last chunk.
		if (currCnt != 1) {
			chars[si++] = currChar;
			cntStartInd = si;
			while (currCnt != 0) {
				chars[si++] = (char) (currCnt % 10 + '0');
				currCnt /= 10;
			}
			arrayReverse(chars, cntStartInd, si);
			currCnt = 1;
		}

		return si;
	}

	public void arrayReverse(char[] nums, int start, int end) {
		for (int i = start; i <= (end + start - 1) / 2; i++) {
			char temp = nums[i];
			nums[i] = nums[end - 1 - i + start];
			nums[end - i - 1 + start] = temp;
		}
	}

	public void arrayReverse(int[] nums, int start, int end) {
		for (int i = start; i <= (end + start - 1) / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[end - 1 - i + start];
			nums[end - i - 1 + start] = temp;
		}
	}

	/*
	 * 1:54pm 0714 started
	 * 
	 * dp.
	 */

	// public int minimumTotal(List<List<Integer>> triangle) {
	//
	// }

	// public int minimumTotal_helper(List<List<Integer>> triangle, int sum) {
	// if (triangle.size() < 1)
	// return sum;
	// List<Integer> intList = triangle.get(0);
	//
	// for (Integer n : intList) {
	//
	// }
	//
	// }

	/*
	 * 12:30pm 0716 started
	 * 
	 * dp, dp[i][j] == isValid(substring(i, j+1))
	 * 
	 * dp[i][j] == match(s[i], s[j]) && (j-1 >= i+1 || dp[i+1][j-1])
	 * 
	 * 1:22PM TLE passed 90% cases.
	 */

	public int longestValidParentheses(String s) {
		if (s == null || s.isEmpty())
			return 0;

		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxLen = 0;

		for (int j = 0; j < s.length(); j++) {
			for (int i = j; i >= 0; i--) {
				if (isMatch(s.charAt(i), s.charAt(j))) {
					if (j - i >= 2) {
						if (dp[i + 1][j - 1] == true) {
							dp[i][j] = true;
						} else {
							if (isMatch(s.charAt(i), s.charAt(i + 1))) {
								dp[i][j] = dp[i + 2][j];
							} else if (isMatch(s.charAt(j - 1), s.charAt(j))) {
								dp[i][j] = dp[i][j - 2];
							}
						}
					} else if (j - i == 1) {
						dp[i][j] = true;
					}
					maxLen = dp[i][j] ? Math.max(maxLen, j - i + 1) : maxLen;
				}
			}
		}

		return maxLen;
	}

	boolean isMatch(char l, char r) {
		return l == '(' && r == ')';
	}

	boolean isValidP(String s) {
		int l = 0, r = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				l++;
				break;
			case ')':
				r++;
				break;
			}
			if (r > l)
				return false;
		}
		return r == l;
	}

	/*
	 * 3:25pm 0716 started
	 * 
	 * 4:00pm failed.
	 * 
	 */
	// public int numDecodings(String s) {
	// if (s == null || s.isEmpty())
	// return 0;
	//
	// int[] dp = new int[s.length()];
	//
	// }

	/*
	 * 4:15pm 0716 started
	 * 
	 * 
	 * BFS first to find the two elements, then find the first element that they
	 * share in the searchPath.
	 * 
	 * 4:31pm draft done 4:46pm memory limit exceeded.
	 * 
	 */

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath = findElement(root, p, new ArrayList<>());
		// List<TreeNode> pPath = null;
		List<TreeNode> qPath = findElement(root, q, new ArrayList<>());

		int max = 0;
		for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
			System.out.println(pPath.get(i).val + "\t" + qPath.get(i).val);
			if (qPath.get(i) == pPath.get(i)) {
				max = i;
			}
		}

		return pPath.get(max);
	}

	private List<TreeNode> findElement(TreeNode root, TreeNode p, List<TreeNode> path) {
		// DFS
		List<TreeNode> currPath, newPath;

		if (root == null)
			return path;
		System.out.println("searching root " + root.val);
		path.add(root);
		if (root.val == p.val) {
			return path;
		} else {
			newPath = new ArrayList<>(path);
			currPath = findElement(root.left, p, newPath);

			if (currPath.get(currPath.size() - 1).val == p.val) {
				return currPath;
			}
			newPath = new ArrayList<>(path);
			currPath = findElement(root.right, p, newPath);
			if (currPath.get(currPath.size() - 1).val == p.val) {
				return currPath;
			}
		}

		return path;

	}

	/*
	 * 10:23am 0717
	 * 
	 * 10:25am draft done.
	 * 
	 * 10:27am 1pass
	 * 
	 * Imagine a simple 1-2-3-2 list with the cyple 2-3-2 p1 goes 1 step and p2 goes
	 * 2steps each round, the path map is:
	 * 
	 * 
	 * 
	 * p2 p1 1 1 3 2 3 3 X this is where loop stops 3 2 3 3 3 2 3 3
	 * 
	 * 
	 * 
	 * a simple 1-2-3 list without cycle:
	 * 
	 * 
	 * 
	 * p2 p1 1 1 3 2 1 3 3 null 1 1 3 2 1 3 3 null
	 * 
	 * 
	 * 
	 */
	public boolean hasCycle(ListNode head) {
		ListNode p1 = head, p2 = head;

		while (p1 != null && p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
			if (p2 == null)
				break;
			p2 = p2.next;
			if (p1 == p2)
				return true;
		}

		return false;

	}

	/*
	 * 10:29am 0717 started
	 * 
	 * 10:33am draft done.
	 * 
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode p1 = head, p2 = head, p1Prev = null;

		while (p1 != null && p2 != null) {

			p1 = p1.next;
			p2 = p2.next;
			if (p2 == null)
				break;
			p2 = p2.next;
			if (p1 == p2) {
				return p1Prev;
			}
			p1Prev = p1;
		}

		return p1Prev;
	}

	/*
	 * 03:14pm 0717 started
	 *
	 * 3:29pm draft done 3:49pm passed after several fixes
	 * 
	 * #TODO Now you understand stack... but not queue and deque(double queue)
	 */

	public List<Integer> postorder(Node2 root) {
		Stack<Action> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();

		if (root == null)
			return result;

		stack.push(new Action(true, root));

		while (!stack.isEmpty()) {
			Action n = stack.pop();
			if (n.visit) {
				stack.push(new Action(false, n.node));
				addChildren(n, stack);
			} else {
				result.add(n.node.val);
			}
		}

		return result;

	}

	public void addChildren(Action act, Stack<Action> stack) {
		List<Node2> children = act.node.children;
		for (int i = children.size() - 1; i >= 0; i--) {
			Action a = new Action(true, children.get(i));
			stack.push(a);
		}
	}

	private class Action {
		boolean visit;
		Node2 node;

		public Action(boolean visitOrPrint, Node2 node) {
			this.visit = visitOrPrint;
			this.node = node;
		}

	}

	private class TreeNodeAction {
		boolean visit;
		TreeNode node;

		public TreeNodeAction(boolean visitOrPrint, TreeNode node) {
			this.visit = visitOrPrint;
			this.node = node;
		}

	}

	/*
	 *
	 * 3:50pm 0717 started
	 *
	 * 3:57pm draft done.
	 * 
	 * 3:58pm 1pass
	 *
	 */
	// public List<Integer> postorderTraversal(TreeNode root) {
	// List<Integer> result = new ArrayList<>();
	//
	// if (root == null)
	// return result;
	//
	// Stack<Action> stack = new Stack<>();
	// stack.push(new Action(true, root));
	//
	// while (!stack.isEmpty()) {
	// Action act = stack.pop();
	// if (act.visitThisNode) {
	// stack.push(new Action(false, act.node));
	// if (act.node.right != null)
	// stack.push(new Action(true, act.node.right));
	// if (act.node.left != null)
	// stack.push(new Action(true, act.node.left));
	// } else {
	// result.add(act.node.val);
	// }
	// }
	//
	// return result;
	// }

	/*
	 *
	 * 4:07pm 0717 started
	 *
	 * 4:21pm draft done.
	 * 
	 * 4:40pm failed due to some boundary conditions.
	 * 
	 */
	public TreeNode buildTree2(int[] inorder, int[] postorder) {

		return buildTree_helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
	}

	public TreeNode buildTree_helper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
		TreeNode root = null;
		if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1)
			return root;
		if (inStart < 0 || inEnd < 0 || poStart < 0 || poEnd < 0)
			return root;
		if (inStart >= inEnd || poStart >= poEnd)
			return root;

		root = new TreeNode(postorder[poEnd - 1]);

		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == postorder[poEnd - 1]) {
				for (int j = poStart; j < poEnd - 1; j++) {
					if (i >= 1) {
						if (postorder[j] == inorder[i - 1]) {
							TreeNode left = buildTree_helper(inorder, inStart, i, postorder, poStart, j + 1);
							TreeNode right = buildTree_helper(inorder, i + 1, inEnd, postorder, j + 1, poEnd - 1);
							root.left = left;
							root.right = right;
							return root;
						}
					} else {
						TreeNode right = buildTree_helper(inorder, i + 1, inEnd, postorder, poStart, poEnd - 1);
						root.left = null;
						root.right = right;
						return root;
					}
				}
			}
		}

		return root;
	}

	/*
	 *
	 * 9:22am 0718 started
	 * 
	 * the number of ways only depend on the size of the region if the region is
	 * [ai,ai+1,ai+2,,ai+n]; to form the tree, first choose the head, then only its
	 * left subregion can form the left tree. vice versa for the right tree.
	 *
	 * 9:40am draft done
	 *
	 * 9:49am check done 10:17am fixed bug 10:18am pass
	 * 
	 * #TODO for problems like this, when n =0, ways = 1, it means we always have a
	 * way!!! and that is to do nothing and sleep.
	 * 
	 * https://en.wikipedia.org/wiki/Catalan_number #TODO do you know how to
	 * calculate the time complexity?
	 */
	public int numTrees(int n) {

		if (n <= 0)
			return 1;
		if (n == 1)
			return 1;

		int[] ways = new int[n + 1];
		int way = 0;

		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;

		for (int i = 3; i <= n; i++) {

			if (i % 2 == 0) {
				for (int j = 1; j <= i / 2; j++) {
					way += ways[j - 1] * ways[i - j];
				}
				way *= 2;
			} else {
				for (int j = 1; j <= i / 2; j++) {
					way += ways[j - 1] * ways[i - j];
				}
				way *= 2;
				way += ways[(i - 1) / 2] * ways[(i - 1) / 2];
			}
			ways[i] = way;
			way = 0;
		}

		return ways[n];
	}

	/*
	 * 10:41am 0718 started sort the array o(nlogn) nums[i] = nums[i-1] o(n) best :
	 * o(nlogn)
	 *
	 * 10:44am draft done. but efficiency is not good. 11:16am done evaluating the
	 * problem # This problem (reportedly) took CS legend Don Knuth twenty-four
	 * hours to solve # and I have only met one person (Keith Amling) who could
	 * solve it in less time # than this.
	 */

	public int findDuplicate(int[] nums) {
		// solution 1 38%
		// if(nums == null || nums.length == 1) return -1;
		// int[] nnums = new int[nums.length];
		// for(int i = 0; i < nums.length; i++) nnums[i] = nums[i];
		// Arrays.sort(nnums);

		// for(int i = 1; i < nums.length; i++)
		// if(nnums[i] == nnums[i-1]) return nnums[i];

		// return -1;

		// // solution 2 35%
		if (nums == null || nums.length == 1)
			return -1;

		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer n = m.get(nums[i]);
			if (n == null) {
				m.put(nums[i], 1);
			} else {
				return nums[i];
			}
		}

		return -1;

	}

	/*
	 *
	 * 2:06pm 0718 started 3:00pm still working on it. 9:19pm resume debuging
	 * 
	 * 10:17pm redesign a recursive algorithm.
	 */
	// public String decodeString(String s) {
	// if (s == null || s.length() < 1)
	// return "";
	//
	// Stack<String> stack = new Stack<>();
	// char curr = '[';
	// StringBuilder content = new StringBuilder();
	// StringBuilder num = new StringBuilder();
	// StringBuilder result = new StringBuilder();
	// int k = 0;
	// int lastStackSize = 0;
	//
	// for (int i = 0; i < s.length(); i++) {
	// curr = s.charAt(i);
	// if (curr != ']') {
	// //System.out.println("pushed " + curr);
	// stack.push(String.valueOf(curr));
	// } else {
	// while (!stack.peek().equals("[")) {
	// String ccc = stack.pop();
	// content.append(String.valueOf(ccc));
	// //System.out.println("poped " + ccc);
	// }
	// content.reverse();
	// stack.pop();
	// //System.out.println("poped " + stack.pop());
	// //System.out.println("empty? " + stack.isEmpty());
	//
	// while (isDigit(stack.peek())) {
	// num.append(stack.pop());
	// if (stack.isEmpty())
	// break;
	// }
	// num.reverse();
	// for (int j = 0; j < num.length(); j++)
	// k = k * 10 + (num.charAt(j) - '0');
	// while (k-- > 0) {
	// result.append(content.toString());
	// }
	// num.setLength(0);
	// content.setLength(0);
	// lastStackSize = stack.size();
	// k = 0;
	// }
	// }
	// if (!stack.isEmpty()) {
	// content.setLength(0);
	// while (stack.size() > lastStackSize) {
	// content.append(stack.pop());
	// }
	// result.append(content.reverse());
	// content.setLength(0);
	// while (!stack.isEmpty()) {
	// content.append(stack.pop());
	// }
	//
	// return content.reverse().append(result).toString();
	// }
	// return result.toString();
	// }

	/*
	 * 10:22pm 0718 started
	 * 
	 * 10:39pm draft done.
	 * 
	 * 10:49pm pass after fixing # TODO BUG1
	 */

	public String decodeString(String s) {
		if (s == null || s.isEmpty())
			return "";

		StringBuilder result = new StringBuilder();
		String brackContent = "";
		int leftBrackCnt = 0;
		int rightBrackCnt = 0;
		int brackContentStart = 0;
		int contentCnt = 0;
		char curr = '-';
		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);
			if (leftBrackCnt == 0 && curr != '[' && curr != ']' && !isDigit(curr)) {
				result.append(curr);
			} else if (leftBrackCnt == 0 && isDigit(curr)) {
				contentCnt = contentCnt * 10 + (curr - '0');
			} else if (curr == '[') {
				leftBrackCnt++;
				// bug1
				// brackContentStart = i + 1;
				if (leftBrackCnt == 1)
					brackContentStart = i + 1;
			} else if (leftBrackCnt != 0 && curr == ']') {
				rightBrackCnt++;
				if (leftBrackCnt == rightBrackCnt) {
					brackContent = decodeString(s.substring(brackContentStart, i));
					while (contentCnt-- > 0) {
						result.append(brackContent);
					}
					leftBrackCnt = 0;
					rightBrackCnt = 0;
					brackContentStart = 0;
					contentCnt = 0;
				}
			}
		}

		return result.toString();
	}

	// public String decodeString(String s) {
	// Stack<Integer> count = new Stack<>();
	// Stack<String> result = new Stack<>();
	// int i = 0;
	// result.push("");
	// while (i < s.length()) {
	// char ch = s.charAt(i);
	// if (ch >= '0' && ch <= '9') {
	// int start = i;
	// while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
	// count.push(Integer.parseInt(s.substring(start, i + 1)));
	// } else if (ch == '[') {
	// result.push("");
	// } else if (ch == ']') {
	// String str = result.pop();
	// StringBuilder sb = new StringBuilder();
	// int times = count.pop();
	// for (int j = 0; j < times; j += 1) {
	// sb.append(str);
	// }
	// result.push(result.pop() + sb.toString());
	// } else {
	// result.push(result.pop() + ch);
	// }
	// i += 1;
	// }
	// return result.pop();
	// }
	private boolean isDigit(char c) {

		return c - '0' >= 0 && c - '9' <= 0;
	}

	/*
	 * 9:00am 0719 started
	 *
	 * 9:10am draft done. 9:10am 1pass
	 * 
	 * 9:29am recursive solution 9:30am draft done. 9:31am 1pass
	 */
	public TreeNode invertTree(TreeNode root) {
		// if(root == null) return root;
		// TreeNode n, m;
		// Stack<TreeNode> stack = new Stack<>();
		// stack.push(root);
		//
		// while(!stack.isEmpty()){
		// n = stack.pop();
		// m = n.left;
		// n.left = n.right;
		// n.right = m;
		// if(n.left != null) stack.push(n.left);
		// if(n.right!= null) stack.push(n.right);
		// }
		//
		// return root;
		if (root == null)
			return root;

		root.left = invertTree(root.right);
		root.right = invertTree(root.left);

		return root;
	}

	/*
	 * 2:14pm 0719 started
	 *
	 * use divide and conquer, divide the strings into substrings with the same size
	 * as s1, then compare. if substrings do not have s1 slide through the center
	 * and compare. the way to compare is to sort the strings and then compare the
	 * sorted strings. 3:00pm draft done.
	 */
	public boolean checkInclusion(String s1, String s2) {
		return checkInclusion(s1, s2, 0, s2.length() - 1);
	}

	public boolean checkInclusion(String s1, String s2, int low, int high) {
		if (s1 == null || s2 == null || s1.length() > (high - low + 1))
			return false;

		if (low > high || low < 0 || high < 0)
			return false;

		int mid = (high + low) / 2;
		int len = high - low + 1;
		int innerHigh = 0;
		char[] cs1, cs2;
		boolean foundInLower, foundInHigher;

		if (s1.length() == len) {
			cs1 = s1.toCharArray();
			cs2 = s2.substring(low, high + 1).toCharArray();
			Arrays.sort(cs1);
			Arrays.sort(cs2);
			return String.valueOf(cs1).equals(String.valueOf(cs2));
		} else {
			foundInLower = checkInclusion(s1, s2, low, mid);
			if (foundInLower) {
				return true;
			} else {
				foundInHigher = checkInclusion(s1, s2, mid + 1, high);
				if (foundInHigher) {
					return true;
				} else {
					for (int i = 0; i <= s1.length(); i++) {
						innerHigh = s1.length() + mid - i - 1;
						if (mid - i >= low && innerHigh <= high && innerHigh >= mid) {
							if (checkInclusion(s1, s2, mid - i, innerHigh)) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	/*
	 * 3:33pm 0719 started
	 *
	 * 3:36pm draft done. 3:37pm 1pass
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return t1;
		if (t1 == null && t2 != null)
			return t2;
		if (t1 != null && t2 == null)
			return t1;

		TreeNode newNode = new TreeNode(t1.val + t2.val);
		TreeNode leftMerged = mergeTrees(t1.left, t2.left);
		TreeNode rightMerged = mergeTrees(t1.right, t2.right);

		newNode.left = leftMerged;
		newNode.right = rightMerged;

		return newNode;
	}

	/*
	 * 4:11pm 0719 started
	 *
	 * all i need to know is if its subtree has a zero node.
	 *
	 * 4:28pm draft done. 4:29pm after fixing several bugs passed. #TODO for the
	 * if/else if sequence, the last else if should be else, otherwise you get
	 * compiler problems.
	 */
	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return root;
		boolean noLeft = subTreeHasNoOne(root.left), noRight = subTreeHasNoOne(root.right);
		TreeNode newLeft, newRight;

		if (noLeft && noRight) {
			root.left = null;
			root.right = null;
			if (root.val == 1)
				return root;
			return null;
		} else if (!noLeft && noRight) {
			newLeft = pruneTree(root.left);
			root.left = newLeft;
			root.right = null;
			return root;
		} else if (noLeft && !noRight) {
			newRight = pruneTree(root.right);
			root.left = null;
			root.right = newRight;
			return root;
		} else {
			newLeft = pruneTree(root.left);
			newRight = pruneTree(root.right);
			root.left = newLeft;
			root.right = newRight;
			return root;
		}

		// Official solution:
		// if (root.left != null) {
		// root.left = pruneTree(root.left);
		// }
		// if (root.right != null) {
		// root.right = pruneTree(root.right);
		// }
		// if (root.left == null & root.right == null) {
		// if (root.val == 0) {
		// return null;
		// } else {
		// return root;
		// }
		// }
		// return root;

		// #TODO the official solution reminds me that many tree problems should be
		// reduced to DFS, thinking the whole
		// tree as a single node.
	}

	public boolean subTreeHasNoOne(TreeNode root) {
		if (root == null)
			return true;
		if (root.val == 1)
			return false;
		return root.val == 0 && subTreeHasNoOne(root.left) && subTreeHasNoOne(root.right);
	}

	/*
	 * 4:50pm 0719 started 5:05pm draft done 5:26pm check done. 9:41pm perhaps we
	 * should use a dummy head.
	 */

	class MyLinkedList {

		Node2 head;
		Node2 tail;
		int len;

		/** Initialize your data structure here. */
		public MyLinkedList() {
			head = tail = null;
			len = 0;
		}

		/**
		 * Get the value of the index-th node in the linked list. If the index is
		 * invalid, return -1.
		 */
		public int get(int index) {

			if (index == len - 1) {
				return tail.val;
			}

			if (index < len) {
				for (int i = 0; i < index; i++)
					head = head.next;
				return head.val;
			}

			return -1;
		}

		/**
		 * Add a node of value val before the first element of the linked list. After
		 * the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			Node2 newNode = new Node2(val);
			if (len == 0) {
				head = tail = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}

			len++;
		}

		/** Append a node of value val to the last element of the linked list. */
		public void addAtTail(int val) {
			Node2 newNode = new Node2(val);

			if (len == 0) {
				head = newNode;
			} else {
				tail.next = newNode;
			}

			tail = newNode;
			len++;
		}

		/**
		 * Add a node of value val before the index-th node in the linked list. If index
		 * equals to the length of linked list, the node will be appended to the end of
		 * linked list. If index is greater than the length, the node will not be
		 * inserted.
		 */
		public void addAtIndex(int index, int val) {
			if (index == len) {
				addAtTail(val);
			} else {
				Node2 pos = head, posNext = head;
				for (int i = 0; i < index - 1; i++) {
					pos = pos.next;
					posNext = posNext.next;
				}
				posNext = posNext.next;
				pos.next = new Node2(val);
				pos.next.next = posNext;
				len++;
			}
		}

		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			Node2 pos, t;
			if (index < len) {
				if (index == 0) {
					t = head;
					head = head.next;
					t.next = null;
				} else {
					pos = head;
					for (int i = 0; i < index - 1; i++) {
						pos = pos.next;
					}
					t = pos.next;
					pos.next = t.next;
					t.next = null;
				}

				len--;
			}
		}
	}

	class Node2 {
		int val;
		Node2 next;

		public Node2(int val) {
			this.val = val;
			next = null;
		}

	}

	/*
	 * 9:55pm 0719 started 10:09pm draft done first let's try the brutal force
	 * 10:17pm algorithm failed.
	 */
	public boolean checkPossibility(int[] nums) {
		if (nums == null)
			return false;
		if (nums.length < 3)
			return true;

		int m = 0, n = 0;
		for (int i = 0; i < nums.length; i++) {

			while ((i + m + 1) < nums.length && nums[i + m] > nums[i + m + 1]) {
				m++;
			}
			if (m > 1)
				return false;
			else if (m == 1) {
				n++;
				if (i + m + 1 < nums.length) {
					if (nums[i] > nums[i + 2] && i > 0)
						return false;
				}
			}
			m = 0;
		}

		if (n > 1)
			return false;

		return true;
	}

	/*
	 * 9:32pm 0721 started 9:49pm done reverseList 9:53pm reverseList copied
	 * previous solution 10:10pm draft done. 10:19pm 1pass.
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1)
			return head;
		ListNode mark, prevTail, groupHead, result, p;

		int m = k;
		mark = head;
		groupHead = mark;
		while (mark != null && --m > 0) {
			mark = mark.next;
		}
		if (mark == null)
			return head;

		prevTail = mark;
		mark = mark.next;
		prevTail.next = null;
		result = new ListNode(-1);
		p = reverseList(groupHead);
		result.next = p;

		while (p.next != null)
			p = p.next;

		p.next = reverseKGroup(mark, k);

		return result.next;

	}

	/*
	 * 10:43pm 0721 started 10:45pm done 10:46pm 1pass
	 * 
	 * #TODO the key is thkning of trees as nodes. the operation is on each node.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q != null)
			return false;
		if (p != null && q == null)
			return false;
		if (p == null && q == null)
			return true;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	/*
	 * 06:00pm 0722 started 6:14pm draft done 6:17pm 1pass after fixing 2 typos.
	 */
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> l = toList(head);
		return sortedArrayToBST(l, 0, l.size());
	}

	public TreeNode sortedArrayToBST(List<Integer> arr, int start, int exclusiveEnd) {
		if (start < 0 || exclusiveEnd < 0 || start >= exclusiveEnd || start >= arr.size())
			return null;
		if (start == exclusiveEnd - 1)
			return new TreeNode(arr.get(start));

		int mid = (exclusiveEnd - 1 + start) / 2;

		TreeNode newHead = new TreeNode(arr.get(mid));
		newHead.left = sortedArrayToBST(arr, start, mid);
		newHead.right = sortedArrayToBST(arr, mid + 1, exclusiveEnd);

		return newHead;
	}

	public List<Integer> toList(ListNode head) {
		List<Integer> result = new ArrayList<>();

		while (head != null) {
			result.add(head.val);
			head = head.next;
		}

		return result;
	}

	/*
	 * 4:02pm 0723 started use two needles. and use recursion. 4:09pm draft done.
	 * 4:12pm 1pass
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		if (head.val == val)
			return removeElements(head.next, val);

		ListNode preMark = head, nextMark = head;

		while (nextMark.next != null && nextMark.next.val != val) {
			nextMark = nextMark.next;
		}

		if (nextMark.next == null)
			return head;

		preMark = nextMark;
		nextMark = nextMark.next;

		preMark.next = removeElements(nextMark, val);

		return head;
	}

	/*
	 * 9:12am 0724 started
	 *
	 * 9:34am pause 9:46am resume 10:22am draft done 10:25am failed 1st test case.
	 */
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "null";
		Stack<WrapperNode> nextVert = new Stack<>();
		Stack<WrapperNode> currVert = new Stack<>();
		StringBuilder result = new StringBuilder();
		currVert.push(new WrapperNode(root));

		while (!currVert.isEmpty()) {
			while (!currVert.isEmpty()) {
				WrapperNode node = currVert.pop();
				if (node.isNull) {
					result.append("null,");
				} else {
					result.append(node.node.val);
					if (!currVert.isEmpty()) {
						result.append(',');
					}
					nextVert.push(new WrapperNode(node.node.right));
					nextVert.push(new WrapperNode(node.node.left));
				}
			}
			currVert.addAll(nextVert);
			nextVert.clear();
		}

		return result.toString();
	}

	private class WrapperNode {
		boolean isNull;
		TreeNode node;

		public WrapperNode(TreeNode node) {
			this.node = node;
			if (node == null)
				this.isNull = true;
			else
				this.isNull = false;
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty())
			return null;

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> nextVert = new Stack<>();
		Stack<String> nextLevel = new Stack<>();
		String[] nodes = data.split(",");
		if (nodes.length < 1)
			return null;
		TreeNode head = new TreeNode(Integer.valueOf(nodes[0]));
		if (nodes.length == 1)
			return head;
		int lastEleInd = 0, t = 0, nextLevelEleCnt = 2;

		stack.push(head);

		while (!stack.isEmpty()) {
			t = nextLevelEleCnt;
			while (nextLevelEleCnt > lastEleInd) {
				nextLevel.push(nodes[nextLevelEleCnt--]);
			}
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				String nVal = nextLevel.pop();
				if (nVal.equals("null")) {
					node.left = null;
				} else {
					node.left = new TreeNode(Integer.valueOf(nVal));
				}

				nVal = nextLevel.pop();
				if (nVal.equals("null")) {
					node.right = null;
				} else {
					node.right = new TreeNode(Integer.valueOf(nVal));
				}

				if (node.right != null) {
					nextVert.push(node.right);
				}
				if (node.left != null) {
					nextVert.push(node.left);
				}
			}
			lastEleInd = t;
			nextLevelEleCnt = lastEleInd + 2 * nextVert.size();
			stack.addAll(nextVert);
			nextVert.clear();
		}

		return head;
	}

	/*
	 * 4:59pm 0724 started
	 *
	 * #TODO if the location does not matter, only record/track the value
	 *
	 */
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		boolean rightIncreasing = false;
		// for(int i = 1; i < nums.length; i++){
		// if(nums[i-1])
		// }
	}

	public String toBinary(int x) {

		return Integer.toBinaryString(x);
	}

	/*
	 * 2:48pm 0725 started recursion, following the destructuring idea of the cci
	 * book
	 *
	 * 3:18pm draft done 3:45pm passed after fixing several times.
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] nums = candidates;

		if (nums == null)
			return result;

		// Make it increasing
		Arrays.sort(nums);

		return combinationSum_helper(nums, target, nums.length - 1);
	}

	public List<List<Integer>> combinationSum_helper(int[] nums, int target, int lastCandidateIndex) {
		List<List<Integer>> result = new ArrayList<>(), r;
		if (nums == null || lastCandidateIndex < 0 || target == 0)
			return result;

		int currSum = 0;
		int cnt = 0;
		List<Integer> tt;

		while (currSum <= target) {
			r = combinationSum_helper(nums, target - currSum, lastCandidateIndex - 1);
			if (r.size() > 0) {
				for (List<Integer> t : r) {
					tt = new ArrayList<>(t);
					for (int i = 0; i < cnt; i++) {
						tt.add(nums[lastCandidateIndex]);
					}
					result.add(tt);
				}
			}

			currSum += nums[lastCandidateIndex];
			cnt++;
			if (currSum == target) {
				tt = new ArrayList<>();
				for (int i = 0; i < cnt; i++) {
					tt.add(nums[lastCandidateIndex]);
				}
				result.add(tt);
			}
		}

		return result;
	}

	/*
	 * 4:13pm 0725 started 4:19pm draft done. 4:28pm time limit excedded.
	 *
	 *
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null)
			return new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		return combinationSum2_helper(candidates, target, candidates.length - 1);
	}

	public List<List<Integer>> combinationSum2_helper(int[] candidates, int target, int lastCandidateIndex) {
		int[] nums = candidates;
		List<List<Integer>> result = new ArrayList<List<Integer>>(), r;
		List<Integer> t;
		if (target == 0 || lastCandidateIndex < 0)
			return result;
		int firstUnique = lastCandidateIndex;

		while (firstUnique >= 0 && nums[firstUnique] == nums[lastCandidateIndex]) {

			firstUnique--;

		}

		r = combinationSum2_helper(candidates, target, firstUnique);
		result.addAll(r);

		r = combinationSum2_helper(candidates, target - nums[lastCandidateIndex], lastCandidateIndex - 1);
		if (r.size() > 0) {
			for (List<Integer> rr : r) {
				t = new ArrayList<Integer>(rr);
				t.add(nums[lastCandidateIndex]);
				result.add(t);
			}
		}

		if (nums[lastCandidateIndex] == target) {
			t = new ArrayList<Integer>();
			t.add(nums[lastCandidateIndex]);
			result.add(t);
		}

		return result;
	}

	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int begin = 0, end = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			end++;

			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (end - begin == t.length()) {
					result.add(begin);
				}
				begin++;
			}

		}
		return result;
	}

	public static void print(Object o) {
		System.out.println(o);
	}

	public static void exit() {
		System.exit(0);
	}

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0, counter = 0, d = 0;

		while (end < s.length()) {
			// > 0 means repeating character
			// if(map[s.charAt(end++)]-- > 0) counter++;
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1)
				counter++;
			end++;

			while (counter > 0) {
				// if (map[s.charAt(begin++)]-- > 1) counter--;
				char charTemp = s.charAt(begin);
				if (map.get(charTemp) > 1)
					counter--;
				map.put(charTemp, map.get(charTemp) - 1);
				begin++;
			}
			d = Math.max(d, end - begin);
		}
		return d;
	}

	/*
	 * 9:37pm 0726 can try mergesort. 10:12pm draft done.
	 */
	public ListNode sortList(ListNode head) {
		if (head == null)
			return head;

		int len = 0;
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
			len++;
		}

		return sortList_divide(head, 0, len);
	}

	public ListNode sortList_divide(ListNode head, int low, int ehigh) {
		if (head == null)
			return head;

		int len = ehigh - low;
		int mid = (ehigh - 1 + low) / 2;
		int l = low, h = ehigh - 1;
		ListNode pLow = head, pMid;

		if (len == 1)
			return pLow;

		while (l-- >= 0 && pLow != null) {
			pLow = pLow.next;
		}

		pMid = pLow;

		while (h-- >= mid && pMid != null) {
			pMid = pMid.next;
		}

		ListNode left = sortList_divide(pLow, 0, mid - low);
		ListNode right = sortList_divide(pMid, 0, ehigh - mid);
		return sortList_merge(left, right);
	}

	public ListNode sortList_merge(ListNode left, ListNode right) {
		ListNode pl = left, pr = right, tl, tr;
		while (pl != null && pr != null) {
			tl = pl.next;
			tr = pr.next;
			if (tl == null || tl.next == null)
				break;
			if (pl.val <= pr.val) {
				pl.next = pr;
				pr.next = tl;
				tl.next = tr;
				pl = tl;
				pr = tr;
			} else {
				pr.next = pl;
				tl.next = tr;
			}
		}

		return left;
	}

	public ListNode getList(int[] nums) {
		if (nums == null || nums.length < 1)
			return null;

		ListNode result = new ListNode(-1), p = new ListNode(nums[0]);
		result.next = p;
		for (int n : nums) {
			p.next = new ListNode(n);
			p = p.next;
		}

		return result.next;

	}

	public void swamp(List<Integer> l) {
		l.add(-1);
	}

	public void swamp(int[] A) {
		A[0] = -1;
	}

	public void printListNode(ListNode head) {
		ListNode p = head;
		StringBuilder buff = new StringBuilder();
		while (p != null) {
			buff.append(p.val);
			buff.append(", ");
			p = p.next;
		}
		System.out.println(buff.toString());
	}

	// #TODO inplace java merge sort:
	// https://github.com/bakeraj4/In-Place-Merge-Sort/blob/master/mergeMain.java
	public void sortIntegers2(int[] A) {
		if (A == null || A.length < 2)
			return;

		sortIntegers2_divide(A, 0, A.length);
	}

	public void sortIntegers2_divide(int[] A, int start, int eEnd) {
		int l = start, h = eEnd, mid = (h - 1 + l) / 2;

		if (h - l < 2)
			return;
		else if (h - l == 2) {
			if (A[l] > A[h - 1]) {
				mid = A[l];
				A[l] = A[h - 1];
				A[h - 1] = mid;
			}
			return;
		}

		sortIntegers2_divide(A, start, mid);
		sortIntegers2_divide(A, mid, eEnd);
		sortIntegers2_merge(A, start, mid, mid);
	}

	public void sortIntegers2_merge(int[] A, int ls, int mid, int rs) {
		int _ls = ls, _lee = mid, _rs = rs, t = 0, i = 0;

		while (_ls + i <= _lee) {
			if (A[_ls + i] > A[_rs + i]) {
				t = A[_ls + i];
				A[_ls + i] = A[_rs + i];
				A[_rs + i] = t;
			}
			i++;
		}
	}

	/*
	 * 11:12am 0727 started bfs, then reverse the list. #TODO DO NOT USE STACK, USE
	 * QUEUE
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> currVert = new LinkedList<>();
		Queue<TreeNode> nextVert = new LinkedList<>();

		if (root == null)
			return result;

		currVert.add(root);

		while (!currVert.isEmpty()) {
			List<Integer> r = new ArrayList<>();
			while (!currVert.isEmpty()) {
				TreeNode n = currVert.poll();
				r.add(n.val);
				if (n.left != null)
					nextVert.add(n.left);
				if (n.right != null)
					nextVert.add(n.right);

			}

			result.add(r);
			currVert.addAll(nextVert);
			nextVert.clear();
		}

		Collections.reverse(result);

		return result;
	}

	/*
	 * 11:31AM 0727 BFS 11:37am draft done 11:39am pass after changing sum to
	 * double. #TODO it is safer to use double for sum for average.
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		double sum = 0, cnt = 0;
		Queue<TreeNode> currVert = new LinkedList<>();
		Queue<TreeNode> nextVert = new LinkedList<>();

		if (root == null)
			return result;

		currVert.add(root);

		while (!currVert.isEmpty()) {
			sum = 0;
			cnt = currVert.size();
			while (!currVert.isEmpty()) {
				TreeNode n = currVert.poll();
				sum += n.val;
				if (n.left != null)
					nextVert.add(n.left);
				if (n.right != null)
					nextVert.add(n.right);
			}
			result.add(sum / cnt);
			currVert.addAll(nextVert);
			nextVert.clear();
		}

		return result;

	}

	/*
	 * 2:16pm 0727 so, recursion is also related to bfs. 2:25pm
	 */
	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> emap = new HashMap<>();

		for (Employee e : employees) {
			emap.put(e.id, e);
		}

		return getImportance(emap, id);
	}

	public int getImportance(Map<Integer, Employee> emap, int id) {

		Employee e = emap.get(id);
		if (e == null)
			return 0;
		int score = e.importance;
		for (Integer ee : e.subordinates) {
			score += getImportance(emap, ee);
		}

		return score;
	}

	/*
	 * 2:40pm 0727 bfs and recursion 2:43pm draft done
	 */
	public int maxDepth(Node root) {
		int d = 0, cnt = 0;
		Queue<Node> q = new LinkedList<>();

		if (root == null)
			return d;

		q.add(root);

		while (!q.isEmpty()) {
			d++;
			cnt = q.size();
			for (int i = 0; i < cnt; i++) {
				Node n = q.poll();
				for (Node nn : n.children) {
					// System.out.println("added: "+nn.val);
					q.add(nn);
				}
			}
		}

		return d;
	}

	/*
	 * 2:40pm 0727 bfs and recursion 2:43pm draft done
	 */
	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		int max = 0;
		for (Node n : root.children) {
			max = Math.max(maxDepth(n), max);
		}
		return max + 1;
	}

	public int kSimilarity(String A, String B) {
		String s1 = A, s2 = B;
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return 0;
		if (s1.length() == 1 && s1.equals(s2))
			return 0;

		Map<String, Integer> sols = new HashMap<String, Integer>();

		return kSimilarity(sols, s1, s2);
	}

	public int kSimilarity(Map<String, Integer> sols, String s1, String s2) {
		Integer s = sols.get(s1);
		if (s != null && s > -1) {
			return s;
		}

		if (s == null) {
			sols.put(s1, -1);
		} else {
			return -1;
		}

		if (s1.equals(s2)) {
			sols.put(s1, 0);
			return 0;
		}

		int k = Integer.MAX_VALUE, kk;
		char[] cs;
		for (int j = 0; j < s1.length(); j++)
			for (int i = j + 1; i < s1.length(); i++) {

				cs = s1.toCharArray();
				swap(cs, j, i);
				kk = kSimilarity(sols, String.valueOf(cs), s2);
				if (kk >= 0) {
					k = Math.min(k, kk);
				}
			}
		System.out.println("reached?");
		sols.put(s1, k + 1);
		return k + 1;
	}

	public void swap(char[] cs, int i, int j) {
		char t = cs[i];
		cs[i] = cs[j];
		cs[j] = t;
	}

	public void swapTailHead(char[] cs) {
		char t = cs[0];
		cs[0] = cs[cs.length - 1];
		cs[cs.length - 1] = t;
	}

	/*
	 * 08:34pm 0727 revisit can try bfs with memory.
	 *
	 * 8:51pm draft done. 9:02pm onepass # TODO need to study carefully the
	 * knackpack problem to figure out the faster DP solution it seems this BFS
	 * algorithm is a general solution, but not fast enough. DP is much more faster
	 * but does not have this general strucuture.
	 * 
	 * #TODO this solution can be furtuer optimized by pruning unncessary branches.
	 */
	public int numSquares2(int n) {

		int numLen = 1;
		while (numLen * numLen < n)
			numLen++;

		if (numLen * numLen > n)
			numLen--;

		int[] nums = new int[numLen];

		for (int i = numLen - 1; i >= 0; i--) {
			nums[numLen - i - 1] = (i + 1) * (i + 1);
		}

		Map<Integer, Integer> ways = new HashMap<>();
		ways.put(1, 1);
		ways.put(0, 0);

		return numSquares2(ways, nums, n);
	}

	public int numSquares2(Map<Integer, Integer> ways, int[] nums, int n) {
		if (ways.containsKey(n))
			return ways.get(n);

		int min = Integer.MAX_VALUE, way = 0;
		for (int i = 0; i < nums.length; i++) {
			if (n - nums[i] >= 0) {
				way = numSquares2(ways, nums, n - nums[i]);
				min = Math.min(min, way);
			}
		}

		min++;
		ways.put(n, min);

		return min;
	}

	/*
	 * 09:56pm 0728 bfs, #TODO backtracking ? faster than bfs? 4:45pm 0729 resume
	 * 5:14pm draft done 8:48pm failed. # the key is how to mark the visited state:
	 * location + number of keys. not just locations
	 */
	public int shortestPathAllKeys(String[] grid) {
		List<Character> keys = new ArrayList<>();
		char[][] grids = parseGridAndKeys(grid, keys);
		Pair2 start = findStartingPoint(grids);
		return shortestPathAllKeys(grids, start.x, start.y, keys, new ArrayList<Character>(), keys.size());
	}

	public int shortestPathAllKeys(char[][] grid, int x, int y, List<Character> keys, List<Character> keysSoFar,
			int keysToGet) {
		if (keysToGet == 0)
			return 0;
		if (x < 0 || y < 0 || x == grid[0].length || y == grid.length || grid[y][x] == '#' || grid[y][x] == 'v')
			return -1;

		// if it is a lock, we must already have the key
		switch (grid[y][x]) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
			if (!keysSoFar.contains(Character.toLowerCase(grid[y][x]))) {
				return -1;
			}
		}

		// it is a key, grab it and continue
		if (keys.contains(grid[y][x])) {
			keysToGet--;
			keysSoFar.add(grid[y][x]);
			// goal is done.
			if (keysToGet == 0)
				return 0;
		}

		int min = Integer.MAX_VALUE, steps;
		grid[y][x] = 'v';
		steps = shortestPathAllKeys(grid, x, y - 1, keys, keysSoFar, keysToGet);
		if (steps >= 0) {
			min = Math.min(min, steps);
		}
		steps = shortestPathAllKeys(grid, x + 1, y, keys, keysSoFar, keysToGet);
		if (steps >= 0) {
			min = Math.min(min, steps);
		}
		steps = shortestPathAllKeys(grid, x - 1, y, keys, keysSoFar, keysToGet);
		if (steps >= 0) {
			min = Math.min(min, steps);
		}
		steps = shortestPathAllKeys(grid, x, y + 1, keys, keysSoFar, keysToGet);
		if (steps >= 0) {
			min = Math.min(min, steps);
		}

		if (min == Integer.MAX_VALUE)
			return -1;

		return min + 1;
	}

	public char[][] parseGridAndKeys(String[] grid, List<Character> keys) {
		char[][] result = new char[grid.length][grid[0].length()];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				result[i][j] = grid[i].charAt(j);
				switch (grid[i].charAt(j)) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
					keys.add(grid[i].charAt(j));
				}
			}
		}

		return result;
	}

	public Pair2 findStartingPoint(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '@') {
					return new Pair2(i, j);
				}
			}
		}

		return null;
	}

	private class Pair2 {
		int x;
		int y;

		public Pair2(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public String largestNumber1(int[] nums) {
		if (nums == null || nums.length < 1)
			return "";

		List<Integer> nn = new ArrayList<>();
		for (int n : nums)
			nn.add(n);
		Collections.sort(nn, new numSort());

		StringBuilder result = new StringBuilder();
		for (int i = nn.size() - 1; i >= 0; i--) {
			result.append(nn.get(i));
		}

		return result.toString();
	}

	/*
	 * 10:31am 0730 started 10:50am draft done
	 *
	 */
	public String addBinary(String a, String b) {
		if (a == null && b == null)
			return "";
		if (a != null && b == null)
			return a;
		if (a == null && b != null)
			return b;

		List<Integer> ac = stringToIntList(a);
		List<Integer> bc = stringToIntList(b);
		StringBuilder result = new StringBuilder();

		int carry = 0, sum = 0;
		int len = ac.size() > bc.size() ? ac.size() : bc.size();

		for (int i = 0; i < len; i++) {
			if (i < ac.size() && i < bc.size()) {
				sum = ac.get(i) + bc.get(i) + carry;
				result.append(sum % 2);
				carry = sum / 2;
			} else if (i < ac.size()) {
				sum = ac.get(i) + carry;
				result.append(sum % 2);
				carry = sum / 2;
			} else if (i < bc.size()) {
				sum = bc.get(i) + carry;
				result.append(sum % 2);
				carry = sum / 2;
			}
		}

		if (carry == 1) {
			result.append(carry);
		}

		return result.reverse().toString();
	}

	public List<Integer> stringToIntList(String a) {
		List<Integer> r = new ArrayList<>();
		for (int i = a.length() - 1; i >= 0; i--) {
			r.add(a.charAt(i) - '0');
		}

		return r;
	}

	/*
	 * 1:34pm 0730 started recursive, check for 6 special cases 1:47pm draft done.
	 * 1:59pm 1pass
	 */
	public int romanToInt(String s) {
		if (s == null || s.isEmpty())
			return 0;

		if (s.length() < 2)
			return getValue(s.substring(0));
		switch (s.charAt(0)) {
		case 'I':
			switch (s.charAt(1)) {
			case 'V':
				return 4 + romanToInt(s.substring(2));
			case 'X':
				return 9 + romanToInt(s.substring(2));
			default:
				return 1 + romanToInt(s.substring(1));
			}
		case 'X':
			switch (s.charAt(1)) {
			case 'L':
				return 40 + romanToInt(s.substring(2));
			case 'C':
				return 90 + romanToInt(s.substring(2));
			default:
				return 10 + romanToInt(s.substring(1));
			}
		case 'C':
			switch (s.charAt(1)) {
			case 'D':
				return 400 + romanToInt(s.substring(2));
			case 'M':
				return 900 + romanToInt(s.substring(2));
			default:
				return 100 + romanToInt(s.substring(1));
			}
		default:
			return getValue(s.substring(0, 1)) + romanToInt(s.substring(1));
		}
	}

	public int getValue(String s) {
		if (s.equals("I")) {
			return 1;
		}
		if (s.equals("V")) {
			return 5;
		}
		if (s.equals("X")) {
			return 10;
		}
		if (s.equals("L")) {
			return 50;
		}
		if (s.equals("C")) {
			return 100;
		}
		if (s.equals("D")) {
			return 500;
		}
		if (s.equals("M")) {
			return 1000;
		}

		return 0;
	}

	/*
	 * 1:58pm 0730 started first, try the brutal force or bfs. 2:05pm draft done.
	 */
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null)
			return 0;

		return minCostClimbingStairs(cost, 0, 0);
	}

	public int minCostClimbingStairs(int[] cost, int start, int costSoFar) {
		if (start > cost.length - 1)
			return costSoFar;
		if (start == cost.length - 1)
			return costSoFar + cost[start];

		int cost1, cost2;

		cost1 = minCostClimbingStairs(cost, start + 1, costSoFar + cost[start]);
		cost2 = minCostClimbingStairs(cost, start + 2, costSoFar + cost[start]);
		return Math.min(cost1, cost2);
	}

	/*
	 * 1:58pm 0730 started first, try the brutal force or bfs. 2:05pm draft done.
	 * 2:25pm TLE 2:26PM DP 2:47pm 3pass. my brain is nto clear.
	 */
	public int minCostClimbingStairs2(int[] cost) {

		return minCostClimbingStairs_helper(cost);
	}

	public int minCostClimbingStairs_helper(int[] cost) {
		int[] mincost = new int[cost.length + 1];

		mincost[0] = cost[0];
		mincost[1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			mincost[i] = Math.min(mincost[i - 1] + cost[i], mincost[i - 2] + cost[i]);
		}

		return Math.min(mincost[cost.length - 1], mincost[cost.length - 2]);
	}

	/*
	 * 2:50pm 0730 started 1p to head, 1p to end, only switch when it reaches a new
	 * vow. 3:00pm draft done 3:04pm 2pass.
	 */
	public String reverseVowels(String s) {
		if (s == null || s.isEmpty() || s.length() < 2)
			return s;

		int ph = 0, pt = s.length() - 1;
		char t;
		char[] sc = s.toCharArray();
		while (ph < pt) {
			while (ph < s.length()) {
				if (isVow(sc[ph])) {
					break;
				}
				ph++;
			}
			while (pt >= 0) {
				if (isVow(sc[pt])) {
					break;
				}
				pt--;
			}
			if (ph < pt && ph < s.length() && pt >= 0) {
				t = sc[ph];
				sc[ph] = sc[pt];
				sc[pt] = t;
			}
			// bug 1
			ph++;
			pt--;
		}

		return String.valueOf(sc);
	}

	boolean isVow(char c) {
		c = Character.toLowerCase(c);
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		}

		return false;
	}

	/*
	 * 3:16pm 0730 3:36pm draft done. 3:42pm failed. brain not clear.
	 */
	public boolean repeatedSubstringPattern(String s) {
		if (s == null || s.isEmpty())
			return false;
		int len = s.length(), hlen = len / 2;
		if (len == 1)
			return false;

		int i = 1, j = 0, k = 1;
		for (i = 1; i <= hlen; i++) {
			while (i * k < len) {
				char[] sc = s.substring(0, i).toCharArray();

				for (j = 0; j < sc.length && i * k + j < len; j++) {
					if (sc[j] != s.charAt(i * k + j))
						break;
				}

				if (j == sc.length && i * k + j < len) {
					k++;
				} else {
					break;
				}
			}
			if (i * k + j == len) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 3:51pm 0730 started bfs 4:06pm draft done. 4:14pm 2pass.
	 */
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		if (S == null)
			return result;
		int i = 0;
		while (i < S.length()) {
			if (Character.isLetter(S.charAt(i))) {
				break;
			}
			i++;
		}
		if (i == S.length()) {
			result.add(S);
			return result;
		}
		StringBuilder ss = new StringBuilder(S.substring(0, i + 1));
		StringBuilder sss = new StringBuilder(S.substring(0, i));
		if (Character.isLowerCase(S.charAt(i))) {
			sss.append(Character.toUpperCase(S.charAt(i)));
		} else {
			sss.append(Character.toLowerCase(S.charAt(i)));
		}

		List<String> right = letterCasePermutation(S.substring(i + 1));
		if (right.size() > 0) {
			for (String s : right) {

				result.add(ss.toString() + s);
				result.add(sss.toString() + s);
			}
		} else {
			result.add(ss.toString());
			result.add(sss.toString());
		}

		return result;
	}

	/*
	 * 4:40pm 0730 started 4:48pm draft done. 4:51pm failed. #TODO need to finish
	 * the tree searializer to enable debugging.
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Queue<TreeNode> r1 = getLeaves(root1);
		Queue<TreeNode> r2 = getLeaves(root2);

		if (r1.size() != r2.size())
			return false;
		for (int i = 0; i < r1.size(); i++) {
			if (r1.poll().val != r2.poll().val)
				return false;
		}

		return true;
	}

	public Queue<TreeNode> getLeaves(TreeNode root) {
		Queue<TreeNode> result = new LinkedList<>();
		if (root == null)
			return result;

		Queue<TreeNode> verts = new LinkedList<>();
		verts.add(root);

		while (!verts.isEmpty()) {
			int currQSize = verts.size();
			for (int i = 0; i < currQSize; i++) {
				TreeNode n = verts.poll();
				if (n.left == null && n.right == null)
					result.offer(n);
				else if (n.left != null && n.right == null)
					verts.offer(n.left);
				else if (n.left == null && n.right != null)
					verts.offer(n.right);
				else {
					verts.offer(n.left);
					verts.offer(n.right);
				}
			}
		}

		return result;
	}

	/*
	 * 6:15pm 0730 started 6:55pm draft done
	 */
	public String validIPAddress(String IP) {
		boolean isIPV4 = false, isIPV6 = false;
		if (isIPV4Candidate(IP)) {
			isIPV4 = isValidIPV4(IP);
		} else {
			isIPV6 = isValidIPV6(IP);
		}

		if (isIPV4 && !isIPV6) {
			return "IPV4";
		} else if (!isIPV4 && isIPV6) {
			return "IPV6";
		} else {
			return "Neither";
		}
	}

	public boolean isValidIPV4(String IP) {
		if (IP == null || IP.isEmpty())
			return false;
		int dotIndex = IP.indexOf(".");
		if (dotIndex < 0) {
			if (IP.length() > 4)
				return false;
			else {
				dotIndex = IP.length();
			}
		}
		if (dotIndex == 0)
			return false;
		String firstGroup = IP.substring(0, dotIndex);
		int zeroIndex = 0;
		while (firstGroup.charAt(zeroIndex) == '0') {
			zeroIndex++;
			if (zeroIndex == firstGroup.length())
				break;
		}
		if (zeroIndex != 0 && firstGroup.length() > 1)
			return false;

		Integer firstVal = Integer.valueOf(firstGroup);
		if (firstVal < 0 || firstVal > 255)
			return false;
		if (dotIndex == IP.length())
			return true;

		return isValidIPV4(IP.substring(dotIndex + 1));
	}

	public boolean isValidIPV6(String IP) {
		if (IP == null || IP.isEmpty())
			return false;
		int dotIndex = IP.indexOf(":");
		if (dotIndex < 0) {
			if (IP.length() > 4)
				return false;
			else
				dotIndex = IP.length();
		}
		if (dotIndex == 0)
			return false;
		String firstGroup = IP.substring(0, dotIndex);
		int zeroIndex = 0;
		while (firstGroup.charAt(zeroIndex) == '0') {
			zeroIndex++;
			if (zeroIndex == firstGroup.length())
				break;
		}
		if (zeroIndex != 0 && firstGroup.length() > 4)
			return false;
		while (zeroIndex < firstGroup.length()) {
			if (Character.toLowerCase(firstGroup.charAt(zeroIndex++)) - 'f' > 0)
				return false;
		}
		if (dotIndex == IP.length())
			return true;
		return isValidIPV6(IP.substring(dotIndex + 1));
	}

	public boolean isIPV4Candidate(String IP) {
		for (char c : IP.toCharArray()) {
			if (c == ':')
				return false;
		}

		return true;
	}

	/*
	 * 10:00am 0731 started bfs 10:26am draft done 10:40am 134/137 TLE. #TODO for
	 * problems like this, BFS is good, but you can also try dfs. and always use
	 * cache when possible #TODO usually, you can solve using iterative or
	 * recursion, recursion is easier to add cache though.
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null)
			return 0;
		if (matrix.length < 1)
			return 0;
		if (matrix[0].length < 1)
			return 0;

		int max = Integer.MIN_VALUE;
		int[][] cache = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				max = Math.max(max, longestIncreasingPath(matrix, cache, new ArrayList<String>(), i, j));
			}
		}

		return max;
	}

	public int longestIncreasingPath(int[][] matrix, int[][] cache, List<String> visited, int x, int y) {
		if (x < 0 || y < 0 || x >= matrix[0].length || y >= matrix.length)
			return -1;
		if (cache[y][x] > 0)
			return cache[y][x];
		Queue<Pair> nextNodes = new LinkedList<>();

		nextNodes.offer(new Pair(x, y));
		visited.add("-1 -1 " + x + " " + y);
		int qSize = 0, nx = 0, ny = 0, path = 0;
		while (!nextNodes.isEmpty()) {
			qSize = nextNodes.size();
			for (int i = 0; i < qSize; i++) {
				Pair node = nextNodes.poll();
				if (cache[node.y][node.x] > 0) {
					cache[y][x] = cache[node.y][node.x] + path;
					return cache[y][x];
				}
				nx = node.x - 1;
				ny = node.y;
				if (isValidCoord(matrix, visited, node.x, node.y, nx, ny, path)) {
					nextNodes.offer(new Pair(nx, ny));
					visited.add(node.x + " " + node.y + " " + nx + " " + ny + " " + path);
				}
				nx = node.x + 1;
				ny = node.y;
				if (isValidCoord(matrix, visited, node.x, node.y, nx, ny, path)) {
					nextNodes.offer(new Pair(nx, ny));
					visited.add(node.x + " " + node.y + " " + nx + " " + ny + " " + path);
				}
				nx = node.x;
				ny = node.y - 1;
				if (isValidCoord(matrix, visited, node.x, node.y, nx, ny, path)) {
					nextNodes.offer(new Pair(nx, ny));
					visited.add(node.x + " " + node.y + " " + nx + " " + ny + " " + path);
				}
				nx = node.x;
				ny = node.y + 1;
				if (isValidCoord(matrix, visited, node.x, node.y, nx, ny, path)) {
					nextNodes.offer(new Pair(nx, ny));
					visited.add(node.x + " " + node.y + " " + nx + " " + ny + " " + path);
				}
			}
			path++;
		}
		cache[y][x] = path;
		return path;
	}

	public boolean isValidCoord(int[][] matrix, List<String> visited, int x, int y, int nx, int ny, int path) {
		if (x < 0 || y < 0 || x >= matrix[0].length || y >= matrix.length)
			return false;
		if (nx < 0 || ny < 0 || nx >= matrix[0].length || ny >= matrix.length)
			return false;
		if (matrix[ny][nx] <= matrix[y][x])
			return false;

		return !visited.contains(x + " " + y + " " + nx + " " + ny + " " + path);
	}

	/*
	 * 10:55am 0731
	 *
	 * 11:15am draft done. #TODO empty list is considered as a valid palindrome.
	 * #TODO you need to revisit this many times. this is a basic question. #TODO
	 * like how to count the len of the list and how to use it in a while loop.
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		int len = 0;
		ListNode lf = head, p1 = head, p2 = head;
		while (p1 != null && p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
			if (p2 == null)
				break;
			p2 = p2.next;
			len++;
		}
		ListNode rh = reverseList(p1);
		while (len-- > 0) {
			if (lf.val != rh.val)
				return false;
			lf = lf.next;
			rh = rh.next;
		}

		return true;
	}

	/*
	 * 11:30am 0731 started
	 *
	 * divide and conquer 11:36am pause 12:33pm resume 12:44pm draft done 12:50pm
	 * 3pass... good... #TODO can be improved many ways. #TODO this again shows why
	 * basic algorithms like mergeSort are so important.
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists_divide(lists);
	}

	public ListNode mergeKLists_divide(ListNode[] lists) {
		if (lists == null || lists.length < 1)
			return null;
		if (lists.length == 1)
			return lists[0];

		int hl = lists.length / 2, i, j;
		ListNode[] left = new ListNode[hl];
		// bug 2
		ListNode[] right = new ListNode[lists.length - hl];

		for (i = 0; i < hl; i++) {
			left[i] = lists[i];
		}
		// bug 1
		for (j = 0; i + j < lists.length; j++) {
			right[j] = lists[i + j];
		}

		ListNode l = mergeKLists_divide(left);
		ListNode r = mergeKLists_divide(right);
		return mergeKLists_merge(l, r);
	}

	public ListNode mergeKLists_merge(ListNode l, ListNode r) {
		ListNode result = new ListNode(-1), rr = result;
		if (l == null && r == null)
			return null;
		if (l != null && r == null)
			return l;
		if (l == null && r != null)
			return r;
		ListNode p1 = l, p2 = r;

		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				result.next = new ListNode(p1.val);
				result = result.next;
				p1 = p1.next;
			} else if (p1.val > p2.val) {
				result.next = new ListNode(p2.val);
				result = result.next;
				p2 = p2.next;
			} else {
				result.next = new ListNode(p1.val);
				result = result.next;
				result.next = new ListNode(p2.val);
				result = result.next;
				p1 = p1.next;
				p2 = p2.next;
			}
		}

		while (p1 != null) {
			result.next = new ListNode(p1.val);
			result = result.next;
			p1 = p1.next;
		}
		while (p2 != null) {
			result.next = new ListNode(p2.val);
			result = result.next;
			p2 = p2.next;
		}

		return rr.next;
	}

	/*
	 * 3:16pm 0731 started
	 *
	 * 3:39pm draft done. #TODO remember that the get digits usually return things
	 * from the least significant digits. #TODO See how much you can do with bits:
	 * https://bit.ly/2tjkTff
	 */
	public int getSum(int a, int b) {

		List<Integer> aa = getDigits(a);
		List<Integer> bb = getDigits(b);
		List<Integer> ans = new ArrayList<>();

		int carry = 0, i = 0, j = 0, sum = 0;
		while (i < aa.size() && j < bb.size()) {
			if (carry == 0) {
				if (aa.get(i) == 1 && bb.get(i) == 1) {
					sum = 0;
					carry = 1;
				} else {
					sum = aa.get(i) ^ bb.get(i);
					carry = 0;
				}
			} else {
				if (aa.get(i) == 1 && bb.get(i) == 1) {
					sum = 1;
					carry = 1;
				} else if (aa.get(i) == 0 && bb.get(i) == 0) {
					sum = 1;
					carry = 0;
				} else {
					sum = 0;
					carry = 1;
				}
			}
			ans.add(sum);
			i++;
			j++;
		}

		while (i < aa.size()) {
			sum = carry ^ aa.get(i);
			if (carry == 0) {
				carry = 0;
			} else {
				if (aa.get(i) == 0)
					carry = 0;
				else
					carry = 1;
			}
			ans.add(sum);
			i++;
		}
		while (j < bb.size()) {
			sum = carry ^ bb.get(j);
			if (carry == 0) {
				carry = 0;
			} else {
				if (bb.get(i) == 0)
					carry = 0;
				else
					carry = 1;
			}
			ans.add(sum);
			j++;
		}
		// bug 2
		if (carry == 1)
			ans.add(1);
		Collections.reverse(ans);
		int result = 0;
		for (Integer n : ans) {
			result = result * 2 + n;
		}

		return result;
	}

	public List<Integer> getDigits(int a) {
		List<Integer> ans = new ArrayList<>();
		if (a == 0) {
			ans.add(0);
			return ans;
		}
		while (a != 0) {
			ans.add(a & 1);
			a >>>= 1;
		}

		return ans;
	}

	/*
	 * 9:25pm 0731 revisit dfs 9:20am 0801 resume 9:37am draft done. * 10:36am TLE,
	 * but i think this solution is good. #TODO whenver you have rolling arrays, or
	 * signals, flags, always make sure they set AND reset.
	 */
	public void solve(char[][] board) {
		if (board == null || board.length < 1 || board[0].length < 1)
			return;

		int bxLength = board[0].length;
		int byLength = board.length;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		Queue<Pair> q = new LinkedList<>();
		List<Pair> toFlip = new ArrayList<>();
		List<String> visited = new ArrayList<>();
		boolean noFlip = false;
		for (int i = 1; i < bxLength - 1; i++) {
			for (int j = 1; j < byLength - 1; j++) {
				if (board[j][i] == 'O') {
					if (visited.contains(i + " " + j))
						continue;
					// visited.add(i+" "+j);
					q.offer(new Pair(i, j));
					while (!q.isEmpty()) {
						int qSize = q.size();
						for (int m = 0; m < qSize; m++) {
							Pair p = q.poll();
							// System.out.println(p.left + " " + p.right);
							visited.add(p.left + " " + p.right);
							toFlip.add(p);
							for (int n = 0; n < dir.length; n++) {
								int[] di = dir[n];
								int nx = di[0] + p.left;
								int ny = di[1] + p.right;
								if (nx > 0 && nx < bxLength - 1 && ny > 0 && ny < byLength - 1) {
									if (!visited.contains(nx + " " + ny) && board[ny][nx] == 'O') {
										q.offer(new Pair(nx, ny));
									}
								} else {
									// once you hit the boundary, you dead
									if (nx >= 0 && nx <= bxLength - 1 && ny >= 0 && ny <= byLength - 1) {

										if (!visited.contains(nx + " " + ny) && board[ny][nx] == 'O') {
											q.offer(new Pair(nx, ny));
											noFlip = true;
										}

									}

								}
							}
						}
					}
					if (!noFlip) {
						flip(board, toFlip);
					}
					noFlip = false;
					toFlip.clear();
				}

			}
		}
	}

	public void flip(char[][] board, List<Pair> locs) {
		for (Pair p : locs) {
			board[p.right][p.left] = 'X';
		}
	}

	public static void printArray(int[][] row) {
		for (int[] i : row) {
			for (int ii : i) {
				System.out.print(ii);
				System.out.print("\t");
			}
			System.out.println();
		}

	}

	public static void printArray(char[][] row) {
		for (int i = 0; i < row[0].length; i++) {
			for (int j = 0; j < row.length; j++) {
				System.out.print(row[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}

	}
	 /*
   *  3:23pm 0801 started
   *  use cache and use recursion(dfs)
   *  3:54pm draft done.
   */
   public List<List<String>> partition(String s) {
       Map<String, Set<List<String>>> cache = new HashMap<>();
       
       partition(s, cache);
       List<List<String>> ans = new ArrayList<>();
       ans.addAll(cache.get(s));
       return ans;
   }
   
   public  Set<List<String>> partition(String s, Map<String, Set<List<String>>> cache) {
       Set<List<String>> ans = new HashSet<>(), left, right;
       List<String> r;
       if(s == null) return ans;
       if(s.equals("")){
           r = new ArrayList<>();
           r.add("");
           ans.add(r);
           cache.put(s, ans);
           return ans;
       } 
          
       if(cache.containsKey(s)) return cache.get(s);
       if(s.length() == 1){
           r = new ArrayList<>();
           r.add(s);
           ans.add(r);
           cache.put(s, ans);
           return ans;
       }
       for(int i = 1; i < s.length(); i++){
           left  = partition(s.substring(0,i), cache);
           right = partition(s.substring(i), cache);
           for(List<String> ll : left){
               for(List<String> rr : right){
                   if(nonAttachIsGood(ll, rr)){
                       List<String> aa = new ArrayList<>(ll);
                       aa.addAll(rr);
                       ans.add(aa);
                     
                       if(attachIsGood(ll,rr)){
                           StringBuilder ss = new StringBuilder(ll.get(ll.size() - 1));
                           ss.append(rr.get(0));
                           aa = new ArrayList<>(ll);
                           aa.remove(aa.size()-1);
                            List<String> bb = new ArrayList<>(rr);
                           bb.remove(0);
                           aa.add(ss.toString());
                           aa.addAll(bb);
                           ans.add(aa);
                       }
                   }
               }
           }
       }
       
       if(isParlindrome(s)) {
      	 r = new ArrayList<>();
      	 ans.add(r);
       }
       cache.put(s, ans);
       return ans;
   }
   public boolean attachIsGood(List<String> ll, List<String> rr){
       StringBuilder ss = new StringBuilder();
       if(ll.size() > 0) {
      	 ss.append(ll.get(ll.size() - 1));
       }
       if(rr.size() > 0) {
      	 ss.append(rr.get(0));
       }
      
       return  isParlindrome(ss.toString());
   }
          
   public boolean nonAttachIsGood(List<String> ll, List<String> rr){
       for(String l : ll) {
           if(!isParlindrome(l)) return false;
       }
       for(String r : rr){
           if(!isParlindrome(r)) return false;
       }
       return true;
   }
          
   public boolean isParlindrome(String s){
       if(s == null) return false;
       if(s.isEmpty()) return true;
       int i = 0, j = s.length() - 1;
    //   print(s);
       while(i < j){
           if(s.charAt(i) != s.charAt(j)) return false;
           i++;
           j--;
       }
       
       return true;
   }
   
   public String mostCommonWord(String paragraph, String[] banned) {
     if(paragraph == null || paragraph.isEmpty()) return "";
     
     String tl = paragraph.toLowerCase();
     
     String[] toks = tl.split(" ");
     
     Map<String, Integer> cnts = new HashMap<>();
     List<String> doNotCnt = Arrays.asList(banned);
     for(String tok : toks){
         if(doNotCnt.contains(tok)) continue;
         Integer cnt = cnts.get(tok);
         if(cnt == null){
             cnts.put(tok, 1);
         }
         else{
             cnts.put(tok, cnts.get(tok) + 1);
         }
     }
     
     Set<String> words = cnts.keySet();
     
     int max = -1;
     String ans = "";
     for(String w : words){
         System.out.print(w);
         if(cnts.get(w) > max){
             max = cnts.get(w);
             ans = w;
         }
     }
     
     return ans;
 }
   /*
    *    9:47pm 0805 started
    *    dfs
    *
    */
   public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     Queue<Pair> nextVert = new LinkedList<>();
     List<String> visited = new ArrayList<>();
     nextVert.add(new Pair(sr, sc));
     int qSize, nx, ny, oldColor = image[sr][sc];
     int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
     
     while(!nextVert.isEmpty()){
         qSize = nextVert.size();
         for(int i = 0; i < qSize; i++){
             Pair loc = nextVert.poll();
             String coord = loc.left +" "+loc.right;
             visited.add(coord);
             image[loc.left][loc.right] = newColor;
             for(int[] dir : dirs){
                 nx = loc.right+dir[1];
                 ny = loc.left+dir[0];
                 if(nx >= 0 && ny >= 0 && nx < image[0].length && ny < image.length){
                     if(image[ny][nx] == oldColor && !visited.contains(ny + " "+ nx)){
                         nextVert.offer(new Pair(ny, nx));
                     }
                 }
             }
         }
     }
     
     return image;
 }
   
   /*
    * #TODO Binary search!!!!
    */
   public int findFirstLarger(int num, int[] prod, int start, int end){
     int mid, l = start, r = end - 1;
    while( l != r){
        mid = (l + r) / 2;
        if(prod[mid] <= num){
            l = mid + 1;
        }
        else{
            r = mid ;
        }
    }
 return l;
}

 /*
          *    4:50pm 0904 started
          *    spent about 1 hour to finish
*          #enter use the technique similar to level order traversal with bfs
*          #exit whenever you see from left to right, use bfs.
***        #exit whenver you need to use a mapping process, use hashmap.
*/
    private List<List<Integer>> left;
    private List<List<Integer>> right;
    private List<Integer> middle;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        left = new ArrayList<>();
        right = new ArrayList<>();
        middle = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
     
        if(root == null) return ans;
        bfs(root);
     
        for(int i = left.size()-1; i >= 0; i--){
            ans.add(left.get(i));
        }
        
        ans.add(middle);
        ans.addAll(right);
        
        return ans;
    }
    
    public void bfs(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        int qSize = 0, l = 0, r = 0;
        
        while(!q.isEmpty()){
            qSize = q.size();
            for(int i = 0 ; i < qSize; i++){
                Pair p = q.poll();
                l = p.l;
                r = p.r;
                TreeNode n = p.n;
                List<Integer> vl = getList(l, r);
                vl.add(n.val);
                if(n.left != null){
                    if(l > r){
                        q.offer(new Pair(n.left, l+1, r));
                    }
                    else if(l < r){
                        q.offer(new Pair(n.left, l, r-1));
                    }
                    else{
                        q.offer(new Pair(n.left, l+1, r));
                    }
                    
                }
                if(n.right != null){
                    if(l > r){
                       q.offer(new Pair(n.right, l-1, r));
                    }
                    else if(l < r){
                       q.offer(new Pair(n.right, l, r+1));
                    }
                    else{
                        q.offer(new Pair(n.right, l, r+1));
                    }
                }
            }
        }
    }
    
    public class Pair{
        TreeNode n;
        int l;
        int r;
        public Pair(TreeNode node, int L, int R){
            n = node;
            l = L;
            r = R;
        }
    }
    
    public void dfs(TreeNode root, int l, int r){
        if(root == null) return;
         List<Integer> vl = getList(l, r);
        if(l > r){
            dfs(root.left, l+1, r);
            dfs(root.right, l-1, r);
            vl.add(0, root.val);
        }
        else if(l < r){
            dfs(root.left, l, r-1);
            dfs(root.right, l, r+1);
            vl.add(root.val);
        }
        else{
            dfs(root.left, l+1, r);
            dfs(root.right, l, r+1);
             vl.add(root.val);
        }
       
        
    }
    
    List<Integer> getList(int l, int r){
        while(left.size() < l) left.add(new ArrayList<>());
       // System.out.println(l+" "+left.size());
        while(right.size() < r) right.add(new ArrayList<>());
        // System.out.println(l+" "+left.size());
        if(l > r) return left.get(l-1);
        else if(l == r) return middle;
        return right.get(r-1);
    }
   
	public static void main(String[] args) {
		Leall test = new Leall();
		String aa = "a";
		String[] strs3 = { "hit" };
		char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', };
		int[] nums = { 41, 23, 87, 55, 50, 53, 18, 9, 39, 63, 35, 33, 54, 25, 26, 49, 74, 61, 32, 81, 97, 99, 38, 96, 22,
				95, 35, 57, 80, 80, 16, 22, 17, 13, 89, 11, 75, 98, 57, 81, 69, 8, 10, 85, 13, 49, 66, 94, 80, 25, 13, 85, 55,
				12, 87, 50, 28, 96, 80, 43, 10, 24, 88, 52, 16, 92, 61, 28, 26, 78, 28, 28, 16, 1, 56, 31, 47, 85, 27, 30, 85,
				2, 30, 51, 84, 50, 3, 14, 97, 9, 91, 90, 63, 90, 92, 89, 76, 76, 67, 55 };
		int[] nums2 = { 1,2,7,9, 12 };
		int[] nums3 = { -2, -1 };
		int[][] prerequisites = { { 0, 1 } };
		int[][] image = {{0,0,0},{0,0,0}};
		print(test.findFirstLarger(-1, nums2, 0, 5));
		exit();
		Codec tc = new Codec();
		TreeNode t = tc.deserialize("3 2 1");
		Solution s = new Solution();
		print(s.minDiffInBST(t));
		print(t.val);
		printArray(image);
		printArray(test.floodFill(image, 1, 0, 2));
		exit();
		print(test.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", strs3));
		
		print(test.rotateString("abcde", "cdeab"));

		// String[] ga = { "hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot" };
//		String[] ga = { "peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach" };
//		String[] ga = {'slit','bunk','wars','ping','viva','wynn','wows','irks','gang','pool','mock','fort','heel','send','ship','cols','alec','foal','nabs','gaze','giza','mays','dogs','karo','cums','jedi','webb','lend','mire','jose','catt','grow','toss','magi','leis','bead','kara','hoof','than','ires','baas','vein','kari','riga','oars','gags','thug','yawn','wive','view','germ','flab','july','tuck','rory','bean','feed','rhee','jeez','gobs','lath','desk','yoko','cute','zeus','thus','dims','link','dirt','mara','disc','limy','lewd','maud','duly','elsa','hart','rays','rues','camp','lack','okra','tome','math','plug','monk','orly','friz','hogs','yoda','poop','tick','plod','cloy','pees','imps','lead','pope','mall','frey','been','plea','poll','male','teak','soho','glob','bell','mary','hail','scan','yips','like','mull','kory','odor','byte','kaye','word','honk','asks','slid','hopi','toke','gore','flew','tins','mown','oise','hall','vega','sing','fool','boat','bobs','lain','soft','hard','rots','sees','apex','chan','told','woos','unit','scow','gilt','beef','jars','tyre','imus','neon','soap','dabs','rein','ovid','hose','husk','loll','asia','cope','tail','hazy','clad','lash','sags','moll','eddy','fuel','lift','flog','land','sigh','saks','sail','hook','visa','tier','maws','roeg','gila','eyes','noah','hypo','tore','eggs','rove','chap','room','wait','lurk','race','host','dada','lola','gabs','sobs','joel','keck','axed','mead','gust','laid','ends','oort','nose','peer','kept','abet','iran','mick','dead','hags','tens','gown','sick','odis','miro','bill','fawn','sumo','kilt','huge','ores','oran','flag','tost','seth','sift','poet','reds','pips','cape','togo','wale','limn','toll','ploy','inns','snag','hoes','jerk','flux','fido','zane','arab','gamy','raze','lank','hurt','rail','hind','hoot','dogy','away','pest','hoed','pose','lose','pole','alva','dino','kind','clan','dips','soup','veto','edna','damp','gush','amen','wits','pubs','fuzz','cash','pine','trod','gunk','nude','lost','rite','cory','walt','mica','cart','avow','wind','book','leon','life','bang','draw','leek','skis','dram','ripe','mine','urea','tiff','over','gale','weir','defy','norm','tull','whiz','gill','ward','crag','when','mill','firs','sans','flue','reid','ekes','jain','mutt','hems','laps','piss','pall','rowe','prey','cull','knew','size','wets','hurl','wont','suva','girt','prys','prow','warn','naps','gong','thru','livy','boar','sade','amok','vice','slat','emir','jade','karl','loyd','cerf','bess','loss','rums','lats','bode','subs','muss','maim','kits','thin','york','punt','gays','alpo','aids','drag','eras','mats','pyre','clot','step','oath','lout','wary','carp','hums','tang','pout','whip','fled','omar','such','kano','jake','stan','loop','fuss','mini','byrd','exit','fizz','lire','emil','prop','noes','awed','gift','soli','sale','gage','orin','slur','limp','saar','arks','mast','gnat','port','into','geed','pave','awls','cent','cunt','full','dint','hank','mate','coin','tars','scud','veer','coax','bops','uris','loom','shod','crib','lids','drys','fish','edit','dick','erna','else','hahs','alga','moho','wire','fora','tums','ruth','bets','duns','mold','mush','swop','ruby','bolt','nave','kite','ahem','brad','tern','nips','whew','bait','ooze','gino','yuck','drum','shoe','lobe','dusk','cult','paws','anew','dado','nook','half','lams','rich','cato','java','kemp','vain','fees','sham','auks','gish','fire','elam','salt','sour','loth','whit','yogi','shes','scam','yous','lucy','inez','geld','whig','thee','kelp','loaf','harm','tomb','ever','airs','page','laud','stun','paid','goop','cobs','judy','grab','doha','crew','item','fogs','tong','blip','vest','bran','wend','bawl','feel','jets','mixt','tell','dire','devi','milo','deng','yews','weak','mark','doug','fare','rigs','poke','hies','sian','suez','quip','kens','lass','zips','elva','brat','cosy','teri','hull','spun','russ','pupa','weed','pulp','main','grim','hone','cord','barf','olav','gaps','rote','wilt','lars','roll','balm','jana','give','eire','faun','suck','kegs','nita','weer','tush','spry','loge','nays','heir','dope','roar','peep','nags','ates','bane','seas','sign','fred','they','lien','kiev','fops','said','lawn','lind','miff','mass','trig','sins','furl','ruin','sent','cray','maya','clog','puns','silk','axis','grog','jots','dyer','mope','rand','vend','keen','chou','dose','rain','eats','sped','maui','evan','time','todd','skit','lief','sops','outs','moot','faze','biro','gook','fill','oval','skew','veil','born','slob','hyde','twin','eloy','beat','ergs','sure','kobe','eggo','hens','jive','flax','mons','dunk','yest','begs','dial','lodz','burp','pile','much','dock','rene','sago','racy','have','yalu','glow','move','peps','hods','kins','salk','hand','cons','dare','myra','sega','type','mari','pelt','hula','gulf','jugs','flay','fest','spat','toms','zeno','taps','deny','swag','afro','baud','jabs','smut','egos','lara','toes','song','fray','luis','brut','olen','mere','ruff','slum','glad','buds','silt','rued','gelt','hive','teem','ides','sink','ands','wisp','omen','lyre','yuks','curb','loam','darn','liar','pugs','pane','carl','sang','scar','zeds','claw','berg','hits','mile','lite','khan','erik','slug','loon','dena','ruse','talk','tusk','gaol','tads','beds','sock','howe','gave','snob','ahab','part','meir','jell','stir','tels','spit','hash','omit','jinx','lyra','puck','laue','beep','eros','owed','cede','brew','slue','mitt','jest','lynx','wads','gena','dank','volt','gray','pony','veld','bask','fens','argo','work','taxi','afar','boon','lube','pass','lazy','mist','blot','mach','poky','rams','sits','rend','dome','pray','duck','hers','lure','keep','gory','chat','runt','jams','lays','posy','bats','hoff','rock','keri','raul','yves','lama','ramp','vote','jody','pock','gist','sass','iago','coos','rank','lowe','vows','koch','taco','jinn','juno','rape','band','aces','goal','huck','lila','tuft','swan','blab','leda','gems','hide','tack','porn','scum','frat','plum','duds','shad','arms','pare','chin','gain','knee','foot','line','dove','vera','jays','fund','reno','skid','boys','corn','gwyn','sash','weld','ruiz','dior','jess','leaf','pars','cote','zing','scat','nice','dart','only','owls','hike','trey','whys','ding','klan','ross','barb','ants','lean','dopy','hock','tour','grip','aldo','whim','prom','rear','dins','duff','dell','loch','lava','sung','yank','thar','curl','venn','blow','pomp','heat','trap','dali','nets','seen','gash','twig','dads','emmy','rhea','navy','haws','mite','bows','alas','ives','play','soon','doll','chum','ajar','foam','call','puke','kris','wily','came','ales','reef','raid','diet','prod','prut','loot','soar','coed','celt','seam','dray','lump','jags','nods','sole','kink','peso','howl','cost','tsar','uric','sore','woes','sewn','sake','cask','caps','burl','tame','bulk','neva','from','meet','webs','spar','fuck','buoy','wept','west','dual','pica','sold','seed','gads','riff','neck','deed','rudy','drop','vale','flit','romp','peak','jape','jews','fain','dens','hugo','elba','mink','town','clam','feud','fern','dung','newt','mime','deem','inti','gigs','sosa','lope','lard','cara','smug','lego','flex','doth','paar','moon','wren','tale','kant','eels','muck','toga','zens','lops','duet','coil','gall','teal','glib','muir','ails','boer','them','rake','conn','neat','frog','trip','coma','must','mono','lira','craw','sled','wear','toby','reel','hips','nate','pump','mont','died','moss','lair','jibe','oils','pied','hobs','cads','haze','muse','cogs','figs','cues','roes','whet','boru','cozy','amos','tans','news','hake','cots','boas','tutu','wavy','pipe','typo','albs','boom','dyke','wail','woke','ware','rita','fail','slab','owes','jane','rack','hell','lags','mend','mask','hume','wane','acne','team','holy','runs','exes','dole','trim','zola','trek','puma','wacs','veep','yaps','sums','lush','tubs','most','witt','bong','rule','hear','awry','sots','nils','bash','gasp','inch','pens','fies','juts','pate','vine','zulu','this','bare','veal','josh','reek','ours','cowl','club','farm','teat','coat','dish','fore','weft','exam','vlad','floe','beak','lane','ella','warp','goth','ming','pits','rent','tito','wish','amps','says','hawk','ways','punk','nark','cagy','east','paul','bose','solo','teed','text','hews','snip','lips','emit','orgy','icon','tuna','soul','kurd','clod','calk','aunt','bake','copy','acid','duse','kiln','spec','fans','bani','irma','pads','batu','logo','pack','oder','atop','funk','gide','bede','bibs','taut','guns','dana','puff','lyme','flat','lake','june','sets','gull','hops','earn','clip','fell','kama','seal','diaz','cite','chew','cuba','bury','yard','bank','byes','apia','cree','nosh','judo','walk','tape','taro','boot','cods','lade','cong','deft','slim','jeri','rile','park','aeon','fact','slow','goff','cane','earp','tart','does','acts','hope','cant','buts','shin','dude','ergo','mode','gene','lept','chen','beta','eden','pang','saab','fang','whir','cove','perk','fads','rugs','herb','putt','nous','vane','corm','stay','bids','vela','roof','isms','sics','gone','swum','wiry','cram','rink','pert','heap','sikh','dais','cell','peel','nuke','buss','rasp','none','slut','bent','dams','serb','dork','bays','kale','cora','wake','welt','rind','trot','sloe','pity','rout','eves','fats','furs','pogo','beth','hued','edam','iamb','glee','lute','keel','airy','easy','tire','rube','bogy','sine','chop','rood','elbe','mike','garb','jill','gaul','chit','dons','bars','ride','beck','toad','make','head','suds','pike','snot','swat','peed','same','gaza','lent','gait','gael','elks','hang','nerf','rosy','shut','glop','pain','dion','deaf','hero','doer','wost','wage','wash','pats','narc','ions','dice','quay','vied','eons','case','pour','urns','reva','rags','aden','bone','rang','aura','iraq','toot','rome','hals','megs','pond','john','yeps','pawl','warm','bird','tint','jowl','gibe','come','hold','pail','wipe','bike','rips','eery','kent','hims','inks','fink','mott','ices','macy','serf','keys','tarp','cops','sods','feet','tear','benz','buys','colo','boil','sews','enos','watt','pull','brag','cork','save','mint','feat','jamb','rubs','roxy','toys','nosy','yowl','tamp','lobs','foul','doom','sown','pigs','hemp','fame','boor','cube','tops','loco','lads','eyre','alta','aged','flop','pram','lesa','sawn','plow','aral','load','lied','pled','boob','bert','rows','zits','rick','hint','dido','fist','marc','wuss','node','smog','nora','shim','glut','bale','perl','what','tort','meek','brie','bind','cake','psst','dour','jove','tree','chip','stud','thou','mobs','sows','opts','diva','perm','wise','cuds','sols','alan','mild','pure','gail','wins','offs','nile','yelp','minn','tors','tran','homy','sadr','erse','nero','scab','finn','mich','turd','then','poem','noun','oxus','brow','door','saws','eben','wart','wand','rosa','left','lina','cabs','rapt','olin','suet','kalb','mans','dawn','riel','temp','chug','peal','drew','null','hath','many','took','fond','gate','sate','leak','zany','vans','mart','hess','home','long','dirk','bile','lace','moog','axes','zone','fork','duct','rico','rife','deep','tiny','hugh','bilk','waft','swig','pans','with','kern','busy','film','lulu','king','lord','veda','tray','legs','soot','ells','wasp','hunt','earl','ouch','diem','yell','pegs','blvd','polk','soda','zorn','liza','slop','week','kill','rusk','eric','sump','haul','rims','crop','blob','face','bins','read','care','pele','ritz','beau','golf','drip','dike','stab','jibs','hove','junk','hoax','tats','fief','quad','peat','ream','hats','root','flak','grit','clap','pugh','bosh','lock','mute','crow','iced','lisa','bela','fems','oxes','vies','gybe','huff','bull','cuss','sunk','pups','fobs','turf','sect','atom','debt','sane','writ','anon','mayo','aria','seer','thor','brim','gawk','jack','jazz','menu','yolk','surf','libs','lets','bans','toil','open','aced','poor','mess','wham','fran','gina','dote','love','mood','pale','reps','ines','shot','alar','twit','site','dill','yoga','sear','vamp','abel','lieu','cuff','orbs','rose','tank','gape','guam','adar','vole','your','dean','dear','hebe','crab','hump','mole','vase','rode','dash','sera','balk','lela','inca','gaea','bush','loud','pies','aide','blew','mien','side','kerr','ring','tess','prep','rant','lugs','hobo','joke','odds','yule','aida','true','pone','lode','nona','weep','coda','elmo','skim','wink','bras','pier','bung','pets','tabs','ryan','jock','body','sofa','joey','zion','mace','kick','vile','leno','bali','fart','that','redo','ills','jogs','pent','drub','slaw','tide','lena','seep','gyps','wave','amid','fear','ties','flan','wimp','kali','shun','crap','sage','rune','logs','cain','digs','abut','obit','paps','rids','fair','hack','huns','road','caws','curt','jute','fisk','fowl','duty','holt','miss','rude','vito','baal','ural','mann','mind','belt','clem','last','musk','roam','abed','days','bore','fuze','fall','pict','dump','dies','fiat','vent','pork','eyed','docs','rive','spas','rope','ariz','tout','game','jump','blur','anti','lisp','turn','sand','food','moos','hoop','saul','arch','fury','rise','diss','hubs','burs','grid','ilks','suns','flea','soil','lung','want','nola','fins','thud','kidd','juan','heps','nape','rash','burt','bump','tots','brit','mums','bole','shah','tees','skip','limb','umps','ache','arcs','raft','halo','luce','bahs','leta','conk','duos','siva','went','peek','sulk','reap','free','dubs','lang','toto','hasp','ball','rats','nair','myst','wang','snug','nash','laos','ante','opal','tina','pore','bite','haas','myth','yugo','foci','dent','bade','pear','mods','auto','shop','etch','lyly','curs','aron','slew','tyro','sack','wade','clio','gyro','butt','icky','char','itch','halt','gals','yang','tend','pact','bees','suit','puny','hows','nina','brno','oops','lick','sons','kilo','bust','nome','mona','dull','join','hour','papa','stag','bern','wove','lull','slip','laze','roil','alto','bath','buck','alma','anus','evil','dumb','oreo','rare','near','cure','isis','hill','kyle','pace','comb','nits','flip','clop','mort','thea','wall','kiel','judd','coop','dave','very','amie','blah','flub','talc','bold','fogy','idea','prof','horn','shoo','aped','pins','helm','wees','beer','womb','clue','alba','aloe','fine','bard','limo','shaw','pint','swim','dust','indy','hale','cats','troy','wens','luke','vern','deli','both','brig','daub','sara','sued','bier','noel','olga','dupe','look','pisa','knox','murk','dame','matt','gold','jame','toge','luck','peck','tass','calf','pill','wore','wadi','thur','parr','maul','tzar','ones','lees','dark','fake','bast','zoom','here','moro','wine','bums','cows','jean','palm','fume','plop','help','tuba','leap','cans','back','avid','lice','lust','polo','dory','stew','kate','rama','coke','bled','mugs','ajax','arts','drug','pena','cody','hole','sean','deck','guts','kong','bate','pitt','como','lyle','siam','rook','baby','jigs','bret','bark','lori','reba','sups','made','buzz','gnaw','alps','clay','post','viol','dina','card','lana','doff','yups','tons','live','kids','pair','yawl','name','oven','sirs','gyms','prig','down','leos','noon','nibs','cook','safe','cobb','raja','awes','sari','nerd','fold','lots','pete','deal','bias','zeal','girl','rage','cool','gout','whey','soak','thaw','bear','wing','nagy','well','oink','sven','kurt','etna','held','wood','high','feta','twee','ford','cave','knot','tory','ibis','yaks','vets','foxy','sank','cone','pius','tall','seem','wool','flap','gird','lore','coot','mewl','sere','real','puts','sell','nuts','foil','lilt','saga','heft','dyed','goat','spew','daze','frye','adds','glen','tojo','pixy','gobi','stop','tile','hiss','shed','hahn','baku','ahas','sill','swap','also','carr','manx','lime','debs','moat','eked','bola','pods','coon','lacy','tube','minx','buff','pres','clew','gaff','flee','burn','whom','cola','fret','purl','wick','wigs','donn','guys','toni','oxen','wite','vial','spam','huts','vats','lima','core','eula','thad','peon','erie','oats','boyd','cued','olaf','tams','secs','urey','wile','penn','bred','rill','vary','sues','mail','feds','aves','code','beam','reed','neil','hark','pols','gris','gods','mesa','test','coup','heed','dora','hied','tune','doze','pews','oaks','bloc','tips','maid','goof','four','woof','silo','bray','zest','kiss','yong','file','hilt','iris','tuns','lily','ears','pant','jury','taft','data','gild','pick','kook','colt','bohr','anal','asps','babe','bach','mash','biko','bowl','huey','jilt','goes','guff','bend','nike','tami','gosh','tike','gees','urge','path','bony','jude','lynn','lois','teas','dunn','elul','bonn','moms','bugs','slay','yeah','loan','hulk','lows','damn','nell','jung','avis','mane','waco','loin','knob','tyke','anna','hire','luau','tidy','nuns','pots','quid','exec','hans','hera','hush','shag','scot','moan','wald','ursa','lorn','hunk','loft','yore','alum','mows','slog','emma','spud','rice','worn','erma','need','bags','lark','kirk','pooh','dyes','area','dime','luvs','foch','refs','cast','alit','tugs','even','role','toed','caph','nigh','sony','bide','robs','folk','daft','past','blue','flaw','sana','fits','barr','riot','dots','lamp','cock','fibs','harp','tent','hate','mali','togs','gear','tues','bass','pros','numb','emus','hare','fate','wife','mean','pink','dune','ares','dine','oily','tony','czar','spay','push','glum','till','moth','glue','dive','scad','pops','woks','andy','leah','cusp','hair','alex','vibe','bulb','boll','firm','joys','tara','cole','levy','owen','chow','rump','jail','lapp','beet','slap','kith','more','maps','bond','hick','opus','rust','wist','shat','phil','snow','lott','lora','cary','mote','rift','oust','klee','goad','pith','heep','lupe','ivan','mimi','bald','fuse','cuts','lens','leer','eyry','know','razz','tare','pals','geek','greg','teen','clef','wags','weal','each','haft','nova','waif','rate','katy','yale','dale','leas','axum','quiz','pawn','fend','capt','laws','city','chad','coal','nail','zaps','sort','loci','less','spur','note','foes','fags','gulp','snap','bogs','wrap','dane','melt','ease','felt','shea','calm','star','swam','aery','year','plan','odin','curd','mira','mops','shit','davy','apes','inky','hues','lome','bits','vila','show','best','mice','gins','next','roan','ymir','mars','oman','wild','heal','plus','erin','rave','robe','fast','hutu','aver','jodi','alms','yams','zero','revs','wean','chic','self','jeep','jobs','waxy','duel','seek','spot','raps','pimp','adan','slam','tool','morn','futz','ewes','errs','knit','rung','kans','muff','huhs','tows','lest','meal','azov','gnus','agar','sips','sway','otis','tone','tate','epic','trio','tics','fade','lear','owns','robt','weds','five','lyon','terr','arno','mama','grey','disk','sept','sire','bart','saps','whoa','turk','stow','pyle','joni','zinc','negs','task','leif','ribs','malt','nine','bunt','grin','dona','nope','hams','some','molt','smit','sacs','joan','slav','lady','base','heck','list','take','herd','will','nubs','burg','hugs','peru','coif','zoos','nick','idol','levi','grub','roth','adam','elma','tags','tote','yaws','cali','mete','lula','cubs','prim','luna','jolt','span','pita','dodo','puss','deer','term','dolt','goon','gary','yarn','aims','just','rena','tine','cyst','meld','loki','wong','were','hung','maze','arid','cars','wolf','marx','faye','eave','raga','flow','neal','lone','anne','cage','tied','tilt','soto','opel','date','buns','dorm','kane','akin','ewer','drab','thai','jeer','grad','berm','rods','saki','grus','vast','late','lint','mule','risk','labs','snit','gala','find','spin','ired','slot','oafs','lies','mews','wino','milk','bout','onus','tram','jaws','peas','cleo','seat','gums','cold','vang','dewy','hood','rush','mack','yuan','odes','boos','jami','mare','plot','swab','borg','hays','form','mesh','mani','fife','good','gram','lion','myna','moor','skin','posh','burr','rime','done','ruts','pays','stem','ting','arty','slag','iron','ayes','stub','oral','gets','chid','yens','snub','ages','wide','bail','verb','lamb','bomb','army','yoke','gels','tits','bork','mils','nary','barn','hype','odom','avon','hewn','rios','cams','tact','boss','oleo','duke','eris','gwen','elms','deon','sims','quit','nest','font','dues','yeas','zeta','bevy','gent','torn','cups','worm','baum','axon','purr','vise','grew','govs','meat','chef','rest','lame'};
		String[] ga = 
			{"slit","bunk","wars","ping","viva","wynn","wows","irks","gang","pool","mock","fort","heel","send","ship","cols","alec","foal","nabs","gaze","giza","mays","dogs","karo","cums","jedi","webb","lend","mire","jose","catt","grow","toss","magi","leis","bead","kara","hoof","than","ires","baas","vein","kari","riga","oars","gags","thug","yawn","wive","view","germ","flab","july","tuck","rory","bean","feed","rhee","jeez","gobs","lath","desk","yoko","cute","zeus","thus","dims","link","dirt","mara","disc","limy","lewd","maud","duly","elsa","hart","rays","rues","camp","lack","okra","tome","math","plug","monk","orly","friz","hogs","yoda","poop","tick","plod","cloy","pees","imps","lead","pope","mall","frey","been","plea","poll","male","teak","soho","glob","bell","mary","hail","scan","yips","like","mull","kory","odor","byte","kaye","word","honk","asks","slid","hopi","toke","gore","flew","tins","mown","oise","hall","vega","sing","fool","boat","bobs","lain","soft","hard","rots","sees","apex","chan","told","woos","unit","scow","gilt","beef","jars","tyre","imus","neon","soap","dabs","rein","ovid","hose","husk","loll","asia","cope","tail","hazy","clad","lash","sags","moll","eddy","fuel","lift","flog","land","sigh","saks","sail","hook","visa","tier","maws","roeg","gila","eyes","noah","hypo","tore","eggs","rove","chap","room","wait","lurk","race","host","dada","lola","gabs","sobs","joel","keck","axed","mead","gust","laid","ends","oort","nose","peer","kept","abet","iran","mick","dead","hags","tens","gown","sick","odis","miro","bill","fawn","sumo","kilt","huge","ores","oran","flag","tost","seth","sift","poet","reds","pips","cape","togo","wale","limn","toll","ploy","inns","snag","hoes","jerk","flux","fido","zane","arab","gamy","raze","lank","hurt","rail","hind","hoot","dogy","away","pest","hoed","pose","lose","pole","alva","dino","kind","clan","dips","soup","veto","edna","damp","gush","amen","wits","pubs","fuzz","cash","pine","trod","gunk","nude","lost","rite","cory","walt","mica","cart","avow","wind","book","leon","life","bang","draw","leek","skis","dram","ripe","mine","urea","tiff","over","gale","weir","defy","norm","tull","whiz","gill","ward","crag","when","mill","firs","sans","flue","reid","ekes","jain","mutt","hems","laps","piss","pall","rowe","prey","cull","knew","size","wets","hurl","wont","suva","girt","prys","prow","warn","naps","gong","thru","livy","boar","sade","amok","vice","slat","emir","jade","karl","loyd","cerf","bess","loss","rums","lats","bode","subs","muss","maim","kits","thin","york","punt","gays","alpo","aids","drag","eras","mats","pyre","clot","step","oath","lout","wary","carp","hums","tang","pout","whip","fled","omar","such","kano","jake","stan","loop","fuss","mini","byrd","exit","fizz","lire","emil","prop","noes","awed","gift","soli","sale","gage","orin","slur","limp","saar","arks","mast","gnat","port","into","geed","pave","awls","cent","cunt","full","dint","hank","mate","coin","tars","scud","veer","coax","bops","uris","loom","shod","crib","lids","drys","fish","edit","dick","erna","else","hahs","alga","moho","wire","fora","tums","ruth","bets","duns","mold","mush","swop","ruby","bolt","nave","kite","ahem","brad","tern","nips","whew","bait","ooze","gino","yuck","drum","shoe","lobe","dusk","cult","paws","anew","dado","nook","half","lams","rich","cato","java","kemp","vain","fees","sham","auks","gish","fire","elam","salt","sour","loth","whit","yogi","shes","scam","yous","lucy","inez","geld","whig","thee","kelp","loaf","harm","tomb","ever","airs","page","laud","stun","paid","goop","cobs","judy","grab","doha","crew","item","fogs","tong","blip","vest","bran","wend","bawl","feel","jets","mixt","tell","dire","devi","milo","deng","yews","weak","mark","doug","fare","rigs","poke","hies","sian","suez","quip","kens","lass","zips","elva","brat","cosy","teri","hull","spun","russ","pupa","weed","pulp","main","grim","hone","cord","barf","olav","gaps","rote","wilt","lars","roll","balm","jana","give","eire","faun","suck","kegs","nita","weer","tush","spry","loge","nays","heir","dope","roar","peep","nags","ates","bane","seas","sign","fred","they","lien","kiev","fops","said","lawn","lind","miff","mass","trig","sins","furl","ruin","sent","cray","maya","clog","puns","silk","axis","grog","jots","dyer","mope","rand","vend","keen","chou","dose","rain","eats","sped","maui","evan","time","todd","skit","lief","sops","outs","moot","faze","biro","gook","fill","oval","skew","veil","born","slob","hyde","twin","eloy","beat","ergs","sure","kobe","eggo","hens","jive","flax","mons","dunk","yest","begs","dial","lodz","burp","pile","much","dock","rene","sago","racy","have","yalu","glow","move","peps","hods","kins","salk","hand","cons","dare","myra","sega","type","mari","pelt","hula","gulf","jugs","flay","fest","spat","toms","zeno","taps","deny","swag","afro","baud","jabs","smut","egos","lara","toes","song","fray","luis","brut","olen","mere","ruff","slum","glad","buds","silt","rued","gelt","hive","teem","ides","sink","ands","wisp","omen","lyre","yuks","curb","loam","darn","liar","pugs","pane","carl","sang","scar","zeds","claw","berg","hits","mile","lite","khan","erik","slug","loon","dena","ruse","talk","tusk","gaol","tads","beds","sock","howe","gave","snob","ahab","part","meir","jell","stir","tels","spit","hash","omit","jinx","lyra","puck","laue","beep","eros","owed","cede","brew","slue","mitt","jest","lynx","wads","gena","dank","volt","gray","pony","veld","bask","fens","argo","work","taxi","afar","boon","lube","pass","lazy","mist","blot","mach","poky","rams","sits","rend","dome","pray","duck","hers","lure","keep","gory","chat","runt","jams","lays","posy","bats","hoff","rock","keri","raul","yves","lama","ramp","vote","jody","pock","gist","sass","iago","coos","rank","lowe","vows","koch","taco","jinn","juno","rape","band","aces","goal","huck","lila","tuft","swan","blab","leda","gems","hide","tack","porn","scum","frat","plum","duds","shad","arms","pare","chin","gain","knee","foot","line","dove","vera","jays","fund","reno","skid","boys","corn","gwyn","sash","weld","ruiz","dior","jess","leaf","pars","cote","zing","scat","nice","dart","only","owls","hike","trey","whys","ding","klan","ross","barb","ants","lean","dopy","hock","tour","grip","aldo","whim","prom","rear","dins","duff","dell","loch","lava","sung","yank","thar","curl","venn","blow","pomp","heat","trap","dali","nets","seen","gash","twig","dads","emmy","rhea","navy","haws","mite","bows","alas","ives","play","soon","doll","chum","ajar","foam","call","puke","kris","wily","came","ales","reef","raid","diet","prod","prut","loot","soar","coed","celt","seam","dray","lump","jags","nods","sole","kink","peso","howl","cost","tsar","uric","sore","woes","sewn","sake","cask","caps","burl","tame","bulk","neva","from","meet","webs","spar","fuck","buoy","wept","west","dual","pica","sold","seed","gads","riff","neck","deed","rudy","drop","vale","flit","romp","peak","jape","jews","fain","dens","hugo","elba","mink","town","clam","feud","fern","dung","newt","mime","deem","inti","gigs","sosa","lope","lard","cara","smug","lego","flex","doth","paar","moon","wren","tale","kant","eels","muck","toga","zens","lops","duet","coil","gall","teal","glib","muir","ails","boer","them","rake","conn","neat","frog","trip","coma","must","mono","lira","craw","sled","wear","toby","reel","hips","nate","pump","mont","died","moss","lair","jibe","oils","pied","hobs","cads","haze","muse","cogs","figs","cues","roes","whet","boru","cozy","amos","tans","news","hake","cots","boas","tutu","wavy","pipe","typo","albs","boom","dyke","wail","woke","ware","rita","fail","slab","owes","jane","rack","hell","lags","mend","mask","hume","wane","acne","team","holy","runs","exes","dole","trim","zola","trek","puma","wacs","veep","yaps","sums","lush","tubs","most","witt","bong","rule","hear","awry","sots","nils","bash","gasp","inch","pens","fies","juts","pate","vine","zulu","this","bare","veal","josh","reek","ours","cowl","club","farm","teat","coat","dish","fore","weft","exam","vlad","floe","beak","lane","ella","warp","goth","ming","pits","rent","tito","wish","amps","says","hawk","ways","punk","nark","cagy","east","paul","bose","solo","teed","text","hews","snip","lips","emit","orgy","icon","tuna","soul","kurd","clod","calk","aunt","bake","copy","acid","duse","kiln","spec","fans","bani","irma","pads","batu","logo","pack","oder","atop","funk","gide","bede","bibs","taut","guns","dana","puff","lyme","flat","lake","june","sets","gull","hops","earn","clip","fell","kama","seal","diaz","cite","chew","cuba","bury","yard","bank","byes","apia","cree","nosh","judo","walk","tape","taro","boot","cods","lade","cong","deft","slim","jeri","rile","park","aeon","fact","slow","goff","cane","earp","tart","does","acts","hope","cant","buts","shin","dude","ergo","mode","gene","lept","chen","beta","eden","pang","saab","fang","whir","cove","perk","fads","rugs","herb","putt","nous","vane","corm","stay","bids","vela","roof","isms","sics","gone","swum","wiry","cram","rink","pert","heap","sikh","dais","cell","peel","nuke","buss","rasp","none","slut","bent","dams","serb","dork","bays","kale","cora","wake","welt","rind","trot","sloe","pity","rout","eves","fats","furs","pogo","beth","hued","edam","iamb","glee","lute","keel","airy","easy","tire","rube","bogy","sine","chop","rood","elbe","mike","garb","jill","gaul","chit","dons","bars","ride","beck","toad","make","head","suds","pike","snot","swat","peed","same","gaza","lent","gait","gael","elks","hang","nerf","rosy","shut","glop","pain","dion","deaf","hero","doer","wost","wage","wash","pats","narc","ions","dice","quay","vied","eons","case","pour","urns","reva","rags","aden","bone","rang","aura","iraq","toot","rome","hals","megs","pond","john","yeps","pawl","warm","bird","tint","jowl","gibe","come","hold","pail","wipe","bike","rips","eery","kent","hims","inks","fink","mott","ices","macy","serf","keys","tarp","cops","sods","feet","tear","benz","buys","colo","boil","sews","enos","watt","pull","brag","cork","save","mint","feat","jamb","rubs","roxy","toys","nosy","yowl","tamp","lobs","foul","doom","sown","pigs","hemp","fame","boor","cube","tops","loco","lads","eyre","alta","aged","flop","pram","lesa","sawn","plow","aral","load","lied","pled","boob","bert","rows","zits","rick","hint","dido","fist","marc","wuss","node","smog","nora","shim","glut","bale","perl","what","tort","meek","brie","bind","cake","psst","dour","jove","tree","chip","stud","thou","mobs","sows","opts","diva","perm","wise","cuds","sols","alan","mild","pure","gail","wins","offs","nile","yelp","minn","tors","tran","homy","sadr","erse","nero","scab","finn","mich","turd","then","poem","noun","oxus","brow","door","saws","eben","wart","wand","rosa","left","lina","cabs","rapt","olin","suet","kalb","mans","dawn","riel","temp","chug","peal","drew","null","hath","many","took","fond","gate","sate","leak","zany","vans","mart","hess","home","long","dirk","bile","lace","moog","axes","zone","fork","duct","rico","rife","deep","tiny","hugh","bilk","waft","swig","pans","with","kern","busy","film","lulu","king","lord","veda","tray","legs","soot","ells","wasp","hunt","earl","ouch","diem","yell","pegs","blvd","polk","soda","zorn","liza","slop","week","kill","rusk","eric","sump","haul","rims","crop","blob","face","bins","read","care","pele","ritz","beau","golf","drip","dike","stab","jibs","hove","junk","hoax","tats","fief","quad","peat","ream","hats","root","flak","grit","clap","pugh","bosh","lock","mute","crow","iced","lisa","bela","fems","oxes","vies","gybe","huff","bull","cuss","sunk","pups","fobs","turf","sect","atom","debt","sane","writ","anon","mayo","aria","seer","thor","brim","gawk","jack","jazz","menu","yolk","surf","libs","lets","bans","toil","open","aced","poor","mess","wham","fran","gina","dote","love","mood","pale","reps","ines","shot","alar","twit","site","dill","yoga","sear","vamp","abel","lieu","cuff","orbs","rose","tank","gape","guam","adar","vole","your","dean","dear","hebe","crab","hump","mole","vase","rode","dash","sera","balk","lela","inca","gaea","bush","loud","pies","aide","blew","mien","side","kerr","ring","tess","prep","rant","lugs","hobo","joke","odds","yule","aida","true","pone","lode","nona","weep","coda","elmo","skim","wink","bras","pier","bung","pets","tabs","ryan","jock","body","sofa","joey","zion","mace","kick","vile","leno","bali","fart","that","redo","ills","jogs","pent","drub","slaw","tide","lena","seep","gyps","wave","amid","fear","ties","flan","wimp","kali","shun","crap","sage","rune","logs","cain","digs","abut","obit","paps","rids","fair","hack","huns","road","caws","curt","jute","fisk","fowl","duty","holt","miss","rude","vito","baal","ural","mann","mind","belt","clem","last","musk","roam","abed","days","bore","fuze","fall","pict","dump","dies","fiat","vent","pork","eyed","docs","rive","spas","rope","ariz","tout","game","jump","blur","anti","lisp","turn","sand","food","moos","hoop","saul","arch","fury","rise","diss","hubs","burs","grid","ilks","suns","flea","soil","lung","want","nola","fins","thud","kidd","juan","heps","nape","rash","burt","bump","tots","brit","mums","bole","shah","tees","skip","limb","umps","ache","arcs","raft","halo","luce","bahs","leta","conk","duos","siva","went","peek","sulk","reap","free","dubs","lang","toto","hasp","ball","rats","nair","myst","wang","snug","nash","laos","ante","opal","tina","pore","bite","haas","myth","yugo","foci","dent","bade","pear","mods","auto","shop","etch","lyly","curs","aron","slew","tyro","sack","wade","clio","gyro","butt","icky","char","itch","halt","gals","yang","tend","pact","bees","suit","puny","hows","nina","brno","oops","lick","sons","kilo","bust","nome","mona","dull","join","hour","papa","stag","bern","wove","lull","slip","laze","roil","alto","bath","buck","alma","anus","evil","dumb","oreo","rare","near","cure","isis","hill","kyle","pace","comb","nits","flip","clop","mort","thea","wall","kiel","judd","coop","dave","very","amie","blah","flub","talc","bold","fogy","idea","prof","horn","shoo","aped","pins","helm","wees","beer","womb","clue","alba","aloe","fine","bard","limo","shaw","pint","swim","dust","indy","hale","cats","troy","wens","luke","vern","deli","both","brig","daub","sara","sued","bier","noel","olga","dupe","look","pisa","knox","murk","dame","matt","gold","jame","toge","luck","peck","tass","calf","pill","wore","wadi","thur","parr","maul","tzar","ones","lees","dark","fake","bast","zoom","here","moro","wine","bums","cows","jean","palm","fume","plop","help","tuba","leap","cans","back","avid","lice","lust","polo","dory","stew","kate","rama","coke","bled","mugs","ajax","arts","drug","pena","cody","hole","sean","deck","guts","kong","bate","pitt","como","lyle","siam","rook","baby","jigs","bret","bark","lori","reba","sups","made","buzz","gnaw","alps","clay","post","viol","dina","card","lana","doff","yups","tons","live","kids","pair","yawl","name","oven","sirs","gyms","prig","down","leos","noon","nibs","cook","safe","cobb","raja","awes","sari","nerd","fold","lots","pete","deal","bias","zeal","girl","rage","cool","gout","whey","soak","thaw","bear","wing","nagy","well","oink","sven","kurt","etna","held","wood","high","feta","twee","ford","cave","knot","tory","ibis","yaks","vets","foxy","sank","cone","pius","tall","seem","wool","flap","gird","lore","coot","mewl","sere","real","puts","sell","nuts","foil","lilt","saga","heft","dyed","goat","spew","daze","frye","adds","glen","tojo","pixy","gobi","stop","tile","hiss","shed","hahn","baku","ahas","sill","swap","also","carr","manx","lime","debs","moat","eked","bola","pods","coon","lacy","tube","minx","buff","pres","clew","gaff","flee","burn","whom","cola","fret","purl","wick","wigs","donn","guys","toni","oxen","wite","vial","spam","huts","vats","lima","core","eula","thad","peon","erie","oats","boyd","cued","olaf","tams","secs","urey","wile","penn","bred","rill","vary","sues","mail","feds","aves","code","beam","reed","neil","hark","pols","gris","gods","mesa","test","coup","heed","dora","hied","tune","doze","pews","oaks","bloc","tips","maid","goof","four","woof","silo","bray","zest","kiss","yong","file","hilt","iris","tuns","lily","ears","pant","jury","taft","data","gild","pick","kook","colt","bohr","anal","asps","babe","bach","mash","biko","bowl","huey","jilt","goes","guff","bend","nike","tami","gosh","tike","gees","urge","path","bony","jude","lynn","lois","teas","dunn","elul","bonn","moms","bugs","slay","yeah","loan","hulk","lows","damn","nell","jung","avis","mane","waco","loin","knob","tyke","anna","hire","luau","tidy","nuns","pots","quid","exec","hans","hera","hush","shag","scot","moan","wald","ursa","lorn","hunk","loft","yore","alum","mows","slog","emma","spud","rice","worn","erma","need","bags","lark","kirk","pooh","dyes","area","dime","luvs","foch","refs","cast","alit","tugs","even","role","toed","caph","nigh","sony","bide","robs","folk","daft","past","blue","flaw","sana","fits","barr","riot","dots","lamp","cock","fibs","harp","tent","hate","mali","togs","gear","tues","bass","pros","numb","emus","hare","fate","wife","mean","pink","dune","ares","dine","oily","tony","czar","spay","push","glum","till","moth","glue","dive","scad","pops","woks","andy","leah","cusp","hair","alex","vibe","bulb","boll","firm","joys","tara","cole","levy","owen","chow","rump","jail","lapp","beet","slap","kith","more","maps","bond","hick","opus","rust","wist","shat","phil","snow","lott","lora","cary","mote","rift","oust","klee","goad","pith","heep","lupe","ivan","mimi","bald","fuse","cuts","lens","leer","eyry","know","razz","tare","pals","geek","greg","teen","clef","wags","weal","each","haft","nova","waif","rate","katy","yale","dale","leas","axum","quiz","pawn","fend","capt","laws","city","chad","coal","nail","zaps","sort","loci","less","spur","note","foes","fags","gulp","snap","bogs","wrap","dane","melt","ease","felt","shea","calm","star","swam","aery","year","plan","odin","curd","mira","mops","shit","davy","apes","inky","hues","lome","bits","vila","show","best","mice","gins","next","roan","ymir","mars","oman","wild","heal","plus","erin","rave","robe","fast","hutu","aver","jodi","alms","yams","zero","revs","wean","chic","self","jeep","jobs","waxy","duel","seek","spot","raps","pimp","adan","slam","tool","morn","futz","ewes","errs","knit","rung","kans","muff","huhs","tows","lest","meal","azov","gnus","agar","sips","sway","otis","tone","tate","epic","trio","tics","fade","lear","owns","robt","weds","five","lyon","terr","arno","mama","grey","disk","sept","sire","bart","saps","whoa","turk","stow","pyle","joni","zinc","negs","task","leif","ribs","malt","nine","bunt","grin","dona","nope","hams","some","molt","smit","sacs","joan","slav","lady","base","heck","list","take","herd","will","nubs","burg","hugs","peru","coif","zoos","nick","idol","levi","grub","roth","adam","elma","tags","tote","yaws","cali","mete","lula","cubs","prim","luna","jolt","span","pita","dodo","puss","deer","term","dolt","goon","gary","yarn","aims","just","rena","tine","cyst","meld","loki","wong","were","hung","maze","arid","cars","wolf","marx","faye","eave","raga","flow","neal","lone","anne","cage","tied","tilt","soto","opel","date","buns","dorm","kane","akin","ewer","drab","thai","jeer","grad","berm","rods","saki","grus","vast","late","lint","mule","risk","labs","snit","gala","find","spin","ired","slot","oafs","lies","mews","wino","milk","bout","onus","tram","jaws","peas","cleo","seat","gums","cold","vang","dewy","hood","rush","mack","yuan","odes","boos","jami","mare","plot","swab","borg","hays","form","mesh","mani","fife","good","gram","lion","myna","moor","skin","posh","burr","rime","done","ruts","pays","stem","ting","arty","slag","iron","ayes","stub","oral","gets","chid","yens","snub","ages","wide","bail","verb","lamb","bomb","army","yoke","gels","tits","bork","mils","nary","barn","hype","odom","avon","hewn","rios","cams","tact","boss","oleo","duke","eris","gwen","elms","deon","sims","quit","nest","font","dues","yeas","zeta","bevy","gent","torn","cups","worm","baum","axon","purr","vise","grew","govs","meat","chef","rest","lame"};
		List<List<String>> r = test.partition("aab");
		exit();
		print(test.ladderLength("sand", "acne", Arrays.asList(ga)));
	
		// char[][] board =
		// {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		// char[][] board = {
		// {'X','O','O','X','X','X','O','X','O','O'},
		// {'X','O','X','X','X','X','X','X','X','X'},
		// {'X','X','X','X','O','X','X','X','X','X'},
		// {'X','O','X','X','X','O','X','X','X','O'},
		// {'O','X','X','X','O','X','O','X','O','X'},
		// {'X','X','O','X','X','O','O','X','X','X'},
		// {'O','X','X','O','O','X','O','X','X','O'},
		// {'O','X','X','X','X','X','O','X','X','X'},
		// {'X','O','O','X','X','O','X','X','O','O'},
		// {'X','X','X','O','O','X','O','X','X','O'}};

		// [["X","O","O","X","X","X","O","X","O","O"],
		// ["X","O","X","X","X","X","X","X","X","X"],
		// ["X","X","X","X","O","X","X","X","X","X"],
		// ["X","O","X","X","X","O","X","X","X","O"],
		// ["O","X","X","X","O","X","O","X","O","X"],
		// ["X","X","O","X","X","O","O","X","X","X"],
		// ["O","X","X","O","O","X","O","X","X","O"],
		// ["O","X","X","X","X","X","O","X","X","X"],
		// ["X","O","O","X","X","O","X","X","O","O"],
		// ["X","X","X","O","O","X","O","X","X","O"]]
		//
		// [["X","O","O","X","X","X","O","X","O","O"],
		// ["X","O","X","X","X","X","X","X","X","X"],
		// ["X","X","X","X","X","X","X","X","X","X"],
		// ["X","X","X","X","X","X","X","X","X","O"],
		// ["O","X","X","X","X","X","X","X","X","X"],
		// ["X","X","X","X","X","X","X","X","X","X"],
		// ["O","X","X","X","X","X","X","X","X","O"],
		// ["O","X","X","X","X","X","X","X","X","X"],
		// ["X","X","X","X","X","X","X","X","O","O"],
		// ["X","X","X","O","O","X","O","X","X","O"]]

		char[][] board = {
				{ 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O' },
				{ 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X' },
				{ 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O' },
				{ 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X' },
				{ 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O' },
				{ 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X' },
				{ 'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O' },
				{ 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X' },
				{ 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O' } };
		int a = 0, b = 1;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		printArray(board);
		test.solve(board);
		print("solution:");
		printArray(board);
		exit();
		print(test.getSum(20, 30));

		List<Integer> cc = new ArrayList<>();
		cc.add(1);
		cc.add(2);
		String bb = "b";
		print(test.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
		exit();
		print(test.letterCasePermutation("a1b2"));
		exit();
		print(test.minCostClimbingStairs(nums2));
		print(cc.toString());
		print(test.largestNumber1(nums2));

		print(test.numSquares2(12));
		exit();
		print(test.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae"));
		exit();
		test.sortIntegers2(nums);
		print(Arrays.toString(nums));
		exit();
		test.swamp(cc);
		test.swamp(nums);
		test.printListNode(test.sortList(test.getList(nums)));

		print(test.findAnagrams("abccba", "cab"));
		print(test.lengthOfLongestSubstring("bbbacb"));

		exit();
		System.out.println(test.reverseBits(11));
		System.out.println(test.hammingWeight(32));

		System.out.println(test.combinationSum(nums, 3));
		System.out.println(test.plusOne(nums));
		System.out.println(test.toBinary(~0) + "\t" + test.toBinary(~0 << 1) + "\t" + (1 & 3));
		System.out.println(test.subsets(nums));
		// System.out.println(ga.length+"\t"+ga[0].length);
		System.exit(0);
		// System.out.println(aa.substring(0, 0));
		System.out.println(test.checkInclusion("adc", "dcda"));
		// String t = "100[leetcode]";
		// int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		// test.arrayReverse(nums3, 0, 2);
		// System.out.println(Arrays.toString(nums3));
		// String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		// System.out.println(test.decodeString(t));
		// System.out.println(test.findIt(nums, 0, nums.length));
		// System.out.println(test.numTrees(6));
		// System.out.println(test.ladderLength("hit", "cog", Arrays.asList(wordList)));

		System.out.println(test.longestValidParentheses(")()())"));
		System.out.println(test.longestPalindrome("cbbd"));
		System.out.println(test.search(nums, 0));
		System.out.println(test.compress(chars));
		System.out.println(test.strCompare("34", "3"));
		System.out.println(test.largestNumber(nums));
		System.out.println(aa.substring(1));
		System.out.println(test.maxProduct(nums));
		System.out.println(test.rob(nums));
		System.out.println(test.longestCommonPrefix(strs3));
		System.out.println(test.uniquePaths(7, 3));
		System.out.println(test.maxSubArray(nums3));
		System.out.println(test.titleToNumber("BB"));
		System.out.println(Arrays.toString(test.searchRange(nums, 6)));
		System.out.println(Arrays.toString(test.findOrder(2, prerequisites)));
		System.out.println((test.longestSubstring("aaabb", 3)));
		System.out.println(Arrays.toString(test.intersect(nums2, nums3)));
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(0);
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(0);
		String ss = "(((";
		System.out.println(test.closePa(ss));
		// System.out.println(test.removeInvalidParentheses(ss));
		// System.out.println(test.removeCharAt(ss, l2, l1));
		System.out.println(test.isValid("{[]}"));
		System.out.println(test.subsets(nums).toString());
		System.out.println(test.reverseWords("test is good"));
		System.exit(0);
		System.out.println(test.lengthOfLastWord("a "));
		// System.out.println(test.reverse(1534236469));

		System.out.println(81 % 3);
		test.moveZeros(nums);
		System.out.println((Arrays.toString(nums)));
		test.moveZeroes(nums);
		System.out.println((Arrays.toString(nums)));
		System.out.println(test.permute(nums));
		System.exit(0);
		String sss = "A man, a plan, a canal: Panama";
		System.out.println(test.isPalindrome(sss));
		System.out.println(test.largestNumber(nums));
		int[][] matrix = new int[0][0];
		char[][] grid = new char[][] { { '1' } };

		System.out.println(String.valueOf(grid[0][0]));

		System.out.println(test.matrixXLength(matrix));
		System.out.println(test.matrixYLength(matrix));

		// List<Interval> a = new ArrayList<Interval>();
		// a.add(new Interval(1,3));
		// a.add(new Interval(2,6));
		int[] a1 = { 1 };
		int[] b1 = { 2 };
		test.swapLine(a1, b1);
		System.out.println(Arrays.toString(a1));
		List<String> strs = new ArrayList<String>();
		strs.add("leet");
		strs.add("code");
		// System.out.println(test.wordBreak("leetcode", strs));
		// System.out.println(test.merge(a));
		// System.out.println(test.backspaceCompare("a#c", "b"));
		// System.out.println("twosum");
		// System.out.println(Arrays.toString(test.twoSum2(new int[] { 3, 2, 4 }, 6)));
		// System.out.println("remove_element");
		// int[] nums = { 3, 2, 2, 3 };
		// int len = test.removeElement(nums, 3);
		//
		// System.out.println(len);
		// System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 4)));
		// String hay = "mississippi";
		// System.out.println(test.reverseBits(2147483648l));
		// String needle = "issip";
		// System.out.println(test.strStr(hay, needle));
		// test.rotate(new int[] { 2, 3, 3, 3, 3, 3, 34, 4, 4, 1 }, 30000);
		// System.out.print(test.fizzBuzz(1));
		// System.out.println(test.titleToNumber("AAA"));
		// System.out.println(test.firstUniqChar("cc"));
		// System.out.println(Arrays.toString(test.plusOne(new int[] { 9 })));
		// System.out.println(test.majorityElement(new int[] { 3, 2, 3 }));
	}

	class numSort implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			List<Integer> aa = new ArrayList<>(), bb = new ArrayList<>();
			if (a == 0 && b == 0)
				return 0;
			if (a != 0 && b == 0)
				return a;
			if (a == 0 && b != 0)
				return b;

			Integer aaa = a, bbb = b;

			while (aaa != 0) {
				aa.add(aaa % 10);

				aaa /= 10;

			}
			while (bbb != 0) {

				bb.add(bbb % 10);

				bbb /= 10;
			}
			Collections.reverse(aa);
			Collections.reverse(bb);

			int len = aa.size() > bb.size() ? bb.size() : aa.size(), i;

			for (i = 0; i < len; i++) {
				if (aa.get(i) == bb.get(i))
					continue;
				return aa.get(i) - bb.get(i);
			}
			if (aa.size() == bb.size())
				return 0;

			if (i < aa.size()) {
				if (aa.get(i) == 0)
					return -1;
				else
					return 1;
			} else {
				if (bb.get(i) == 0)
					return -1;
				else
					return 1;
			}

		}
	}

	class Node {
		public int val;
		public List<Node2> children;

		public Node() {
		}

		public Node(int _val, List<Node2> _children) {
			val = _val;
			children = _children;
		}
	}
	
	
}
