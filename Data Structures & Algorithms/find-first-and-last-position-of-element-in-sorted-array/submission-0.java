class Solution {
    public int[] searchRange(int[] nums, int target) {
        // apply binary search for lower and upper bound

        int u = -1, v = -1;

        int l = 0, r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;

            if(nums[m]>target){
                r = m-1;
            }else if(nums[m]<target){
                l = m+1;  
            }else{
                u = m;
                r = m-1;
            }
        }

        l = 0; r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;

            if(nums[m]>target){
                r = m-1;
            }else if(nums[m]<target){
                l = m+1;  
            }else{
                v = m;
                l = m+1;
            }
        }

        int[] ans = new int[2];
        ans[0] = u;
        ans[1] = v;

        return ans;
    }
}