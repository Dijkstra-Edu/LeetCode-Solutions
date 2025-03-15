Can use pow(x,n) surprisingly lol.

Actual solution would be to compute powers of x by right shifting to cut down the number of multiplications since high powers would lead to TLE.

By using this we improve the time complexity from O(n) to O(log(n)), which is very significant at higher values of n, close to 2^19 and above.
