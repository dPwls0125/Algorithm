#include <stdlib.h>
#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;
unordered_map<string, int> m;
string solution(vector<string> participant, vector<string> completion)
{
    string answer = "";
    for (auto iter : participant)
    {
        if (m.find(iter) == m.end())
            m.insert(make_pair(iter, 1));
        else
            m[iter]++;
    }
    for (auto iter : completion)
        m[iter]--;
    for (auto i : m)
    {
        if (i.second > 0)
        {
            answer = i.first;
            break;
        }
    }
    return answer;
}
int main()
{
    cout << "hello";
}