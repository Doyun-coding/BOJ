import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int x, y;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        
        if(x > 0 && y > 0) {
            bw.write("1\n");
        }
        else if(x > 0 && y < 0) {
            bw.write("4\n");
        }
        else if(x < 0 && y > 0) {
            bw.write("2\n");
        }
        else if(x < 0 && y < 0) {
            bw.write("3\n");
        }
        bw.flush();
        bw.close();
    }
}