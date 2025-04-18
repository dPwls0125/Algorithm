import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        // 입력 :  게임 진행 시간 N초, B 스킬 시전 시간 M초
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); int m = Integer.parseInt(input[1]);
        // // A스킬 시전 시간 1초, B스킬 시전 시간 M초 일때, 가능한 스킬 조합의 수를 알고싶다. (스킬을 안쓰고 있는 시간은 없다.)
        // 로직 : dp 점화식 세우기
        // dp[i] i초를 채우는 방법의 수
        // 점화식 dp[0] = 1, dp[1] = 1 , dp[i] = dp[i-1] + dp[i-m]; (i-M >= 0 일때)
        long [] dp = new long[n+1];
        for (int time=0; time<=n; time++){
            if(time < m) dp[time] = 1;
            else {
                dp[time] = dp[time-1] + dp[time-m];
            }
            dp[time] %= 1_000_000_007;
        }
        //A:1초, B:M초 +>   게임 시간 N초일때 가능한 조합의 수
        System.out.println(dp[n]);
    }
}
