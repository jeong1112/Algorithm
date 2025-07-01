import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;
    static int[] wine;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Person> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int document =  Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                list.add(new Person(document, interview));
            }
            Collections.sort(list);
            int answer = 1;
            int min = list.get(0).interview;
            for(int j=1;j<n;j++){
                if(list.get(j).interview < min){
                    min = list.get(j).interview;
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }

    static class Person implements Comparable<Person>{

        int document; // 점수
        int interview; // 면접

        public Person(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Person o) {
            return this.document- o.document;
        }
    }

}