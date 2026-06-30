class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        if(hm.containsKey(1)){
            int onesCt=hm.get(1);
            if(onesCt%2==0) max=onesCt-1;
            else max=onesCt;
        } 
        for(int i=0;i<n;i++){
            if(nums[i]==1) continue;
            int cur=nums[i];
            int len=0;
            while(hm.getOrDefault(cur,0)>=2){
                len+=2;
                cur*=cur;
            }
            //if middle present
            if(hm.containsKey(cur)) len++;
            else len--;
            max=Math.max(max,len);
        }
    return max;
    }
}