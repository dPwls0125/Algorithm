import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {
    public static int[][] heights;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String readLine = br.readLine();
            // w, h 입력받기
            String[] readLine_split = readLine.split(" ");
            int w = Integer.parseInt(readLine_split[0]);
            int h = Integer.parseInt(readLine_split[1]);

            // 입력 종료
            if (w==0 && h ==0){
                break;
            }

            // 육지와 바다 정보 입력받기
            int[][] earth = new int[h][w];
            for(int i=0; i<h; i++){
                readLine = br.readLine();
                String[] row = readLine.split(" ");
                for(int j=0; j<w; j++){
                    earth[i][j] = Integer.parseInt(row[j]);
                }
            }

            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    // 1은 땅, 0은 바다
                    if(earth[i][j] == 1) {
                        dfs(earth,i,j);
                        cnt += 1 ;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int[][] earth, int i, int j){
        // exit 조건
        if (earth[i][j] == 0 ) return;

        // 방문 표시
        earth[i][j] = 0;
        int[] dx = {-1,0,1,1,1,0,-1,-1};
        int[] dy = {-1,-1,-1,0,1,1,1,0};

        for (int k=0; k<8; k++) {
            int next_i = i+dy[k]; int next_j = j+dx[k];
            if (next_i >= 0 && next_i< earth.length && next_j >=0 && next_j < earth[0].length )
                dfs(earth,i+dy[k], j+dx[k]);
        }
    }
}


