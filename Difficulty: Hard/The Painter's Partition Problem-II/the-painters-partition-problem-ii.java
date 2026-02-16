class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int max=0;
        int ts=0;
        for(int i:arr){
            max=Math.max(max,i);
            ts+=i;
        }
        int s=max;
        int e=ts;
        while(s<=e){
            int m=s+(e-s)/2;
            int t=f(arr,m);
            if(t<=k){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
    return s;
    }
    public static int f(int[] nums,int m){
        int n=nums.length;
        int cs=0;
        int c=1;
        for(int i=0;i<n;i++){
            if(cs+nums[i]<=m){
                cs+=nums[i];
            }
            else{
                c++;
                cs=nums[i];
            }
        }
    return c;
    }
}
