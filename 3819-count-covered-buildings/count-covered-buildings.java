class Pair{
    int min;
    int max;
    Pair(int m1,int m2){
        min=m1;
        max=m2;
    }
}
class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        HashMap<Integer,Pair> xm=new HashMap<>();
        HashMap<Integer,Pair> ym=new HashMap<>();
        for(int i=0;i<b.length;i++){
            int u=b[i][0];
            int v=b[i][1];
            if(!xm.containsKey(u)){
                xm.put(u,new Pair(v,v));
            }
            else{
               Pair p=xm.get(u);
               p.min=Math.min(p.min,v);
               p.max=Math.max(p.max,v);
            }
            if(!ym.containsKey(v)){
            ym.put(v,new Pair(u,u));
            }
            else{
               Pair p=ym.get(v);
               p.min=Math.min(p.min,u);
               p.max=Math.max(p.max,u);
            }
        }
        int c=0;
        for(int i=0;i<b.length;i++){
            int u=b[i][0];
            int v=b[i][1];
            if(xm.get(u).min<v && v<xm.get(u).max && ym.get(v).min<u && u<ym.get(v).max) c++;
        }
    return c;
    }
}