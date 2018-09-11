
public class YourErrorPatterns {

	public static void main(String[] args) {

		YourErrorPatterns t = new YourErrorPatterns();
		
		t.objReferenceIsImmutable(); 
	}
	
	
	public TreeNode checkWhyLoopBreaks(String data, int[] start) {
	
		int i = start[0];

		while (i < data.length()) {
			if (data.charAt(i++) == ',')
				break;
		}
		// #exit always check why the while loop breaks.
		// #exit do this by starting with a template when more than one condition trigger loop breaks.
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
	
	public void objReferenceIsImmutable() {
		TreeNode t = Utils.treeDeserializer("1,2,3");
		testTreeZ(t);
		Utils.print(String.valueOf(t.left.val));
		if(t.val == -1) {
			Utils.print("should not see this");
		}
	}
	
	public void testTreeZ(TreeNode t) {
		// #enter you can not let t == null, but you can let t.left == null. and you can change t's value
		//t.left = null; will work
		//t = null. WONT work
		//t.val = -2 will work
		t.left.val= -2;
	}
	public void testStr(String s) {
		s = "should not see this";
	}

}
