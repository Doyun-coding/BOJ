import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static boolean[] isPrime;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        isPrime = new boolean[1001];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2; i < Math.sqrt(1000); i++) {
            if(!isPrime[i]) {
                for(int j = i*i; j <= 1000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(!isPrime[n]) cnt++;
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    
    
}