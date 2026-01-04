class Solution {
    public List<List<String>> wordSquares(String[] arr) {
        List<List<String>> li=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                for(int k=0;k<n;k++){
                    if(k==i || k==j) continue;
                    for(int m=0;m<n;m++){
                        if(m==i || m==j || m==k) continue;
                        
                            if(arr[i].charAt(0)==arr[j].charAt(0) && arr[i].charAt(3)==arr[k].charAt(0)
                               && arr[m].charAt(0)==arr[j].charAt(3) && arr[m].charAt(3)==arr[k].charAt(3)){
                                List<String> l=new ArrayList<>();
                                l.add(arr[i]);
                                l.add(arr[j]);
                                l.add(arr[k]);
                                l.add(arr[m]);
                                li.add(l);
                               }
                    }
                }
            }
        }
        li.sort((a,b)->{
            for(int i=0;i<n;i++){
                int t=a.get(i).compareTo(b.get(i));
                if(t!=0) return t;
            }
            return 0;
            
        });
    return li;
    }
}