//7983 내일할거야 G5
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <memory.h>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;
#define INF 2147483648
typedef long long ll;
int n ;
vector<pair<int,int>>v;
bool visited[1000005] ;
int main(void){
    cin >> n ;
    while(n--)
    {
        int d, t;
        cin >> d >> t;
        v.push_back({t,d});
    }
    sort(v.begin(),v.end());
    reverse(v.begin(),v.end());
    //일자를 뒤쪽부터 접근하면서 걸리는 기간을 계산하여 처리해줌.
    int date = v[0].first ;
    for(int i=0; i<v.size(); i++)
    {
        if(date <= v[i].first ){
            date = date - v[i].second ;
        }else{
            date = v[i].first - v[i].second ;
        }
    }
    cout << date << '\n';
}
 


