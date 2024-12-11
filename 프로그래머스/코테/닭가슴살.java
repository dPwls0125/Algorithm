package 프로그래머스.코테;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class 닭가슴살 {

    public int[] axis_x = {1, 0, -1, 0};
    public int[] axis_y = {0, 1, 0, -1};
    public int[] startPoint;
    public boolean dfs(int[][] map, int x, int y, boolean[][] visited) {

        if (x < 0 || x >= map.length || y < 0 || y >= map.length || visited[y][x]) return false;

        int dist = map[y][x];

        if (dist == 7) return true;
        else if (dist == 0 || dist == 8) return false;

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int index_x = axis_x[i] * dist + x;
            int index_y = axis_y[i] * dist + y;

            if (index_x >= 0 && index_x < map.length && index_y >= 0 && index_y < map.length) {
                if (y == startPoint[0] && x == startPoint[1] && (i == 1 || i == 3)) {
                    continue;
                }
                if (dfs(map, index_x, index_y, visited)) return true;
            }
        }
        return false;
    }
    public boolean solution ( int[][] tossConvenienceStoreMap, int[] entrancePoint){
        startPoint = Arrays.copyOf(entrancePoint, entrancePoint.length);
        boolean[][] visited = new boolean[tossConvenienceStoreMap.length][tossConvenienceStoreMap.length];
        return dfs(tossConvenienceStoreMap,entrancePoint[1], entrancePoint[1], visited);
    }

    public static void main(String[] args) {
//        int[][] map = {
//
//                        {1,2,3,2,1},
//                        {4,2,0,7,2},
//                        {1,3,3,8,1},
//                        {2,0,1,1,1},
//                        {8,2,8,1,1}
//        };

        int[][] map =
                {{1, 2, 3, 2, 1}, {4, 2, 0, 7, 2}, {1, 3, 3, 8, 1}, {2, 0, 1, 1, 1}, {8, 2, 8, 1, 1}};
        int[] entrancePoint = {0,0};
        닭가슴살 m = new 닭가슴살();
        System.out.println(m.solution(map,entrancePoint));
    }
}
