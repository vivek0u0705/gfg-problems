class Solution {
    static Set<List<Integer>> s=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        s.clear();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> com=new ArrayList<>();
        gen(candidates,0,ans,com,target);
    return ans;
    }
    public static void gen(int[] arr,int idx,List<List<Integer>> ans,List<Integer> com,int t){
        if(t<0 ||idx==arr.length){
            return;
        }
        if(t==0){
            List<Integer> c=new ArrayList<>(com);
            if(!s.contains(c)){
                ans.add(c);
                s.add(c);
            }
        return;
        }
        com.add(arr[idx]); //add
        gen(arr,idx,ans,com,t-arr[idx]); //single
        gen(arr,idx+1,ans,com,t-arr[idx]);  //multiple
        com.remove(com.size()-1); //remove
        gen(arr,idx+1,ans,com,t);  //skip
    }
}