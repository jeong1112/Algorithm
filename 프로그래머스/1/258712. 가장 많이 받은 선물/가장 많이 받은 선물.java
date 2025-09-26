// 선물 지수 = 준 선물 - 받은 선물

import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, List<String>> giveMap = new HashMap<>(); // 준 선물, 누가 누구한테 줬는지
        Map<String, List<String>> receiveMap = new HashMap<>(); // 받은 선물, 누가 누구한테 받았는지
        //일단 입력값 맵에 저장부터
        for(String record : gifts){
            StringTokenizer st = new StringTokenizer(record);
            String from = st.nextToken();
            String to = st.nextToken();
            
            List<String> give = giveMap.getOrDefault(from, new ArrayList<>());
            give.add(to);
            giveMap.put(from, give);
            
            List<String> receive = receiveMap.getOrDefault(to, new ArrayList<>());
            receive.add(from);
            receiveMap.put(to, receive);
        }
        
        //선물 지수 계산
        
        Map<String, Integer> giftScore = new HashMap<>();
        
        for(String user : giveMap.keySet()){
            giftScore.put(user, giveMap.get(user).size());
        }
        
        for(String user : receiveMap.keySet()){
            int receiveCnt = receiveMap.get(user).size();
            if(giftScore.keySet().contains(user)){
                int score = giftScore.get(user);
                giftScore.put(user, score - receiveCnt);
            }
            else{
                giftScore.put(user, receiveCnt * (-1));
            }
        }
        Map<String, Integer> nextMonthGift = new HashMap<>();
        //다음 달에 누가 가장 많이 받을지 계산, 주고 받은 기록을 조사해야 함..
        
        for(int i = 0; i < friends.length ; i++){
            for(int j = i + 1 ; j < friends.length ; j++){
                String friend1 = friends[i];
                String friend2 = friends[j];
                
                if(friend1.equals(friend2)) continue;
                
                
                List<String> friend1_give = giveMap.getOrDefault(friend1, new ArrayList<>());
                List<String> friend2_give = giveMap.getOrDefault(friend2, new ArrayList<>());
                
                //선물을 주고받은 적이 있는 경우, 몇번 줬는지 조사.
                int friend1_give_count = 0;
                int friend2_give_count = 0;
                for(String s : friend1_give){
                    if(s.equals(friend2)) friend1_give_count++;
                }
                for(String s : friend2_give){
                    if(s.equals(friend1)) friend2_give_count++;
                }
                if(friend1_give_count > friend2_give_count){
                    int nextGift = nextMonthGift.getOrDefault(friend1, 0);
                    nextMonthGift.put(friend1, nextGift + 1);
                }
                else if(friend2_give_count > friend1_give_count){
                    int nextGift = nextMonthGift.getOrDefault(friend2, 0);
                    nextMonthGift.put(friend2, nextGift + 1);
                }         
                //선물을 주고받은 적이 없는 경우
                else{
                    int friend1_score = giftScore.getOrDefault(friend1, 0);
                    int friend2_score = giftScore.getOrDefault(friend2, 0);
                    if(friend1_score > friend2_score){
                        int nextGift = nextMonthGift.getOrDefault(friend1, 0);
                        nextMonthGift.put(friend1, nextGift + 1);
                    }
                    else if(friend2_score > friend1_score){
                        int nextGift = nextMonthGift.getOrDefault(friend2, 0);
                        nextMonthGift.put(friend2, nextGift + 1);
                    }
                }
                
            }
        }
        
        
        int answer = nextMonthGift.values().stream().max(Integer::compareTo).orElse(0);
        return answer;
    }
}