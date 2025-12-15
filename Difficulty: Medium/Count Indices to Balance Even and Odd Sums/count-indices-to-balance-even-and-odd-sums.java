class Solution {
    public int cntWays(int[] arr) {
        // code here
        int n=arr.length;
        int pe[]=new int[n];
        int po[]=new int[n];
        pe[0]=arr[0];
        for(int i=1;i<n;i++){
           pe[i]=pe[i-1];
           if(i%2==0) pe[i]+=arr[i];
        }
        for(int i=1;i<n;i++){
            if(i==0) po[i]=0;
            if(i>0) po[i]=po[i-1];
           if(i%2!=0) po[i]+=arr[i];
        }
        int te=pe[n-1];
        int to=po[n-1];
        int ans=0;
        for(int i=0;i<n;i++){
            int le=0;
            if(i>0) le+=pe[i-1];
            int lo=0;
            if(i>0) lo+=po[i-1];
            int re=te-pe[i];
            int ro=to-po[i];
            if(le+ro==re+lo) ans++;
        }
    return ans;
    }
}
