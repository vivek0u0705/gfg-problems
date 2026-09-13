class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],new ArrayList<>());
            }
            hm.get(nums[i]).add(i);
        }
        int ans=0;
        for(int key:hm.keySet()){
            List<Integer> li=hm.get(key);
            System.out.println(li.size());
            if(li.size()<3) continue;
            int t=li.get(1)-li.get(0);
            if(check(li,t)) ans++;
        }
    return ans;
    }
    public static boolean check(List<Integer> li,int k){
        int n=li.size();
        for(int i=0;i<n-1;i++){
            if((li.get(i+1)-li.get(i))!=k) return false;
        }
    return true;
    }
}