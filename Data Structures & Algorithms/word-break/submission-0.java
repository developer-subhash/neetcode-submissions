class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        int[] dp = new int[n]; // dp[i] if s[i..n-1] can be broken successfully or not
        for(int i=0; i<n; i++)dp[i] = -1;

        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }

        return help(0, s, set, dp);
    }

    boolean help(int i, String s, Set<String> set, int[] dp){
        if(i == s.length())return true;

        if(dp[i] != -1){
            return dp[i]==1 ? true : false;
        }

        for(int j=i+1;j<=s.length();j++){
            if(set.contains(s.substring(i, j))){
                if(help(j, s, set, dp)){
                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = 0;
        return false;
    }
}