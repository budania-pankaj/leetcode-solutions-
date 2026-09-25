class Solution {
    List<List<Integer>> ans= new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        printSubsets(0, nums, new ArrayList<>());
        return ans;
    }

    private void printSubsets(int i, int[] nums, List<Integer> arr) {
        if (i == nums.length) {
            ans.add(arr);          
            return;
        }
        printSubsets(i + 1, nums, arr);                  
        List<Integer> take = new ArrayList<>(arr);       
        take.add(nums[i]);
        printSubsets(i + 1, nums, take);                   
    }
}