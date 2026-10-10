class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int ans = 0;

        for(int x : set){
            if(set.contains(x-1))continue;

            int l = 1;

            while(set.contains(x+1)){
                l++;
                x++;
            }
            ans = Math.max(ans, l);
        }

        return ans;
    }
}