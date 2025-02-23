import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write("#  # #### #### #  #\n");
        bw.write("#### #  # #  # # #\n");
        bw.write("#### #  # #  # # #\n");
        bw.write("#  # #### #### #  #\n");
        
        bw.flush();
        bw.close();
    }
    
}