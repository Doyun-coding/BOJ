import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int big = 1;
            
            for(int j = A; j >= 1; j--) {
                if(A % j == 0) {
                    if(B % j == 0) {
                        big = j;
                        break;
                    }
                }
            }
            
            int n = (A / big) * B;
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
    
}