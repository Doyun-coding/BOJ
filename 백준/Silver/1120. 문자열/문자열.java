import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String A, B;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        for(int i = 1; i <= B.length()-A.length()+1; i++) {
            int idx = 0;
            int cnt = 0;
            for(int j = i; j < i+A.length(); j++) {
                if(A.charAt(idx) == B.charAt(j-1)) {
                    cnt++;
                }
                idx++;
            }
            max = Math.max(max, cnt);
        }

        int ans = A.length() - max;

        bw.write(ans +"\n");
        bw.flush();
        bw.close();
    }
}
