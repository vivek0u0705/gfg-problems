class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int bits=Integer.toBinaryString(n).length();
        System.out.println(n+ " "+bits);
        return 1<<(bits);
    }
}