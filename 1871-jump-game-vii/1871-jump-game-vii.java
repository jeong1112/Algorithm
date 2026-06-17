class Solution {
    String s;
    int minJump;
    int maxJump;
    public boolean canReach(String s, int minJump, int maxJump) {
        this.s = s;
        this.minJump = minJump;
        this.maxJump = maxJump;
        if (s.charAt(0) != '0') return false;

        return bfs();
    }

    private boolean bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.offer(0);
        visited[0] = true;
        
        int idx = 0;

        while(!q.isEmpty()){
            int temp = q.poll();
            visited[temp] = true;

            int start = Math.max(temp + minJump, idx + 1);
            int end = Math.min(temp + maxJump, s.length() - 1);

            if(temp == s.length() - 1) return true;

            // 겹치는 구간은 제외하고 검사해야 한다.
            for(int i = start; i <= end; i++){
                if(i >= s.length()) break;
                if(s.charAt(i) == '0' && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }

            idx = Math.max(idx, end);
        }

        return false;

    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna