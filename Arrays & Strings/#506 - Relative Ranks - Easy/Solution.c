/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct {
    int score;
    int index;
} ScoreEntry;

int compareScores(const void* a, const void* b) {
    return ((ScoreEntry*)b)->score - ((ScoreEntry*)a)->score;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    ScoreEntry* entries = (ScoreEntry*)malloc(sizeof(ScoreEntry) * scoreSize);
    char** result = (char**)malloc(sizeof(char*) * scoreSize);

    for (int i = 0; i < scoreSize; i++) {
        entries[i].score = score[i];
        entries[i].index = i;
    }

    qsort(entries, scoreSize, sizeof(ScoreEntry), compareScores);

    for (int i = 0; i < scoreSize; i++) {
        int idx = entries[i].index;
        result[idx] = (char*)malloc(20 * sizeof(char));  
        if (i == 0) {
            strcpy(result[idx], "Gold Medal");
        } else if (i == 1) {
            strcpy(result[idx], "Silver Medal");
        } else if (i == 2) {
            strcpy(result[idx], "Bronze Medal");
        } else {
            sprintf(result[idx], "%d", i + 1);
        }
    }

    free(entries);
    *returnSize = scoreSize;
    return result;
}