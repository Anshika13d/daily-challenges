class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int num[] : intervals){
            int s = num[0];
            int e = num[1];

            if(!pq.isEmpty() && pq.peek() < s){
                pq.poll();
            }
            
            pq.offer(e);
        }

        return pq.size();
    }
}
