class Solution {
    public int bitonic(int[] arr) {
        // code here
        int n=arr.length;
        int[] pm=new int[n];
        pm[0]=1;
        int[] sm=new int[n];
        sm[n-1]=1;
        for(int i=1;i<n;i++){
            //prefix min
            if(arr[i-1]<=arr[i]) {
                pm[i]=pm[i-1]+1;
            }
            else{
                pm[i]=1;
            }
        }
        // System.out.print(Arrays.toString(pm));
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[i+1]){
                sm[i]=sm[i+1]+1;
            }
            else{
                sm[i]=1;
            }
        }
        int maxL=0;
        for(int i=0;i<n;i++){
            maxL=Math.max(maxL,pm[i]+sm[i]-1);
        }
    return maxL;
    }
}