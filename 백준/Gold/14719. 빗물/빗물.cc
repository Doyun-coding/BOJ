#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <stack>

using namespace std;

class Node {
public:
    int level;
    int index;
    Node(int level, int index) {
        this->level = level;
        this->index = index;
    }
    int getLevel() {
        return this->level;
    }
    int getIndex() {
        return this->index;
    }
};

int H, W;
vector<vector<int> > arr;
stack<Node> s;
int cnt = 0;

int main() {
    cin >> H >> W;

    arr.resize(H+1, vector<int>(W+1, 0));

    for(int i = 1; i <= W; i++) {
        int n;
        cin >> n;
        for(int j = 1; j <= n; j++) {
            arr[j][i] = 1;
        }

        if(s.empty()) {
            s.push(Node(n, i));
        }
        else {
            while(true) {
                if(!s.empty()) {
                    int t = s.top().getLevel();
                    if(t > n) {
                        s.push(Node(n, i));
                        break;
                    }
                    else if(t == n) {
                        int index = s.top().getIndex();
                        s.pop();

                        for(int k = index; k <= i; k++) {
                            for(int w = 1; w <= n; w++) {
                                if(arr[w][k] == 0) {
                                    arr[w][k] = 2;
                                }
                            }
                        }
                        s.push(Node(n, i));
                        break;
                    }
                    else {
                        int level = s.top().getLevel();
                        int index = s.top().getIndex();
                        s.pop();
                        if(s.empty()) {
                            for(int k = index; k <= i; k++) {
                                for(int w = 1; w <= level; w++) {
                                    if(arr[w][k] == 0) {
                                        arr[w][k] = 2;
                                    }
                                }
                            }

                            s.push(Node(n, i));
                            break;
                        }
                    }
                }
            }
        }
    }

    if(!s.empty()) {
        int preLevel = s.top().getLevel();
        int preIndex = s.top().getIndex();
        s.pop();

        while(true) {
            if(!s.empty()) {
                int level = s.top().getLevel();
                int index = s.top().getIndex();
                s.pop();

                for(int i = index; i <= preIndex; i++) {
                    for(int j = 1; j <= preLevel; j++) {
                        if(arr[j][i] == 0) arr[j][i] = 2;
                    }
                }

                preLevel = level;
                preIndex = index;
            }
            else break;
        }

    }
    

    for(int i = 1; i <= H; i++) {
        for(int j = 1; j <= W; j++) {
            if(arr[i][j] == 2) cnt++;
            //cout << arr[i][j] << " ";
        }
       //cout << "\n";
    }

    cout << cnt << "\n";

    return 0; 
}