import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int[] result = {0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        str = br.readLine();
        String[] array = str.split(" ");

        int left_number = Integer.parseInt(array[0]);
        int right_number = Integer.parseInt(array[1]);

        int left_cnt = 0;
        int right_cnt = 0;

        // Top - down
        while(true){

            if (left_number > right_number){
                ++left_cnt;
                left_number = left_number - right_number;
            }

            else if (left_number < right_number){
                ++right_cnt;
                right_number = right_number - left_number;
            }

            else break;
        }

        System.out.println(left_cnt + " " + right_cnt);
    }
}
