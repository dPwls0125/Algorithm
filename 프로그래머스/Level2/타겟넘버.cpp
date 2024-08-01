#include <string>
#include <vector>
#include <iostream>

using namespace std;

int result = 0;
int global_target;

void dfs(int idx, long size, int calculation, vector<int> numbers){
    
    if((idx > size-1) ){
        if(calculation == global_target) ++result;
        return;
    }
    
    ++idx;

    dfs(idx,size,calculation-numbers[idx-1],numbers);
    dfs(idx,size,calculation+numbers[idx-1],numbers);
    
}

int solution(vector<int>numbers, int target) {
    global_target = target;
    dfs(0,numbers.size(),0,numbers);
    return result;
}

int main(void){

   vector<int>numbers = {4,1,2,1};
   int target = 4;
   cout << solution(numbers,target);
}
