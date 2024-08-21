import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static Stack<String> stack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            stack = new Stack<>();
            //st = new StringTokenizer(br.readLine());
            String S = br.readLine();

            if(S.charAt(0) == '.') break;

            boolean check = true;
            st = new StringTokenizer(S);
            S = st.nextToken();

            while(true) {

                for(int i = 0; i < S.length(); i++) {
                    if(S.charAt(i) == '(') {
                        stack.add("(");
                    }
                    else if(S.charAt(i) == '[') {
                        stack.add("[");
                    }
                    else if(S.charAt(i) == ')') {
                        if(!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        }
                        else {
                            check = false;
                            break;
                        }
                    }
                    else if(S.charAt(i) == ']') {
                        if(!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        }
                        else {
                            check = false;
                            break;
                        }
                    }


                }

                if(S.charAt(S.length()-1) == '.') {
                    if(!stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    break;
                }

                S = st.nextToken();
            }

            if(check) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }

}