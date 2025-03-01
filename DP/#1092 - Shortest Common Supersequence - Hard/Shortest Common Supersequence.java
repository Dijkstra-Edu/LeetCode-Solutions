class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // If characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max from either previous row or column
                }
            }
        }

        // Build the shortest common supersequence
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // If characters are the same, add to the result
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // Move in the direction of the larger dp value
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }

        // If there are any remaining characters in str1
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }

        // If there are any remaining characters in str2
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result before returning
        return result.reverse().toString();
    }
}