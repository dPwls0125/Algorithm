#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <map>
using namespace std;

map<string,int>terms_map;
vector<int>comp;
vector<string> split(string str) {
    vector <string> words;
    string temp = "";
    for(int i=0; i<str.size(); i++){
        if(str[i] == ' ') {
            words.push_back(temp);
            temp = "";
            continue;
        }
        temp += str[i];
    }
    words.push_back(str.substr(str.size()-1,1));
    return words;
}
vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    vector<pair<string,string> >privacy;
    
    int y = stoi(today.substr(0, 4)); int m = stoi(today.substr(5, 2)); int d = stoi(today.substr(8, 2));
    int today_sum = y*12*28 + (m-1) * 28 + d; 
    // cout << "today_sum:" << today_sum <<"\n";
    //약관 mapping
    for(int i = 0; i < terms.size(); i++){
        string str_temp = terms[i];
        int month_size = str_temp.size() - 2;
        string a = str_temp.substr(0,1);
        int num = stoi(str_temp.substr(2,month_size));
        terms_map[a]=num;
    } 
    //공백 기준 분리 
    for(int i=0; i<privacies.size(); i++){
        string str = privacies[i];
        vector<string>privacy;
        privacy = split(str);
        // cout << "privacy size:"<<privacy.size()<<" ";

        for(int i=0; i<privacy.size(); i++) cout << privacy[i] <<"\n";
        int year = stoi(privacy[0].substr(0,4));
        int month = stoi(privacy[0].substr(5,2));
        int day = stoi(privacy[0].substr(8,2));
        // cout << i <<":" << year << " " << month << " " << day <<",";
        // cout << "privacy : "<< privacy[1] << "\n";
        int days = year * 12 * 28 + (month-1)*28 + day +(terms_map[privacy[1]]*28-1);
        comp.push_back(days);
    }
    for(int i=0; i < comp.size(); i++){
        if(today_sum > comp[i]) answer.push_back(i+1);
        // cout << i <<":"<<comp[i] << " " ;
    }
    // cout << "\n";
    return answer;
}

// int main(void) {
//     string today = "2022.05.19";
//     vector<string>p; vector<string>t;
//     p.push_back("2021.05.02 A"); p.push_back("2021.07.01 B"); 
//     p.push_back("2022.02.19 C"); p.push_back("2022.02.20 C");
//     t.push_back("A 6"); t.push_back("B 12"); t.push_back("C 3");
//     vector<int>s = solution(today,t,p);
//     for(int i=0; i<s.size(); i++){
//         cout << s[i]<< " ";
//     }
// }