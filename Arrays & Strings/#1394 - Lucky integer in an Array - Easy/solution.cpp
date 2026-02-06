class Solution {
public:
    int findLucky(vector<int>& arr) {
        int temp = 0, lucky = -1, count = 0;

        for (int i = 0; i < arr.size(); i++) {
            count = 0;
            temp = arr[i];

            for (int j = 0; j < arr.size(); j++) {
                if (arr[j] == temp)
                    count++;
            }

            if (count == arr.size())
                lucky = temp;
        }

        return lucky;
    }
};
