class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        ArrayList<Integer> T=new ArrayList<>();
        ArrayList<Integer> P=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]=='T') T.add(i);
            else P.add(i);
        }
        int i=0;
        int j=0;
        int c=0;
        while(i<P.size() && j<T.size()){
            int val=P.get(i)-T.get(j);
            if(Math.abs(val)<=k){
               i++;
               j++;
               c++;
            }
            else{
                if(val<0)i++;
                else j++;
            }
        }
    return c;
    }
}