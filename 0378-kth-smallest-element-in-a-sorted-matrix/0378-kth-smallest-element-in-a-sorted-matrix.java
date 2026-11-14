class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        while (--k > 0) {
            int[] cur = pq.poll();

            int val = cur[0];
            int row = cur[1];
            int col = cur[2];

            if (col + 1 < matrix[0].length) {
                pq.offer(new int[]{
                    matrix[row][col + 1],
                    row,
                    col + 1
                });
            }
        }

        return pq.peek()[0];
    }
}