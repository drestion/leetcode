package problems;

public class ValidPalindrome {
	 /*
   *   10:48am 0920 revisit
   *   10:52am draft done.
   *
   *
   *
   */
   public boolean isPalindrome(String s) {
       if(s == null) return false;
       if(s.isEmpty()) return true;
       
       int i = 0, j = s.length() - 1;
       
       while(i < j){
           while( i < j && !(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
               i++;
           }
           if(i >= j) break;
           while( i < j && !(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
               j--;
           }
           if(i >= j) break;
           if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
       }
       
       return true;
   }
}
