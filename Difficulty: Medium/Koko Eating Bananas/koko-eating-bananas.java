class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int max=arr[n-1];
        int s=0;
        int e=max;
        int ans=0;
        while(s<=e){
            int m=s+(e-s)/2;
            int t=f(arr,m);
            if(t<=k){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
    return ans;
    }
    public static int f(int[] arr,int m){
        int s=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            s+=Math.ceil((double)arr[i]/m);
        }
    return s;
    }
}
