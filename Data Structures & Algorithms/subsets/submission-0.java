class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // total subset - 2 to the power n, use bit manipulation

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        int total = (int) Math.pow(2, n);

        int start = 0;

        while(start < total){
            int next = start+1;
            int index = 0;
            List<Integer> subset = new ArrayList<>();

            while(start != 0){
                if(start%2 == 1){
                    subset.add(nums[index]);
                }
                index++;
                start /= 2;
            }
            ans.add(subset);
            start = next;
        }

        return ans;
    }
}