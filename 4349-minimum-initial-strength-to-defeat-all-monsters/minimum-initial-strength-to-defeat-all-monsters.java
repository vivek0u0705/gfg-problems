class Solution {
    public long minInitialStrength(int[] mon, int[][] boosts) {
        int n=mon.length;
        long[] arr=new long[n+1];
        for(int i=0;i<boosts.length;i++){
            int l=boosts[i][0];
            int r=boosts[i][1];
            int v=boosts[i][2];
            arr[l]+=v;
            if(r+1<n) arr[r+1]-=v;
        }
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
        }
        // for finding the min strength we do bs on answers
        long sum=0;
        for(int x:mon) sum+=1L*x;
        long s=0;
        long e=sum;
        long ans=e;
        while(s<=e){
            long m=s+(e-s)/2;
            if(ck(m,arr,mon)){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
    return ans;
    }
    public boolean ck(long cur,long[] arr,int[] mon){
        long val=cur;
        for(int i=0;i<mon.length;i++){
            if(val+arr[i]>=mon[i]){
                if(val>=mon[i]) val-=mon[i];
                else val=0;
            }
            else return false;
        }
    return true;
    }

}