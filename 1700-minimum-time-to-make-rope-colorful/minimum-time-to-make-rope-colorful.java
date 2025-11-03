class Pair{
    char c;
    int num;
    Pair(char c,int num){
        this.c=c;
        this.num=num;
    }
}
class Solution {
    public int minCost(String col, int[] arr) {
        List<Pair> li=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            li.add(new Pair(col.charAt(i),arr[i]));
        }
        int tl=0,i=0;
        while(i<li.size()-1){
            Pair a=li.get(i);
            Pair b=li.get(i+1);
            if(a.c==b.c){
                if(a.num<b.num){
                    li.remove(i);
                    tl+=a.num;
                }
                else{
                    li.remove(i+1);
                    tl+=b.num;
                }
            }
            else i++;
        }
    return tl;
    }
}