class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        HashMap<Integer,TreeSet<Integer>> xm=new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> ym=new HashMap<>();
        for(int i=0;i<b.length;i++){
            int u=b[i][0];
            int v=b[i][1];
            if(!xm.containsKey(u)) xm.put(u,new TreeSet<>());
            xm.get(u).add(v);
            if(!ym.containsKey(v)) ym.put(v,new TreeSet<>());
            ym.get(v).add(u);
        }
        int c=0;
        for(int i=0;i<b.length;i++){
            int u=b[i][0];
            int v=b[i][1];
            if(xm.get(u).first()<v && v<xm.get(u).last() && ym.get(v).first()<u && u<ym.get(v).last()) c++;
        }
    return c;
    }
}