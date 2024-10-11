class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] chairs = new int[n];
        Arrays.fill(chairs, -1);
        //
        int arrival = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(chairs[j] <= times[i][0]){
                    chairs[j] = times[i][1];

                    if(times[i][0] == arrival) return j;
                    break;
                }
            }
        }

        return -1;
    }
}