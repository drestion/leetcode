package problems;

public class SmallestRangeI {
  /*
  *     4:03pm 0924 started
  *     4:06pm draft done
  *
  *     #enter technical?
  */
  public int smallestRangeI(int[] A, int K) {
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      
      for(int n : A){
          min = Math.min(min, n);
          max = Math.max(max, n);
      }
      
      max = max - min;
      min = 0;
      
      if(min + K >= max - K) return 0;
      
      return Math.abs(min + K - max + K);
  }
}
