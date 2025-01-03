package 프로그래머스.KAKAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class 신고_결과_받기 {
      public int[] solution(String[] id_list, String[] report, int k) {
        // key:신고 당한 사람, value:신고 한사람. HashSet을 쓰는 이유는 중복 신고를 거르기 위해서임.
        Map <String, HashSet<String>>reportMap = new HashMap<>();
        // 모든 아이디의 신고 결과를 저장, HashMap의 순서를 보장하기 위해 LinkedMap 사용. 
        Map<String,Integer> result = new LinkedHashMap<>();

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
        
        // :: 메서드 참조란 람다형식의 축약형이라고 이해하면 된다. 즉 Integer 클래스의 intValue 메서드를 참조한다. x -> x.intValue();
        return result.values().stream().mapToInt(Integer::intValue).toArray();
    }
}
