class Pair{
    int a1;
    int a2;
    Pair(int a1,int a2){
        this.a1=a1;
        this.a2=a2;
    }
}
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.a2!=b.a2) return Integer.compare(a.a2,b.a2);
            else return Integer.compare(a.a1,b.a1);
        });
        int r=0;
        int arr[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int j=i;j<i+k;j++){
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            }
            for(int key :hm.keySet()){
                pq.add(new Pair(key,hm.get(key)));
                if(pq.size()>x) pq.poll();
            }
            int k1=0;
            while(!pq.isEmpty()){
                Pair rem=pq.poll();
                k1+=rem.a1*rem.a2;
            }
            arr[r++]=k1;
        }
    return arr;
    }
}