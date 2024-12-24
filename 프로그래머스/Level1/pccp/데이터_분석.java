package 프로그래머스.Level1.pccp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 데이터_분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        answer = Arrays.stream(data).filter(o1 -> o1[getIndex(ext)] < val_ext).sorted((o1,o2)->o1[getIndex(sort_by)] - o2[getIndex(sort_by)])
                .toArray(int[][]::new);
        return answer;
    }

    public int getIndex(String base){
        String[] index = {"code","date","maximum","remain"};
        List<String> indexList = Arrays.asList(index);
        return indexList.indexOf(base);
    }
}
