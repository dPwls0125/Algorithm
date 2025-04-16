import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
    public static void main(String[] args) throws IOException {
        // 입력 : n (1<= n <=10000) , n개 포도주의 양 각각 나열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 로직 : 연속으로 놓여있는 3잔을 모두 마실 수는 없다.
        int[] wine = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n==1) {
            System.out.println(wine[0]);
            return;
        }
        else if (n==2) {
            System.out.println(wine[0] + wine[1]);
            return;
        }

        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        int temp = Math.max(dp[1],dp[0] + wine[2]); // 나자신 제외, 중간 제외
        dp[2] = Math.max(temp, wine[1] + wine[2]); // 맨 왼쪽 제외

        for (int i=3; i<n; i++){
            temp = Math.max(dp[i-1],dp[i-2]+ wine[i]); // 맨 오른쪽 제외, 중간 제외
            dp[i] = Math.max(temp,dp[i-3] + wine[i-1] + wine[i]); // 맨 왼쪽 제외
        }
        // 출력 : 최대로 마실 수 있는 포도주의 양 (2초)
        System.out.println(dp[n-1]);
    }
}

