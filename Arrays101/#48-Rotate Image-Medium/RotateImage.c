#include<stdio.h>

void rotate( int matrixSize, int* matrixColSize, int matrix[][*matrixColSize]) {
    for(int i=0;i<matrixSize;i++){
        for(int j=i;j<(*matrixColSize);j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
    
    for(int i=0;i<matrixSize;i++){
        for(int j=0;j<(*matrixColSize)/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][*matrixColSize-1-j];
            matrix[i][*matrixColSize-1-j]=temp;
        }
    }
    //AFTER ROTATE
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            printf("%d ",matrix[i][j]);
        }
        printf("\n");
    }
}
int main(){
    int arr[3][3]={1,2,3,4,5,6,7,8,9};
    int matrixSize=3, matrixColSize =3;
    //BEFORE ROTATE
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }
    rotate(matrixSize,&matrixColSize,arr);
    
}