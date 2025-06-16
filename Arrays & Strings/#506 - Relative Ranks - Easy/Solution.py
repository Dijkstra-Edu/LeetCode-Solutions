class Solution(object):
    def findRelativeRanks(self, score):
        """
        :type score: List[int]
        :rtype: List[str]
        """
        indexed_scores = sorted([(s, i) for i, s in enumerate(score)], reverse=True)
        
        result = [''] * len(score)
        for rank, (s, i) in enumerate(indexed_scores):
            if rank == 0:
                result[i] = "Gold Medal"
            elif rank == 1:
                result[i] = "Silver Medal"
            elif rank == 2:
                result[i] = "Bronze Medal"
            else:
                result[i] = str(rank + 1)
        
        return result