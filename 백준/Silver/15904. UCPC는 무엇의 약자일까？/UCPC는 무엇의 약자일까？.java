import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static int cnt = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = br.readLine();

        for(int i = 0; i < S.length(); i++) {
            if(cnt == 0) {
                if(S.charAt(i) == 'U') {
                    cnt++;
                }
            }
            else if(cnt == 1) {
                if(S.charAt(i) == 'C') {
                    cnt++;
                }
            }
            else if(cnt == 2) {
                if(S.charAt(i) == 'P') {
                    cnt++;
                }
            }
            else if(cnt == 3) {
                if(S.charAt(i) == 'C') {
                    cnt++;
                    check = true;
                    break;
                }
            }
            else if(cnt == 4) {
                break;
            }
        }

        if(check) {
            bw.write("I love UCPC\n");
        }
        else {
            bw.write("I hate UCPC\n");
        }
        bw.flush();
        bw.close();
    }
}
