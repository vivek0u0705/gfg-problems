class Pair{
    int val;
    int ct;
    Pair(int v,int c){
        val=v;
        ct=c;
    }
}
class Solution {
    public int[] sortByBits(int[] arr) {
        List<Pair> li=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int t=Integer.bitCount(arr[i]);
            li.add(new Pair(arr[i],t));
        }
        li.sort((a,b)->{
            if(a.ct!=b.ct){
                return Integer.compare(a.ct,b.ct);
            }
            else{
                return Integer.compare(a.val,b.val);
            }
        });
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=li.get(i).val;
        }
    return ans;
    }
}