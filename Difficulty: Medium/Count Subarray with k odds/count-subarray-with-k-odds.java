class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        return f(arr,k)-f(arr,k-1);
    }
    public static int f(int []arr,int k){
        int c=0;
        int s=0;
        int l=0;
        for(int r=0;r<arr.length;r++){
            if(arr[r]%2==1) c++;
            if(c>k){
                while(c>k){
                    if(arr[l]%2==1) c--;
                    l++;
                }
            }
            if(c<=k) s+=(r-l+1);
        }
    return s;
    }
}
