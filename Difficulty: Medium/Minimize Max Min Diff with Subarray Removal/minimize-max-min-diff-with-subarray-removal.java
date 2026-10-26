class Solution {
    public int minDiff(int k, int[] arr) {
        // code here
        int n=arr.length;
        int[] pmin=new int[n];
        int[] pmax=new int[n];
        int[] smin=new int[n];
        int[] smax=new int[n];
        pmin[0]=arr[0];
        pmax[0]=arr[0];
        smin[n-1]=arr[n-1];
        smax[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pmin[i]=Math.min(pmin[i-1],arr[i]);
            pmax[i]=Math.max(pmax[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            smax[i]=Math.max(smax[i+1],arr[i]);
            smin[i]=Math.min(smin[i+1],arr[i]);
        }
            // System.out.println(Arrays.toString(pmin));
            // System.out.println(Arrays.toString(pmax));
            // System.out.println(Arrays.toString(smin));
            // System.out.println(Arrays.toString(smax));
        int res=(int)1e9;
        for(int i=0;i<n;i++){
            int l=i-1;
            int r=i+k;
            int min=(int)1e9;
            int max=0;
            if(l>=0) min=Math.min(min,pmin[l]);
            if(r<n) min=Math.min(min,smin[r]);
            if(l>=0) max=Math.max(max,pmax[l]);
            if(r<n) max=Math.max(max,smax[r]);
            res=Math.min(res,max-min);
        }
    return res;
    }
}