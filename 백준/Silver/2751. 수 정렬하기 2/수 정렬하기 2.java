import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Integer> priorityQueue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        priorityQueue = new PriorityQueue<>();
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            priorityQueue.add(n);
        }
        
        while(!priorityQueue.isEmpty()) {
            int p = priorityQueue.remove();
            bw.write(p + "\n");
        }
        bw.flush();
        bw.close();
    }
    
}