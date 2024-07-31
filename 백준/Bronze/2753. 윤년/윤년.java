import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if(N % 4 == 0) {
            if(N % 400 == 0) {
                System.out.println("1");
            }
            else if(N % 100 == 0) {
                System.out.println("0");
            }
            else {
                System.out.println("1");
            }
        }
        else {
            System.out.println("0");
        }
    }
}
