class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
     if(n<=2) return n ;
   /*  return climbStairs(n-1)+climbStairs(n-2);
   */
    if(map.containsKey(n)) {
      return   map.get(n);
       }
       int a = climbStairs(n-1);
       int b = climbStairs(n-2);
       int res = a +b;
       map.put(n ,res);
 return res;
    }
}