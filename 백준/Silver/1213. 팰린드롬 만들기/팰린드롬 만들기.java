import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static ArrayList<Node> arrayList;
    static String[] arr;

    static class Node implements Comparable<Node> {
        String s;
        int cnt;
        Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
        String getS() {
            return this.s;
        }
        int getCnt() {
            return this.cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.s.compareTo(o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();

        arr = new String[S.length()+1];

        arrayList = new ArrayList<>();
        boolean check;
        for(int i = 0; i < S.length(); i++) {
            check = false;
            for(Node node : arrayList) {
                if(node.getS().equals(String.valueOf(S.charAt(i)))) {
                    node.cnt++;
                    check = true;
                    break;
                }
            }

            if(!check) {
                arrayList.add(new Node(String.valueOf(S.charAt(i)), 1));
            }
        }

        Collections.sort(arrayList);

        int idx = 1;
        check = true;
        for(Node node : arrayList) {
            int n = node.getCnt() / 2;
            for(int i = idx; i < idx+n; i++) {
                arr[i] = node.getS();
                arr[S.length()+1-i] = node.getS();
            }

            idx += n;

            if(node.getCnt() % 2 == 1) {
                arr[S.length()/2+1] = node.getS();
            }
        }

        for(int i = 1; i <= S.length(); i++) {
            if(arr[i] == null) {
                check = false;
                break;
            }
        }

        if(!check) {
            bw.write("I'm Sorry Hansoo\n");
        }
        else {
            for(int i = 1; i <= S.length(); i++) {
                bw.write(arr[i] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
