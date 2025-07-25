class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        ransom_count = Counter(ransomNote)
        magazine_count = Counter(magazine)

        for letter, count in ransom_count.items():
            if magazine_count[letter] < count:
                return False
    
        return True