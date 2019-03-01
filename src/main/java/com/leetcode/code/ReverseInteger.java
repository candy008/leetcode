package com.leetcode.code;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class ReverseInteger {


    public static void main(String[] args) {
        int s = -153423646;
        int res = doManacher(s);
        System.out.println(res);
    }

    public static int doManacher(int x) {
        int res = 0;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7) )return 0;
            if(res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop<-8)) return 0;
            res = res * 10 + pop;
        }
        return res;
    }
}
