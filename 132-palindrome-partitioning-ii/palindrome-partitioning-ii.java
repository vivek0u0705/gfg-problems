class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,s,n,dp)-1; // for remove last un wanted cut
    }
    static int f(int i,String s,int n,int dp[]){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        // String t="";
        int min=(int)1e9;
        for(int j=i;j<n;j++){
            // t=t+s.charAt(j);
            if(isPolindrome(i,j,s)){
                int cost=1+f(j+1,s,n,dp);
                min=Math.min(min,cost);
            }
        }
    return dp[i]=min;
    }
    static boolean isPolindrome(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
    return true;
    }
}