class Solution {
    public int numMagicSquaresInside(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int c=0;
        
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(f(i,j,mat)) c++;
            }
        }
    return c;
    }
    public static boolean f(int i,int j,int mat[][]){
        HashSet<Integer> hs=new HashSet<>();
            for(int r1=i;r1<i+3;r1++){
                for(int c1=j;c1<j+3;c1++){
                    if(mat[r1][c1]==0 || mat[r1][c1]>9) return false;
                    if(hs.contains(mat[r1][c1])) return false;
                    hs.add(mat[r1][c1]);
                }
            }
        int sr1=0,sr2=0,sr3=0,sc1=0,sc2=0,sc3=0,sd1=0,sd2=0;

        sr1=mat[i][j]+mat[i][j+1]+mat[i][j+2];
        sr2=mat[i+1][j]+mat[i+1][j+1]+mat[i+1][j+2];
        sr3=mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];

        sc1=mat[i][j]+mat[i+1][j]+mat[i+2][j];
        sc2=mat[i][j+1]+mat[i+1][j+1]+mat[i+2][j+1];
        sc3=mat[i][j+2]+mat[i+1][j+2]+mat[i+2][j+2];

        sd1=mat[i][j]+mat[i+1][j+1]+mat[i+2][j+2];
        sd2=mat[i][j+2]+mat[i+1][j+1]+mat[i+2][j];

    return sr1==sr2 && sr2==sr3 && sr3==sc1 && sc1==sc2 && sc2==sc3 && sc3==sd1 && sd1==sd2 && sr1+sr2+sr3==45 && sc1+sc2+sc3==45 && sd1+sd2==30;
    }
} 