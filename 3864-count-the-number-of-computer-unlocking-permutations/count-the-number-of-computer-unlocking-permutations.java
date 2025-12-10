class Solution {
    public int countPermutations(int[] nums) {
        int n=nums.length;
        long ans=1;
        long m=1000000007;
        for(int i=1;i<n;i++){
            if(nums[0]>=nums[i]) return 0;
            ans=(ans*i)%m;
        }
    return (int)ans;
    }
}