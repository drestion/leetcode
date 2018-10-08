package problems;

import java.util.ArrayList;
import java.util.List;

class Solution {
   /*     4:11pm 1007 started
   *      4:17pm draft done
   *      4:18pm 1pass
   *      #enter keep the k-1th row, return the kth row using O(k) array
   *      #Time  O(k)
   *      #Space O(k) + O(k) 
   */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>();
        
        if(rowIndex < 0){
            return data;
        }
        
        data.add(1);
        
        if(rowIndex == 0){
            return data;
        }
        else{
            while(rowIndex-- > 0){
                data = getRow(data);
            }
        }
        
        return data;
    }
    
    public List<Integer> getRow(List<Integer> prev){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 0; i < prev.size()-1; i++){
            ans.add(prev.get(i) + prev.get(i+1));
        }
        ans.add(1);
        
        return ans;
    }
}