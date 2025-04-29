#include<stdio.h>
#include<stdlib.h>

int* applyOperations(int *nums, int numsSize, int* returnSize) {
    int j=0;
    int *arr = malloc(sizeof(int)*numsSize);
    for(int i=0;i<numsSize-1;i++){
        if(nums[i]==nums[i+1]){
            nums[i]*=2;
            nums[i+1]=0;
        }
    }
    for(int k=0;k<numsSize;k++){
        if (nums[k]!=0){
            int temp = nums[k];
            nums[k]=nums[j];
            nums[j]=temp;
            j++;
        }
    }
    for(int i=0;i<numsSize;i++){
        arr[i]=nums[i];
    }
    *returnSize=numsSize;
    return arr;
}

int main(){
    int nums[8] = {1,1,2,2,2,3,4,5};
    int size=0;
    int *ret_size=&size;
    int *arr = applyOperations(nums,8,ret_size);
    for(int i=0;i<size;i++){
        printf("%d ",arr[i]);
    }
}