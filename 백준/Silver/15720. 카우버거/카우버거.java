import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int A, B, C;
    static int setMenu = 0;
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        setMenu = Math.min(A, Math.min(B, C));

        int sum1 = 0;
        int sum2 = 0;

        arrayLists = new ArrayList[4];
        for(int i = 0; i <= 3; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= A; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum1 += n;

            arrayLists[1].add(n);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= B; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum1 += n;

            arrayLists[2].add(n);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= C; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum1 += n;

            arrayLists[3].add(n);
        }

        Collections.sort(arrayLists[1], Collections.reverseOrder());
        Collections.sort(arrayLists[2], Collections.reverseOrder());
        Collections.sort(arrayLists[3], Collections.reverseOrder());

        for(int i = 0; i < setMenu; i++) {
            for(int j = 1; j <= 3; j++) {
                double n = arrayLists[j].get(i);

                n = n * 0.9;

                sum2 += n;
            }
        }

        for(int i = 1; i <= 3; i++) {
            for(int j = setMenu; j < arrayLists[i].size(); j++) {
                sum2 += arrayLists[i].get(j);
            }
        }

        bw.write(sum1 + "\n");
        bw.write(sum2 + "\n");

        bw.flush();
        bw.close();
    }
}
