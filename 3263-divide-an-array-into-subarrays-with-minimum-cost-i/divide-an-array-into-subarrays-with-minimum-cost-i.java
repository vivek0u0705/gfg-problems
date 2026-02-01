class Solution {
    public int minimumCost(int[] nums) {
        int t=nums[0];
        nums[0]=(int)1e9;
        Arrays.sort(nums);
        t+=nums[0]+nums[1];
    return t;
    }
}