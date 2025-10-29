import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int n = cards.length;
        int target = n + 1;
        int cardIndex = n / 3;
        
        //처음에 가지고 있을 카드 구한다.
        Set<Integer> additionalCard = new HashSet<>();
        Set<Integer> originalCard = new HashSet<>();
        for(int i = 0 ; i < cardIndex; i++){
            originalCard.add(cards[i]);
        }
        
        while(true){
            answer++;
            
            //카드뭉치에 카드가 더이상 없는 경우
            if(cardIndex + 1 >= n) break;
            
            // 카드를 두 장 뽑는다
            int first = cards[cardIndex];
            int second = cards[cardIndex + 1];
            cardIndex += 2;
            additionalCard.add(first);
            additionalCard.add(second);
            
            boolean flag = false;
            
            //기존에 있던 카드로도 합을 맞출 수 있는 경우
            for(int i : originalCard){
                if(originalCard.contains(target - i)){
                    originalCard.remove(i);
                    originalCard.remove(target - i);
                    flag = true;
                    break;
                }
            }
            
            //기존에 있던 카드 1장, 새로운 카드 1장
            if(!flag){
              for(int i : originalCard){
                if(coin > 0){
                    if(additionalCard.contains(target - i)){
                        originalCard.remove(i);
                        additionalCard.remove(target - i);
                        flag = true;
                        coin--;
                        break;
                        }
                    }
                }
            }
           
            
            //새로운 카드 2장 
            if(!flag){
               for(int i : additionalCard){
                if(coin > 1){
                    if(additionalCard.contains(target - i)){
                        additionalCard.remove(i);
                        additionalCard.remove(target - i);
                        flag = true;
                        coin -= 2;
                        break;
                        }
                    }
                } 
            }
            
            if(!flag) break; 
            
        }
        return answer;
    }
}