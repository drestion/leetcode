package problems;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class HouseRobberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

  
	 /*
   *    9:22pm 0922 started
   *    9:47pm draft done.
   *
   *    #enter dp(root, r): max money to rob house at tree rooted at root, r = 0, no rob, = 1, rob
   *    #TODO The Hashmap using class as key
   *    #TODO Nopass
   *     
   */
   public int rob(TreeNode root) {
       if(root == null) return 0;
       
       return rob(root,  new HashMap<HouseAction, Integer>());
   }
   
   
   public int rob(TreeNode root, Map<HouseAction, Integer> vals){
       if(root == null) return 0;
    
       rob(root.left,vals);
       rob(root.right,vals);
          System.out.println("Processing "+root.val);
       int lr = 0, lnr = 0, rr = 0, rnr = 0;
       if(root.left != null && root.right != null){
          lr = vals.get(new HouseAction(root.left, 1));
          lnr = vals.get(new HouseAction(root.left, 0));
          rr = vals.get(new HouseAction(root.right, 1));
          rnr = vals.get(new HouseAction(root.right, 0));
          
          vals.put(new HouseAction(root, 1), root.val+lnr+rnr);
          vals.put(new HouseAction(root, 0), Math.max(lr+rr, Math.max(lr+rnr, Math.max(lnr+rr, lnr+rnr))));
       }
       else if(root.left != null && root.right == null){
          lr = vals.get(new HouseAction(root.left, 1));
          lnr = vals.get(new HouseAction(root.left, 0));
          
          vals.put(new HouseAction(root, 1), root.val+lnr);
          vals.put(new HouseAction(root, 0), Math.max(lr, lnr));
       }else if(root.left == null && root.right != null){
          rr = vals.get(new HouseAction(root.right, 1));
          rnr = vals.get(new HouseAction(root.right, 0));
          
          vals.put(new HouseAction(root, 1), root.val+rnr);
          vals.put(new HouseAction(root, 0), Math.max(rr, rnr));
       }
       else{
           vals.put(new HouseAction(root,1), root.val);
           vals.put(new HouseAction(root, 0), 0);
       }
       System.out.println(vals.get(new HouseAction(root,0)));
       return Math.max(vals.get(new HouseAction(root,0)), vals.get(new HouseAction(root, 1)));
   }
   
   public class HouseAction{
       TreeNode root;
       int r;
       public HouseAction(TreeNode root, int r){
           this.root = root;
           this.r = r;
       }
   }
}
