import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static ArrayList<Node> arrayList;

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
            if(this.S.length() == o.S.length()) {
                for(int i = 0; i < this.S.length(); i++) {
                    if(this.S.charAt(i) != o.S.charAt(i)) {
                        return this.S.charAt(i) - o.S.charAt(i);
                    }
                }

                return this.S.compareTo(o.S);
            }

            return this.S.length() - o.S.length();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String s = "";

            for(int j = 0; j < S.length(); j++) {
                int n = S.charAt(j) - '0';

                if(n >= 0 && n <= 9) {
                    s += String.valueOf(S.charAt(j));
                }
                else {
                    if(!s.equals("")) {
                        int index = 0;
                        for(index = 0; index < s.length()-1; index++) {
                            if(s.charAt(index) != '0') {
                                break;
                            }
                        }

                        s = s.substring(index);

                        arrayList.add(new Node(s));
                    }

                    s = "";
                }
            }
            if(!s.equals("")) {
                int index = 0;
                for(index = 0; index < s.length()-1; index++) {
                    if(s.charAt(index) != '0') {
                        break;
                    }
                }

                s = s.substring(index);

                arrayList.add(new Node(s));
            }
        }

        Collections.sort(arrayList);

        for(Node node : arrayList) {
            bw.write(node.getS() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
