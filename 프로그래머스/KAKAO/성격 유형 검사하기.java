package 프로그래머스.KAKAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static Map<String,Integer> type_map = new HashMap<String,Integer>();
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        init();
        for(int i=0; i< survey.length; i++){
            String disagree_type = survey[i].substring(0,1);
            String  agree_type = survey[i].substring(1,2);
            // 비동의인 경우
            int score = choices[i] - 4;
            if(score < 0){
                type_map.replace(disagree_type, type_map.get(disagree_type) + Math.abs(score));
                continue;
            }
            // 동의 or 모르겠음의 경우
            type_map.replace(agree_type, type_map.get(agree_type) + score);
        }
        // 1번 지표
        decide_type("R","T",answer);
        // 2번 지표
        decide_type("C","F",answer);
        // 3번 지표
        decide_type("J","M",answer);
        // 4번 지표
        decide_type("A","N",answer);

        return answer.toString();
    }

    public void decide_type(String a, String b, StringBuilder answer){
        if(type_map.get(a) > type_map.get(b)) {
            answer.append(a);
            return;
        }
        if(type_map.get(a) < type_map.get(b)){
            answer.append(b);
            return ;
        }
        if(Objects.equals(type_map.get(a), type_map.get(b))){
            char a_c = a.charAt(0);
            char a_b = b.charAt(0);
            answer.append((char)Math.min(a_c,a_b));
        }
    }

    public void init(){
        type_map.put("R",0);
        type_map.put("T",0);
        type_map.put("C",0);
        type_map.put("F",0);
        type_map.put("J",0);
        type_map.put("M",0);
        type_map.put("A",0);
        type_map.put("N",0);
    }
}


