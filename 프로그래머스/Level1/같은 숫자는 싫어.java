import java.util.*;

 class Solution {
    public int[] solution(int []arr) {
        int top_number = -1;
        List<Integer> numbers = new ArrayList<>();
        for(int num : arr){
            if(num != top_number){
                numbers.add(num);
                top_number = num;
            }
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
