import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static HashMap<String, Integer> hashMap;
    static PriorityQueue<Node> priorityQueue;

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
            return o.S.compareTo(this.S);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hashMap = new HashMap<>();
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String s = "";

            for(int j = 0; j < S.length(); j++) {
                if(S.charAt(j) == '.') {
                    for(int k = j+1; k < S.length(); k++) {
                        s += String.valueOf(S.charAt(k));
                    }
                    break;
                }
            }

            if(hashMap.containsKey(s)) {
                int n = hashMap.get(s);
                hashMap.replace(s, n+1);
            }
            else {
                hashMap.put(s, 1);
                priorityQueue.add(new Node(s));
            }

        }

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            String s = node.getS();
            int n = hashMap.get(s);
            bw.write(s + " " + n + "\n");
        }
        bw.flush();
        bw.close();

    }
}
