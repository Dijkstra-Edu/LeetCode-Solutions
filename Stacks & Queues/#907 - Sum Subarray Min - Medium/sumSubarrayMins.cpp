class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        stack<vector<int>> stack;
        vector<int> res(arr.size(), 0);

        for (int i = 0; i < arr.size(); i++) {
            // use ">=" to deal with duplicate elements
            while (!stack.empty() && stack.top()[0] >= arr[i]) {
                stack.pop();
            }

            int j = stack.empty() ? -1 : stack.top()[1];
            res[i] = stack.empty() ? arr[i] * (i + 1) : res[j] + arr[i] * (i - j);
            stack.push({arr[i], i});
        }

        const long MOD = static_cast<long>(1e9 + 7);
        long ans = 0;

        for (int i = 0; i < arr.size(); i++) {
            ans = (ans + static_cast<long>(res[i])) % MOD;
        }
        return static_cast<int>(ans);        
    }
};