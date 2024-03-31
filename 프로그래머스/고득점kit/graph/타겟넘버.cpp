#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    vector<vector<int>>graph; 
    graph[0].push_back(numbers[0]);
    graph[0].push_back(-numbers[0]);
    int visited[100] = {0,};
    for(int i=0; i<numbers.size()-1; i++){
        graph[numbers[i]].push_back(numbers[i+1]);
        graph[numbers[i]].push_back(-numbers[i+1]);
    }
    
    return answer;
}