import java.io.*;
import java.util.*;

public class Main {
    static int[][] wheels = new int[4][8];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 4; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                wheels[i][j] = line.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            simulation(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }

        // 여기서 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if(wheels[i][0] == 1){
                score += (int) Math.pow(2,i);
            }
        }
        System.out.println(score);
    }

    private static void simulation(int wheelNum, int direction){
        int[] rotateDir = new int[4];
        rotateDir[wheelNum] = direction;

        // 오른쪽 톱니바퀴 체크
        for (int i = wheelNum; i < 3; i++) {
            if (wheels[i][2] != wheels[i+1][6]) {
                rotateDir[i+1] = -rotateDir[i];
            } else {
                break;
            }
        }

        // 왼쪽 톱니바퀴 체크
        for (int i = wheelNum; i > 0; i--) {
            if (wheels[i][6] != wheels[i-1][2]) {
                rotateDir[i-1] = -rotateDir[i];
            } else {
                break;
            }
        }

        // 실제 회전 수행
        for (int i = 0; i < 4; i++) {
            if (rotateDir[i] != 0) {
                rotate(i, rotateDir[i]);
            }
        }
    }

    private static void rotate(int wheelNum, int direction){
        //시계 방향
        if(direction == 1){
            int temp = wheels[wheelNum][7];
            for(int i = 7; i >= 1 ; i--){
                wheels[wheelNum][i] = wheels[wheelNum][i-1];
            }
            wheels[wheelNum][0] = temp;
        }
        //반시게 방향
        else{
            int temp = wheels[wheelNum][0];
            for(int i = 0 ; i < 7; i++){
                wheels[wheelNum][i] = wheels[wheelNum][i+1];
            }
            wheels[wheelNum][7] = temp;
        }
    }




}