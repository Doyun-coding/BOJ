import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int one = 0;
    static int cnt = 0;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int l = Integer.parseInt(st.nextToken());

            arrayList.add(l);
        }

        Collections.sort(arrayList);

        int need = N-2;
        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) <= need - one) {
                need -= arrayList.get(i);
                one++;
            }
            else break;
        }

        if(N == 2) {
            cnt = 1;
        }
        else {
            cnt = N - 1 - one;
        }


        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
