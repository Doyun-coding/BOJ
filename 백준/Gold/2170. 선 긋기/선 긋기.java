import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static ArrayList<Node> arrayList;
    static int ans = 0;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }
        int getEnd() {
            return this.end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList.add(new Node(s, e));
        }

        Collections.sort(arrayList);

        int s = arrayList.get(0).getStart();
        int e = arrayList.get(0).getEnd();

        for(int i = 1; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);

            if(node.getStart() > e) {
                ans += e-s;
                s = node.getStart();
                e = node.getEnd();
                continue;
            }

            if(node.getEnd() < e) {
                continue;
            }

            e = node.getEnd();
        }
        ans += e-s;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
