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
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());

            arrayList.add(n);
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        double sum = arrayList.get(0);

        for(int i = 1; i < arrayList.size(); i++) {
            double d = arrayList.get(i);

            sum += d / 2;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
