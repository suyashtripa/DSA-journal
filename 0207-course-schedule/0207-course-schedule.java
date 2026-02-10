class Solution {

    boolean ans = true;

    public boolean canFinish(int n, int[][] pre) {

        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph
        // b -> a (to take a, you must finish b)
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];

        // Step 3: Run DFS from every node
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, path);
                if (!ans) return false;
            }
        }

        return true;
    }

    // DFS to detect cycle
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {

        vis[node] = true;
        path[node] = true;   // mark current path

        for (int nei : adj.get(node)) {

            // 🔴 Cycle detected
            if (path[nei]) {
                ans = false;
                return;
            }

            // Go deeper
            if (!vis[nei]) {
                dfs(nei, adj, vis, path);
                if (!ans) return;
            }
        }

        // Backtrack (remove from current path)
        path[node] = false;
    }
}
