class DisjointSet{
    List<Integer> par;
    List<Integer> size;
    public DisjointSet(int n){
        par=new ArrayList<>();
        size=new ArrayList<>();
        for(int i=0;i<n;i++){
           par.add(i);
           size.add(1);
        }
    }
    public int parent(int node){
        if(node==par.get(node)) return node;
        int ulp=parent(par.get(node));
        par.set(node,ulp);
    return ulp;
    }
    public void union(int n1,int n2){
        int ulp1=parent(n1);
        int ulp2=parent(n2);
        if(parent(ulp1)==parent(ulp2)) return;
        if(size.get(ulp1)<size.get(ulp2)){
           par.set(ulp1,ulp2);
           size.set(ulp1,size.get(ulp1)+size.get(ulp2));
        }
        else{
            par.set(ulp2,ulp1);
            size.set(ulp1,size.get(ulp1)+size.get(ulp2));
        }
    }
}
class Solution {
    int minEdgesReq(int n, int[][] edges) {
       int len=edges.length;
       DisjointSet ds=new DisjointSet(n);
       int ext=0;
       for(int i=0;i<len;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           if(ds.parent(u)==ds.parent(v)) ext++;
           else ds.union(u,v);
       }
       int cnt=0;
       for(int i=0;i<n;i++){
           if(ds.par.get(i)==i) cnt++;
       }
    return ext>=cnt-1?cnt-1:-1;
    }
}