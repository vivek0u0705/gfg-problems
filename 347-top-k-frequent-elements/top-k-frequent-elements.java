class Pair{
    int k;
    int v;
    Pair(int key,int val){
        v=val;
        k=key;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.v,b.v));
        for(int key :hm.keySet()){
            // System.out.println(key +" "+hm.get(key));
            pq.add(new Pair(key,hm.get(key)));
            if(pq.size()>k) pq.poll();
        }
        int arr[]=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            arr[i++]=pq.peek().k;
            pq.poll();
        }
    return arr;
    }
}