#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <iterator>
#include <string>

using namespace std;
// 내 풀이
bool solution(vector<string> phone_book)
{
    bool answer = true;
    map<string, bool> map;
    for (auto iter : phone_book)
        map.insert(make_pair(iter, true));

    for (auto iter : phone_book)
    {
        string str_temp = "";
        for (int i = 0; i < iter.size() - 1; i++)
        {
            str_temp += iter[i];
            if (map.find(str_temp) == map.end())
                continue;
            else
            {
                answer = false;
                return answer;
            }
        }
    }
    return answer;
}
// 다른사람 풀이 응용
bool solution2(vector<string> phone_book)
{
    bool answer = true;
    sort(phone_book.begin(), phone_book.end()); // 문자열 정렬을 반드시 진행해야함.
    for (int i = 0; i < phone_book.size() - 1; i++)
    {
        if (phone_book[i] == phone_book[i + 1].substr(0, phone_book[i].size()))
            return false;
    }
    return answer;
}
int main(void)
{
    // string arr1[3][20] = {"123", "456", "789"};

    // vector<string> v;

    // for (int i = 0; i < sizeof(arr1); i++)
    // {
    //     string t = "";
    //     for (int j = 0; j < sizeof(arr1[i]); j++)
    //     {
    //         t += arr1[i][j];
    //     }
    //     v.push_back(t);
    // }
    // cout << solution(v);
}