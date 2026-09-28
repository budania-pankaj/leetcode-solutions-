class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
       int[][] ans = new int[m][matrix.length];
        for (int i = 0; i < matrix[0].length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;  
    }
}