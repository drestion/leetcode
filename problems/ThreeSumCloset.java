package problems;

import java.util.Arrays;

public class ThreeSumCloset {
  
  /*
  *    7:50pm 0924 started
  *    8:13pm draft done
  *    8:51pm 5pass
*       #enter  sort, then for each three, use two points
*        -4,-1,1,2
*       #Brutal force: O(n3)
*       # Time O(nlogn) + O(n2)
*       # Space O(1)
*/
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int i1 = 0, i2=1, i3=nums.length-1, ans = 0;
      if(nums.length < 3){
          for(int n : nums) ans += n;
          return ans;
      }
   
      int min =  nums[i1] + nums[i2] + nums[i3];
      for(int i = 0; i < nums.length - 2; i++){
          i1 = i;
          i2 = i+1;
          i3 = nums.length-1;
          int csum = nums[i1] + nums[i2] + nums[i3];
     
          while(i2 < i3){
             
              csum = nums[i1] + nums[i2] + nums[i3];
              if(getDistance(csum, target) < getDistance(min, target) ){
                  min = csum;
              }
              if(csum == target) return csum;
              if(csum < 0 && csum < target){
                  i2++;
              }
              else if(csum < 0 && csum > target){
                  i3--;
              }
              else if(csum >= 0 && csum < target){
                  i2++;
              }
              else if(csum >= 0 && csum > target){
                  i3--;
              }
             
          }
      }
      
      return min;
  }
  

  
  public int getDistance(int sum, int target){
      return Math.abs(sum - target);
  }
}
