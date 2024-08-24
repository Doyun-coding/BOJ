import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Integer> priorityQueueA;
    static PriorityQueue<Integer> priorityQueueB;
    static int A = 0, B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        priorityQueueA = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueB = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(priorityQueueA.isEmpty()) {
                priorityQueueA.add(n);
                A++;
            }
            else if(priorityQueueB.isEmpty()) {
                if(!priorityQueueA.isEmpty()) {
                    int p = priorityQueueA.peek();
                    if(n >= p) {
                        priorityQueueB.add(n);
                        B++;
                    }
                    else {
                        p = priorityQueueA.remove();
                        priorityQueueB.add(p);
                        priorityQueueA.add(n);
                        B++;
                    }
                }

            }
            else {
                if(!priorityQueueB.isEmpty()) {
                    int peek = priorityQueueB.peek();
                    if(n >= peek) {
                        priorityQueueB.add(n);
                        B++;

                        if(Math.abs(B-A) > 1) {
                            int r = priorityQueueB.remove();
                            priorityQueueA.add(r);
                            A++;
                            B--;
                        }

                    }
                    else {
                        priorityQueueA.add(n);
                        A++;

                        if(Math.abs(A-B) > 1) {
                            int r = priorityQueueA.remove();
                            priorityQueueB.add(r);
                            A--;
                            B++;
                        }
                    }
                }
            }

            int mid = (A + B) / 2;

            if((A+B) % 2 == 1) {
                if(A > B) {
                    if(!priorityQueueA.isEmpty()) {
                        int p = priorityQueueA.peek();
                        sb.append(p + "\n");
                    }
                }
                else {
                    if(!priorityQueueB.isEmpty()) {
                        int p = priorityQueueB.peek();
                        sb.append(p + "\n");
                    }
                }
            }
            else {
                if(!priorityQueueA.isEmpty()) {
                    int p = priorityQueueA.peek();
                    sb.append(p + "\n");
                }
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}
