#include<stdio.h>
#include<stdlib.h>

//SOLUTION FUCTION
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i=0;
    for(i=digitsSize-1;i>=0;i--){
        if(digits[i]<9){
            digits[i]+=1;
            break;
        }
        digits[i]=0;
    }
    if(i==-1){
        int *ret_arr=malloc(sizeof(int)*(digitsSize+1));
        *returnSize = digitsSize+1;
        ret_arr[0]=1;
        for(int i=1;i<*returnSize;i++){
            ret_arr[i]=digits[i-1];
        }
        return ret_arr;
    }
    else{
        int *ret_arr = malloc(sizeof(int)*digitsSize);
        *returnSize=digitsSize;
        for(int i=0;i<digitsSize;i++){
            ret_arr[i]=digits[i];
        }
        return ret_arr;
    }

}

int main(){
    int arr[]={9,9,9};
    int size=sizeof(arr)/sizeof(arr[0]);
    int returnSize;
    int *ret_arr=plusOne(arr,size,&returnSize); 
    printf("[");
    for(int i=0;i<returnSize-1;i++){
        printf("%d,",ret_arr[i]);
    }
    printf("%d]",ret_arr[returnSize-1]);
    free(ret_arr);
}
