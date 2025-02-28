class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if (a > b){
            int temp_b = b;
            b  = a;
            a = temp_b;
        }
        return (a+b)*(b-a+1)/2;
    }
}
