class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int l = 0, r = n-1;

        // place 0 at beginning, 2 at last, ignore 1
        for(int i=0;i<n;i++){
            boolean swapped = true;
            while(swapped){
                swapped = false;
                if(nums[i] == 0 && i>l){
                    swap(nums, l, i);
                    l++;
                    swapped = true;
                }
                if(nums[i] == 2 && i<r){
                    swap(nums, i, r);
                    r--;
                    swapped = true;
                }
            }
            
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}