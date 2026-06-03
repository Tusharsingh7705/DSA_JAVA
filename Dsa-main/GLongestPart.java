import java.util.*;

public class GLongestPart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            adj.get(u).add(v);

            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int node : adj.get(x)) {
 
                dp[node] = Math.max(dp[node], dp[x] + 1);
                indegree[node]--;
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        sc.close();
    }
}
// import java.util.*;

// public class Main {
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for (int i=0; i<n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i=0; i<m; i++) {
//             int u=sc.nextInt() - 1;
//             int v=sc.nextInt() - 1;
//             adj.get(u).add(v);
//         }

//         int dp[]=new int[n];
//         boolean visited[]= new boolean[n];

//         int ans=0;

//         for (int i=0; i<n; i++){
//             ans=Math.max(ans, dfs(i,visited,dp,adj));
//         }

//         System.out.println(ans);
//     }

//     static int dfs(int node, boolean[] visited, int[] dp,ArrayList<ArrayList<Integer>> adj ){
        
//         if (visited[node]){
//             return dp[node];
//         }

//         visited[node]=true;

//         for (int next : adj.get(node)) {
//             dp[node]=Math.max(dp[node], 1 + dfs(next,visited,dp,adj));
//         }

//         return dp[node];
//     }
// }


// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.*;

// public class GLongestPart {
//     static ArrayList<ArrayList<Integer>> adj;
//     static int[] dp;

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++)
//             adj.add(new ArrayList<>());

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             adj.get(a).add(b); 
//         }

//         dp = new int[n + 1];
//         Arrays.fill(dp, -1);

//         int longestPath = 0;

//         for (int i = 1; i <= n; i++) {
//             longestPath = Math.max(longestPath, dfs(i));
//         }

//         System.out.println(longestPath);
//     }

//     private static int dfs(int node) {
//         if (dp[node] != -1) return dp[node];

//         int maxDepth = 0;

//         for (int it : adj.get(node)) {
//             maxDepth = Math.max(maxDepth, 1 + dfs(it));
//         }

//         return dp[node] = maxDepth;
//     }
// }