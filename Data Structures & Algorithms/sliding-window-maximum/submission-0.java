class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // key note - for any highest element in a window, we don't need all smaller element left to that highest
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n-k+1];

        
        for(int i=0;i<k;i++){
            if(d.isEmpty()){
                d.add(nums[i]);
            }else{
                while(!d.isEmpty() && d.getLast()<nums[i]){
                    d.pollLast();
                }
                d.add(nums[i]);
            }
        }
        ans[0] = d.getFirst();
        for(int i=k;i<n;i++){
            if(nums[i-k] == d.getFirst()){
                d.pollFirst();
            }
            if(d.isEmpty()){
                d.add(nums[i]);
            }else{
                while(!d.isEmpty() && d.getLast()<nums[i]){
                    d.pollLast();
                }
                d.add(nums[i]);
            }

            ans[i-k+1] = d.getFirst();
        }

        return ans;
    }
}