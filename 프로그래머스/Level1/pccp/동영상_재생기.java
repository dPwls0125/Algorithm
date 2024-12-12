package 프로그래머스.Level1.pccp;

public class 동영상_재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int currentTime = parseTime(pos);
        for(String command : commands){
            // 현재 시간이 오프닝 시간에 속해있다면, 현재 재생 시간을 오프닝 시간의 끝으로 이동
            if(currentTime <= parseTime(op_end) && currentTime >= parseTime(op_start)){
                pos = op_end;
                currentTime = parseTime(op_end);
            }
            // prev 명령이 떨어졌을때
            if(command.equals("prev")){
                currentTime = prev(currentTime);
            }
            // next 명령이 떨어졌을때
            if(command.equals("next")){
                currentTime = next(currentTime,video_len);
            }
        }
        if(currentTime <= parseTime(op_end) && currentTime >= parseTime(op_start)){
                currentTime = parseTime(op_end);
            }
        answer = makeTimeIntToString(currentTime);
        return answer;
    }

    public int prev(int currentTime){
        if(currentTime - 10 < 0){
            return 0;
        }
        return currentTime - 10;
    }

    public int next(int currentTime, String video_len){
        if(currentTime + 10 > parseTime(video_len)){
            return parseTime(video_len);
        }
        return currentTime + 10;
    }

    public int parseTime(String mmss){
        String[] split = mmss.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

    }

    public String makeTimeIntToString(int time){
        int mm = time / 60;
        int ss = time % 60;
        return String.format("%02d:%02d",mm,ss);
    }

}
