/*
  Leetcode: https://leetcode.com/problems/unique-number-of-occurrences/

*/


class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> uniqueCounts = new HashSet<>();

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            uniqueCounts.add(entry.getValue());
        }

        return uniqueCounts.size() == count.size();
    }

    // count sort ...
    public boolean uniqueOccurrences2(int[] arr) { 
        int offset = 1000;
        int[] counts = new int[offset * 2];

        for (int i : arr) {
            counts[i + offset]++;
        }

        Arrays.sort(counts);

        for (int i = 1 ; i < counts.length; i++) {
            if (counts[i] != 0 && counts[i] == counts[i-1]) {
                return false;
            }
        }

        return true;
    }

}
