import java.util.*;
class Solution {
    class Homework {
        private String name;
        private int playTime;
        
        public Homework(String name, int playTime){
            this.name = name;
            this.playTime = playTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        int answerIdx = 0;
        
        Stack<Homework> remainWorks = new Stack<>();
        
        for(int i = 0; i < plans.length - 1; i++){
            String[] p = plans[i];
            
            String name = p[0];
            int start = convertTime(p[1]);
            int playTime = Integer.parseInt(p[2]);
        
            int nextStart = convertTime(plans[i+1][1]);
            if(start + playTime > nextStart){
                int usedTime = nextStart - start;
                remainWorks.push(new Homework(name, playTime - usedTime));
            }
            else{
                answer[answerIdx] = name;
                answerIdx++;
                // 남은 시간동안 미완 과제들을 수행한다.
                int remain = nextStart - (start + playTime);
                while(remain > 0 && !remainWorks.isEmpty()){
                    Homework h = remainWorks.pop();
                    
                    if(h.playTime <= remain){
                        remain -= h.playTime;
                        answer[answerIdx++] = h.name;
                    } else{
                        h.playTime -= remain;
                        remainWorks.push(h);
                        remain = 0;
                    }
                }
            }                
        }
        answer[answerIdx++] = plans[plans.length - 1][0];
        
        while(!remainWorks.isEmpty()){
            answer[answerIdx++] = remainWorks.pop().name;
        }
    
        return answer;
        
    }
    
    public int convertTime(String time){
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        return hour * 60 + minute;
    }
}