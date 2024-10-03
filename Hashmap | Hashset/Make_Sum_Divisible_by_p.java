class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int cumm = 0;
        int sum = 0;
        
        for(int num : nums){
            sum = (sum + num) % p;
        }

        int t = sum % p;

        if(t == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int len = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            cumm += nums[i];
            cumm %= p;

            int check = (cumm - t + p) % p;
            if(map.containsKey(check)){
                len = Math.min(len, i - map.get(check));
            }

            map.put(cumm, i);
        }

        return len == n? -1 : len;
    }
}
