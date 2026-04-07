class Solution {
    public boolean wordBreak(String s, List<String> w) {
        int n=s.length();
        HashSet<String> hs=new HashSet<>();
        for(String str: w){
            hs.add(str);
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,s,hs,dp)==1?true:false;
    }
    public static int f(int i,String s,HashSet<String> hs,int[] dp){
        int n=s.length();
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++){
            String str=s.substring(i,j+1);
            if(hs.contains(str)){
                if(f(j+1,s,hs,dp)==1) return dp[i]=1;
            }
        }
    return dp[i]=0;
    }
}