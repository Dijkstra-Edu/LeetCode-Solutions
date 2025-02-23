public class #1718-Construct Lexicographically Largest Valid Sequence-Medium {
    import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] vis = new boolean[n + 1];
        solve(0, res, vis, 0, n);
        return res;
    }

    private boolean solve(int indx, int[] res, boolean[] vis, int count, int n) {
        if (count == 2 * n - 1) {
            return true;
        }

        if (res[indx] != 0) {
            return solve(indx + 1, res, vis, count, n);
        }
        for (int i = n; i >= 1; i--) {
            if (!vis[i]) {
                if (i == 1) {
                    vis[i] = true;
                    res[indx] = i;
                    if (solve(indx + 1, res, vis, count + 1, n)) {
                        return true; // Early termination
                    }
                    vis[i] = false; // Backtrack
                    res[indx] = 0;
                } else if (indx + i < res.length && res[indx + i] == 0) {
                    vis[i] = true;
                    res[indx] = i;
                    res[indx + i] = i;
                    if (solve(indx + 1, res, vis, count + 2, n)) {
                        return true; 
                    }
                    vis[i] = false; 
                    res[indx] = 0;
                    res[indx + i] = 0;
                }
            }
        }
        return false; 
    }

}
}
