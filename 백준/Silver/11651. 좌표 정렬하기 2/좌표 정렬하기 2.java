import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      List<Position> positions = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          Position p = new Position(a, b);
          positions.add(p);
      }
      Collections.sort(positions, new Comparator<>() {
          @Override
          public int compare(Position o1, Position o2) {
              if(o1.getY() == o2.getY()){
                  return o1.getX() - o2.getX();
              }
              return o1.getY() - o2.getY();
          }
      });
        for (Position position : positions) {
            System.out.println(position.getX() + " " + position.getY());
        }




    }

    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
