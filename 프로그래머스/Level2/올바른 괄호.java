class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int open = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                open--;
            }else{
                open++;
            }
            if(open < 0) return false;
        }
        if(open > 0) answer = false;
        return answer;
    }

}
