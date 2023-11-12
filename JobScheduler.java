/*
LeetCode:

https://leetcode.com/problems/task-scheduler/

*/


class Solution {

    class Node {
        int rem;
        int time;

        Node(int rem, int time) {
            this.rem = rem;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        HashMap<Character, Integer> jobFreq = new HashMap<>();

        for (char task : tasks) {
            jobFreq.put(task, jobFreq.getOrDefault(task, 0)+1);
        } 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (n1 , n2) -> n2 - n1
        );

        for (Map.Entry<Character, Integer> e : jobFreq.entrySet()) {
            maxHeap.offer(e.getValue());
        }

        Queue<Node> waiting = new LinkedList<>();

        while(!maxHeap.isEmpty() || !waiting.isEmpty()) {

            time++;

            if(!maxHeap.isEmpty()) {
                int poped = maxHeap.poll();
                if (poped - 1 > 0) {
                    waiting.add(new Node(poped - 1, time + n));
                } 
            }
           

            if (!waiting.isEmpty()) {
               if (waiting.peek().time == time) {
                   maxHeap.offer(waiting.poll().rem);
               }
            }
        }

        return time;
    }
}
