import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arrayList.add(n);
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        for(int i = 0; i < arrayList.size(); i++) {
            bw.write(arrayList.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
