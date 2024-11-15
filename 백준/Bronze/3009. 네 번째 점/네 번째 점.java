import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int[] p1 = {sc.nextInt(),sc.nextInt()};
        int[] p2 = {sc.nextInt(),sc.nextInt()};
        int[] p3 = {sc.nextInt(),sc.nextInt()};
        int resultX = 0;
        int resultY = 0;
        if(p1[0] == p2[0]){
            resultX = p3[0];
        }
        else if(p1[0] == p3[0]){
            resultX = p2[0];
        }
        else if(p2[0] == p3[0]){
            resultX = p1[0];
        }

        if(p1[1] == p2[1]){
            resultY = p3[1];
        }

        else if(p1[1] == p3[1]){
            resultY = p2[1];
        }

        else if(p2[1] == p3[1]){
            resultY = p1[1];
        }

        System.out.println(resultX + " " + resultY);
    }


}


