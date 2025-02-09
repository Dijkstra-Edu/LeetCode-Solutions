
def Solution( x: int) -> int:
        MAX_INT=(2**31)-1
        MIN_INT=-2**31
        if -10<x<10==0:
            return x
        sign = (x)//abs(x)
        rev = int(str(abs(x))[::-1])
        if(sign==-1 and rev*sign<MIN_INT):
            return 0
        elif(sign==1 and rev>MAX_INT):
            return 0
        else:
            return rev*sign
             
if __name__ == "__main__":
    print(Solution(456))
