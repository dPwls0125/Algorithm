package 프로그래머스.Level1.pccp;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        int top = findTop(wallpaper);
        int bottom = findBottom(wallpaper);
        int left = findLeft(wallpaper);
        int right = findRight(wallpaper);

        answer = new int[]{top, left, bottom, right};
        return answer;
    }

    public int findTop(String[] wallpaper){
        int top = 50;
        for(int i=0; i< wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#' && i < top) {
                    top = i;
                }
            }
        }
        return top;
    }

    public int findBottom(String[] wallpaper){
        int bottom = 0;
        for(int i=0; i< wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#' && i > bottom) {
                    bottom = i;
                }
            }
        }
        return bottom + 1 ;
    }

    public int findLeft(String[] wallpaper){
        int left = 50;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#' && j < left) {
                    left = j;
                }
            }
        }
        return left;
    }

    public int findRight(String[] wallpaper){
        int right = 0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#' && j > right) {
                    right = j;
                }
            }
        }
        return right + 1 ;
    }
}
