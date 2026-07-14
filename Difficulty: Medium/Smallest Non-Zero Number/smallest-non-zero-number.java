class Solution {
    public int find(int[] arr) {
        // code here
        // int max=0;
        // for(int i:arr) max=Math.max(max,i);
        long i=1;
        long j=(long)1e9;
        long ans=j;
        while(i<=j){
            long m=i+(j-i)/2;
            if(f(m,arr)){
                ans=m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
    return (int)ans;
    }
    public boolean f(long k,int[] arr){
        for(int i=0;i<arr.length;i++){
            k=2*k*1L-arr[i];
            if(k<0) return false;
            if(k>(long)1e9) k=(long)1e9;
        }
    return k>=0;
    }
}
