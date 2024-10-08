class Solution {
    public int minSwaps(String arr) {
        int n = arr.length();
        int closed = 0;
        int open = 0;
        int cnt = 0;
        char[] s = arr.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = s[i];
            if(ch == '[') list.add(i);
        }

        int k = list.size() - 1;

        for(int i = 0; i < n; i++){
            char ch = s[i];
            if(ch == ']'){
                closed++;
            }
            if(ch == '[') open++;
            if(closed > open){
                
                swap(i, list.get(k), s, n);
                cnt++;
                k--;
                closed--;
                open++;
            }
        }

        return cnt;
    }

    public void swap(int i, int j, char[] arr, int n){
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}