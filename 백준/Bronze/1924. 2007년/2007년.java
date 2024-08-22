import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int M, D;
    static int[] month;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        month = new int[13];

        month[0] = 0;
        month[1] = 31;
        month[2] = 59;
        month[3] = 90;
        month[4] = 120;
        month[5] = 151;
        month[6] = 181;
        month[7] = 212;
        month[8] = 243;
        month[9] = 273;
        month[10] = 304;
        month[11] = 334;
        month[12] = 365;

        M -= 1;
        int m = month[M];
        m += D;
        m %= 7;

        if(m == 1) {
            bw.write("MON\n");
        }
        else if(m == 2) {
            bw.write("TUE\n");
        }
        else if(m == 3) {
            bw.write("WED\n");
        }
        else if(m == 4) {
            bw.write("THU\n");
        }
        else if(m == 5) {
            bw.write("FRI\n");
        }
        else if(m == 6) {
            bw.write("SAT\n");
        }
        else {
            bw.write("SUN\n");
        }
        bw.flush();
        bw.close();

    }
}
