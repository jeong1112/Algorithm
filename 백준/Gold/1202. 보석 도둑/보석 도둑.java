import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[n];
        int[] bag =  new int[k];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Jewelry jewelry = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            jewelries[i] = jewelry;
        }

        for(int i = 0; i < k; i++){
            int maximumWeight = Integer.parseInt(br.readLine());
            bag[i] = maximumWeight;
        }

        //현재 가방보다 무게가 덜 나가면서 가장 비싼 놈들을 골라야 함.
        Arrays.sort(jewelries, (o1, o2) -> {
            if(o1.weight == o2.weight){
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });

        Arrays.sort(bag);

        //가장 비싼 보석을 우선적으로 선택해야 하므로 내림차순으로 정렬한다
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        for(int i = 0, j = 0 ; i < k ; i++){
            while(j < n && bag[i] >= jewelries[j].weight){
                pq.offer(jewelries[j++].price);
            }
            if(!pq.isEmpty()){
                answer +=  pq.poll();
            }
        }

        System.out.println(answer);


    }

    static class Jewelry{
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }


}