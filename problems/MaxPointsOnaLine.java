package problems;

public class MaxPointsOnaLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
  /*
   *     3:12pm 0924 started
   *   
   *     3:33pm #TODO needs to finish
*         # enter sort the points by x ;
                 dp[i]: max points ending at x = i;
                 dp[i+1] = dp[i] + 1 if point(i+1) is on the same line with any point ending at i with the max length dp[i]
                           or 1 if not.
*             answer: max(dp[0 ~ len-1])
*/
   public int maxPoints(Point[] points) {
       if(ponits == null || points.length < 1) return 0;
       
       int len = points.length, ans = Integer.MIN_VALUE;
       
       Map<Integer, List<Point>> cnts = sortPoints(points);
       
       int[][] dp = new int[extreme[1]- extreme[0] + 1][3];
       Map<Integer, List<Point>> prevCnts = new HashMap<>();
       
       prevCnts.put(extreme[0], cnts.get(extreme[0]));
       
       dp[0][0] = 1;
       dp[0][1] = 1;
       dp[0][2] = 1;
       
       for(int i = 1; i < dp.length; i++){
           List<Point> prevPts = prevCnts.get()xxxx;
           for(Point p : prevPts){
               // #TODO need to iterate through all points.
               dp[i][0] = isLevel(p, points[i])? dp[i-1][0] + 1 : 1;
               dp[i][1] = isUp(p, points[i])? dp[i-1][1] + 1 : 1;
               dp[i][2] = isDown(p, points[i])? dp[i-1][2] + 1 : 1;
           }
       }
   }
   
   public boolean isUp(Point p1, Point p2){
       return (p1.x + 1 == p2.x && p1.y + 1 == p2.y);
   }
   
   public boolean isLevel(Point p1, Point p2){
       return (p1.x + 1 == p2.x && p1.y  == p2.y);
   }
   
   public boolean isDown(Point p1, Point p2){
       return (p1.x + 1 == p2.x && p1.y - 1 == p2.y);
   }
   
   public boolean isLevel()
   
   public Map<Integer, List<Point>> sortPoints(Point[] points, int[] extreme){
       Map<Integer, List<Point>> ret = new HashMap<>();
       
   }
}
