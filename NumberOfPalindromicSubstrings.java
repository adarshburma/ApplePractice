/*
  Leetcode: https://leetcode.com/problems/palindromic-substrings/
https://www.youtube.com/watch?v=4RACzI5-du8
*/

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0 ; i < s.length(); i++) {
            res += count(s, i, i);
            res += count(s, i, i+1);
        }

        return res;
    }

    public int count (String s, int l, int r) {
        int res= 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            res++;
        }

        return res;
    }
}
