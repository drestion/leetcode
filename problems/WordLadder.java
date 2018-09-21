package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
  /*
  *   1:53pm 0829 revisit
  *   2:00pm
  *   #entry a better way to prevent revisiting is to delete the word once it is used.
  *   #exit you have a tendency to type begin as begwin.
  *   2:58pm 0921 revisit
  *   3:09pm draft done
  *   #enter try dfs
  *   3:18pm TLE
  *   3:18PM Reverse
  *   3:48pm tle
  *   3:52PM standard answer still TLE
  *   #TODO Need Two sides BFS?
  */
  
 // private List<String> sortedDictW;
  
//   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//       if(beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty()){
//           return 0;
//       }
      
//       if(!wordList.contains(endWord)){
//           return 0;
//       }
     
//       Queue<String> q = new LinkedList<>();
//       q.offer(beginWord);
//       int qSize = 0, step = 0;
      
//       while(!q.isEmpty()){
//           step++;
//           qSize =q.size();
//           for(int i = 0; i < qSize; i++){
//               String w = q.poll();
              
//           }
//       }
      
//       return 0;
//   }
  
  
//   private int currMin = Integer.MAX_VALUE;
  
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord)) return 0;
       
//        dfs(beginWord, endWord, wordList, 0);
       
//        if(currMin == Integer.MAX_VALUE) return 0;
       
//        return currMin + 1;
//    }
  
//   public void dfs(String beginWord, String endWord, List<String> wordList, int curStep){
//       if(curStep >= currMin) return;
      
//       if(beginWord.equals(endWord)) {
//           currMin = Math.min(currMin, curStep);
//           return;
//       }
      
//       for(int j = 0; j < beginWord.length(); j++){
//           char[] cc = beginWord.toCharArray();
//           for(int k = 0; k < 26; k++){
//               cc[j] = (char)('a' + k);
//               String nw = new String(cc);
//               if(wordList.contains(nw)){
//                   List<String> nwordList = new ArrayList<>();
//                   nwordList.addAll(wordList);
//                   nwordList.remove(nw);
//                   dfs(nw, endWord, nwordList, curStep+1);
//               }
//           }
//       }
//   }
//   private int ans = Integer.MAX_VALUE;
  
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//       if(!wordList.contains(endWord)) return 0;
       
//       reverseDFS(beginWord, endWord, wordList, 0);
       
//       if(ans == Integer.MAX_VALUE) return 0;
       
//       return ans + 1;
//    }
  
//   public void reverseDFS(String w, String e, List<String> list, int curStep){
//      // System.out.println("w:"+w+" e:"+e);
//       if(curStep >= ans) return;
      
//       if(diffByOne(w, e)){
//        //    System.out.println("Found w:"+w+" e:"+e);
//           ans = Math.min(ans, curStep+1);
//           return;
//       }
      
//       List<String> nlist = new ArrayList<>();
//       List<String> nextList = new ArrayList<>();
      
//       nlist.addAll(list);
      
//       for(String dw : list){
//           if(diffByOne(e, dw)){
//               nextList.add(dw);
//           }
//       }
      
//       nlist.removeAll(nextList);
//       for(String nw : nextList){
//      //     System.out.println("Starting out:"+nw+" "+nlist.toString());
//           reverseDFS(w, nw, nlist, curStep+1);
//       }

//   }
  
//   public boolean diffByOne(String w1, String w2){
//       int cnt = 0;
//       for(int i = 0; i < w1.length();i++){
//           if(w1.charAt(i) != w2.charAt(i)) cnt++;
//       }
      
//       return cnt <= 1;
//   }
//   public List<String> getWords(String w){
//       char[] cc = w.toCharArray();
//       Arrays.sort(cc);
      
//       int cnt = 0;
//       List<String> ans = new ArrayList<>();
      
//       for(String s : sortedDictW){
          
//           for(int i = 0; i < cc.length; i++){
//               if(cc[i] != s.charAt(i)) cnt++;
//               if(cnt > 1) break;
//           }
          
//           if(cnt <= 1){
//               ans.add(s);        
//           }
//       }
      
//       return ans;
//   }
  
   public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
       if(!wordDict.contains(endWord)) return 0;
      Set<String> reached = new HashSet<String>();
      reached.add(beginWord);
      wordDict.add(endWord);
      int distance = 1;
      while (!reached.contains(endWord)) {
          Set<String> toAdd = new HashSet<String>();
          for (String each : reached) {
              for (int i = 0; i < each.length(); i++) {
                  char[] chars = each.toCharArray();
                  for (char ch = 'a'; ch <= 'z'; ch++) {
                      chars[i] = ch;
                      String word = new String(chars);
                      if (wordDict.contains(word)) {
                          toAdd.add(word);
                          wordDict.remove(word);
                      }
                  }
              }
          }
          distance++;
          if (toAdd.size() == 0) return 0;
          reached = toAdd;
      }
      return distance;
   }
}
