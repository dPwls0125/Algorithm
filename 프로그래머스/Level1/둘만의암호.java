import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {

        HashSet<Integer> aski_skip_set = new HashSet<>();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<skip.length(); i++){
            int skip_num = skip.charAt(i);
            // auto_boxing
            aski_skip_set.add(skip_num);
        }

        // 전체 char에 대해
        for(int i=0; i<s.length(); i++){
//            System.out.println("current start char :" + s.charAt(i));
            int temp_index = index;
            int char_askicode = s.charAt(i);

            while(temp_index > 0){
                char_askicode++;
                //  z를 초과하면 a로 돌아감.
                if(char_askicode > 'z'){
                    char_askicode = 'a';
                }
                // skip에 포함된 문자라면 temp_index 감소 없이 건너뜀
                if(aski_skip_set.contains(char_askicode)) {
                    continue;
                }
                temp_index--;
            }
            // 변형된 알파벳을 추가
            answer.append((char)char_askicode);
        }
        return answer.toString();
    }
}