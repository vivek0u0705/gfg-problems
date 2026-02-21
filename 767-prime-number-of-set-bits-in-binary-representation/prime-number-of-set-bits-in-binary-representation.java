class Solution {
    public int countPrimeSetBits(int l, int r) {
        HashSet<Integer> hs=new HashSet<>();
        doP(hs);
        int c=0;
        for(int i=l;i<=r;i++){
            int bts=find(i);
            if(hs.contains(bts)) c++;
        }
    return c;
    }
    public static int find(int num){
        int c=0;
        while(num>0){
            int t=num&1;
            if(t==1) c++;
            num=num>>1;
        }
    return c;
    }
    public static void doP(HashSet<Integer> hs){
        hs.add(2);
        hs.add(3);
        hs.add(5);
        hs.add(7);
        hs.add(11);
        hs.add(13);
        hs.add(17);
        hs.add(19);
    }
}