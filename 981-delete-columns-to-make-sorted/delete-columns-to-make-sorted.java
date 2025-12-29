class Solution {
    public int minDeletionSize(String[] arr) {
        int ct=0;
        char[][] ca=new char[arr.length][arr[0].length()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length();j++){
                char c=arr[i].charAt(j);
                ca[i][j]=c;
            }
        }
        for(int i=0;i<ca[0].length;i++){
            for(int j=0;j<ca.length-1;j++){
                if(ca[j][i]>ca[j+1][i]) {
                    ct++;
                    break;
                } 
            } 
        } 
    return ct;
    }
}