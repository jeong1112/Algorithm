import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] distances = new int[6] ;
        int k = Integer.parseInt(br.readLine());
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int maxWidthIdx = 0;
        int maxHeightIdx = 0;
        for(int i = 0 ; i < 6 ; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(direction == 1 || direction == 2){
                if(value > maxWidth){
                    maxWidth = value;
                    maxWidthIdx = i;
                }
            }
            else if(direction == 3 || direction == 4){
                if(value > maxHeight){
                    maxHeight = value;
                    maxHeightIdx = i;
                }
            }
            distances[i] = value;
        }

        int maxArea = maxWidth * maxHeight;
        int duplicateArea = distances[(maxWidthIdx + 3) % 6] * distances[(maxHeightIdx + 3) % 6];
        System.out.println((maxArea - duplicateArea) * k);


    }




}
