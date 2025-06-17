/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define MAX_NUM 10001

int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int* result = (int*)malloc(sizeof(int) * nums1Size);
    int next_greater[MAX_NUM];  
    int stack[MAX_NUM];
    int top = -1;

    for (int i = 0; i < MAX_NUM; i++) {
        next_greater[i] = -1;
    }

    for (int i = 0; i < nums2Size; i++) {
        int current = nums2[i];
        while (top >= 0 && current > stack[top]) {
            int prev = stack[top--];
            next_greater[prev] = current;
        }
        stack[++top] = current;
    }

    for (int i = 0; i < nums1Size; i++) {
        result[i] = next_greater[nums1[i]];
    }

    *returnSize = nums1Size;
    return result;
}