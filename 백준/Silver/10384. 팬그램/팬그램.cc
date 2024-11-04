#include <bits/stdc++.h>

using namespace std;

int N;
int arr[27];
vector<int> pangram;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    string S;
    getline(cin, S);

    N = stoi(S);

    for(int i = 1; i <= N; i++) {
        for(int i = 1; i <= 26; i++) {
            arr[i] = 0;
        }
        
        S = "";
        getline(cin, S);

        for(int j = 0; j < S.length(); j++) {
            int c = S[j] - 'A' + 1;
            
            if(c > 32) {
                c -= 32;
            }

            if(c >= 1 && c <= 26) { 
                arr[c] += 1;
            }
        }

        int min = 3;
        for(int i = 1; i <= 26; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        pangram.push_back(min);
    }
    
    for(int i = 0; i < pangram.size(); i++) {
        int n = pangram[i];

        if(n == 1) {
            cout << "Case " << i+1 << ": Pangram!\n";
        }
        else if(n == 2) {
            cout << "Case " << i+1 << ": Double pangram!!\n";
        }
        else if(n == 3) {
            cout << "Case " << i+1 << ": Triple pangram!!!\n";
        }
        else {
            cout << "Case " << i+1 << ": Not a pangram\n";
        }
    }
    
    return 0;
}