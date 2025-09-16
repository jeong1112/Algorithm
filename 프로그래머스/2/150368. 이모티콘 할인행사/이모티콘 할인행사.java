import java.util.*;
class Solution {
    static int[][] userArr;
    static int[] emoticonArr;
    static int[] discountArr = {10, 20, 30, 40};
    static int maxEmoticonPlus = 0;
    static int maxSaleCount = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        
        userArr = users;
        emoticonArr = emoticons;
        
        combination(0, new int[emoticonArr.length]);
        
        int[] answer = new int[]{maxEmoticonPlus, maxSaleCount};
        
        return answer;
        
    }
    
    private void combination(int depth, int[] discount){
        // 최댓값 갱신
        if(depth == emoticonArr.length){
            int emoticonPlus = 0;
            int saleCount = 0;
            
            //사용자별로 판매금액, 이모티콘 플러스 가입 여부 계산
            for(int[] user : userArr){
                int maxDiscount = user[0];
                int maxPurchase = user[1];
                
                int userPurchase = 0;
                
                for(int i = 0; i < emoticonArr.length; i++){
                    if(maxDiscount <= discount[i]){
                        userPurchase += emoticonArr[i] /100 * (100-discount[i]);
                    }
                }
                if(userPurchase >= maxPurchase) emoticonPlus++;
                else saleCount += userPurchase;
            }
            if(emoticonPlus > maxEmoticonPlus){
                maxEmoticonPlus = emoticonPlus;
                maxSaleCount = saleCount;
            }
            else if(emoticonPlus == maxEmoticonPlus){
                maxSaleCount = Math.max(maxSaleCount, saleCount);
            }
            return;
        }
        
        for(int i = 0 ; i < 4; i++){
            discount[depth] = discountArr[i];
            combination(depth + 1, discount);
        }
        
    }
}