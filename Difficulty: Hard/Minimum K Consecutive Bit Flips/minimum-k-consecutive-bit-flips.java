class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int t=0;
        int n=arr.length;
        int fp[]=new int[n];
        int ans=0;
        if(k>n) return -1;
        for(int i=0;i<n;i++){
            if(i-k>=0){
                t=t-fp[i-k];
            }
            if(arr[i]==0 && t%2==0 || arr[i]==1 && t%2==1){
                if(i+k>n) return -1;
                t++;
                ans++;
                fp[i]=1;
            }
        }
    return ans;
    }
}
