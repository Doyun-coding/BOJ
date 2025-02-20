import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static ArrayList<String> arrayList;

    static void rectangle(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {

        if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
            System.out.println("d");
        }
        else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
            System.out.println("c");
        }
        else if (p1 == x2 || q1 == y2|| p2 == x1 || y1 == q2){
            System.out.println("b");
        }
        else {
            System.out.println("a");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arrayList = new ArrayList<>();

        for(int i = 1; i <= 4; i++) {
            st = new StringTokenizer(br.readLine());
            rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}
