double myPow(double x, int n) {
    double y;
    int i;
    long z = n; //converting to long to avoid the integer overflow/limt
    y = 1;
    if (x == 1 || n == 0) //x^0 == 1 and 1^n == 1
    return 1;
    
    else if (z<0) //for negative numbers
    {
        z = z * -1;
        x = 1/x; //x^-1 == 1/x^n :)
    }
    //using the concept of binary exponentiation
    while (z>0) 
    {
        if (z%2==1)
        {
            y = y * x; // y keeps track of the result in every step
            z = z-1;
        }
        
            x = x*x;
            z = z/2;
    }
    return y; 
}    