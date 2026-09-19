
class Solution {
    public boolean containsDuplicate(int[] nums) {
/*    <<---Approach-1--->>>>>
    boolean flag  = false;
    for(int i = 0; i < nums.length;i++){
        if(flag == true) return flag;
        for(int j =  i + 1; j< nums.length;j++){
            if(nums[i] == nums[j]) {
            flag = true;
            break;}
        }
    }
    return flag;
    */
     /* <<<-----Approach-2 ----->>>>>
    Arrays.sort(nums);
    boolean flag = false;
    for(int i = 1; i< nums.length; i++){
        if(nums[i-1] == nums[i]) return (flag= true); 
    }
     return flag; */
             Set<Integer> uniq = new HashSet<>();
        for (int num : nums) {
            if (!uniq.add(num)) {  // add() returns false if it's already present
                return true;
            }
        }
        return false;

    }
}