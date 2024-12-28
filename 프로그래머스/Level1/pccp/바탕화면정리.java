package 프로그래머스.Level1.pccp;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {

        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        int[] answer = {};

        for(int i=0; i<wallpaper.length;i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    top = Math.min(top,i);
                    bottom = Math.max(bottom,i+1);
                    left = Math.min(left,j);
                    right = Math.max(right,j+1);
                }
            }
        }
        answer = new int[]{top, left, bottom, right};
        return answer;
    }
}
