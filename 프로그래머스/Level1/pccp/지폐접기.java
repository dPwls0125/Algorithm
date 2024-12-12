package 프로그래머스.Level1.pccp;

public class 지폐접기 {
    public static int solution(int[] wallet, int[] bill) {

        int answer = 0;
        // 지갑 길이의 최대 최소
        int wallet_max = Math.max(wallet[0], wallet[1]);
        int wallet_min = Math.min(wallet[0], wallet[1]);

        // 지폐 길이의 최대 최소
        int bill_max = Math.max(bill[0],bill[1]);
        int bill_min = Math.min(bill[0],bill[1]);

        // 지폐의 최대가 지갑의 최대보다 크다면 or 지폐의 최소가 지갑의 최소보다 크다면
        // 지갑에 지폐가 들어갈때까지 접는다
        while(bill_max > wallet_max || bill_min > wallet_min){
            ++answer;
            bill[bill[0] > bill[1]? 0:1] /= 2;
            bill_max = Math.max(bill[0],bill[1]);
            bill_min = Math.min(bill[0],bill[1]);
        }
        return answer;
    }
}
