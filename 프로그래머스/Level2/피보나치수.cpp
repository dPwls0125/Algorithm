#include <string>
#include <vector>
#include <iostream>
using namespace std;

int fibo_n[100001] =  {0,1,} ; 
void fibo(int num) {
    if(num == 1)
        return;
    else{
        fibo(num-1);
        fibo_n[num] = (fibo_n[num-1] + fibo_n[num-2]) % 1234567;
        // printf("fibo[%d] : %d \n",num, fibo_n[num]) ; 
    }
    return;
}

int solution(int n) {
    int answer = 0;
    fibo(n);
    answer = fibo_n[n] % 1234567;
    return answer; 
}

int main(void) {
    int n;
    cin >> n;
    cout << solution(n);
}