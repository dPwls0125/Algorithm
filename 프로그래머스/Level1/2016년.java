package 프로그래머스.Level1;

public class 2016년 {
    public static HashMap<Integer,Integer> month_map = new HashMap<Integer, Integer>();
    public String solution(int a, int b) {

        String[] arr = new String[] {"FRI", "SAT","SUN", "MON", "TUE", "WED", "THU"};
        int date_sum = 0;

        initialize_monthMap();

        for(int i=1; i<=a; i++){
            if(i == a) date_sum += b;
            else date_sum += month_map.get(i);
        }

        int temp = date_sum % 7;

        if(temp == 0) return arr[6];
        return arr[temp-1];
    }

    public void initialize_monthMap(){
        month_map.put(1,31);
        month_map.put(2,29);
        month_map.put(3,31);
        month_map.put(4,30);
        month_map.put(5,31);
        month_map.put(6,30);
        month_map.put(7,31);
        month_map.put(8,31);
        month_map.put(9,30);
        month_map.put(10,31);
        month_map.put(11,30);
        month_map.put(12,31);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5,24));
    }
}
