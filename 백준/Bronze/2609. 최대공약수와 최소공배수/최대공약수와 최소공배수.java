import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int y = Y;
        while(true) {
            if(X % y == 0 && Y % y == 0) {
                break;
            }

            y--;
        }

        bw.write(y + "\n");

        int x = X / y;
        int z = Y / y;
        int s = x * z * y;
        bw.write(s + "\n");
        bw.flush();
        bw.close();
    }
}
