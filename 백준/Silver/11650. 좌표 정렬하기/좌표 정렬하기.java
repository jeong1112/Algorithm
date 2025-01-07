import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Position> positions = new ArrayList<Position>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Position p = new Position(x, y);
            positions.add(p);
        }
        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {

                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                else{
                    return o1.x - o2.x;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Position position : positions) {
            sb.append(position.x).append(" ").append(position.y).append("\n");
        }
        System.out.println(sb);
    }

    public static class Position{
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
