import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedWriter bw;
    static int N;
    static long A = 0, B = 0;
    static long ATime = 0;
    static long BTime = 0;
    static long last = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            long mmss = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            
            if(A > B) {
                ATime += mmss - last;
            }
            else if(B > A) {
                BTime += mmss - last;
            }
            
            if(t == 1) {
                A += 1;
            }
            else if(t == 2) {
                B += 1;
            }
            
            last = mmss;            
        }
        
        long mmss = 48*60;
        if(A > B) {
            ATime += mmss - last;
        }
        else if(B > A) {
            BTime += mmss - last;
        }
        
        long AH = ATime / 60;
        long BH = BTime / 60;
        long AM = ATime % 60;
        long BM = BTime % 60;
        
        bw.write(String.format("%02d:%02d\n", AH, AM));
        bw.write(String.format("%02d:%02d\n", BH, BM));
        
        bw.flush();
        bw.close();
    }
    
}