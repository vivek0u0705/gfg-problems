class Solution {
    static Integer[] dp;
    public int maxProduct(int n) {
        // code here
        dp=new Integer[n+1];
    return f(0,n);
    }
    static int f(int i,int num){
        if(i>=num) return 1;
        if(dp[i]!=null) return dp[i];
        int mp=1;
        for(int j=i+1;j<num;j++){
            mp=Math.max(mp,(j-i) * Math.max(num-j,f(j,num)));
        }
    return dp[i]=mp;
    }
}