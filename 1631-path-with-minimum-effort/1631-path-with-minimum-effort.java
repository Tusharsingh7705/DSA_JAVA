class Solution {
    public int minimumEffortPath(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int l=0,r=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                r = Math.max(arr[i][j],r);
            }
        }
        while(l<=r){
            int mid = l + (r-l)/2;
            int[][] vis = new int[rows][cols];
            for(int i=0;i<rows;i++){
                Arrays.fill(vis[i],-1);
            }
            if(dfs(mid,0,0,arr,rows,cols,vis,0,0)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    static boolean dfs(int mid, int i,int j, int[][] arr, int rows, int cols, int[][] vis,int previ,int prevj){
        if(i<0 || j<0 || i>=rows || j>=cols || vis[i][j]==1)return false;

        int check = Math.abs(arr[i][j]  - arr[previ][prevj]);
        if(check>mid)return false;

        vis[i][j]=1;

        if(i==rows-1 && j==cols-1)return true;
        
        return dfs(mid,i+1,j,arr,rows,cols,vis,i,j) || dfs(mid,i,j+1,arr,rows,cols,vis,i,j) || dfs(mid,i-1,j,arr,rows,cols,vis,i,j) || dfs(mid,i,j-1,arr,rows,cols,vis,i,j);
    }
}