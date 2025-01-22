import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static Set<Integer> set;

    static boolean isPrime(int num) {
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void BackTracking(int n, int depth) {
        if(depth == N-1) {
            if(isPrime(n)) {
                set.add(n);
            }
            return;
        }

        if(isPrime(n)) {
            for (int i = 1; i <= 9; i++) {
                BackTracking(n * 10 + i, depth+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();

        for(int i = 2; i <= 9; i++) {
            BackTracking(i, 0);
        }

        for(int n : set) {
            System.out.println(n);
        }

    }
}