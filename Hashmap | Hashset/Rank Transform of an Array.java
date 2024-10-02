class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] newArr = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(newArr);

        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: newArr){
            if(!map.containsKey(num)){
                map.put(num, rank);
                rank++;
            }
        }

        for(int i=0;i<n;i++){
            newArr[i] = map.get(arr[i]);
        }

        return newArr;
    }
}
