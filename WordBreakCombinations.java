class Solution {

    HashMap<String, List<String>> dp = new HashMap<>();
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.length() < word.length()) continue;
            
            if (s.substring(0, word.length()).equals(word)) {
                if (s.length() == word.length()) {
                    res.add(word);
                } else {
                    List<String> intermediate = wordBreak(s.substring(word.length()), wordDict);
                    
                    for (String sentence : intermediate) {
                        res.add(word + " " + sentence);
                    }
                }
            }
        }
        dp.put(s, res);
        return res;
    }
}
