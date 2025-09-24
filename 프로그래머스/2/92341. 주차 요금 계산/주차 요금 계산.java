import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> carIn = new HashMap<>();
        Map<Integer, Integer> carOut = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = convertTimeToMin(st.nextToken());
            int carNum = Integer.parseInt(st.nextToken());
            String InOut = st.nextToken();
            //입차인 경우
            if(InOut.equals("IN")){
                carIn.put(carNum, time);
            }
            //출차인 경우
            else{
                int carInTime = carIn.get(carNum);
                carIn.remove(carNum);
              
                if(carOut.containsKey(carNum)){ 
                    int carOutTime = carOut.get(carNum);
                    carOut.replace(carNum, carOutTime + time - carInTime);
                }
                else{
                    carOut.put(carNum, time - carInTime);
                }
            }
            
        }
        
        //23시 59분
        int maxTime = 1439;
        
        //IN은 있는데 OUT이 없는, 즉 23시 59분 출차 차량들
        for(int car : carIn.keySet()){
            int carInTime = carIn.get(car);
            if(carOut.containsKey(car)){
                int carOutTime = carOut.get(car);
                carOut.replace(car, carOutTime + maxTime - carInTime);
            }
            else{
                carOut.put(car, maxTime - carInTime);
            }
        }
        
        int baseTime = fees[0];
        int basePrice = fees[1];
        int extraTime = fees[2];
        int extraPrice = fees[3];
        
        int[] answer = new int[carOut.size()];
        
        Object[] cars = carOut.keySet().toArray();
        Arrays.sort(cars);
        for(int i = 0 ; i < cars.length; i++){
            int totalPrice = basePrice;
            //기본 시간이 지난 경우 
            int car = Integer.parseInt(String.valueOf(cars[i]));
            int totalParkingTime = carOut.get(car);
            if(totalParkingTime > baseTime){
                totalPrice = (int)(basePrice + Math.ceil((double)((totalParkingTime - baseTime)) / extraTime) * extraPrice);
            }
            answer[i] = totalPrice;
        }
        
        
        return answer;
    }
    
    private static int convertTimeToMin(String time){
        String[] timeInt = time.split(":");
        return Integer.parseInt(timeInt[0]) * 60 + Integer.parseInt(timeInt[1]);
    }
}