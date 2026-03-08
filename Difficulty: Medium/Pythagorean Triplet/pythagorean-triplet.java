class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int val[]=new int[1001];
        for(int i :arr) val[i]=1;
        
        for(int i=1;i<1001;i++){
            if(val[i]!=1) continue;
            for(int j=1;j<1001;j++){
                if(val[j]!=1) continue;
                int c1=i*i+j*j;
                int c=(int)Math.sqrt(c1);
                if(val[c]==1 && c*c==c1) return true;
            }
        }
    return false;
    }
}