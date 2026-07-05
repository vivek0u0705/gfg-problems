class Solution {
    HashSet<Integer> ft;
    long mod=(long)1e9+7;
    public int divisibleGame(int[] nums) {
        ft=new HashSet<>();
        int n=nums.length;
        compute(nums);
        ft.add(2);
        long diff=-(long)1e10;
        int best=2;
        for(int k:ft){
            int[] arr=new int[n];
            for(int i=0;i<n;i++){ 
                if(nums[i]%k==0) arr[i]=nums[i];
                else arr[i]=-nums[i];
            }
            int cur=-(int)1e9;
            int max=-(int)1e9;
            for(int i=0;i<n;i++){
                cur=Math.max(arr[i],cur+arr[i]);
                max=Math.max(max,cur);
            }
            if(max>diff){
                diff=max;
                best=k;
            }
            else if(max==diff && best>k){
                best=k;
            }
        }
    return (int)(((1L*diff*best)%mod + mod) % mod);
    }
    public void compute(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            int k=nums[i];
            for(int j=2;j*j<=k;j++){
                if(k%j==0){
                    ft.add(j);
                    if(j!=k/j) ft.add(k/j);
                }
            }
            if(k>1) ft.add(k);
        }
    }
}