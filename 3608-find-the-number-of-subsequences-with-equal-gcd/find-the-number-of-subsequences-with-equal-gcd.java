class Solution {
Integer[][][] dp;
int mod=(int)1e9+7;
    public int subsequencePairCount(int[] nums) {
        //states  pos,gcd1,gcd2
        dp=new Integer[nums.length][201][201];
        return f(0,0,0,nums);
    }
    public int f(int i,int gcd1,int gcd2,int[] nums){

        if(i==nums.length){
            if(gcd1!=0 && gcd1==gcd2) return 1;
            else return 0;
        }
        if(dp[i][gcd1][gcd2]!=null) return dp[i][gcd1][gcd2];

        int nt=f(i+1,gcd1,gcd2,nums);
        int ng1=gcd1==0?nums[i]:gcd(nums[i],gcd1);
        int t1=f(i+1,ng1,gcd2,nums);
        int ng2=gcd2==0?nums[i]:gcd(nums[i],gcd2);
        int t2=f(i+1,gcd1,ng2,nums);
    return dp[i][gcd1][gcd2]=((nt+t1)%mod+t2)%mod;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
    return gcd(b,a%b);
    }
}