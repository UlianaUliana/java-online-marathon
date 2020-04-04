// https://leetcode.com/problems/divide-two-integers/
// Given two integers dividend and divisor, divide two integers without using
// multiplication, division and mod operator.
// Return the quotient after dividing dividend by divisor.
// The integer division should truncate toward zero, which means losing its fractional part.
// For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
// Both dividend and divisor will be 32-bit signed integers.
// The divisor will never be 0.
// Assume we are dealing with an environment which could only store integers
// within the 32-bit signed integer range: [−2^31,  2^31 − 1].
// For the purpose of this problem, assume that your function returns 2^31 − 1
// when the division result overflows.

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        int quotient = 0;
        long dividendLong = 0L;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                dividendLong = Integer.MAX_VALUE + 1L;
            }
        } else {
            dividendLong = dividend;
        }
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        if (dividendLong < 0) dividendLong = -dividendLong;
        if (divisor < 0) divisor = -divisor;
        while (dividendLong >= divisor) {
            dividendLong -= divisor;
            quotient++;
        }
        if (sign == -1) quotient = -quotient;
        return quotient;
    }
}
