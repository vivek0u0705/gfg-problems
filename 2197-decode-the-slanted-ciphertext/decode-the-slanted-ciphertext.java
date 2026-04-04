class Solution {
    public String decodeCiphertext(String str, int r) {
        int n=str.length();
        // if(n==0 || r==0) return "";
        int c=n/r;
        char mat[][]=new char[r][c];
        int k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j]=str.charAt(k);
                k++;
            }
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<c;i++){
            int row=0;
            int col=i;
            while(row<r && col<c){
                s.append(mat[row][col]);
                row++;
                col++;
            }
        }
        int idx=-1;
    for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)!=' '){
            idx=i;
            break;
        }
    }
    if(idx!=-1) return s.substring(0,idx+1).toString();
    return s.toString();
    }
}