class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        List<Integer> li=new ArrayList<>(hm.keySet());
        li.sort((a,b)->Integer.compare(hm.get(b),hm.get(a)));
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=li.get(i);
        }
    return arr;
    }
}