import java.util.*;
class Solution {
    
    public int solution(int n, int[][] edge) {
        
        Graph graph = new Graph(n);
        int[] distance = graph.distance;
        
        for(int i=0; i<edge.length; i++){
            graph.addRelation(edge[i][0],edge[i][1]);
        }
        
        graph.bfs(1);
        
        int max_value = distance[1]; 
        int cnt_max = 1; 
        
    
        for(int i=2; i<=n ; i++){
            if (max_value < distance[i]){
                cnt_max = 1; 
                max_value = distance[i];
            }else if (max_value == distance[i]){
                // System.out.println("max_value: " + max_value + "node: "  + i);
                cnt_max++;
            }
        }
        
        return cnt_max;
    }
    
    
}

class Graph{
    
    public ArrayList<ArrayList<Integer>> adj; 
    public boolean[] visited; 
    public int[] distance; 
    
    public Graph(int n){
        
        adj = new ArrayList<ArrayList<Integer>>(); 
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<Integer>());
        }
        visited = new boolean[n+1];
        distance = new int[n+1];
    }
    
    public void addRelation(int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    
    public void bfs(int node){
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.add(node);
        distance[node] = 0; 
        visited[node] = true; 
        
        while(!q.isEmpty()){
            
            int current_node = q.remove();
            
            for (int i=0; i<adj.get(current_node).size(); i++){
                
                int adj_node = adj.get(current_node).get(i);
                
                if(!visited[adj_node]) {
                    distance[adj_node] = distance[current_node] + 1; 
                    visited[adj_node] = true; 
                    q.add(adj_node); 
                }
            }
        }
        
    }
    

}
