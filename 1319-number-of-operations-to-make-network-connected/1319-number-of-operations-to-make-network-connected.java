class Solution {
    static class DSU{
        int size[];
        int parent[];
        int components;

        public DSU(int n){
            size = new int[n];
            parent = new int[n];
            this.components = n;

            for(int i = 0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u){
            if(parent[u]==u) return u;
            return parent[u] = find(parent[u]);
        }

        public void union(int u,int v){

            int pu = find(u);
            int pv = find(v);

            if(pu==pv){
                return;
            }

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            components--;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;

     
        if(m < n - 1) return -1;

        DSU obj = new DSU(n);

        for(int i = 0; i < m; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            obj.union(a,b);
        }

       
        return obj.components - 1;
        
    }
}