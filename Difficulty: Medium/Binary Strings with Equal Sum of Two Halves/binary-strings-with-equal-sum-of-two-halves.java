class Solution {
    static long mod=1000000007L;
    static long fact[];
    static long invfact[];
    
    static void precompute(int n){
        fact=new long[n+1];
        invfact=new long[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++) fact[i]=(fact[i-1]*i)%mod;
        
        invfact[n]=pow(fact[n],mod-2);
        for(int i=n-1;i>=0;i--){
            invfact[i]=(invfact[i+1]*(i+1))%mod;
        }
    }
    static long pow(long a,long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=(res*a)%mod;
            
            a=(a*a)%mod;
            b=b>>1;
        }
    return res;
    }
    static long ncr(int n,int r){
        if(r<0 || r>n) return 0;
        
    return (((fact[n] * invfact[n-r]%mod) % mod ) * invfact[r] % mod) % mod;
    }
    public int computeValue(int n){
        // code here
        precompute(n);
        long ans=0;
        for(int i=0;i<=n;i++){
            // find nci
            long k=( ncr(n,i) * ncr(n,i) ) % mod;

            ans = (ans + k) % mod;
            
        }
    return (int)ans;
    }
}