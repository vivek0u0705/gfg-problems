class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        Arrays.sort(arr);
        int t=0;
        long ans=0;
        for(int i=arr.length-1;i>=0;i--){
            if(k>0){
                arr[i]=arr[i]-t;
                t++;
                if(arr[i]>0) ans+=(long)arr[i];
                k--;
            }
        }
    return ans;
    }
}