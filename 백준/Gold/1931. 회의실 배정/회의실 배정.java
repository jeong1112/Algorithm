import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Conference {
        private final int startTime;
        private final int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Conference> conferences = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            conferences.add(new Conference(startTime, endTime));
        }

        conferences.sort(Comparator.comparingInt(Conference::getEndTime)
                .thenComparingInt(Conference::getStartTime));

        int count = 0;
        int lastEndTime = 0;

        for (Conference c : conferences) {
            if (c.getStartTime() >= lastEndTime) {
                count++;
                lastEndTime = c.getEndTime();
            }
        }

        System.out.println(count);
    }
}
