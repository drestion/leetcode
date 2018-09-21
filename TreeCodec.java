import java.util.LinkedList;
import java.util.Queue;

public class TreeCodec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "null";

		StringBuilder ret = new StringBuilder();
		Queue<TreeNodePP> q = new LinkedList<>();
		q.offer(new TreeNodePP(root));
		int qSize = 0;

		while (!q.isEmpty()) {
			qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				TreeNodePP pp = q.poll();
				TreeNode n = pp.n;
				if (n != null) {
					q.offer(new TreeNodePP(n.left));
					q.offer(new TreeNodePP(n.right));
					ret.append(n.val + ",");
				} else {
					ret.append("null,");
				}
			}
		}

		String ans = ret.toString();

		// remove the last two nulls.
		return ans.substring(0, ans.length() - 11);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		Queue<TreeNode> q = new LinkedList<>();
		int[] start = new int[1];
		int qSize = 0;
		TreeNode head = read(data, start);
		if (head == null)
			return head;
		q.offer(head);

		while (!q.isEmpty()) {
			qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				TreeNode n = q.poll();
				if (start[0] >= data.length()) {
					break;
				}
				n.left = read(data, start);

				n.right = read(data, start);
				if (n.left != null) {
					q.offer(n.left);
				}
				if (n.right != null) {
					q.offer(n.right);
				}

			}
		}

		return head;
	}

	public TreeNode read(String data, int[] start) {
		// if(start[0] >= data.length()) return null
		int i = start[0];

		while (i < data.length()) {
			if (data.charAt(i++) == ',')
				break;
		}
		// #exit always check why the while loop breaks.
		String sub = null;
		if (i == data.length()) {
			sub = data.substring(start[0], i);
		} else {
			sub = data.substring(start[0], i - 1);
		}

		start[0] = i;
		if (sub.equals("null"))
			return null;
		return new TreeNode(Integer.valueOf(sub));

	}

	public class TreeNodePP {
		TreeNode n;

		public TreeNodePP(TreeNode t) {
			n = t;
		}
	}
}
