import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // key : number value : count 
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        ArrayList<Pair> list = new ArrayList<Pair>();
        int[] answer = new int[k];

        for(int i=0 ;i<nums.length; i++){
            int key = nums[i];
            if(map.containsKey(key)){
                int old_value = map.get(key);
                map.put(key,old_value+1);
            }else{
                map.put(key,1);
            }
        }

        for (int key : map.keySet()){
            list.add(new Pair(key,map.get(key)));
        }

        list.sort(Comparator.comparing(Pair::getCount).reversed());

        // for(Pair p : list){

        //     System.out.println("num:" + p.getNumber() + "cnt;" + p.getCount());
        
        // }

        for(int i=0; i<k; i++){
            System.out.println(list.get(i).getNumber());
            answer[i] = list.get(i).getNumber();
        }

        return answer;
    }

    class Pair {
        int number;
        int count; 

        public Pair(int num, int cnt){
            number = num ; 
            count = cnt ; 
        }

        public int getCount(){
            return count;
        }

        public int getNumber(){
            return number;
        }
    }
}
