import java.util.*;

class Solution {
    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        int n = 26;
        long[][] dist = new long[n][n];

        // initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        // fill direct costs
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Long.MAX_VALUE || dist[k][j] == Long.MAX_VALUE)
                        continue;

                    dist[i][j] = Math.min(dist[i][j],
                                          dist[i][k] + dist[k][j]);
                }
            }
        }

        long totalCost = 0;

        // compute answer
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s == t) continue;

            if (dist[s][t] == Long.MAX_VALUE)
                return -1;

            totalCost += dist[s][t];
        }

        return totalCost;
    }
}
