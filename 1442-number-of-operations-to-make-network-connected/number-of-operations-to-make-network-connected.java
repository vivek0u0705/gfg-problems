class DisjointSet {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n) {
        for(int i=0;i<=n;i++){
            size.add(1);
            rank.add(0);
            parent.add(i);
        }
      
    }

    public int find(int u) {
        if(u==parent.get(u)){
            return u;
        }
        int ulp=find(parent.get(u));
        parent.set(u,ulp);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);

        }
        else if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
        
    }

    public void unionBySize(int u, int v) {
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));

        }
        else{
           parent.set(ulp_v,ulp_u);
           size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int m=connections.length;
        int extra=0;
        //finds the extraa edges 
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.find(u)==ds.find(v)){
                extra++;
            }
            else{
                ds.unionByRank(u,v);
            }
        }
        //find the all components presents
        int components=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                components++;
            }
        }
        //for connecting n components we need n-1 edges >>>
        int ans=components-1;
        if(extra>=ans) return ans;
        return -1;
    }
}