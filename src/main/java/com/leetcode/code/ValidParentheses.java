package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 有效的括号
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {


    public static void main(String[] args) {
        String s = "(]";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {

        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char pops = stack.pop();
                if(('('+')'!=pops+s.charAt(i))&&('['+']'!=pops+s.charAt(i))&&('{'+'}'!=pops+s.charAt(i))){
                    stack.push(pops);
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
