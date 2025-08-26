// Sorting approach
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.rbegin(), citations.rend());
        for (int i = 0; i < citations.size(); i++) {
            if (citations[i] < i + 1)
                return i;
        }
        return citations.size();
    }
};

// Counting approach
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> count(n + 1, 0);
        for (int c : citations) {
            count[min(c, n)]++;
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }
        return 0;
    }
};
