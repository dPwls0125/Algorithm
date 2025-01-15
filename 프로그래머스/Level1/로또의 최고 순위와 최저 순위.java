import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int numberOfErased = 0;
        int numberOfCorrespond = 0;

        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                numberOfErased++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]){
                    numberOfCorrespond++;
                    break;
                }
            }
        }

        int floor = Math.abs(numberOfCorrespond - 7);
        int ceiling = Math.abs(numberOfErased + numberOfCorrespond - 7);
        if(floor > 6){
            floor = 6;
        }
        if(ceiling > 6){
            ceiling = 6;
        }
        return List.of(ceiling,floor).stream().mapToInt(Integer::intValue).toArray();
    }
}
