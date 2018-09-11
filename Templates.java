import java.util.ArrayList;
import java.util.List;

public class Templates {

	public static void main(String[] args) {

		Templates t = new Templates();
		
		t.treeLevelTraversalUsingDFS();
	}
	
	private List<List<String>> strList;
	public void treeLevelTraversalUsingDFS() {
		
		strList = new ArrayList<>();
		TreeNode tree = Utils.treeDeserializer("1,2,3,null,null,4,5");
		dfsLevel(tree, 0);
		Utils.printListofList(strList);
	}
	
	public void dfsLevel(TreeNode root, int depth) {
		if(root == null) return;
		while(strList.size() <= depth) strList.add(new ArrayList<>());
		strList.get(depth).add(String.valueOf(root.val));
		dfsLevel(root.left, depth+1);
		dfsLevel(root.right, depth+1);
	}
	
}
