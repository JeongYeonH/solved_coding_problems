package 레벨2_문제;

class Solution{
    int count = 0;

    public int solution(int n) {
        int[] queens = new int[n];
        dfs(queens, 0, n);
        return count;
    }

    public void dfs(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                dfs(queens, row + 1, n);
            }
        }
    }

    public boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
