class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int m=arr[0];
        int cur=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            cur=Math.min(arr[i],cur+arr[i]);
            m=Math.min(m,cur);
        }
    return m;
    }
}