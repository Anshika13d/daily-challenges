class Solution {
    public char findKthBit(int n, int k) {
        //3 cases
        //1st => k < len / 2;
        //2nd => k == len / 2;
        //3rd => k > len / 2;

        if(n == 1) return '0';

        int len = (1 << n) - 1;

        if(k < Math.ceil(len / 2.0)){
            return findKthBit(n-1, k);
        }
        else if(k == Math.ceil(len / 2.0)){
            return '1';
        }
        else{
            char ch = findKthBit(n - 1, len - (k - 1));
            if(ch == '0') return '1';
            else return '0';
        }
    }
}