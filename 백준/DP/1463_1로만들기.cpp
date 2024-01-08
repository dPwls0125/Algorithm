#include <stdlib.h>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
#include <cmath>
// #include <iostream>
using namespace std;
int dp[1000005]; 
int n;
int solution(int num){
    dp[1] = 0; 
    for (int i=2; i<=num; i++){
    dp[i] = dp[i-1] + 1 ;
    if(i%2 == 0 ) dp[i] = min(dp[i/2]+1,dp[i]) ;
    if(i%3 == 0) dp[i] = min(dp[i/3]+1,dp[i]); // 최소공배수가 6이 되는 경우 반드시 2로 나누었을떄와 3으로 나누었을 경우의 min값을 비교
    }
    return dp[num];
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    cout << solution(n);
    return 0;
}