import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        arr = new int[100];

        for(int i = 0; i < S.length(); i++) {
            int n = S.charAt(i);
            if(n >= 97) {
                n -= 32;
            }

            arr[n] += 1;
        }

        int max = 0;
        int maxString = 0;
        for(int i = 65; i < 97; i++) {
            if(arr[i] == max) {
                maxString = -1;
            }
            else if(arr[i] > max) {
                maxString = i;
                max = arr[i];
            }
        }

        if(maxString == -1) {
            bw.write("?\n");
        }
        else {
            char c = (char) maxString;
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
    }
}
