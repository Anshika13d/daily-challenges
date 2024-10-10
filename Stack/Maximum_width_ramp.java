class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        int[] far = new int[n];
        getFar(nums, far, n);

        int ramp = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            ramp = Math.max(ramp, far[i] - i);
        }

        return ramp;
    }

    public void getFar(int[] nums, int[] far, int n){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(s1.isEmpty() || nums[s1.peek()] < nums[i]){
                s1.push(i);
            }
            while(!s1.isEmpty() && nums[s1.peek()] >= nums[i]){
                s2.push(s1.pop());
            }
            if(!s2.isEmpty()){
                far[i] = s2.peek();
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }
}
