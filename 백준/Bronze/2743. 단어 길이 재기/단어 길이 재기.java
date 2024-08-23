import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static String S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        
        int length = S.length();
        bw.write(length + "\n");
        bw.flush();
        bw.close();
    }
    
}