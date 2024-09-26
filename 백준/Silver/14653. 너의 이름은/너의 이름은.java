import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K, Q;
    static Node[] nodes;
    static HashSet<String> hashSet;
    static int cnt = 0;
    static int num = 0;

    static class Node {
        int read;
        char name;
        Node(int read, char name) {
            this.read = read;
            this.name = name;
        }

        int getRead() {
            return this.read;
        }
        char getName() {
            return this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nodes = new Node[K+1];
        hashSet = new HashSet<>();
        cnt = N-1;

        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int read = Integer.parseInt(st.nextToken());
            char name = st.nextToken().charAt(0);

            nodes[i] = new Node(read, name);
        }
        hashSet.add(String.valueOf('A'));

        for(int i = K; i >= Q; i--) {
            Node node = nodes[i];
            int read = node.getRead();
            char name = node.getName();
            num = read;

            if(!hashSet.contains(String.valueOf(name))) {
                hashSet.add(String.valueOf(name));
                cnt--;
            }

            if(read == 0) {
                cnt = 0;
                break;
            }
        }

        for(int i = Q; i >= 1; i--) {
            Node node = nodes[i];
            int read = node.getRead();
            char name = node.getName();

            if(read != num) break;

            if(!hashSet.contains(String.valueOf(name))) {
                hashSet.add(String.valueOf(name));
                cnt--;
            }
            if(read == 0) {
                cnt = 0;
                break;
            }
        }

        if(cnt == 0) {
            bw.write("-1\n");
        }
        else {
            for(int i = 65; i < 65+N; i++) {
                char c = (char) i;
                if(!hashSet.contains(String.valueOf(c))) {
                    bw.write(String.valueOf(c) + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
