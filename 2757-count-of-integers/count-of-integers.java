import java.math.*;
class Solution {
    static int[][][] dp=new int[24][401][2];
    static int MOD=1000000007;
    public int count(String num1, String num2, int l, int r) {

        //states pos,tight,     sum   will calculate through  recursion
        for(int i=0;i<24;i++) {
            for(int j=0;j<401;j++) Arrays.fill(dp[i][j],-1);
        }

        int rf=f(0,1,0,num2,l,r);

        BigInteger x= new BigInteger(num1);
        BigInteger y= new BigInteger("1");

        num1=x.subtract(y).toString();

        // re keeping -1 for next fn

        for(int i=0;i<24;i++) {
            for(int j=0;j<401;j++)  Arrays.fill(dp[i][j],-1);
        }

        int lf=f(0,1,0,num1,l,r);

    return (rf-lf + MOD ) % MOD;   //may get -ve so 
    }
    static int f(int i,int tight,int sum,String s,int l,int r){

        //base case
        if(i==s.length()){
            if(l<=sum && sum<=r) return 1;
            else return 0;
        }

        //already exist
        if(dp[i][sum][tight]!=-1) return dp[i][sum][tight];

        int lb=0;
        int ub=(tight==1)? s.charAt(i)-'0': 9 ;
        int ans=0;
        
        for(int d=lb;d<=ub;d++){
            int newSum= sum+d; 
            if(newSum > r) continue;
            int newTight=(tight==1 && d==ub)?1:0;

            ans = ( ans + f(i+1,newTight,newSum,s,l,r) ) % MOD;
        }
    return dp[i][sum][tight]=ans;
    }
}