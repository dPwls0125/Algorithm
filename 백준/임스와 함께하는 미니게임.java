import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력 :  게임 신청 횟수 n , 게임 중류 (Y, F, O => 2,3,4)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 로직 : 동일한 사람과 게임을 진행하지 않음. 총 몇번 할 수 있을까?
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        String kind = inputs[1];
        Set<String> set = new HashSet<String>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        int result;
        if (kind.equals("Y")) result = set.size() / 1;
        else if (kind.equals("F")) result = set.size()  / 2;
        else result = set.size() / 3;

        System.out.println(result);
    }
}



