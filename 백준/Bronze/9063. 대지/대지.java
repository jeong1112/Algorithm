import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 1){
            System.out.println(0);
            return;
        }
        List<Integer> xValues = new ArrayList<>();
        List<Integer> yValues = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            xValues.add(Integer.parseInt(s.split(" ")[0]));
            yValues.add(Integer.parseInt(s.split(" ")[1]));
        }
        Collections.sort(xValues);
        Collections.sort(yValues);
        int resultX = xValues.get(xValues.size() - 1) - xValues.get(0);
        int resultY = yValues.get(yValues.size() - 1) - yValues.get(0);
        System.out.println(resultX * resultY);
    }
}


