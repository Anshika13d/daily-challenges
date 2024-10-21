class Solution {
    public int maxUniqueSplit(String s) {
        int n = s.length();

        Set<String> set = new HashSet<>();
        
        return helper(0, 0, s, n, set);
    }

    public int helper(int ind, int currCnt, String s, int n, Set<String> set){
        if(ind >= n) return currCnt;

        int maxCnt = 0;

        for(int i=ind;i<n;i++){
            String str = s.substring(ind, i + 1);
            if(!set.contains(str)){
                set.add(str);
                maxCnt = Math.max(maxCnt, helper(i + 1, currCnt + 1, s, n, set));
                set.remove(str);
            }
        }

        return maxCnt;
    }
}
