class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int n=arr.length;
        
        //1
        //find max sub array sum upto ind i by using -> kadanes algo
        int[] mbi=new int[n];
        mbi[0]=arr[0];
        for(int i=1;i<n;i++){
            mbi[i]=Math.max(arr[i]+mbi[i-1],arr[i]);
        }
        // System.out.println(Arrays.toString(mbi));
        //2
        //do sliding window  first find the k size sum then extend left 
        //if wanted take left sum by precomputed sum by kadanes mbi[i-k]
        
        int max=0;
        for(int i=0;i<k;i++){
            max+=arr[i];
        }
        int cur=max;
        for(int i=k;i<n;i++){
            cur+=arr[i]-arr[i-k];
            // System.out.println(cur);
            max=Math.max(max,Math.max(cur,cur+mbi[i-k]));
        }
    return max;
    }
}