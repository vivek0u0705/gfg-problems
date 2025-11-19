class Solution {
    public int findFinalValue(int[] nums, int t) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==t){
                while(true){
                    if(hs.contains(t)){
                        t=t*2;
                    }
                    else break;
                }
            break;
            }
        }
    return t;
    }
}