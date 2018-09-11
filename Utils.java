
import java.util.List;


public class Utils {
	public static String treeSerializer(TreeNode node) {
		TreeCodec c = new TreeCodec();
		return c.serialize(node);
	}

	public static TreeNode treeDeserializer(String str) {
		TreeCodec c = new TreeCodec();
		return c.deserialize(str);
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void printListofList(List<List<String>> l) {
		for(List<String> ll : l) {
			for(String o : ll) {
				System.out.print(o.toString()+",");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	
}
