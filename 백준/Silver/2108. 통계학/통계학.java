import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static long sum = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static HashMap<Integer, Integer> hashMap;
    static int m = 1;
    static ArrayList<Node> arrayList;

    static class Node implements Comparable<Node> {
        int n;
        int cnt;

        Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        int getN() {
            return this.n;
        }
        int getCnt() {
            return this.cnt;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt == o.cnt) {

                return this.n - o.n;
            }

            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        hashMap = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], 1);
            }
            else {
                int v = hashMap.get(arr[i]);
                hashMap.replace(arr[i], v+1);
                m = Math.max(m, v+1);
            }
        }

        int na = (int) Math.round((double)sum / N);

        bw.write(na + "\n");

        Arrays.sort(arr);

        bw.write(arr[N/2] + "\n");

        int c = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int n = arr[i];

            int v = hashMap.get(n);
            if(v == m && ans != n) {
                c++;
                ans = n;
                if(c == 2) {
                    break;
                }
            }
        }

        bw.write(ans + "\n");

        bw.write((max-min) + "\n");

        bw.flush();
        bw.close();
    }
}
