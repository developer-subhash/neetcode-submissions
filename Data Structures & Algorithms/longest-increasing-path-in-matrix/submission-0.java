class Solution {
    int n,m;
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == -1){
                    ans = Math.max(ans, help(matrix, dp, i, j));
                }
            }
        }

        return ans;
    }

    int help(int[][] matrix, int[][] dp, int i, int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 1;
        for(int d=0; d<4; d++){
            int u = i + dx[d], v = j + dy[d];

            if(u>=0 && u<n && v>=0 && v<m && matrix[u][v]>matrix[i][j]){
                ans = Math.max(ans, 1 + help(matrix, dp, u, v));
            }
        }

        dp[i][j] = ans;
        return ans;
    }
}