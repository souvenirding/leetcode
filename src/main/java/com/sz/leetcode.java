package com.sz;

import org.junit.Test;

public class leetcode {
    public static void main(String[] args) {

        int nums[] = {2, 7, 11, 15};
        System.out.println(twoSum(nums, 9));
    }

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void test01() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(8);
        l4.next = l5;
        l5.next = l6;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1.next != null || l2.next != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b;
        }
        return null;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public void getstr(String str) {
        char[] chars = str.toCharArray();

    }

    /**
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     * 示例 1：
     * 输入：guess = [1,2,3], answer = [1,2,3]
     * 输出：3
     * 解释：小A 每次都猜对了。
     * 示例 2：
     * 输入：guess = [2,2,3], answer = [3,2,1]
     * 输出：1
     * 解释：小A 只猜对了第二次。
     */

    public void guess(int a[], int b[]) {
//        int m = 0;
//        for (int i = 0; i < 3; i++) {
//            if (a[i] == b[i]) {
//                m += 1;
//            }
//        }
//        System.out.println(m);
        System.out.println((a[0] == b[0] ? 1 : 0) + (a[1] == b[1] ? 1 : 0) + (a[2] == b[2] ? 1 : 0));
    }

    @Test
    public void test03() {
        guess(new int[]{1, 2, 2}, new int[]{2, 2, 2});
    }

    /**
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * 注意:
     * S 和 J 最多含有50个字母。
     *  J 中的字符不重复。
     */

    public void Aa(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    m++;
                }
            }
        }
        System.out.println(m);
    }

    @Test
    public void test04() {
        String J = "aA";
        String S = "aAAbbbb";
        Aa(J, S);
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123 输出: 321
     * 示例 2:
     * 输入: -123 输出: -321
     * 示例 3:
     * 输入: 120 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下32位的有符号整数，则其数值范围为[−2的31次方,2的31次方− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public int reverse(int a) {
        int sum = 0;
        while (a != 0) {
            // 由于后续运算 sum = sum * 10 + a % 10
            // 如果 sum 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
            // 如果 sum 的值等于 Integer.MAX_VALUE / 10，那么 a % 10 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
            // 相反的，sum 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出
            // 如果 sum 的值等于 Integer.MIN_VALUE / 10，那么 a % 10 的值如果小于于 Integer.MIN_VALUE % 10 也会溢出
            //Integer.MAX_VALUE:2147483647;  Integer.MIN_VALUE:-2147483648
            if (sum > Integer.MAX_VALUE/10
                    || sum < Integer.MIN_VALUE/10
                    || ((sum == Integer.MAX_VALUE/10)&&(a % 10>7))
                    || ((sum == Integer.MIN_VALUE/10)&&(a % 10<-8)) ) {
                return 0;
            }
            sum = sum * 10 + a % 10;
            a = a / 10;
        }
        return sum;

    }

    @Test
    public void test05() {
        System.out.println(reverse(-1463847412));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
