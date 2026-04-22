class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n=arr.length;
        int ps[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0) ps[i]=arr[i];
            else{
                ps[i]=ps[i-1]+arr[i];
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int val=ps[r]-ps[l]+arr[l];
            val=val/(r-l+1);
            ans.add(val);
        }
    return ans;
    }
}