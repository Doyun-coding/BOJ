import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int cnt = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        int n = 1;
        int count = 1;
        while(true) {
            if(N <= n) break;
            
            n = n + (6 * count);
            count++;
            cnt++;
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    
    
}