import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int A, B, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        int n = A * B * C;
        arr = new int[10];
        String s = String.valueOf(n);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0') {
                arr[0] += 1;
            }
            else if(c == '1') {
                arr[1] += 1;
            }
            else if(c == '2') {
                arr[2] += 1;
            }
            else if(c == '3') {
                arr[3] += 1;
            }
            else if(c == '4') {
                arr[4] += 1;
            }
            else if(c == '5') {
                arr[5] += 1;
            }
            else if(c == '6') {
                arr[6] += 1;
            }
            else if(c == '7') {
                arr[7] += 1;
            }
            else if(c == '8') {
                arr[8] += 1;
            }
            else if(c == '9') {
                arr[9] += 1;
            }
        }

        for(int i = 0; i <= 9; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
