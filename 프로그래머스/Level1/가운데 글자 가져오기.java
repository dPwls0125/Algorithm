class Solution {
    public String solution(String s) {
        String answer = "";
        int medium = s.length() / 2;
        if(s.length() % 2 == 0){
            answer = s.substring(medium-1,medium+1);
        }else{
            answer = s.substring(medium,medium+1);
        }
            return answer;
    }
}
