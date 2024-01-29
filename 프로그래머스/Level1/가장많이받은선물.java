
package 프로그래머스.Level1;
import java.util.*;
public class 가장많이받은선물 {
    public static int solution(String[] friends, String[] gifts) {
    int answer = 0;
    int[][] arr2 = new int[55][55];
    int[] presentNum = new int[55];
    int[] answerList = new int[55];
    Map<String,Integer> indexMap = new HashMap();
    //indexMap에 각friends의 인덱스를 매핑
    for(int i=0; i<friends.length; i++)
        indexMap.put(friends[i],i);
    
    for(int i = 0; i<gifts.length; i++){
        String[] split = gifts[i].split(" ");
        int giver = indexMap.get(split[0]);
        int getter = indexMap.get(split[1]);
        arr2[giver][getter]++;
        presentNum[giver]++; //선물지수 계산
        presentNum[getter]--;
    }
    //다음달에 받게 될 선물 계산
    for(int i=0; i<friends.length; i++){
        for(int j=i+1; j<friends.length; j++){
            if(arr2[i][j] == arr2[j][i]) {
                if(presentNum[i] > presentNum[j]) answerList[i]++;
                else if(presentNum[i] < presentNum[j]) answerList[j]++;
            }
            else if(arr2[i][j] > arr2[j][i]) answerList[i]++;
            else answerList[j]++;
        }
    }
    for(int i=0; i<friends.length; i++){
        // System.out.println("answerlist: "+ answerList[i]);
        answer = Math.max(answer,answerList[i]);
        // System.out.println("current max: "+answer);
    }    
    return answer;
    } 
    public static void main(String[] args) {
        // String[] friends = {"muzi", "ryan", "frodo", "neo"};
        // String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends,gifts));
        /*
         * 누가 더 선물을 많이 받는가?
        1.	선물을 주고 받음 : 관계에서 선물을 더 많이 준사람이 다음달에 하나 받음
        2.	선물을 주고받지 않음 : 선물지수가 높은 사람이 선물을 받음
        선물지수 : 모두에게 준선물 – 모두에게 받은 선물
        다음달에 선물을 가장 많이 받은 친구의 선물수 
        선물을 준친구 선물을 받은 친구
         */
    } 
}