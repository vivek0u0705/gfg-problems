//implementation of Disjoint -Set
class DisjointSet{
    List<Integer> size;
    List<Integer> parent;
    public DisjointSet(int n){
        size=new ArrayList<>(n);
        parent=new ArrayList<>(n);
        for(int i=0;i<n;i++){  //creating parent ,size 
            size.add(1); 
            parent.add(i);
        }
    }

    //for find ultimate parent of node
    public int findUParent(int node){
        if(node==parent.get(node)) return node;
        
        int ulp=findUParent(parent.get(node));
        parent.set(node,ulp);
    return ulp; // for all nodes set ulp 
    }


    //merge 2 components by using union by size method
    public void unionBySize(int u,int v){
        int ulp_u=findUParent(u);
        int ulp_v=findUParent(v);

        if(ulp_u==ulp_v) return; //for same component  no need merge again

        int s1=size.get(ulp_u);
        int s2=size.get(ulp_v);
        if(s1 < s2 ){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
             // merge small size node to largersize node to reduce graph size
             //set size small-node to size[small]+size[lardge]
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    static boolean isValid(int r,int c,int n){  // for out of bounds - check
        return r>=0 && c>=0 && r<n && c<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int N=n*n; // for  making linear arrays of parent,size in disjoint set
        DisjointSet ds=new DisjointSet(N);

        //step - 1 
        //make components of all 1 intially
        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(isValid(nr,nc,n) && grid[nr][nc]==1){
                        int nodeNo=nr*n+nc;
                        int adjNo=i*n+j;
                        ds.unionBySize(nodeNo,adjNo);
                    }
                }
            }
        }

        //step 2
        //find for 0 value max island size
        int mx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> hs=new HashSet<>(); //we hashset for not finding sameislangs (edge-case)
                //either we can use vis array for neglect extra islands
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(isValid(nr,nc,n) && grid[nr][nc]==1){
                        int adjNo=nr*n+nc;
                        int ulp=ds.findUParent(adjNo);
                        hs.add(ulp);
                    }
                }
                int sum=1; // for 0 to make 1 
                for(int val :hs){
                    sum+=ds.size.get(val);
                }
                mx=Math.max(mx,sum);
            }
        }

        //step 3
        //for not 0 cases we find for max size same componenst sizes

        for(int i=0;i<N;i++){
            if(ds.findUParent(i)==i) mx=Math.max(mx,ds.size.get(i));   // means  same componenet  ( each 1 island)
        }
    return mx;
    }
}