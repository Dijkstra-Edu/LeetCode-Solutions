class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        std::stack<int> stack;

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.empty() && stack.top() > 0 && stack.top() < -a) {
                    stack.pop();
                }

                if (stack.empty() || stack.top() < 0) {
                    stack.push(a);
                }

                if (!stack.empty() && stack.top() == -a) {
                    stack.pop();
                }
            }
        }

        std::vector<int> res(stack.size());
        int i = stack.size() - 1;

        while (!stack.empty()) {
            res[i--] = stack.top();
            stack.pop();
        }

        return res;        
    }
};