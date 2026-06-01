class Solution {
    public int findMaxProduct(int[] arr) {
        // code here
        long mod=1000000007;
        int nzc=0;
        int n=arr.length;
        int zc=0;
        long p=1;
        int mNeg=-(int)1e9;
        int ct=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zc++;
                continue;
            }
            else{
                if(arr[i]<0){
                    mNeg=Math.max(mNeg,arr[i]);
                    nzc++;
                }
                p=(p*arr[i])%mod;
                if(arr[i]>0){
                    ct++;
                }
            }
        }
        if(nzc==n && n==1) return (int)p;
        if(zc==n) return 0;
        if(p>0) return (int)p;
        if(nzc==1 && zc!=0) if(ct==0) return 0;
        if(p<0) return (int)p/mNeg;
      return 0;
    }
}