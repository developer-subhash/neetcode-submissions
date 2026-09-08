class Solution {
    public int search(int[] nums, int target) {
        // hint - atleast one half will always be sorted
        int n = nums.length;
        int l =0, r = n-1;

        while(l <= r){
            int m = (l + r) / 2;

            if(nums[m] < nums[r]){
                // right half sorted, search here
                int index = binarySearch(nums, m, r, target);
                if(index != -1)return index;
                r = m - 1;
            } else {
                // left half sorted, search here
                int index = binarySearch(nums, l, m, target);
                if(index != -1)return index;
                l = m + 1;
            }
        }

        return -1;
    }

    int binarySearch(int[] nums, int l, int r, int target){

        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target)return m;
            else if(nums[m] > target)r = m - 1;
            else l = m + 1;
        }

        return -1;
    }
}