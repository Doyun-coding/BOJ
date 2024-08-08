import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int check = 0;
    static int pre;
    static boolean c = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        pre = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= 7; i++) {
            if(check == 0) {
                int n = Integer.parseInt(st.nextToken());
                if(pre > n) {
                    check = -1;
                }
                else {
                    check = 1;
                }
                pre = n;
            }
            else if(check == 1) {
                int n = Integer.parseInt(st.nextToken());
                if(n < pre) {
                    c = false;
                    break;
                }
                pre = n;
            }
            else if(check == -1) {
                int n = Integer.parseInt(st.nextToken());
                if(n > pre) {
                    c = false;
                    break;
                }
                pre = n;
            }
        }
        if(!c) {
            bw.write("mixed\n");
        }
        else {
            if(check == 1) {
                bw.write("ascending\n");
            }
            else {
                bw.write("descending\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
