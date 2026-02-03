class Solution {
    public int maxProfit(int[] arr) {
        // Code here
        int n=arr.length;
        int b=arr[0];
        int max=0;
        for(int i=1;i<n;i++){
            if(b>arr[i]){
                b=arr[i];
            }
            else{
                max=Math.max(max,arr[i]-b);
            }
        }
    return max;
    }
}