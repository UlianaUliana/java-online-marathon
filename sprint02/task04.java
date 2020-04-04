//https://leetcode.com/problems/sqrtx/
//Implement int sqrt(int x).
//Compute and return the square root of x, where x is guaranteed to be
// a non-negative integer.
//Since the return type is an integer, the decimal digits are truncated
// and only the integer part of the result is returned.

class Solution {
    public int mySqrt(int x) {
        long result = 0L;
        while ((result + 1) * (result + 1) <= x) {
            result++;
        }
        return (int) result;
    }
}
