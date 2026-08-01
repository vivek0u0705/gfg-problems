class Solution {
    public boolean predictTheWinner(int[] nums) {
        //removal game  find the player 1 score if both plays optimally
        //interval dp (start i=0 && j=n-1)
        int n=nums.length;
        int res=f(0,n-1,nums);
        long sum=0;
        for(int x:nums)sum+=x;
    return (sum-res)<=res;
    }
    static int f(int i,int j,int[] arr){
        if(i>j) return 0;
        // if(i==j) return arr[i];
        // if(i==j+1) return Math.max(arr[i],arr[j]);
        int start=arr[i]+Math.min(f(i+2,j,arr),f(i+1,j-1,arr));
        int end=arr[j]+Math.min(f(i,j-2,arr),f(i+1,j-1,arr));
    return Math.max(start,end);
    }
}