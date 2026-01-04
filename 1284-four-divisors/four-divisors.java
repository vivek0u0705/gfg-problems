class Solution {
    public int sumFourDivisors(int[] nums) {
        int ts=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
             int s=0;
             HashSet<Integer> hs=new HashSet<>();
            for(int j=1;j*j<=nums[i];j++){
                 if(nums[i]%j==0){
                    hs.add(j);
                    hs.add(nums[i]/j);
                    s+=j;
                    s+=nums[i]/j;
                }
            }
            if(hs.size()==4){
                    ts+=s;
            }
        }
    return ts;
    }
}