class Solution {
    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        // Base case
        if (index == word.length()) {
            return true;
        }

        // Boundary + mismatch check
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Move in 4 directions
        int[] rowDir = {1, -1, 0, 0};
        int[] colDir = {0, 0, 1, -1};

        boolean found = false;
        for (int d = 0; d < 4; d++) {
            if (backtrack(row + rowDir[d], col + colDir[d], word, index + 1)) {
                found = true;
                break;
            }
        }

        // Restore the cell
        board[row][col] = temp;
        return found;
    }
}
