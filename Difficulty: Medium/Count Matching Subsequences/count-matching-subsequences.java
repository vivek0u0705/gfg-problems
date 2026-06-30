class Solution {
    static Integer dp[][];
    static int mod=(int)1e9 + 7;
    public static int countWays(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        dp=new Integer[n][m];
        return f(n-1,m-1,s1,s2);
    }
    public static int f(int i,int j,String s1,String s2){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int t=0;
        if(s1.charAt(i)==s2.charAt(j)) t=f(i-1,j-1,s1,s2);
        int nt=f(i-1,j,s1,s2);
    return dp[i][j]=(nt+t) % mod;
    }
}
