import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean visited [] = new boolean[1000001];
        visited[1] = true; // 1은 소수가 아님

        // 두 정수 입력 받기
        String[] inputs = br.readLine().split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);

        int max_num = Math.max(num1,num2);
        int min_num = Math.min(num1,num2);


        for (int i = min_num; i <= max_num; i++){
            if (visited[i]) continue;

            boolean isItPrime = true;

            // 소수 판별
            for (int j = 2; j <= Math.sqrt(i); j++){
                if ( i % j == 0) {
                    isItPrime = false;
                    break;
                }
            }

            // 소수인 경우 배수의 수 모두 탐색 범위에서 제거
            if (isItPrime) {
                int cnt = 1;
                while(i * cnt <= max_num){
                    visited[cnt * i] = true;
                    cnt += 1;
                }

                System.out.println(i);
            }
        }
    }


}
