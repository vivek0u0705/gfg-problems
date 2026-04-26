class Solution {
    public long minOperations(int[] arr) {
     long ct=0;
        int n=arr.length;
        for(int i=0;i<n;){
            int j=i+1;
            int p=arr[i];
            int mx=-(int)1e9;
            while(j<n && p>arr[j]){
                if(arr[j]>arr[j-1]) break;
                int val=p-arr[j];
                mx=Math.max(mx,val);
                j++;
            }
            if(mx!=-(int)1e9)  ct+=(long)mx;
            i=j;
        }
    return ct;
    }
}