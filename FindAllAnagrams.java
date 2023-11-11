/*
Leetcode:

https://leetcode.com/problems/find-all-anagrams-in-a-string/

*/

class Solution {

    // Solution -1 O(len(s) * len(p))

    
    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> res = new ArrayList<>();
    //     int uniqueChars = 0;

    //     int[] original = new int[26];

    //     for (int i = 0 ; i < p.length(); i++) {
    //         char c = p.charAt(i);
    //         if (original[c - 'a'] == 0) {
    //             uniqueChars++;
    //         }
    //         original[c - 'a']++;
    //     }
        
    //     // implement sliding window ...
    //     for (int st = 0; st < s.length() - p.length() + 1; st++) {
    //         if (isAnagram(s, st, st + p.length(), res, uniqueChars, original)) {
    //             res.add(st);
    //         }

    //     }

    //     return res;
    // }

    // public boolean isAnagram(String s, int st, int end, List<Integer> res, int uniqueChars, int[] original) {
    //     int[] aux = new int[26];
    //     int charCount = 0;
    //     for (int j = st; j < end; j++) {
    //         char c = s.charAt(j);
    //         if (aux[c - 'a'] + 1 == original[c - 'a']) {
    //             charCount++;
    //         }

    //         if (aux[c - 'a'] + 1 > original[c - 'a']) {
    //             return false;
    //         }

    //         aux[c - 'a']++;
    //     }

    //     return charCount == uniqueChars;
    // }

    // solution 2 O(n) --> pretty good

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) return res;

        int[] window = new int[26];
        int[] freq = new int[26];

        for (int i = 0 ; i < p.length(); i++) {
            window[s.charAt(i) - 'a']++;
            freq[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq, window)) {
            res.add(0);
        }

        for (int j = p.length(); j < s.length(); j++) {
            window[s.charAt(j - p.length()) - 'a']--;
            window[s.charAt(j) - 'a']++; 

            if (Arrays.equals(freq, window)) {
                res.add(j - p.length()+1);
            }
        } 

        return res;
    }
}
