class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> bl=new ArrayList<>();
        int n=0;
        for(int i=0;i<nums.length;i++){
            n=n<<1 | nums[i];
           if(n%5==0){
            bl.add(true);
           }
           else bl.add(false);
           n=n%5;
        }
    return bl;
    }
}