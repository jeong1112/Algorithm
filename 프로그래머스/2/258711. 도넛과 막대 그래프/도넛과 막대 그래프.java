import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // 정점 번호, 도넛, 막대, 8자 순서
        // 생성한 정점은 보면 나가는 간선만 있고 들어오는 것이 없다.
        // 8자 그래프는 가운데 원소가 2개 들어오고 2개 나간다.
        // 막대 그래프는 마지막꺼가 들어오는 것만 1개 있다.
        // 생성한 정점에서 나가는 간선의 수가 그래프의 총 수이다.
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int[] edge : edges){
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int key : out.keySet()){
            
            if(out.get(key) > 1){
                if(!in.containsKey(key)){
                    answer[0] = key;
                }
                else{
                    answer[3]++;
                }
            }
            
        }
        
        for(int key : in.keySet()){
            if(!out.containsKey(key)){
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}