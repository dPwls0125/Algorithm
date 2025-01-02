package 프로그래머스.KAKAO;

import java.util.HashMap;
import java.util.HashSet;

public class 신고_결과_받기 {
     public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        // key:신고 당한 사람, value:신고 한사람. HashSet을 쓰는 이유는 중복 신고를 거르기 위해서임.
        HashMap<String, HashSet<String>>reportMap = new HashMap<>();
        // 모든 아이디의 신고 결과를 저장 (신고가 K만큼 접수되었다면 value++)
        HashMap<String,Integer> result = new HashMap<>();

        
        // initialize Maps
        int idx = 0; 
        for(String id : id_list){
            reportMap.put(id,new HashSet<String>());
            result.put(id,0);
        }

        for(String declaration : report){
            String[] split_declaration = declaration.split(" ");
            String reporter = split_declaration[0];
            String accused = split_declaration[1];
            reportMap.get(accused).add(reporter);
        }

        // 키셋을 통해 접근
        for(String key : reportMap.keySet()){
            HashSet<String> reporters = reportMap.get(key);
            if(reporters.size() >= k){
                for(String reporter : reporters){
                    result.replace(reporter,result.get(reporter)+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = result.get(id_list[i]);
        }

        return answer;
    }
}
