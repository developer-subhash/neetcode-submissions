class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int n = nums.length;

        if(nums[l] < nums[r] || l == r){
            // not roatated, just simple binary search
            return binarySearch(nums, l, r, target);
        } else {
            // find other way, find lowest element, start of original arr
            int index = -1;
            while(l < r){
                int m = (l + r ) / 2;

                if(m == l){
                    if(nums[r] < nums[l]){
                        index = r;
                    }else{
                        index = l;
                    }
                    break;
                }

                if(nums[m] > nums[l]){
                    l = m+1;
                    if(l<n && nums[l] < nums[m]){
                        index = l;break;
                    }
                } else {
                    // other half
                    r = m - 1;
                    if(r>=0 && nums[r] > nums[m]){
                        index = m;break;
                    }
                }
            }
            if(index == -1)return -2;
            System.out.println(index);

            int index1 = binarySearch(nums, 0, index-1, target);
            if(index1 == -1){
                return binarySearch(nums, index, n-1, target);
            }else{
                return index1;
            }
        }

    }

    private int binarySearch(int[] nums, int l, int r, int target){
        while(l <= r){
            int m = (l + r) / 2;

            if(nums[m] > target){
                r = m - 1;
            }else if(nums[m] < target){
                l = m + 1;
            }else if(nums[m] == target){
                return m;
            }
        }

        return -1;
    }
}