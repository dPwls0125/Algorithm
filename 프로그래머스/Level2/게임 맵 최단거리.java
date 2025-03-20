class Solution {
    
    public int min_route = Integer.MAX_VALUE; 
    
    public int solution(int[][] maps) {

        dfs(1,0,0,maps);
        
        if (min_route == Integer.MAX_VALUE) return -1;
        
        return min_route;
    }
    
    
    public void dfs(int current_route, int x , int y, int[][] maps){
        // dfs 종료 조건 
        if (x < 0 || x > maps[0].length-1 || y < 0 || y > maps.length-1) {
            return;            
        }

        if ( maps[0].length - 1 == x && maps.length - 1 == y ){
            min_route =  Math.min(current_route, min_route);
            return;
        }
        
        // 도달할 수 없는 길이거나 이미 방문했던 경로인 경우(Cycle 제거)
        if ( maps[y][x] == 0 || maps[y][x] == -1 ){
            return;    
        }
        
        // 방문 표시
        
        int temp = maps[y][x];
        maps[y][x] = -1; 
        
        dfs(current_route+1,x,y-1,maps);
        dfs(current_route+1,x-1,y,maps);
        dfs(current_route+1,x+1,y,maps);
        dfs(current_route+1,x,y+1,maps);    
        
        maps[y][x] = temp; 
    }
} 
