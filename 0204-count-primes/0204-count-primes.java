class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;

        boolean[] composite = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!composite[i]) {
                count++;
                // (long) avoids int overflow of i * i
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        composite[j] = true;
                    }
                }
            }
        }
        return count;
    }
}