import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 우선순위 1: 가장 쉬운 문제부터 (번호 오름차순 순서대로)
        // 우선순위 2 : 입력된 관계 대로
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<Integer>[] adj_arr = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj_arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            adj_arr[a].add(b);
            indegree[b]++;

        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            bw.write(Integer.toString(num) + " ");
            for (int i = 0; i < adj_arr[num].size(); i++) {
                int adj = adj_arr[num].get(i);
                --indegree[adj];
                if (indegree[adj] == 0) {
                    pq.add(adj);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}


