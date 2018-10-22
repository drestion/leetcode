package problems;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("1-(5)"));
	}
  /*
  *    5:40pm 1018 started
  *
*
*   
*         #enter recursion
*        #Time O(n)
*        #Space O(1)
*/
  public int calculate(String s) {
      int[] pos = new int[2];
      
    return helper(s, pos);
  }
  
  private int helper(String s, int[] pos){
      int ans = 0, i = pos[0];
      int sign = 0;
      while(i < s.length()){
          while(i < s.length() && s.charAt(i) == ' ') i++;
          if(i == s.length()) break;
          if(s.charAt(i) == ')'){
              pos[1] = i+1;
              return ans;
          }
          else if(s.charAt(i) == '('){
              pos[0] = i+1;
              ans = calc(ans, sign, helper(s, pos));
              i = pos[1] - 1;
          }
          else if(s.charAt(i) == '+'){
              sign = 1;
          }
          else if(s.charAt(i) == '-'){
              sign = -1;
          }
          else if(Character.isDigit(s.charAt(i))){
          	int val = 0;
          		while(i < s.length() && Character.isDigit(s.charAt(i))) {
          			val = val*10 + s.charAt(i) - '0';
          			i++;
          		}
              ans = calc(ans, sign, val);
              if(i == s.length()) break;
              continue;
          }
          
          i++;
      }
    
      return ans;
  }
  
  private int calc(int csum, int sign, int num){
      if(sign > 0){
          return csum + num;
      }
      else if(sign < 0){
          return csum - num;
      }
      
      return num;
  }

}
