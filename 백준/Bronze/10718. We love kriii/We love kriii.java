import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb.append("강한친구 대한육군\n");
        sb.append("강한친구 대한육군\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}