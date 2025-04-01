import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 : 자연수 n (1~116)
        String readLine = br.readLine();
        Integer input = Integer.parseInt(readLine);
        // 로직 : dfs를 사용하여 재귀적으로 탐색, 중복 계산 방지를 위해 배열에 결과 저장
        long[] dp = new long[117];
        int[] visited = new int[117];
        long result = dfs(input, dp , visited);
        // 출력 : 피보나치 비스무리한 수열 f(n) = f(n-1) + f(n-3)의 결과
        System.out.println(result);

    }

    public static long dfs(int n, long[] dp, int[] visited ) {

        // dfs exit 조건
        if (n == 1 || n == 2 || n == 3){
            dp[n] = 1;
            visited[n] = 1;
            return 1;
        }

        if (visited[n] == 1 ) {
            return dp[n];
        }

        dp[n] = dfs(n-1, dp, visited) + dfs(n-3, dp, visited);
        visited[n] = 1;
        return dp[n];
    }

}
