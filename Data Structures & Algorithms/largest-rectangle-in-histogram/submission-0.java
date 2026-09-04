class Solution {
    public int largestRectangleArea(int[] heights) {
        // find nearest smaller element index for current element both side
        int n = heights.length;

        int[] left = new int[n]; // left[i] - index of next smaller element in left of current element
        int[] right = new int[n]; // right[i] - index of next smaller element in right of curr element

        // base case - when no such next smaller element exist
        for(int i=0;i<n;i++){
            left[i] = -1;
            right[i] = n;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    int index = stack.peek();
                    if(heights[index] >= heights[i]){
                        stack.pop();
                    } else {
                        left[i] = index;
                        break;
                    }
                }
                stack.push(i);
            }
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    int index = stack.peek();
                    if(heights[index] >= heights[i]){
                        stack.pop();
                    } else {
                        right[i] = index;
                        break;
                    }
                }
                stack.push(i);
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            int l = heights[i];
            int b = right[i]-1 - left[i]-1 + 1;
            ans = Math.max(ans, l*b);
        }

        return ans;

    }
}