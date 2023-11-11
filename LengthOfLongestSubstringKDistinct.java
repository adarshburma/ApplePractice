/*
Leetcode:

https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

*/


class Solution {

    // solution using hashmap, O(n)

    // public int lengthOfLongestSubstringKDistinct(String s, int k) {

    //     if (k == 0) return 0;

    //     HashMap<Character, Integer> map = new HashMap<>();
    //     int res = 0;
    //     int st = 0;
    //     for (int end = 0; end < s.length(); end++){ 
    //         char c = s.charAt(end);
    //         map.put(c, map.getOrDefault(c, 0)+1);

    //         while (map.size() > k) {
               
    //             //reached max start shrinking ...
    //             char leftChar = s.charAt(st);
    //             if(map.containsKey(leftChar)) {
    //                 map.put(leftChar, map.get(leftChar)-1);
    //                 if (map.get(leftChar) == 0) {
    //                     map.remove(leftChar);
    //                 }
                  
    //             }

    //              st++;

    //         }

    //          res = Math.max(res, end - st +1);

            
    //     }

    //      return res;
    // }


   // solution using hashmap, O(n)
    public int lengthOfLongestSubstringKDistinct(String s, int k) { 
        int[] count = new int[256];

        int left = 0;
        int max = 0;
        int num = 0;

        for (int right = 0 ; right < s.length(); right++) {

            int rightChar = s.charAt(right);
            if (count[rightChar]++ == 0) num++;

            if (num > k) {
                while(--count[s.charAt(left++)] > 0);
                num--;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
