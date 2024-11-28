import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        hashMap = new HashMap<>();
        for (int i = 1; i < N; i++) {
            if (hashMap.containsKey(arr[i])) {
                bw.write((i+1) + " " + (hashMap.get(arr[i])+1));
                break;
            }
            else {
                hashMap.put(arr[i], i);
            }
        }

        bw.flush();
        bw.close();
    }
}
