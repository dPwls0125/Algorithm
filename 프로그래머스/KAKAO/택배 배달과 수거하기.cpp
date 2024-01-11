#include <stdlib.h>
#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = -1;
    int del[100005]; int pick[100005];

    for(int i=deliveries.size()-1; i>=0; i--) 
        del[deliveries.size()-1-i] = deliveries[i];
    for(int i=pickups.size()-1; i>=0; i--) 
        pick[pickups.size()-1-i] = pickups[i];

    int index;
    while(true){
        
    }
    
    return answer;
}

