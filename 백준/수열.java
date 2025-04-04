import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1 : N _ 온도를 측정한 전체 날짜 수, K : 연속적인 날짜의 수
        String readLine = br.readLine();
        String[] NK = readLine.split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);

        // 입력2 : N일 동안 측정한 온도 int 배열
        readLine = br.readLine();
        String[] tempLine = readLine.split(" ");
        int [] temperatures = new int[n+1];

        for(int i=0; i<n; i++) {
            temperatures[i] = Integer.parseInt(tempLine[i]);
        }

        // 로직 :
        // 1. 2중 포문 : 최대 O(N^2) -> 10^10 -> 1초 초과 (불가능)
        // 2. 슬라이딩 윈도우 : 이전 계산 값을 저장하면서 진행. 0(N) -> 10 ^ 5 -> 1초 이내
        int memo = 0;
        int max;

        for (int i=0; i<k; i++){
            memo += temperatures[i];
        }

        max = memo;
        for (int i=1; i<n-k+1; i++){
            memo = memo - temperatures[i-1] + temperatures[i+k-1];
            max = Math.max(max,memo);
        }

        // 출력 : 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력
        System.out.println(max);
    }
}


