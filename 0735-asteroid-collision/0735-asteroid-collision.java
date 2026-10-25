class Solution {
    public int[] asteroidCollision(int[] asteroids) {
 Deque<Integer> s = new ArrayDeque<>(); // Used this since stack is slow in java
        
        int i, n = asteroids.length;
        for(i = 0; i < n; i++)
        {
            int curr = asteroids[i];
            if(curr > 0)
            {
                s.push(curr);
            }
            else if(curr < 0)
            {
                while(!s.isEmpty() && s.peek() > 0 && -curr > s.peek())
                {
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() > 0 && -curr == s.peek())
                {
                    s.pop();
                    continue;
                } 
                if((!s.isEmpty() && s.peek() < 0) || s.isEmpty())
                {
                    s.push(curr);
                }
            }
        }

        int[] ans = new int[s.size()];

        for(int j = ans.length - 1; j >= 0; j--)
        {
            ans[j] = s.pop();
        }
        return ans;
    }
}