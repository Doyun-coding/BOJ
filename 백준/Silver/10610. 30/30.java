import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static BufferedWriter bw;
    static String S;
    static boolean check = false;
    static long sum = 0;
    static ArrayList<Character> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        arrayList = new ArrayList<>();

        int index = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0' && !check) {
                check = true;
            }

            arrayList.add(S.charAt(i));
            sum += Integer.parseInt(String.valueOf(S.charAt(i)));
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        if(check) {
            if(sum % 3 == 0) {
                for(char c : arrayList) {
                    bw.write(c + "");
                }
                bw.write("\n");
            }
            else {
                bw.write("-1\n");
            }
        }
        else {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
    }

}