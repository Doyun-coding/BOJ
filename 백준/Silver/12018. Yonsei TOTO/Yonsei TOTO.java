import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int P, L;
    static ArrayList<Integer> arrayList;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new ArrayList<>();

        for(int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arrayList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= P; i++) {
                int n = Integer.parseInt(st.nextToken());
                arrayList.add(n);
            }

            Collections.sort(arrayList, Collections.reverseOrder());

            if(arrayList.size() < L) {
                ans.add(1);
            }
            else {
                int n = arrayList.get(L - 1);
                ans.add(n);
            }
        }

        Collections.sort(ans);

        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);

            if(sum > M) break;

            cnt++;
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
