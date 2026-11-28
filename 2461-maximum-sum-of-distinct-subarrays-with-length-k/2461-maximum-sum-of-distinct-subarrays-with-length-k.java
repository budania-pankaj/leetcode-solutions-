class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int r = 0, l = 0;
        long sum = 0;
        long maxSum = 0;

        while (r < nums.length) {

            int i = nums[r];

            // Remove elements until i becomes unique
            while (set.contains(i)) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            // Add current element
            set.add(i);
            sum += i;

            // Window size is k
            if (r - l + 1 == k) {

                maxSum = Math.max(maxSum, sum);

                // Move window forward
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return maxSum;
    }
}