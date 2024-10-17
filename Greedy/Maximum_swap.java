class Solution {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);

        int n = str.length();
        char[] c = str.toCharArray();
        for(int i=0;i<n;i++){
            int val = c[i] - '0';
            int max = val;

            int ind = -1;
            for(int j=i+1;j<n;j++){
                int val2 = c[j] - '0';
                if(val2 >= max && val != val2){
                    max = val2;
                    ind = j;
                }
            }
            if(ind != -1){
                swap(i, ind, c);
                break;
            }
        }

        String str2 = new String(c);

        int number = Integer.parseInt(str2);
        return number;
    }

    public void swap(int c1, int c2, char[] c){
        int n = c.length;

        char temp = c[c1];
        c[c1] = c[c2];
        c[c2] = temp;
    }
}