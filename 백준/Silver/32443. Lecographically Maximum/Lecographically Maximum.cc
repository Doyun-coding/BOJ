// #include <vector>
// #include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int bit_count[31];


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;

    cin >> n;

    for(int i = 0;i < n; i++) {
        int a;
        cin >> a;
        for(int j = 0; j < 32; j++){
            if((1 << j) > a) break;
            if((1 << j) & a) bit_count[j]++;
        }
    }

    for(int i = 0; i < n; i++){
        int k = 0;
        for(int j = 0; j < 32; j++){
            if(bit_count[j]){
                k |= (1 << j);
                bit_count[j]--;

            }
        }
        cout << k << ' ';

    }

    return 0;
}