class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcs= f(s1,s2,n1-1,n2-1,dp);
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n1;i++){
            sum1+=s1.charAt(i);
        }
        for(int i=0;i<n2;i++){
            sum2+=s2.charAt(i);
        }
        int val=sum1-lcs + sum2-lcs;
    return val;
    }
    public static int f(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
           return dp[i][j] = s1.charAt(i) + f(s1,s2,i-1,j-1,dp);
        }
        else{
            return dp[i][j] = Math.max(f(s1,s2,i-1,j,dp),f(s1,s2,i,j-1,dp));
        }
    
    }
}