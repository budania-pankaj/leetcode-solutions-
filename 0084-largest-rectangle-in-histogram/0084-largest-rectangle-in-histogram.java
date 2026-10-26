
 class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        nextSmaller = findNextSmallerElements(heights, n);
        prevSmaller = findPrevSmallerElements(heights, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] findNextSmallerElements(int[] heights, int n) {
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nextSmaller;
    }

    private static int[] findPrevSmallerElements(int[] heights, int n) {
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return prevSmaller;
    }
}