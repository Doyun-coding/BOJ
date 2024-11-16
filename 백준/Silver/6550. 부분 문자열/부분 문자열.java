import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if(input == null || input == "" || input.trim().isEmpty()) break;

            st = new StringTokenizer(input);

            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            boolean check = false;
            for(int i = 0; i < t.length(); i++) {
                if(idx >= s.length()) {
                    check = true;
                    break;
                }

                if(t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
            }

            if(idx == s.length()) check = true;

            if(check) {
                bw.write("Yes\n");
            }
            else {
                bw.write("No\n");
            }

        }

        bw.flush();
        bw.close();

    }
}
