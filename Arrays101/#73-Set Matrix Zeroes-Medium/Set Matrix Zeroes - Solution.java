class Solution{
    public void SetMatrixZeroes(int[][] matrix) {
        boolean firstrow = false, firstcol = false; // Used to check if the first row and first column contain any zeros
        
        // Iterate through the matrix to find zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) { // If an element is 0, mark its row and column in the first row and first column
                    if (i == 0) firstrow = true; // Mark that the first row has a zero
                    if (j == 0) firstcol = true; // Mark that the first column has a zero
                    
                    // Store zero markers in the first row and first column
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Use the markers in the first row and column to set matrix elements to zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // If the first row was marked, set all elements in the first row to zero
        if (firstrow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // If the first column was marked, set all elements in the first column to zero
        if (firstcol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
