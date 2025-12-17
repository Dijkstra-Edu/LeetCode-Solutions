private static boolean[] isPrime = new boolean[1000001]; This boolean array is used to mark prime numbers up to 1000000. The size of the array is 1000001 to include the number 1000000.

Static Block:
The static block is used to initialize the isPrime array and precompute the prime numbers.

Arrays.fill(isPrime, true); This method sets all elements of the isPrime array to true, assuming all numbers are prime initially.

precompute(); This method is called to mark non-prime numbers in the isPrime array.

Method: precompute()
This method uses the Sieve of Eratosthenes algorithm to mark non-prime numbers in the isPrime array.

isPrime[0] = isPrime[1] = false; Numbers 0 and 1 are not prime.

A loop is used to iterate from 2 to sqrt(1000000).

If isPrime[i] is true, all multiples of i are marked as false (not prime) starting from i*i.

Method: closestPrimes(int left, int right)
This method finds the closest prime numbers within the range [left, right].

int prev = -1, minDiff = Integer.MAX_VALUE; Variables to track the previous prime number and the minimum difference between consecutive primes.

int num1 = -1, num2 = -1; Variables to store the closest prime numbers.

A loop iterates through the range [left, right].

If isPrime[i] is true, the number i is a prime.

If prev is not -1 and the difference (i - prev) is less than minDiff, update minDiff and set num1 to prev and num2 to i.

Update prev to i.

If no prime numbers are found, return new int[]{-1, -1}. Otherwise, return the closest prime numbers num1 and num2.