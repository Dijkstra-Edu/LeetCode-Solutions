class Solution:
    def findLucky(self, arr):
        temp = 0
        lucky = -1
        count = 0

        for i in range(len(arr)):
            count = 0
            temp = arr[i]

            for j in range(len(arr)):
                if arr[j] == temp:
                    count += 1

            if count == len(arr):
                lucky = temp

        return lucky