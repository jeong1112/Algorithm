import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Member> members = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Member m = new Member(age, name, i);
            members.add(m);
        }
        Collections.sort(members,new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                int res = 0;
                if(o1.age > o2.age){
                    res = 1;

                }
                else if(o1.age < o2.age){
                    res = -1;
                }
                else{
                    if(o1.order > o2.order){
                        res = 1;
                    }
                    else if(o1.order < o2.order){
                        res = -1;
                    }
                }
                return res;
            }
        });
        for (Member m : members) {
            System.out.println(m.age + " " + m.name);
        }
    }

    public static class Member{
        private int age;
        private String name;
        private int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
