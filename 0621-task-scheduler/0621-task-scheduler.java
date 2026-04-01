import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] frequency = new int[26];
        for(char c: tasks){
            frequency[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : frequency){
            if(f > 0){
                pq.offer(f);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int freq = pq.poll() - 1;
                if(freq > 0){
                    q.offer(new int[]{freq, time + n});
                }
            }
            
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.offer(q.poll()[0]);
            }

        }
        return time;
    }
}