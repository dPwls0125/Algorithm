package 프로그래머스.고득점kit.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트엘범LV3 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 우선순위1. 속한 노래가 많이 재생된 장르가 먼저
        // 우선순위2. 장르 내에서 많이 재생된 노래를 먼저
        // 우선순위3. 고유 번호가 낮은 노래를 먼저

        // sudo
        // 1. 장르별 총 재생 횟수를 HashMap에 저장한다.
        int N = genres.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++){
            int temp = map.getOrDefault(genres[i],0);
            temp += plays[i];
            map.put(genres[i],temp);
        }

        // 2. 내림 차순으로 정렬된 장르를 반복문을 돌면서, 노래를 위의 우선순위 2,3에 맞게 투입/정렬한다.
        // 어떻게 장르를 내림차순으로 정렬할 것인지?
        // 우선순위 큐를 두개 사용한다. 장르를 정렬하는 우선순위 큐,음악을 정렬하는 우선순위 큐
        // 상위 두개 를 저장하는데, 하나인 경우도 있을 수 있다. 이 경우에는 하나만 저장한다.
        class Genre implements Comparable<Genre>{
            String name;
            int value;

            @Override
            public int compareTo(Genre o) {
                return Integer.compare(o.value,this.value);
            }

            public Genre(String name, int value){
                this.name = name;
                this.value = value;
            }

        }

        PriorityQueue<Genre> genreQueue = new PriorityQueue<>();
        for (Map.Entry<String,Integer> e : map.entrySet()){
            genreQueue.add(new Genre(e.getKey(),e.getValue()));
        }

        class Music implements Comparable<Music>{
            int index;
            int value;
            public Music(int index, int value) {
                this.index = index;
                this.value = value;
            }

            @Override
            public int compareTo(Music o) {
                int c = Integer.compare(o.value,this.value); // 내림차순
                if(c == 0) return Integer.compare(this.index,o.index); // 오름차순
                return c;
            }
        }


        // 우선순위가 높은 장르 순서대로
        while(!genreQueue.isEmpty()){
            PriorityQueue<Music> musicQueue = new PriorityQueue<>();
            Genre genre = genreQueue.poll();
            // 장르별 음악 music 우선순위 큐에 투입
            for( int i=0; i < N; i++){
                if (genres[i].equals(genre.name)){
                    musicQueue.add(new Music(i,plays[i]));
                }
            }
            // 우선순위가 높은 음악 먼저 answer에 투입
            answer.add(musicQueue.poll().index);
            if (musicQueue.size() == 0){
                continue;
            }
            answer.add(musicQueue.poll().index);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
