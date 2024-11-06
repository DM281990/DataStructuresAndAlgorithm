package PrefixSum;
/*
cur = 0 if current prefix sum is even
cur = 1 if current prefix sum is odd
count[0] is the number of even prefix sum
count[1] is the number of odd prefix sum


For each element in A:
if current prefix sum is even, res += the number of odd prefix sum
if current prefix sum is odd, res += the number of even prefix sum



More Explanation
All by @Anonymouso:


Basically the way it works is -
If you add an odd number to an even number - you get an odd number (4+1 = 5, 1+2 = 3, 7+12 = 19 etc.)
If you add an even number to an odd number - same result as above obviously.
if you add an even number to an even number - you get an even number (4 + 2 =6, 8+6 = 14 etc.)
If you add an odd number to an odd number - you get an even number ( 1+1 = 2, 5 +7 = 12 etc.)


Based on the above table of options, you need to pick only 2 options > add odd number to even number & add even number to odd number.
What lee is doing is basically counting the amount of "odd" prefix sums he sees and "even prefix sums he sees.
As he does that:
if the current subarray sum is odd - that means that we need to add all the number of even sub arrays we saw so far to the result.
if the current subarray sum is even - that means that we need to add all the number of odd sub arrays we saw so far to the result.


cur ^= a & 1;
This checks whether the current subarray is odd or even (in binary if the last digit is 1, then the number is odd).
We don't care about the sum of the subarray, we just want to know whether it's odd or even.
Then the XOR is simply to check whether the previous subarray we saw is odd/even - if it is the opposite of our current number, then we'll get cur=1 else, cur=0.
then


res = (res + count[1 - cur]) % mod;
This adds all the previous odd/even arrays to the result, depending on the result we found.
If our cur=1, then count[1-cur] will give the total amount of subarrays of the opposite cur and vice versa.


count[cur]++;
finally we increase the total count of the appropriate subarrays we found (even or odd).


Tried to do my best explaining...
Hope you get it.
 */

/**
 * FAILED
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/discuss/754743/JavaC%2B%2BPython-Prefix-Sum
 * Leetcoed#1524
 */
public class NumberOfSubArraysWithOddSum {
    public int numOfSubarrays(int[] A) {
        int cur = 0, res = 0, count[] = {1, 0}, mod = (int)1e9 + 7;
        for (int a: A) {
            cur ^= a & 1;
            res = (res + count[1 - cur]) % mod;
            count[cur]++;
        }
        return res;
    }
}
