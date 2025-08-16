What This Code Does:
* Find zeros in the matrix

* If a cell is 0, mark its row and column to be zero later.
* Use the first row & column as markers

* To track if first row and column have zeros we use firstrow and firstcol boolean variables 

* Instead of creating extra memory, the first row and column store which rows/columns should be zero.
* Set the marked cells to zero

* Go through the matrix and make elements 0 based on the markers.
* Handle the first row and column separately

If the first row/column originally had a 0, set the entire first row/column to 0.

Imagine this matrix:


1   2   3
4   0   6
7   8   9

After running the code, it becomes:

1   0   3
0   0   0
7   0   9
The 0 at (1,1) caused its entire row and column to be zero.