class Solution {
    List<Integer>[] g;
    double ans = 0;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(1, 0, 1.0, t, target, 0);
        return ans;
    }

    void dfs(int node, int time, double prob, int t, int target, int parent) {
        if (time > t) return;

        int children = 0;
        for (int nei : g[node]) if (nei != parent) children++;

        if (node == target) {
            if (time == t || children == 0) ans = prob;
            return;
        }

        if (children == 0) return;

        for (int nei : g[node]) {
            if (nei != parent) {
                dfs(nei, time + 1, prob / children, t, target, node);
            }
        }
    }
}
