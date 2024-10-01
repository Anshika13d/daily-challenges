class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] mp = new int[k];

        for(int num: arr){
            //to handle the cases where the elements are negative and have to find remainder.
            int rem = (num % k + k) % k;
            mp[rem]++;
        }

        if(mp[0] % 2 != 0) return false;

        for(int i=1;i<=k/2;i++){
            int calc = k - i;
            if (mp[calc] != mp[i]) return false;
        }

        return true;
    }
}