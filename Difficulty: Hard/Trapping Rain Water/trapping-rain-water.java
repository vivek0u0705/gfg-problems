class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        int[] pm=new int[n];
        int nm[]=new int[n];
        pm[0]=arr[0];
        nm[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pm[i]=Math.max(pm[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            nm[i]=Math.max(nm[i+1],arr[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int ht=Math.min(pm[i],nm[i]);
            ans+=ht-arr[i];
        }
    return ans;
    }
}
