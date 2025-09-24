import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];

        Map<String, Set<String>> userReport = new HashMap<>();

        Map<String, Integer> reportedCount = new HashMap<>();

        for (String r : report) {
            StringTokenizer st = new StringTokenizer(r);
            String reporter = st.nextToken();
            String reported = st.nextToken();

            // reporter의 집합 가져오고 없으면 새로 생성
            Set<String> targets = userReport.computeIfAbsent(reporter, key -> new HashSet<>());

            // 중복이 아니면 추가
            if (targets.add(reported)) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            }
        }

        Set<String> suspended = new HashSet<>();
        for (Map.Entry<String, Integer> e : reportedCount.entrySet()) {
            if (e.getValue() >= k) suspended.add(e.getKey());
        }

        Map<String, Integer> mailCount = new HashMap<>();
        for (Map.Entry<String, Set<String>> e : userReport.entrySet()) {
            String reporter = e.getKey();
            int cnt = 0;
            for (String target : e.getValue()) {
                if (suspended.contains(target)) cnt++;
            }
            mailCount.put(reporter, cnt);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}