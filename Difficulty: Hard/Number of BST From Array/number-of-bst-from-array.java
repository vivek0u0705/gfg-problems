class Pair{
    int val;
    int idx;
    Pair(int v,int i){
        val=v;
        idx=i;
    }
}
class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n=arr.length;
        ArrayList<Pair> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new Pair(arr[i],i));
        }
        li.sort((a,b)->Integer.compare(a.val,b.val));
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int t1=i-0;
            int t2=n-1-i;
            int k=f(t1)*f(t2);
            li.get(i).val=k;
        }
         li.sort((a,b)->Integer.compare(a.idx,b.idx));
         for(int i=0;i<n;i++){
             int t=li.get(i).val;
             ans.add(t);
         }
        return ans;
        
    }
    public static int f(int n){
        int k1=fact(2*n);
        int k2=fact(n);
        int k3=fact(2*n-n);
        int k=k3*k2;
         int ans=k1/k;
         ans=ans/(n+1);
        return ans;
    }
    public static int fact(int n){
        if(n==0 || n==1) return 1;
    return n*fact(n-1);
    }
}