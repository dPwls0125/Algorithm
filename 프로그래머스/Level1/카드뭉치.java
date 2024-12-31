package 프로그래머스.Level1;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        String answer = "";
        int cards1_index = 0;
        int cards2_index = 0;

        for(int i=0; i<goal.length; i++){
            
            if(cards1_index < cards1.length &&cards1[cards1_index].equals(goal[i])){
                ++cards1_index;
                continue;
            }
            if(cards2_index < cards2.length && cards2[cards2_index].equals(goal[i])){
                ++cards2_index x;
                continue;
            }

            answer = "No";
            return answer;
        }

        answer = "Yes";
        return answer;
    }
}
