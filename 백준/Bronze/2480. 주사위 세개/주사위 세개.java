import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int A, B, C;
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        if(A == B && B == C) {
            sum = 10000 + (A * 1000);
        }
        else {
            if((A == B) || (B == C) || (A == C)) {
                if(A == B) {
                    sum = 1000 + A*100;
                }
                else if(B == C) {
                    sum = 1000 + B*100;
                }
                else {
                    sum = 1000 + C*100;
                   
                }
            }
            else {
                int max = Math.max(A, Math.max(B, C));
                sum = max * 100;
            }
            
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
    
}