import java.util.*;

class Solution {
    class DSU {
        int[] par, rank;
        
        public DSU(int n) {
            par = new int[n + 1];
            rank = new int[n + 1];
            Arrays.fill(rank, 1);
            for (int i = 0; i <= n; i++) par[i] = i;
        }

        public int find_set(int v) {
            if (v == par[v]) return v;
            return par[v] = find_set(par[v]); // Path compression
        }

        public void union_sets(int a, int b) {
            a = find_set(a);
            b = find_set(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                par[b] = a;
                rank[a] += rank[b];
            }
        }
    }

    public List<Integer> minimumCost(int n, int[][] edges, int[][] query) {
        DSU ds = new DSU(n);
        int[] ands = new int[n + 1];
        Arrays.fill(ands, -1);

        for (int[] it : edges) {
            ds.union_sets(it[0], it[1]);
        }

        for (int[] it : edges) {
            int root = ds.find_set(it[0]);
            int cur = ands[root];
            ands[root] = (cur == -1) ? it[2] : (cur & it[2]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] it : query) {
            if (ds.find_set(it[0]) == ds.find_set(it[1])) {
                ans.add(ands[ds.find_set(it[0])]);
            } else {
                ans.add(-1);
            }
        }
        return ans;
    }
}