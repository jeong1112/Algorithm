// 어떤 정수가 x^i + y^j 형태로 표현될 수 있다면 Powerful Integer이다.
// bound 이하의 정수 중에 powerful integer 모두 출력, 리스트 형태로.
import java.util.*;
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <= 100 ; i++){
            for(int j = 0; j <= 100 ; j++){
                int newX = (int)Math.pow(x, i);
                int newY = (int)Math.pow(y, j);
                if(newX > bound || newY > bound) continue;
                int num = newX + newY;
                if(num <= bound){
                    set.add(num);
                }
            }
        }
        List<Integer> answer = new ArrayList<>(set);
        return answer;
    }
}