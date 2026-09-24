class Solution {
    public int fib(int n) {
        if( n <= 1 ) return n;
        int s = fib(n-1);
 int v = fib(n-2);
        return  s + v ;
    }
}