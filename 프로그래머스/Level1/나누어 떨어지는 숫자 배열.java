import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a : arr){
            if(a % divisor == 0){
                list.add(a);
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if (list.size() == 0){
            list.add(-1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
