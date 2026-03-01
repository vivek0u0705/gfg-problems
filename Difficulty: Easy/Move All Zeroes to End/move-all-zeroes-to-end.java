class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n=arr.length;
        int ans[]=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0) continue;
            else ans[k++]=arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=ans[i];
        }
    }
}