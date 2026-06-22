class Solution {
    int k;
    public int minimumSum(int n, int k) {

        this.k = k;
        List<Integer> list = new ArrayList<>();
        int num = 1;

        while(true){
            if(list.size() == n) break;

            if(!list.contains(k - num)){
                list.add(num);
            }
            num++;
        }

        return list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna