package 프로그래머스.Level1;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) { 

        int[] answer = new int[2];
        char[][] parkArray = new char[park.length][park[0].length()];

        int y = 0;
        int x = 0;

        // 시작점 설정
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                if ("S".equals(park[i].substring(j,j+1))){
                     y = i; x = j;
                    System.out.println("Start Y,X: "+ y + " " + x);
                }
            }
        }

        // 경로 이동
        for(String route : routes){

            String[] r = route.split(" ");
            Pair move = getRoute(r[0]);

            int num = Integer.parseInt(r[1]);
            System.out.print("num: "+ num);


            for(int i=1; i<=num; i++){
                y += move.y;
                x += move.x;

                System.out.println("tempY, tempX: " + y +" "+x);
                // 1. 음수 좌표 확인
                if (y < 0 || x < 0) {
                    y -= move.y * i;
                    x -= move.x * i;
                    break;
                }

                // 2. 경계 초과 확인
                boolean outOfBoundary = (y >= park.length || x >= park[0].length());
                if (outOfBoundary){
                    y -= move.y * i;
                    x -= move.x * i;
                    break;
                }

                //  3. 장애물 확인
                boolean inBarrier = park[y].substring(x,x+1).equals("X");
                if(inBarrier) {
                    y -= move.y * i;
                    x -= move.x * i;
                    break;
                }
            }

            System.out.println(route + "y,x" + y + " " + x);

        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }


    public Pair getRoute(String r){
        if(r.equals("E")) {
            return Pair.E;
        }
        if(r.equals("W")){
            return Pair.W;
        }
        if(r.equals("N")){
            return Pair.N;
        }
        if(r.equals("S")){
            return Pair.S;
        }
        return null;
    }
}

class Pair {
    int y;
    int x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
    public final static Pair S = new Pair(1,0);
    public final static Pair N = new Pair(-1,0);
    public final static Pair W = new Pair(0,-1);
    public final static Pair E = new Pair(0,1);
}


