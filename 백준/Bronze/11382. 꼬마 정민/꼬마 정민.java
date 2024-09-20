import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static long A, B, C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        long sum = A + B + C;
        
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
    
}