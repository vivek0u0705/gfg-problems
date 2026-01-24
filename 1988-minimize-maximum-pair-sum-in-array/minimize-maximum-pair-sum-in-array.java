class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int m=0;
        for(int i=0;i<nums.length;i++){
            m=Math.max(nums[i]+nums[nums.length-i-1],m);
        }
    return m;
    }
}