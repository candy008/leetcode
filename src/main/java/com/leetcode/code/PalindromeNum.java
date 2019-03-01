package com.leetcode.code;

/**

 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNum {

    public static void main(String[] args) {
        boolean bool1 = isPalindrome1(121);
        boolean bool2 = isPalindrome2(121);

        System.out.println("result1:"+bool1);
        System.out.println("result2:"+bool2);

    }

    public static boolean isPalindrome1(int x) {

        int old = x;
        if(x<0){
            return false;
        }
        int res = 0;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7) )return false;
            if(res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop<-8)) return false;
            res = res * 10 + pop;
        }

        if(res==old){
            return true;
        }else{
            return false;
        }
    }


    public static boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }
}
