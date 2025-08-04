class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        
        answer = countAlarm(endTime) - countAlarm(startTime);
        answer += alarmNow(startTime) ? 1 : 0;
        
        return answer;
    }
    
    private int countAlarm(int second){
        int minuteAlarm = second * 59 / 3600;
        int hourAlarm = second * 719 / 43200;
    
        int duplicatedAlarm = 43200 <= second ? 2 : 1;
        
        return minuteAlarm + hourAlarm - duplicatedAlarm;
    }
    
    private boolean alarmNow(int second) {
        return second * 59 / 3600 == 0 || second * 719 % 43200 == 0;
    }
}