class Solution {
    public void reverseString(char[] s) {
     /*  int start = 0 ,end = s.length-1;
        while(start < end ){
            char a  = s[start];
            s[start] = s[end];
            s[end] = a;
            start++;
            end--;
*/
int n = s.length;

reverse(s ,0 ,n-1);
        } 
        void reverse(char[] s ,int low ,int end)
        {
int start = low ;



             if(start >= end) return ;
     char a = s[start];
    s[start]  =   s[end];
    s[end] = a ;
    reverse(s , low+1 ,end-1);
        }
    }
