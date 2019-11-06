package com.sz;

import org.junit.Test;

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
}
