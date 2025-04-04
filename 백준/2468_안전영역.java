import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
    public static int[][] heights;
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1 : n , 정사각형 배열의 너비
        String readLine = br.readLine();
        int n = Integer.parseInt(readLine);
        // 입력2 : 각 격자 지역의 높이
        String[] inputs;
        heights = new int[n][n];
        int max_height = -1;
        boolean[][] flood = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            readLine = br.readLine();
            inputs = readLine.split(" ");
            for (int j = 0; j < n; j++) {
                heights[i][j] = Integer.parseInt(inputs[j]);
                max_height = Math.max(heights[i][j],max_height);
            }
        }
//        System.out.println(max_height);
        /*
        1. 로직 O(N**2)로 비에 잠기는지 안잠기는지 체크(비 높이 이하이면 잠김), max_height 최대 높이 구하기
        2. dfs로 인접 노드 탐색하며 지역 최대 갱신하기
         */
        int max_area = 0;

        for (int rain = max_height; rain>=0; rain--){
            boolean[][] visited = new boolean[n][n];
            // 1. flood 상태 갱신
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(heights[i][j] <= rain) {
                        flood[i][j] = true;
                        visited[i][j] = true;
                    }else{
                        flood[i][j] = false;
                    }
                }
            }

            // 물에 잠기지 않는 안전한 영역 갯수 - max값 갱신
            // dfs(int i, int j, boolean[][] visited, int cnt)
            cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    dfs(i,j,flood,visited);
                    cnt++;
                }
            }

//            System.out.println("cnt" + cnt);
            max_area = Math.max(max_area,cnt);
        }
        System.out.println(max_area);
    }

    public static void dfs(int i, int j, boolean[][] flood, boolean[][] visited){
        // dfs 종료 조건
        if (visited[i][j] || flood[i][j]) {
            return;
        }

        visited[i][j] = true;
        // 탐색
        int[][] search = {
                {i-1,j},
                {i,j-1},
                {i+1,j},
                {i,j+1}
        };

        for (int k=0; k<4; k++){

            int tempI = search[k][0];
            int tempJ = search[k][1];
            if(tempI >=0 && tempJ >=0 && tempI < heights.length && tempJ < heights.length)
                dfs(tempI,tempJ,flood,visited);
        }
//        // cnt 증가 연산
//        ++cnt;
    }

}


