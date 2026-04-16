class Solution {
    public List<Integer> solveQueries(int[] nums, int[] que) {
        int n=nums.length;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                hm.get(nums[i]).add(i);
            }
            else{
                hm.put(nums[i],new ArrayList<>());
                hm.get(nums[i]).add(i);
            }
        }
        int n2=que.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n2;i++){
            int idx=que[i];
            int val=nums[idx];
            List<Integer> list=hm.get(val);
            int len=list.size();
            if(len==1){
                ans.add(-1);
                continue;
            }
            int pos=bs(list,idx);
            int lf=list.get((pos-1+len)%len);
            int rt=list.get((pos+1)%len);
            int d1=Math.min(Math.abs(idx-lf),n-Math.abs(lf-idx));
            int d2=Math.min(Math.abs(rt-idx),n-Math.abs(rt-idx));
        ans.add(Math.min(d1,d2));
        }
    return ans;
    }
    public static int bs(List<Integer> ls,int idx){
        int i=0;
        int j=ls.size()-1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(ls.get(m)==idx) return m;
            if(ls.get(m)>idx) j=m-1;
            else i=m+1;
        }
    return 0;
    }
}