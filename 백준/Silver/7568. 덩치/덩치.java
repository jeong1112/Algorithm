import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            Person p = new Person(weight,height,1);
            persons.add(p);
        }
        for(int i = 0; i < n; i++){
            Person p1 = persons.get(i);
            for(int j = 0; j < persons.size(); j++){
                Person p2 = persons.get(j);
                if(p1.weight > p2.weight && p1.height > p2.height){
                    p2.rank++;
                }
            }
        }
        for (Person person : persons) {
            bw.write(person.getRank() + " ");
        }

        bw.flush();
        bw.close();
    }
    private static class Person {
        private int weight;
        private int height;
        private int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }
    }
}
