class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
        int n=arr.length;
        int cur=arr[n-1];
        //kadanes for finding right to left max sub array and min subbarray
        int[] rm=new int[n];
        rm[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            cur=Math.max(cur+arr[i],arr[i]);
            rm[i]=Math.max(rm[i+1],cur);
        }
        cur=arr[n-1];
        int rs[]=new int[n];
        rs[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            cur=Math.min(cur+arr[i],arr[i]);
            rs[i]=Math.min(rs[i+1],cur);
        }
        
        //kadanes to find the min and max sub array from left to right
        cur=arr[0];
        int ls[]=new int[n];
        ls[0]=arr[0];
        for(int i=1;i<n;i++){
            cur=Math.min(cur+arr[i],arr[i]);
            ls[i]=Math.min(ls[i-1],cur);
        }
        
        cur=arr[0];
        int lm[]=new int[n];
        lm[0]=arr[0];
        for(int i=1;i<n;i++){
            cur=Math.max(cur+arr[i],arr[i]);
            lm[i]=Math.max(lm[i-1],cur);
        }
        // System.out.println(Arrays.toString(ls));
        // System.out.println(Arrays.toString(lm));
        // System.out.println(Arrays.toString(rs));
        // System.out.println(Arrays.toString(rm));
        int ans=0;
        for(int i=0;i<n;i++){
            //left max and right min
           if(i+1<n) ans=Math.max(ans,lm[i]-rs[i+1]);
           //left min and right max
           if(i-1>=0) ans=Math.max(ans,rm[i]-ls[i-1]);
        }
    return ans;
    }
}