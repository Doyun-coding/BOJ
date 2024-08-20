import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        N -= 543;
        bw.write(N+"\n");
        bw.flush();
        bw.close();
    }
    
}