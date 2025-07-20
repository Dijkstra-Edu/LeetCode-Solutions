
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize) {
    int l = 0; 
    int r = numbersSize-1;

    int* answer = (int*)malloc(2*sizeof(int)); //dynamic memory allocation
    *returnSize = 2; //we're returning two values
    
    while (l < r)
    {
        int sum = (numbers[l] + numbers[r]);
        if (sum == target)
        {
            answer[0] = l+1; //facilitating 1-based indexing as required by the problem.
            answer[1] = r+1;
            return answer;
        }
        else if (sum > target)
        {
            r--; //point to a smaller value to reduce the sum
        }
        else
        {
            l++; //point to a larger value to increase the sum
        }

    }
    return 0;
    
}
