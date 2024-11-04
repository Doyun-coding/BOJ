#include <bits/stdc++.h>

using namespace std;

int N;
vector<int> arr;
vector<int> cal;

ostringstream sb;

void backTracking(int depth, int end) {
    if(depth == end) {
        int sum = 0;

        for(int i = end-1; i >= 0; i--) {
            if(cal[i] == 1) {
                sum += depth;
                depth--;
            }
            else if(cal[i] == -1) {
                sum -= depth;
                depth--;
            }
            else if(cal[i] == 0) {
                string s = to_string(depth);
                while(true) {
                    depth--;
                    string S = to_string(depth);
                    S += s;
                    s = S;
                    i--;
                    if(cal[i] != 0) break;
                }

                if(cal[i] == 1) {
                    sum += stoi(s);
                }
                else if(cal[i] == -1) {
                    sum -= stoi(s);
                }
                depth--;
            }
        }

        if(sum == 0) {
            depth = 1;
            sb << "1";
            for(int i = 1; i < end; i++) {
                depth++;
                if(cal[i] == 1) {
                    sb << "+";
                }
                else if(cal[i] == -1) {
                    sb << "-";
                }
                else {
                    sb << " ";
                }

                sb << to_string(depth);
            }
            sb << "\n";
        }
        
        return;
    }

    cal[depth] = 0;
    backTracking(depth+1, end);

    cal[depth] = 1;
    backTracking(depth+1, end);

    cal[depth] = -1;
    backTracking(depth+1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    
    arr.resize(N+1);

    for(int i = 1; i <= N; i++) {
        int n;
        cin >> n;

        arr[i] = n;
    }

    for(int i = 1; i < arr.size(); i++) {
        int n = arr[i];
        cal.resize(n, 0);
        cal[0] = 1;

        backTracking(1, n);

        sb << "\n";
    }

    cout << sb.str() << "\n";

    return 0;
}