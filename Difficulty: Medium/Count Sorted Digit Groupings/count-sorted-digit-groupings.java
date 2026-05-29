class Solution {
    public int validGroups(String s) {
        // code here
        int n=s.length();
        int[][] dp=new int[n][99*n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,s,-1,dp);
    }
    static int f(int idx,String s,int p,int[][] dp){
        if(idx==s.length()) return 1;
        if(dp[idx][p+1]!=-1) return dp[idx][p+1];
        int num=0;
        int ts=0;
        for(int i=idx;i<s.length();i++){
            num=num+s.charAt(i)-'0';
            if(p<=num) ts=ts+f(i+1,s,num,dp);
        }
    return dp[idx][p+1]=ts;
    }
}