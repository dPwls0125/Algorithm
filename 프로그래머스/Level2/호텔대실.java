package 프로그래머스.Level2;

import java.util.*;
class Solution {
    public int solution(String[][] book_time){

        // 예약시간 기준으로 오름차순 정렬
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                // o1[1]와 o2[1]의 위치를 바꾸면 내림차순.
                // o1[1] - o2[1]도 가능
                else
                    return o1[0].compareTo(o2[0]);
            }
        });

        // 예약 시간 정수로 변경
        int[][] time = new int[book_time.length][2];
        for(int i=0; i< book_time.length; i++){

            int start_time = Integer.parseInt(book_time[i][0].replace(":",""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":",""));

            end_time += 10;
            if(end_time % 100 >= 60){
                end_time += 40;
            }

            time[i][0] = start_time;
            time[i][1] = end_time;
        }

        System.out.println(Arrays.deepToString(time));

        // Interval Partitioning (구간 채색)
        int total_room = 0;
        int current_using_room = 0;
        boolean checkout_room[] = new boolean[book_time.length]; // default value false;

        for(int i=0; i<time.length; i++){
            // 현재 일정의 시작시간 기준으로 이미 끝난 일정이 있으면 방 반납
            for(int j=0; j < i; j++){
                if(time[j][1] <= time[i][0] && checkout_room[j]!=true) {
                    System.out.println(i + " " + j);
                    --current_using_room;
                    checkout_room[j] = true;
                }
            }
            if(current_using_room == total_room){
                ++total_room;
            }
            ++current_using_room;
        }

        return total_room;

        // c:3 t:3
    }
}
