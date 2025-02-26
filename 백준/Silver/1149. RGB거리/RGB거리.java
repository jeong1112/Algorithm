import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static int[][] DP;
    static int[][] RGB;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        RGB = new int[n][3];
        DP = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            RGB[i][RED] = Integer.parseInt(st.nextToken());
            RGB[i][GREEN] = Integer.parseInt(st.nextToken());
            RGB[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        DP[0][RED] = RGB[0][RED];
        DP[0][GREEN] = RGB[0][GREEN];
        DP[0][BLUE] = RGB[0][BLUE];
        System.out.print(Math.min(calculateCost(n - 1, RED), Math.min(calculateCost(n - 1, GREEN), calculateCost(n - 1, BLUE))));

    }

    private static int calculateCost(int n, int color){
        if(DP[n][color] == 0){
            if(color == RED){
                DP[n][color] = Math.min(calculateCost(n-1,GREEN), calculateCost(n-1,BLUE)) + RGB[n][RED];
            }
            else if(color == GREEN){
                DP[n][color] = Math.min(calculateCost(n-1,RED), calculateCost(n-1,BLUE)) + RGB[n][GREEN];
            }
            else if(color == BLUE){
                DP[n][color] = Math.min(calculateCost(n-1,RED), calculateCost(n-1,GREEN)) + RGB[n][BLUE];
            }
        }
        return DP[n][color];
    }


}
