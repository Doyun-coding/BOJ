#include <bits/stdc++.h>

using namespace std;

int N, M;

class Node {
public:
    string s;
    int n;
    Node(string s, int n) {
        this->s = s;
        this->n = n;
    }
    string getS() {
        return this->s;
    }
    int getN() {
        return this->n;
    }

    bool operator<(const Node& other) const {
        if (this->s == other.s) {
            return this->n > other.n;
        }
        return this->s > other.s;
    }
};

string num[10];
priority_queue<Node> p;

int main() {
    cin >> N >> M;

    num[0] = "zero ";
    num[1] = "one ";
    num[2] = "two ";
    num[3] = "three ";
    num[4] = "four ";
    num[5] = "five ";
    num[6] = "six ";
    num[7] = "seven ";
    num[8] = "eight ";
    num[9] = "nine "; 

    for(int i = N; i <= M; i++) {
        string n = to_string(i);
        int length = n.size();

        string s = "";
        for(int j = 0; j < length; j++) {
            int l = n[j] - '0';

            s += num[l];
        }
        
        
        p.push(Node(s, i));
    }

    int c = 0;
    while(!p.empty()) {
        Node node = p.top();
        p.pop();

        int n = node.getN();

        cout << n << " ";
        c++;
        
        if(c >= 10) {
            cout << "\n";
            c = 0;
        }
    }
    cout << "\n";

    return 0;
}