package 프로그래머스.KAKAO;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        Id id = new Id(new_id);
        return id.getId();
    }
}

interface Validation_ID{

    public String step1(String id);
    public String step2(String id);
    public String step3(String id);
    public String step4(String id);
    public String step5(String id);
    public String step6(String id);
    public String step7(String id);

}

class Id implements Validation_ID {

    public static Set<String> set = new HashSet<String>();
    private String id;
    public Id(String id){
        id = step1(id);
        id = step2(id);
        id = step3(id);
        id = step4(id);
        id = step5(id);
        id = step6(id);
        id = step7(id);

        this.id = id;
    }


    public String getId(){
        return this.id;
    }

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    @Override
    public String step1(String id) {
        return id.toLowerCase();
    }

    @Override
    public String step2(String id) {
        return id.replaceAll("[^a-z0-9\\-_.]","");
    }


    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    @Override
    public String step3(String id) {
        return id.replaceAll("\\.{2,}", ".");
    }

    //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    @Override
    public String step4(String id) {
        if (id.startsWith(".")) {
            id = id.substring(1);
        }
        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }
    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    @Override
    public String step5(String id) {
        if(isEmptyString(id)){
            id = "a";
        }
        return id;
    }

    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    @Override
    public String step6(String id) {
        if(id.length() >= 16) {
            id = id.substring(0,15);
        }
        return step4(id);
    }

    @Override
    public String step7(String id) {

        StringBuilder strB = new StringBuilder();
        strB.append(id);

        if(strB.length() <=2 ){
            String lastChar = strB.substring(strB.length()-1,strB.length());
            while(strB.length() != 3){
                strB.append(lastChar);
            }
        }
        return strB.toString();
    }

    private boolean isEmptyString(String str){
        if(str == null || str.isEmpty() || str.isBlank()){
            return true;
        }
        return false;
    }

}