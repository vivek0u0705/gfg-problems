class Fwk{
    int mod=(int)1e9+7;
    int[] bit;
    int n;
    public Fwk(int n){
        bit=new int[n+1];
        this.n=n;
    }
    public void update(int idx,int val){
        while(idx<=n){
            bit[idx]=(bit[idx] +val) % mod;
            idx+=(idx & -idx);
        }
    }
    public int query(int idx){
        int sum=0;
        while(idx>0){
            sum=(sum+bit[idx])%mod;
            idx-=(idx & -idx);
        }
    return sum;
    }
    public int range(int r,int l){
        return (query(r)-query(l-1) + mod) % mod;
    }
}
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len=n*(n+1)/2;
        int[] arr=new int[len+1];
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                arr[k++]=sum;
            }
        }
        Arrays.sort(arr);
        Fwk fk=new Fwk(len);
        for(int i=1;i<=len;i++){
            fk.update(i,arr[i]);
        }
    return fk.range(right,left);
    }
}