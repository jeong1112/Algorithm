import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        dpMax[0] = dpMin[0] = map[0][0];
        dpMax[1] = dpMin[1] = map[0][1];
        dpMax[2] = dpMin[2] = map[0][2];

        for (int i = 1; i < n; i++) {
            int[] nextMax = new int[3];
            int[] nextMin = new int[3];

            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    nextMax[0] = Math.max(dpMax[0], dpMax[1]) + map[i][0];
                    nextMin[0] = Math.min(dpMin[0], dpMin[1]) + map[i][0];
                } else if (j == 2) {
                    nextMax[2] = Math.max(dpMax[1], dpMax[2]) + map[i][2];
                    nextMin[2] = Math.min(dpMin[1], dpMin[2]) + map[i][2];
                } else {
                    nextMax[1] = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]) + map[i][1];
                    nextMin[1] = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]) + map[i][1];
                }
            }

            dpMax = nextMax;
            dpMin = nextMin;
        }

        int maxAns = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
        int minAns = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
        System.out.println(maxAns + " " + minAns);
    }
}