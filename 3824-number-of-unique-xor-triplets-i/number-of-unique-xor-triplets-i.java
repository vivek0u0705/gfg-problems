class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int bits=(int)(Math.log(n)/Math.log(2))+1;
        System.out.println(n+ " "+bits);
        return 1<<(bits);
    }
}