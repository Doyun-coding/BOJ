import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int[] arr;
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[6];
        
        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            int n =Integer.parseInt(st.nextToken());
            arr[i] = n;
            sum += n;
        }
        
        Arrays.sort(arr);
        
        int avg = sum / 5;
        bw.write(avg + "\n");
        bw.write(arr[3] + "\n");
        bw.flush();
        bw.close();
    }
    
}