import java.util.*;

/**
 * 332. Reconstruct Itinerary -- Medium
 *
 * Find Path --> DFS --> Topological Sort
 */

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> h = new HashMap<>();
        for (List<String> l : tickets) {
//            PriorityQueue<String> pq = h.getOrDefault(l.get(0), new PriorityQueue<>());
//            pq.add(l.get(1));
//            h.put(l.get(0), pq);
            h.computeIfAbsent(l.get(0), v -> new PriorityQueue<>()).add(l.get(1));
        }
        List<String> res = new LinkedList<>();
        dfs("JFK", res, h);
        return res;
    }

    private void dfs(String airport, List<String> res, HashMap<String, PriorityQueue<String>> h) {
        while (h.containsKey(airport) && !h.get(airport).isEmpty()) {
            String str = h.get(airport).poll();
            dfs(str, res, h);
        }
        res.add(0, airport);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("MUC", "LHR"));
//        tickets.add(Arrays.asList("JFK", "MUC"));
//        tickets.add(Arrays.asList("SFO", "SJC"));
//        tickets.add(Arrays.asList("LHR", "SFO"));

        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        tickets.add(Arrays.asList("JFK", "NRT"));

        List<String> res = s.findItinerary(tickets);
        for (String e : res) {
            System.out.println(e);
        }
    }
}