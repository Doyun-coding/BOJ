import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int N;
    static ArrayList<String> arrayList;

    static class Node implements Comparable<Node> {
        String S;
        Node(String S) {
            this.S = S;
        }
        String getS() {
            return this.S;
        }

        @Override
        public int compareTo(Node o) {
            return this.S.compareTo(o.S);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arrayList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                String S = st.nextToken();

                if(i == 0) {
                    arrayList.add(S);
                    continue;
                }

                String s = arrayList.get(0);

                if(S.compareTo(s) <= 0) {
                    arrayList.add(0, S);
                }
                else {

                    arrayList.add(S);
                }
            }

            for(String S : arrayList) {
                bw.write(S + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
