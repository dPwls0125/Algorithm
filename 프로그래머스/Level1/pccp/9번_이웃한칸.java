class Solution {
    public int solution(String[][] board, int h, int w) {

        int count = 0 ;
        int[] dw = {0,1,0,-1};
        int[] dh = {-1,0,1,0};
        String color = board[h][w];

        for(int i=0; i<4; i++){
            int x = w + dw[i];
            int y = h + dh[i];
            if((x >= 0 && x < board.length) && (y >= 0 && y < board.length)) {
              if(color.equals(board[y][x])) ++count;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

