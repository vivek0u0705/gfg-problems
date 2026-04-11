class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int l=0;
        int n=arr.length;
        int ct=0;
        for(int r=0;r<n;r++){
            while(l<r && arr[r-1]>=arr[r]){
                l++;
            }
            ct+=r-l;
        }
    return ct;
    }
}
