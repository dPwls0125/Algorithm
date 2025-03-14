import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(br.readLine());

        long[] dp = new long[height+1];
        dp[0] = 1;
        for (int i=1; i<=height; i++){
            if(i % 2 ==0) dp[i] = dp[i-1] * 2 + 1;
            else dp[i] = dp[i-1] * 2 -1 ;
        }

        System.out.println(dp[height]);
    }
}
