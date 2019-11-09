package com.sz;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ding
 * @date 2019/11/6
 */
public class Solution {
    /**
     * 14.编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 所有输入只包含小写字母 a-z
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                ///strs[i].indexOf(str)!=0,说明strs[i]这个字符串不是以str开始的
                //去掉str的最后一个字符，再次比较，直到while的条件满足，此时str就是这两个字符串的公共前缀
                //再将str与其他字符串比较。。。
                str = str.substring(0, str.length() - 1);
                //当str为空时，说明这两个字符串没有共同前缀，整个字符串数组就没有共同前缀，返回空
                if (str == "" || str.isEmpty()) {
                    return "";
                }
            }
        }
        return str;
    }

    @Test
    public void test() {
        String[] str1 = {"a", "a", "b"};
        System.out.println(longestCommonPrefix(str1));

        String[] str2 = {"flower", "flows", "flight"};
        System.out.println(longestCommonPrefix(str2));

    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 输入: "()"
     * 输出: true
     * 输入: "()[]{}"
     * 输出: true
     * 输入: "(]"
     * 输出: false
     * 输入: "([)]"
     * 输出: false
     * 输入: "{[]}"
     * 输出: true
     */

    /**
     * 1.利用栈实现
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //空串满足
        if (s.isEmpty() || s == "") {
            return true;
        }
        //字符串个数为奇数，不满足
        if ((s.length() & 1) == 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        //第一个字符为闭括号时不满足
        if (chars[0] == '}' || chars[0] == ')' || chars[0] == ']') {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(16) {{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            //如果是开括号，入栈
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else if (map.get(stack.lastElement()) == chars[i]) {
                //如果是栈顶开括号对应的闭括号，出栈
                stack.pop();
            } else {
                //以上两种都不满足，false
                return false;
            }
        }
        if (stack.isEmpty()) {
            //当栈为空，满足条件
            return true;
        }
        return false;
    }

    @Test
    public void test01() {
        System.out.println(isValid("(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){"));
    }

    /**
     * 2.开心消消乐式解法
     */
    public boolean isValid3(String s) {
        //判断是否存在一对括号
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            //如果存在则将这一对括号消除
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
        }
        //如果消除所有的成对括号后，字符串为空，则有效
        return s.isEmpty();
    }


    @Test
    public void test1() {
        System.out.println(Fb(5));
    }

    /**
     * 循环实现斐波那契数列
     *
     * @param n
     * @return
     */
    public int Fb(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int temp = 0, k = 1, p = 1;
        for (int i = 1; i < n - 1; i++) {
            temp = k + p;
            k = p;
            p = temp;
        }
        return p;
    }

    @Test
    public void test14() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }
}
