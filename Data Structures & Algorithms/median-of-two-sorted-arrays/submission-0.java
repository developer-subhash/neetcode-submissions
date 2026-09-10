class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // try partitioning two array, do binary search on smaller array
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        // check if both empty
        if(n+m == 0)return 0;


        int l = 0, r = m-1;

        int totalLeft = (n + m + 1)/2;

        boolean odd = ((n+m)%2 != 0);

        while(l <= r){
            int p1 = (l+r)/2;

            int p2 = totalLeft - (p1+1) - 1;

            int left1 = (p1>=0 ? nums1[p1] : Integer.MIN_VALUE);
            int right1 = (p1<m-1 ? nums1[p1+1] : Integer.MAX_VALUE);
            int left2 = (p2>=0 ? nums2[p2] : Integer.MIN_VALUE);
            int right2 = (p2<n-1 ? nums2[p2+1] : Integer.MAX_VALUE);

            // check partition valid
            if(left1 <= right2 && left2 <= right1){
                if(odd){
                    return Math.max(left1, left2);
                }else{
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            }

            if(left1 > right2){
                r = p1 - 1;
            }
            if(right1 < left2){
                l = p1 + 1;
            }
        }

        if(l>=m){
            // get all totalLeft from first array as second array couldn't provide
            return median(nums1, nums2, totalLeft, odd);
        }
        if(r<0){
            // get all totalLeft from second array as first array couldn't provide
            return median(nums2, nums1, totalLeft, odd);
        }

        return 0; // shouldn't reach here
    }

    private double median(int[] nums1, int[] nums2, int totalLeft, boolean odd){
        int m = nums1.length;
        int n = nums2.length;
        if(odd){
            if(totalLeft <= m)return nums1[totalLeft-1];
            totalLeft -= m;
            return nums2[totalLeft-1];
        }else{
            double sum = 0;
            if(totalLeft <= m){
                sum += nums1[totalLeft-1];
                if(totalLeft <= m-1){
                    sum += Math.min(nums1[totalLeft], (n>0 ? nums2[0] : Integer.MAX_VALUE));
                    return sum/2;
                }
                else{
                    totalLeft -= m;
                    sum += nums2[0];
                    return sum/2;
                }
            }else{
                totalLeft -=m;
                return (nums2[totalLeft-1] + nums2[totalLeft])/2.0;
            }

        }

    }


}

