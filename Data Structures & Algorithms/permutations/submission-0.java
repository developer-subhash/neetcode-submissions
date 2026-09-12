class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        boolean[] selected = new boolean[n];
        for(int i=0;i<n;i++)selected[i] = false;

        int[] curr = new int[n];

        rec(0, nums, selected, curr, ans);

        return ans;
    }

    void rec(int i,int[] nums, boolean[] selected, int[] curr, List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                t.add(curr[j]);
            }
            ans.add(t);
            return;
        }

        int j = 0;
        while(j < nums.length){
            if(!selected[j]){
                selected[j] = true;
                curr[i] = nums[j];
                rec(i+1, nums, selected, curr, ans);
                selected[j] = false;
            }
            j++;
        }
    }
}