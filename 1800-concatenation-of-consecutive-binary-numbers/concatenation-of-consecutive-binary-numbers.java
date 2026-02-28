class Solution {
    public int concatenatedBinary(int n) {
        int i=1;
        long ans=0;
        while(i<=n){
            int b=f(i);
            ans=ans<<b;
            ans=(ans|i);
            ans=ans%1000000007;
            i++;
        }
    return (int)ans;
    }
    public static int f(int n){
        int c=0;
        while(n>0){
            n=n>>1;
            c++;
        }
    return c;
    }
}