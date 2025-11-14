class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int i=n;
        int j=m;
        int dp[][]=new int[n+1][m+1];
        for(int k=0;k<=n;k++){
            Arrays.fill(dp[k],-1);
        }
        return s1.length()+s2.length()-f(i,j,s1,s2,dp);
    }
    public static int f(int i,int j,String s1, String s2,int dp[][]){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]=1+f(i-1,j-1,s1,s2,dp);
        }
        else {
            return dp[i][j]=Math.max(f(i-1,j,s1,s2,dp),f(i,j-1,s1,s2,dp));
        }
    }
}