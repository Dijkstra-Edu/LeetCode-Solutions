/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool isInRow(const char* row, const char* word) {
    for (int i = 0; word[i]; i++) {
        if (!strchr(row, tolower(word[i]))) {
            return false;
        }
    }
    return true;
}

char** findWords(char** words, int wordsSize, int* returnSize) {
    const char* row1 = "qwertyuiop";
    const char* row2 = "asdfghjkl";
    const char* row3 = "zxcvbnm";

    char** result = (char**)malloc(wordsSize * sizeof(char*));
    int count = 0;

    for (int i = 0; i < wordsSize; i++) {
        char* word = words[i];
        if (isInRow(row1, word) || isInRow(row2, word) || isInRow(row3, word)) {
            result[count++] = word;
        }
    }

    *returnSize = count;
    return result;
}