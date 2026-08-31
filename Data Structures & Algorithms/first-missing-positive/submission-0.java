class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // treat array index start with 1
        // asnwer lie bwteen 1 to n+1
        // let's put each element between 1 to n to its correct index , and ignore remaining

        for(int i=0;i<n;i++){
            if(arr[i] == i+1 || arr[i]<=0 || arr[i]>n)continue;
        
            // swap current element to its correct position
            while(arr[i]>0 && arr[i]<=n && arr[i]!=i+1){
                // swap 
                int index = arr[i]-1;
                int j = arr[index];
                if(j == arr[i]){
                    // duplicate element, so ignore
                    break;
                }
                arr[index] = arr[i];
                arr[i] = j;
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i] != i+1)return i+1;
        }

        return n+1;
    }
}