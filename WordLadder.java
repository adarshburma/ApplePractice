/*
Leetcode: 

https://leetcode.com/problems/word-ladder/

*/


class Solution {
    
   HashMap<String, List<String>> adj = new HashMap<>();
    
    public void constructAdj (List<String> wordList, String beginWord) {
        wordList.add(beginWord);
        int m = beginWord.length();
        
        for (String word : wordList) {
            for (int j = 0 ; j < m; j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j+1);
                if (!adj.containsKey(pattern)) {
                    adj.put(pattern, new ArrayList<>());
                }
                
                adj.get(pattern).add(word);
            }
        }
    }
    
    public int bfs (String beginWord, List<String> wordList, String endWord) {
        Set<String> visited = new HashSet<>();
        int m = beginWord.length();
        constructAdj(wordList, beginWord);
        Queue<String> q = new LinkedList<>();
        int steps = 1;
        visited.add(beginWord);
        q.add(beginWord);
        
        while (!q.isEmpty()) {
            for (int i = 0 ; i < q.size(); i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return steps;
                }
                
                for (int j = 0 ; j < m; j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1);
                    for (String nei : adj.get(pattern)) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            q.add(nei);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return 0;
        
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;
        return bfs(beginWord, wordList, endWord);
    }
}
