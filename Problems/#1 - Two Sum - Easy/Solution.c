/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define TABLE_SIZE 10007  

typedef struct {
    int key;
    int value;
    int is_filled;
} HashItem;

int hash(int key) {
    return (key % TABLE_SIZE + TABLE_SIZE) % TABLE_SIZE;
}

void insert(HashItem* table, int key, int value) {
    int idx = hash(key);
    while (table[idx].is_filled) {
        idx = (idx + 1) % TABLE_SIZE;
    }
    table[idx].key = key;
    table[idx].value = value;
    table[idx].is_filled = 1;
}

int find(HashItem* table, int key, int* found_value) {
    int idx = hash(key);
    int start = idx;
    while (table[idx].is_filled) {
        if (table[idx].key == key) {
            *found_value = table[idx].value;
            return 1;
        }
        idx = (idx + 1) % TABLE_SIZE;
        if (idx == start) break;
    }
    return 0;
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    HashItem* table = (HashItem*)calloc(TABLE_SIZE, sizeof(HashItem));
    int* result = (int*)malloc(sizeof(int) * 2);

    for (int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];
        int index;
        if (find(table, complement, &index)) {
            result[0] = index;
            result[1] = i;
            *returnSize = 2;
            free(table);
            return result;
        }
        insert(table, nums[i], i);
    }

    *returnSize = 0;
    free(table);
    return NULL;
}