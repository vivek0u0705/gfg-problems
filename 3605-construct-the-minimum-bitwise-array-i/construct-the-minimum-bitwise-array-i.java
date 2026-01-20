class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int k=-1;
            int t=1;
            while(t<nums.get(i)){
                if((t | t+1)==nums.get(i)) {
                    k=t; 
                    break;
                }
                t++;
            }
            arr[i]=k;
        }
    return arr;
    }
}