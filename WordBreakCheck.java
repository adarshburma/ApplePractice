/*
  Leetcode : https://leetcode.com/problems/word-break/submissions/1106129987/
*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       boolean[] dp = new boolean[s.length()+1];
       dp[s.length()] = true;

       for (int j = s.length()-1; j >=0 ;j--) {
           for (String word : wordDict) {
               int sIdx = j + 1 - word.length();
               if (s.charAt(j) != word.charAt(word.length()-1) || sIdx < 0) {
                   continue;
               }

               if (s.substring(sIdx, j+1).equals(word) && dp[j+1] == true) {
                   dp[sIdx] = true;
               }
           }
       }

       return dp[0];
    }

}
