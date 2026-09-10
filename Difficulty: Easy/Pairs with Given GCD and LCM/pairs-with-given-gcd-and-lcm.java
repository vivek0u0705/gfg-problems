class Solution {
    public int pairCount(int x, int y) {
        // code here
        int ans=0;
        long p=1L*x*y;
        for(int i=1;i<=y;i++){
            if(p%i==0){
                long b=p/i;
                if(gcd(i,(int)b)==x) ans++;
            }
        }
    return ans;
    }
    int gcd(int a,int b){
        if(b==0) return a;
    return gcd(b,a%b);
    }
}