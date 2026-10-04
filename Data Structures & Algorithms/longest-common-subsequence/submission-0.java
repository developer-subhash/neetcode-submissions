class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        
        int[][] dp = new int[n+1][m+1]; // dp[i][j] - length of common subsequence for s1 with i len, s2 with j len


        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // option to don't match curr if duplicate char present
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j-1], dp[i-1][j]));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        return dp[n][m];
    }
}