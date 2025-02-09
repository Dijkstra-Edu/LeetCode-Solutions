
#include<stdio.h>
int reverse(int x){
    int MAX_INT=pow(2,31)-1;
    int MIN_INT=pow(-2,31);
    if (x==0 || (x>-10 && x<10)){
        return x;
    }
    int sign;
    if(x>=0) sign=1; else sign=-1;
    long int xx=labs(x);
    long int rev=0;
    while(xx){
        rev=rev*10 + xx%10;
        xx=xx/10;
    }
    if(rev*sign>MAX_INT || rev*sign<MIN_INT){
        return 0;
    }
    return rev*sign;
    
}

int main(){
    printf("%d",reverse(13452));
}