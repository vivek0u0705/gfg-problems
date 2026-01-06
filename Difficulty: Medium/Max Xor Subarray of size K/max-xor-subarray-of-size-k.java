class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int xor=0;
        for(int i=0;i<k;i++){
            xor^=arr[i];
        }
        int s=xor;
        int m=xor;
        for(int i=k;i<arr.length;i++){
            s=s^arr[i-k]^arr[i];
            m=Math.max(m,s);
        }
    return m;
    }
}
