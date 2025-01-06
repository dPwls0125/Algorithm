import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();
        Map<String,Button> number_hand_map = new HashMap<String,Button>();
        init(number_hand_map);

        String current_left_hand = "*";
        String current_right_hand = "#";

        for(int number : numbers){
            // Left, Right가 지정된 번호의 경우
            String numberToString = Integer.toString(number);
            if(number_hand_map.get(numberToString).hand != null) {
                String h = number_hand_map.get(numberToString).hand;
                answer.append(h);
                if(h.equals("L")){
                    current_left_hand = numberToString;
                }else{
                    current_right_hand = numberToString;
                }
                continue;
            }
            // Left, Right가 지정되지 않은 번호의 경우
            Button left_hand_button = number_hand_map.get(current_left_hand);
            Button number_button = number_hand_map.get(numberToString);
            Button right_hand_button = number_hand_map.get(current_right_hand);
            int left_location_from_number = Math.abs(number_button.row - left_hand_button.row) + Math.abs(number_button.column - left_hand_button.column);
            int right_location_from_number = Math.abs(number_button.row - right_hand_button.row) + Math.abs(number_button.column - right_hand_button.column);
            if(left_location_from_number < right_location_from_number || (left_location_from_number == right_location_from_number && hand.equals("left")) ){
                current_left_hand = numberToString;
                answer.append("L");
            }
            else if(left_location_from_number > right_location_from_number || hand.equals("right")){
                current_right_hand = numberToString;
                answer.append("R");
            }

        }
        return answer.toString();
    }

    public void init(Map<String,Button>number_hand_map){
        number_hand_map.put("1",new Button(1,"L",0,0));
        number_hand_map.put("2",new Button(2,0,1));
        number_hand_map.put("3",new Button(3,"R",0,2));
        number_hand_map.put("4",new Button(4,"L",1,0));
        number_hand_map.put("5",new Button(5,1,1));
        number_hand_map.put("6",new Button(6,"R",1,2));
        number_hand_map.put("7",new Button(7,"L",2,0));
        number_hand_map.put("8",new Button(8,2,1));
        number_hand_map.put("9",new Button(9,"R",2,2));
        number_hand_map.put("*",new Button(-1,"L",3,0));
        number_hand_map.put("0",new Button(0,3,1));
        number_hand_map.put("#",new Button(-1,"R",3,2));
    }

}

class Button {

    int button_num;
    String hand;
    int row;
    int column;

    public Button(int button_num, String hand, int row, int column) {
        this.button_num = button_num;
        this.hand = hand;
        this.row = row;
        this.column = column;
    }

    public Button(int button_num, int row, int column) {
        this.button_num = button_num;
        this.row = row;
        this.column = column;
    }
}