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
        int input = Integer.parseInt(readLine);
        // 로직 : dp사용하여 배열에 결과 저장
        long [] dp = new long[117];

        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= input; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        // 출력 : 피보나치 비스무리한 수열 f(n) = f(n-1) + f(n-3)의 결과
        System.out.println(dp[input]);
    }
}

