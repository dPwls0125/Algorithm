#include <string>
#include <vector>
#include <iostream>
#include <utility>
#include <map>


using namespace std;

pair<string,string> parser (string gift){
    
    string first;
    string second;
    bool flag = false;

    for(int i=0; i<gift.length(); i++){
        
        if(gift[i] == ' '){
            flag = true;
            continue;
        }

        if(flag == false){
            first += gift[i];
        }else{
            second += gift[i];
        }
    }

    return make_pair(first,second);
}

int solution(vector<string> friends, vector<string> gifts) {
    
    int answer = 0;
    map<string,int>idx;
    int present[55][55];
    
    for(int i=0; i<friends.size(); i++) {
        for(int j=0; j < friends.size(); j++){
            present[i][j] = 0;
        }
    }

    for(int i=0; i < friends.size(); i++){
        idx.insert({friends[i],i});
    }

    for(int i=0; i< gifts.size(); i++){
        
        string giver = parser(gifts[i]).first;
        string getter = parser(gifts[i]).second;

        int giver_idx = idx.find(giver) ->second ;
        int getter_idx = idx.find(getter) -> second;

        ++present[giver_idx][getter_idx];
        
    }

    vector<int> gisu(friends.size(),0);
    vector<int> result(friends.size(),0);

    for(int i=0; i<friends.size(); i++){
        
        int give = 0; int get = 0;
        
        for(int j=0; j<friends.size(); j++){
            give += present[i][j];
            get += present[j][i];
        }

        gisu[i] = give - get;

    }

    
    for(int i=0; i<friends.size(); i++){
        for(int j=0; j<friends.size(); j++){
            if(present[i][j] == present[j][i]){
                if(gisu[i] > gisu[j])  ++result[i];
            }else if(present[i][j] > present[j][i]){
                ++result[i];
            }
        }
    }


    for(int i=0; i<result.size(); i++){
        if(result[i] > answer)
            answer = result[i];
    }

    return answer;
}


//
//int main(void){
//
//    vector<string> f = {"muzi", "ryan", "frodo", "neo"};
//    vector<string> g = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//    cout << solution(f,g);
//}
