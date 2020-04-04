//https://leetcode.com/problems/reverse-integer/
// Reverse Integer
//Given a 32-bit signed integer, reverse digits of an integer.
//Assume we are dealing with an environment which could only store 
//integers within the 32-bit signed integer range: [−231,  231 − 1]. 
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class Solution {
    public int reverse(int x) {
      int reverse = 0;
        while (x != 0) {
            if((reverse > Integer.MAX_VALUE / 10) || (reverse == Integer.MAX_VALUE / 10 && x % 10 > 7)
                || (reverse < Integer.MIN_VALUE / 10) || (reverse == Integer.MIN_VALUE / 10 && x % 10 > 8)) return 0;
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}
