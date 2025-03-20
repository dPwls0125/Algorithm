import java.util.*;

class Solution {

    public static int min_route = Integer.MAX_VALUE;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
    }

    public static int bfs(int[][] maps) {

        int[][] distance = new int[maps.length][maps[0].length];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        distance[0][0] = 1;
        maps[0][0] = -1 ;

        while(!queue.isEmpty()){
            Pair node = queue.remove();

            int current_x = node.x;
            int current_y = node.y;

            // 도착 지점에 도달한 경우
            if ( maps[0].length - 1 == current_x && maps.length - 1 == current_y ){
                return distance[node.y][node.x];
            }

            for (int i=0; i<4; i++) {
                // 범위를 벗어났거나 이미 방문했던 노드인 경우
                int x = current_x + dx[i];
                int y = current_y + dy[i];

                if (!check(x, y, maps)) {
                    continue;
                }
                queue.add(new Pair(x, y));
                distance[y][x] = distance[current_y][current_x] + 1;
                maps[y][x] = -1;
            }
            
        }
        return -1;
    }

    public static boolean check(int x, int y, int[][]maps){
        // dfs 종료 조건
        if (x < 0 || x > maps[0].length-1 || y < 0 || y > maps.length-1) {
            return false;
        }

        // 도달할 수 없는 길이거나 이미 방문했던 경로인 경우(Cycle 제거)
        if ( maps[y][x] == 0 || maps[y][x] == -1 ){
            return false;
        }

        return true;
    }
}


class Pair{
    int x ; int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

