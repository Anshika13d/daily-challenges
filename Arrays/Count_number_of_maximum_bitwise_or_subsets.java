class Solution {
    public int countMaxOrSubsets(int[] nums) {
        //find max or
        int n = nums.length;
        //find the max OR
        int maxi = nums[0];
        for(int i=1;i<n;i++){
            maxi |= nums[i];
        }

        int[][] dp = new int[n+1][maxi+1];
        for(int[] num: dp){
            Arrays.fill(num, -1);
        }

        return count(0, 0, nums, maxi, dp);
    }

    public int count(int ind, int currOr, int[] nums, int maxi, int[][] dp){
        if(ind >= nums.length){
            
            if(currOr == maxi) return 1;
            
            return 0;
        }

        if(dp[ind][currOr] != -1) return dp[ind][currOr];

        //take it
        int take = count(ind + 1, currOr | nums[ind], nums, maxi, dp);

        //not take it

        int notTake = count(ind + 1, currOr, nums, maxi, dp);

        return dp[ind][currOr] = take + notTake;
    }
}
