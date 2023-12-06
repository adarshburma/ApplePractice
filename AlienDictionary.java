/*

  https://leetcode.com/problems/alien-dictionary/description/?source=submission-noac
*/



class Solution {
    public static String alienOrder(String[] words) {
        HashMap<Character, List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (String word: words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                adj.put(c, new ArrayList<>());
            }
        }

        // adjacency matrix built ...
        for (int i = 0 ; i < words.length-1; i++) {
            String par = words[i];
            String child = words[i+1];
            if (par.length() > child.length() && par.startsWith(child)) return "";
            int len = Math.min(par.length(), child.length());
            for (int ptr = 0 ; ptr < len; ptr++) {
                if (par.charAt(ptr) != child.charAt(ptr)) {
                    if (!adj.containsKey(par.charAt(ptr))) {
                        adj.put(par.charAt(ptr), new ArrayList<>());
                    }
                    adj.get(par.charAt(ptr)).add(child.charAt(ptr));
                    
                    
                    indegree.put(child.charAt(ptr), indegree.get(child.charAt(ptr)) + 1);
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        
        for (Map.Entry<Character, List<Character>> e : adj.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        for (Map.Entry<Character, Integer> e : indegree.entrySet()){
            if (e.getValue() == 0) {
                q.add(e.getKey());
            }
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            char poped = q.poll();
            System.out.println(poped + " .. ");
            sb.append(poped);
            if (adj.containsKey(poped)) {
                for (char c : adj.get(poped)) {
                    indegree.put(c, indegree.get(c)-1);
                    if (indegree.get(c) == 0) {
                        q.add(c);
                    }
                }
            }
        }

        if (sb.length() < adj.size()) return "";

        return sb.toString();
        
    }
}
