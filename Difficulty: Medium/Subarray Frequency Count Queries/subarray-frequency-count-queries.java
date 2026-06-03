class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] que) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],new ArrayList<>());
            }
            hm.get(arr[i]).add(i);
        }
        for(int i=0;i<que.length;i++){
            int l=que[i][0];
            int r=que[i][1];
            int val=que[i][2];
            if(hm.containsKey(val)){
                List<Integer> li=hm.get(val);
                int fre=ub(li,r)-lb(li,l);
                res.add(fre);
            }
            else{
                res.add(0);
            }
            
        }
    return res;
    }
    static int lb(List<Integer> li,int x){
        int i=0;
        int j=li.size()-1;
        int res=j+1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(li.get(m)>=x){
                res=m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
    return res;
    }
    static int ub(List<Integer> li,int x){
        int i=0;
        int j=li.size()-1;
        int res=j+1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(li.get(m)>x){
                res=m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
    return res;
    }
}