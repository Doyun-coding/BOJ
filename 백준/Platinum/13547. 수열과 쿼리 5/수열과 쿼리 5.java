import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static int sqrtN;
    static Query[] queries;
    static HashMap<Integer, Integer> hashMap;
    static int cnt = 0;
    static int[] ans;

    static void push(int num) {
        if(!hashMap.containsKey(num)) {
            hashMap.put(num, 1);
            cnt++;
        }
        else {
            int v = hashMap.get(num);
            hashMap.replace(num, v+1);
        }
    }

    static void pop(int num) {
        if(hashMap.get(num) <= 1) {
            hashMap.remove(num);
            cnt--;
        }
        else {
            int v = hashMap.get(num);
            hashMap.replace(num, v-1);
        }
    }

    static class Query implements Comparable<Query> {
        int left;
        int right;
        int index;
        int compare;

        Query(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
            this.compare = left / sqrtN;
        }

        @Override
        public int compareTo(Query o) {
            if(this.compare == o.compare) {
                return this.right - o.right;
            }

            return this.compare - o.compare;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sqrtN = (int)Math.sqrt(N);

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        queries = new Query[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            queries[i] = new Query(l, r, i);
        }
        Arrays.sort(queries);

        hashMap = new HashMap<>();
        int l = queries[0].left;
        int r = queries[0].right;

        for(int i = l; i <= r; i++) {
            push(arr[i]);
        }

        ans = new int[M];
        ans[queries[0].index] = cnt;

        for(int i = 1; i < M; i++) {
            Query query = queries[i];

            for(int j = query.left; j < l; j++) {
                push(arr[j]);
            }
            for(int j = r+1; j <= query.right; j++) {
                push(arr[j]);
            }
            for(int j = l; j < query.left; j++) {
                pop(arr[j]);
            }
            for(int j = query.right+1; j <= r; j++) {
                pop(arr[j]);
            }

            l = query.left;
            r = query.right;
            ans[query.index] = cnt;
        }

        for(int i = 0; i < M; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
