class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tobe = n * (n + 1) / 2;

        int real = 0;
        for (int num : nums) {
            real += num;
        }

        return tobe - real;
    }
}