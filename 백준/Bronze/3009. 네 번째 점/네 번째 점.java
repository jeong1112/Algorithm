import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] p1 = br.readLine().split(" ");
        String[] p2 = br.readLine().split(" ");
        String[] p3 = br.readLine().split(" ");
        String resultX = "";
        String resultY = "";
        if(p1[0].equals(p2[0])){
            resultX = p3[0];
        }
        else if( p1[0].equals(p3[0])){
            resultX = p2[0];
        }
        else if( p2[0].equals(p3[0])){
            resultX = p1[0];
        }

        if(p1[1].equals(p3[1])){
            resultY = p2[1];
        }
        else if( p1[1].equals(p2[1])){
            resultY = p3[1];
        }
        else if( p2[1].equals(p3[1])){
            resultY = p1[1];
        }



        System.out.println(resultX + " " + resultY);
    }


}


