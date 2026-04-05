class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> li=new ArrayList<>();
        int len=(int)Math.cbrt(n);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<=len;i++){
            for(int j=i;j<=len;j++){
                int k=i*i*i + j*j*j;
                if(k<= n){ 
                    hm.put(k,hm.getOrDefault(k,0)+1);
                }
            }
        }
        for(int k: hm.keySet()){
            if(hm.get(k)>=2) li.add(k);
        }
        Collections.sort(li);
    return li;
    }
}