class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length < 2) return nums;
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = left;      // pointer for temp

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }
}