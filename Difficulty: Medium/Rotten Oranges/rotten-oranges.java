class Pair{
    int row;
    int col;
    Pair(int r,int c){
        row=r;
        col=c;
    }
}
class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        Queue<Pair> q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int fr=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                }
                if(mat[i][j]==0) vis[i][j]=-1;
                if(mat[i][j]==1) fr++;
            }
        }
        int nr[]={-1,0,1,0};
        int nc[]={0,1,0,-1};
        int ct=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean b=false;
            for(int j=0;j<size;j++){
                 Pair rem=q.poll();
                 int r=rem.row;
                 int c=rem.col;
                 for(int i=0;i<4;i++){
                    int R=r+nr[i];
                    int C=c+nc[i];
                    if(R>=0 && C>=0 && R<n && C<m && mat[R][C]==1 && vis[R][C]==0){
                        q.add(new Pair(R,C));
                        vis[R][C]=1;
                        fr--;
                        b=true;
                    }
                }
            }
            if(b) ct++;
        }
        if(fr!=0) return -1;
    return ct;
    }
}