#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> validCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        unordered_set<string> validCategories = {"electronics", "grocery", "pharmacy", "restaurant"};
        unordered_map<string, int> categoryOrder = {
            {"electronics", 0},
            {"grocery", 1},
            {"pharmacy", 2},
            {"restaurant", 3}
        };

        vector<pair<string, string>> validList;
        for (int i = 0; i < code.size(); i++) {
            bool validCode = !code[i].empty() && all_of(code[i].begin(), code[i].end(),
                                [](char ch) { return isalnum(ch) || ch == '_'; });

            if (isActive[i] && validCategories.count(businessLine[i]) && validCode) {
                validList.push_back({businessLine[i], code[i]});
            }
        }

        sort(validList.begin(), validList.end(), [&](auto &a, auto &b) {
            if (categoryOrder[a.first] != categoryOrder[b.first])
                return categoryOrder[a.first] < categoryOrder[b.first];
            return a.second < b.second;
        });

        vector<string> result;
        for (auto &p : validList) result.push_back(p.second);
        return result;
    }
};
