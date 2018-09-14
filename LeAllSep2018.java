import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author ga
 *
 */
public class LeAllSep2018 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeAllSep2018 test = new LeAllSep2018();
		TreeNode t = Utils.treeDeserializer("7,2,8,1,4,null,null,null,null,3,5");
		//TreeNode t = Utils.treeDeserializer("4,2,6,1,3,5,7");
		TreeNode[] tt = test.splitBST(t, 5);
		Utils.print(Utils.treeSerializer(tt[0]));
		Utils.print(Utils.treeSerializer(tt[1]));
	}
  /*
  *   05:13pm 0914 started
  *   5:25pm draft done
  *    #enter post-order traversal
  *
  */
  
  public int findTilt(TreeNode root) {
     int[] ans = new int[1];
     helper(root, ans);
      
     return ans[0];
  }
  
  public int helper(TreeNode root, int[] ans){
       if(root == null) return 0;
      int l = helper(root.left, ans);
      int r = helper(root.right, ans);
      
      int pl = 0, pr =0, ori = root.val;
      if(root.left != null) {
          root.val += root.left.val;
          pl = root.left.val;
      }
      if(root.right != null){
          root.val += root.right.val;
          pr = root.right.val;
      }
      ans[0] += Math.abs(pl - pr);

      return Math.abs(pl - pr);
  }
  
  /*
   *   6:02pm 0910 started
   *   6:22pm 2pass.
   *    #enter it is bst, so consider in-order traversal.
*        #enter consider using reverse in-order traversal given the description of the problem.
*/
   private TreeNode prev = null;
   public TreeNode convertBST(TreeNode root) {
       if(root == null) return null;
       helper(root);
       return root;
   }
   
 
   public void helper(TreeNode root){
       if(root == null) return;
       helper(root.right);
       if(prev != null){
           root.val += prev.val;
       }
       prev = root;
       helper(root.left);
   }

	//First think the ending point of the whole recursion process
	//you know that eventually it will go to the null nodes of the target node.
	//Then you go back and think as if splitBST already do the job.
	//Then you think how to modify the root's right and left.
	//One key for this problem is that splitBST will return the nodes NOT necessarily starting from the original root.right or root.left
	// it will instead return the resulting nodes needed by root.left and right. that's how you can just use root.left = result[0]
	// or root.right = result[1];
	public TreeNode[] splitBST(TreeNode root, int V) {
    if(root==null) return new TreeNode[]{null, null};
    
    TreeNode[] splitted;
    if(root.val<= V) {
    		System.out.println("root"+root.val+" still <= "+V);
        splitted = splitBST(root.right, V);
        String s0 = splitted[0] == null? "null":String.valueOf(splitted[0].val);
        String s1 = splitted[1] == null? "null":String.valueOf(splitted[1].val);
       	System.out.println("Returned in the less than branch: root:"+root.val+" V:"+V +" results:"
        +s0+" "+s1);
        root.right = splitted[0];
        splitted[0] = root;
    } else {
    	System.out.println("root"+root.val+" still > "+V);
        splitted = splitBST(root.left, V);
        String s0 = splitted[0] == null? "null":String.valueOf(splitted[0].val);
        String s1 = splitted[1] == null? "null":String.valueOf(splitted[1].val);
       	System.out.println("Returned in the bigger than branch: root:"+root.val+" V:"+V +" results:"
        +s0+" "+s1);
        root.left = splitted[1];
        splitted[1] = root;
    }
    String s0 = splitted[0] == null? "null":String.valueOf(splitted[0].val);
    String s1 = splitted[1] == null? "null":String.valueOf(splitted[1].val);
   	System.out.println("Returning from root:"+root.val+" V:"+V +" results:"
    +s0+" "+s1+"\n");
    return splitted;
}
	
	
	 /*
   *    3:30pm 0905 started
*        3:37pm draft done
*    #enter use hashmap and sameTree
*    #TODO should stop using this type of 2-pass algorithms for tree. 
*
*/
   public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       Set<TreeNode> ans = new HashSet<>();
       if(root == null) return new ArrayList<>();
       
       Map<Integer, List<TreeNode>> m = new HashMap<>();
       buildMap(root, m);
       
       Set<Integer> nodes = m.keySet();
       for(Integer n : nodes){
           System.out.println(n);
           List<TreeNode> l = m.get(n);
           if(l.size() < 2) continue;
           List<Integer> used = new ArrayList<>();
           for(int i = 0; i < l.size(); i++){
               for(int j = i+1; j < l.size(); j++){
                    System.out.println(i+" "+j);
                   if(used.contains(i) || used.contains(j)) continue;
                   if(sameTree(l.get(i), l.get(j))){
                       ans.add(l.get(i));
                       used.add(i);
                       used.add(j);
                   }
               }
           }
       }
       List<TreeNode> ret = new ArrayList<>();
       ret.addAll(ans);
       return ret;
   }
   
   public void buildMap(TreeNode t, Map<Integer, List<TreeNode>> m){
       if(t == null) return;
       List<TreeNode> l = m.get(t.val);
       if(l == null){
           l = new ArrayList<>();
           m.put(t.val, l);
       }
       l.add(t);
       
       buildMap(t.left, m);
       buildMap(t.right, m);
   }
   
   public boolean sameTree(TreeNode t1, TreeNode t2){
       if(t1 == null && t2 == null) return true;
       if(t1 != null && t2 != null){
           return (t1.val == t2.val) && (sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right));
       }
       
       return false;
   }
   
   /*  
   *    10:31am 0910 started
   *    10:39am draft done.
*        11:02am 3pass
*
*/
   
   private int longest = Integer.MIN_VALUE;
   public int longestConsecutive(TreeNode root) {
       helper(root);
       if(longest == Integer.MIN_VALUE) return 0;
       return longest;
   }
   
   // Return the longest consec path that ends at the root node
   public int helper(TreeNode root){
       if(root == null) return 0;
       int l = helper(root.left), r = helper(root.right);
       int pl = l, pr = r;
       if(pl != 0 && root.left.val == root.val + 1) pl++;
       if(pr != 0 && root.right.val == root.val+ 1) pr++;
       if(pl == 0 && pr == 0) pl = 1; // the bottomest node
       
       longest = Math.max(longest, Math.max(pl, pr));
       if(pl == l && pr == r){
           return 1;//reset the counter.
       }
       return Math.max(pl, pr);
   }
   
   public TreeNode findShortestLeaf(TreeNode root, int[] distance){
     if(root == null) return null;
     distance[0] += 1;
     System.out.println(root.val);
     if(root.left == null && root.right == null) return root;
     int old = distance[0];
       System.out.println(root.val);
     distance[0] = 0;
     TreeNode l = findShortestLeaf(root.left, distance);
     int dl = distance[0];
       System.out.println(root.val);
     distance[0] = 0;
     TreeNode r = findShortestLeaf(root.right, distance);
     int dr = distance[0];
     
     System.out.println(root.val+" "+dl+" "+dr);
     if(dl >= dr) {
         distance[0] = dr + old;
         return r;
     }
     else{
         distance[0] = dl + old;
         return l;
     } 
 }
}
