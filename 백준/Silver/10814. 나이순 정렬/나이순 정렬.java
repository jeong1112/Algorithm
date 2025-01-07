import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] persons = new StringBuilder[201];

        for(int i = 0; i < persons.length; i++) {
            persons[i] = new StringBuilder();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons[age].append(age).append(" ").append(name).append("\n");
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder val : persons) {
            sb.append(val);
        }

        System.out.println(sb);
    }


}
