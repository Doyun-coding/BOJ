import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int X1, Y1, X2, Y2;
    static int R1, R2;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        ans = new ArrayList<>();

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            X1 = Integer.parseInt(st.nextToken());
            Y1 = Integer.parseInt(st.nextToken());
            R1 = Integer.parseInt(st.nextToken());
            X2 = Integer.parseInt(st.nextToken());
            Y2 = Integer.parseInt(st.nextToken());
            R2 = Integer.parseInt(st.nextToken());

            if(R1 < R2) {
                int temp = R2;
                R2 = R1;
                R1 = temp;
            }

            double dist = Math.sqrt((long) (Math.pow(X2-X1, 2) + Math.pow(Y2-Y1, 2)));

            if(X1 == X2 && Y1 == Y2 && R1 == R2) {
                ans.add(-1);
            }
            else if(dist == R1+R2) {
                ans.add(1);
            }
            else if(dist > R1+R2) {
                ans.add(0);
            }
            else if(dist < R1) {
                if(dist+R2 == R1) {
                    ans.add(1);
                }
                else if(dist+R2 < R1) {
                    ans.add(0);
                }
                else if(dist+R2 > R1) {
                    ans.add(2);
                }
            }
            else {
                ans.add(2);
            }

        }

        for(int n : ans) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}