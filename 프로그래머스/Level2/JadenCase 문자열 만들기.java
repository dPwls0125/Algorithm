import java.util.*;

class Solution {
    public String solution(String s) {
        // 입력 : 길이 1이상 200 이하 문자열, 공백 연속 포함 가능
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ",-1);
        
        for (String word : words){
            if (word.length() > 0){
                answer.append(word.substring(0,1).toUpperCase());
                answer.append(word.substring(1).toLowerCase());      
            }
            answer.append(" ");
        }
        
        return answer.toString().substring(0,answer.length()-1);
        
        
        // 출력 : JadenCase로 바꾼 단어들을 공백 포함하여 연결한다. 
    }
}
