import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int height = Integer.parseInt(br.readLine());


        // Level에 따라 노드를 저장할 수 있도록 함.
        for(int i=0; i<height; i++){
            map.put(i,new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[st.countTokens()];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; int end = numbers.length-1;
        recursive(start,end,0,height-1,numbers);

        for (int i=0; i<height; i++){
            ArrayList<Integer> list = map.get(i);
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }



    public static void recursive(int start, int end, int level, int height, int[] numbers) {

        if (level > height){
//            System.out.println("level : " + level + "height : "+ height);
            return;
        }

        int mid = (start + end) / 2   ;
        map.get(level).add(numbers[mid]);
//        System.out.println(level + ":" + numbers[mid]);

        recursive(start,mid-1,level+1,height,numbers);
        recursive(mid+1,end,level+1,height,numbers);
    }
}

