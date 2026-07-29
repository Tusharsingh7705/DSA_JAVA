class Solution {

    public static boolean dfs(int node,int set,int color[],int graph[][]){
        color[node] = set;

        for(int it:graph[node]){
            if(color[it]==-1){
               if(dfs(it,1-color[node],color,graph)==false){
                return false;
               }
            }
            else if(color[it]==color[node]){
                return false;
            }
        }

        return true;

       

    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<graph.length;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false){
                    return false;
                }
            }
           
        }

        return true;
        



        
       


        
    }
}