class Solution:
    def reverseWords(self, s: str) -> str:
        left = 0
        right = len(s) - 1

        temp = ""
        ans = ""

        # Skip leading spaces
        while left <= right and s[left] == ' ':
            left += 1
        # Skip trailing spaces
        while right >= left and s[right] == ' ':
            right -= 1

        # Iterate the string and collect words
        while left <= right:
            ch = s[left]
            if ch != ' ':
                temp += ch
            else:
                if temp != '':
                    if ans != '':
                        ans = temp + " " + ans
                    else:
                        ans = temp
                    temp = ""
            left += 1

        # Add the last word if any
        if temp != "":
            if ans != "":
                ans = temp + " " + ans
            else:
                ans = temp

        return ans
