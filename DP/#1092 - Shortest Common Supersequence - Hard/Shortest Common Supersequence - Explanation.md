Shortest Common Supersequence Solution
Overview
The goal of this solution is to find the shortest common supersequence (SCS) of two given strings, str1 and str2. The shortest common supersequence is the shortest string that has both str1 and str2 as subsequences.

Steps
Create DP Table:

We first create a dynamic programming (DP) table dp of size (m + 1) x (n + 1), where m is the length of str1 and n is the length of str2.

Fill the DP Table:

We fill the DP table based on the following conditions:

If characters of str1 and str2 match, we take the diagonal value and add 1: dp[i][j] = dp[i - 1][j - 1] + 1.

If characters do not match, we take the maximum value from the left or the top cell: dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]).

Build the Shortest Common Supersequence:

We use a StringBuilder to construct the SCS.

Starting from the bottom-right corner of the DP table, we move based on the values in the DP table:

If characters match, we add that character to the result and move diagonally up-left.

If characters do not match, we move in the direction of the larger DP value (either up or left).

Finally, we add any remaining characters from str1 or str2.

Reverse the Result:

The result is constructed in reverse order, so we reverse it before returning.

Time Complexity
The time complexity is O(m * n) because we traverse the DP table of size (m + 1) x (n + 1).

Space Complexity
The space complexity is O(m * n) because we use a DP table of size (m + 1) x (n + 1).