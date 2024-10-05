class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        //TC - O((m-n) * (nlog n))
        for(int i=0;i<=m-n;i++){
            char[] c2 = s2.substring(i, i + n).toCharArray();
            Arrays.sort(c2);
            if(Arrays.equals(c1, c2)) return true;
        }

        return false;
    }
}