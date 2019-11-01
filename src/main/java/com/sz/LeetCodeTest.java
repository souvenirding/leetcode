package com.sz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 */
public class LeetCodeTest {
    private String s;

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
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

    public void guess(int[] a, int[] b) {

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

    public void search(String s1, String s2) {
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
        String j = "aA";
        String s = "aAAbbbb";
        search(j, s);
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
            int max = Integer.MAX_VALUE / 10;
            int min = Integer.MIN_VALUE / 10;
            if (sum > max
                    || sum < min
                    || ((sum == max) && (a % 10 > 7))
                    || ((sum == min) && (a % 10 < -8))) {
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
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 输入: 121
     * 输出: true
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */

    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        int m = x % 10;
        if (x < 0 || (m == 0 && x != 0)) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test06() {
        long s = System.nanoTime();
        System.out.println(isPalindrome(1234554321));
        long e = System.nanoTime();
        System.out.println(e - s);
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
     * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * I:1，II:2，III:3，IV:4，V:5，
     */

    /**
     * 使用数组
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                numbers[i] = 1;
            } else if (chars[i] == 'V') {
                numbers[i] = 5;
            } else if (chars[i] == 'X') {
                numbers[i] = 10;
            } else if (chars[i] == 'L') {
                numbers[i] = 50;
            } else if (chars[i] == 'C') {
                numbers[i] = 100;
            } else if (chars[i] == 'D') {
                numbers[i] = 500;
            } else if (chars[i] == 'M') {
                numbers[i] = 1000;
            }
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int sum = 0;
        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] >= numbers[j + 1]) {
                //如果当前值大于后面，则加上当前值
                sum += numbers[j];
            } else {
                //如果当前值小于后面，则加上组合值
                sum = sum + numbers[j + 1] - numbers[j];
                j++;
            }
        }
        //上述遍历操作在当前值大于后面值时，未加最后一个值，需加上
        if (numbers[numbers.length - 2] >= numbers[numbers.length - 1]) {
            sum += numbers[numbers.length - 1];
        }
        return sum;
    }

    /**
     * map实现
     *
     * @param s
     * @return
     */
    public int romanToIntMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return map.get(chars[0]);
        }
        int sum = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (map.get(chars[i]) < map.get(chars[i + 1])) {
                //两个字符,即当前值小于后面值
                sum = sum + map.get(chars[i + 1]) - map.get(chars[i]);
                i++;
            } else {
                //单个字符
                sum += map.get(chars[i]);
            }
        }
        return sum;
    }

    /**
     * 最优的算法
     *
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0, length = chars.length; i < length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    ret += 1000;
                    break;
                case 'D':
                    ret += 500;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'M') {
                            ret += 900;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'D') {
                            ret += 400;
                            i++;
                            break;
                        }
                    }
                    ret += 100;
                    break;
                case 'L':
                    ret += 50;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'C') {
                            ret += 90;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'L') {
                            ret += 40;
                            i++;
                            break;
                        }
                    }
                    ret += 10;
                    break;
                case 'V':
                    ret += 5;
                    break;
                default:
                    // I
                    if (i < length - 1) {
                        if (chars[i + 1] == 'X') {
                            ret += 9;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'V') {
                            ret += 4;
                            i++;
                            break;
                        }
                    }
                    ret += 1;
                    break;
            }
        }
        return ret;
    }

    @Test
    public void test07() {
        long s = System.nanoTime();
        //System.out.println(romanToInt("MCMXCIV"));//耗时：169187
        System.out.println(romanToIntMap("MCMXCIV"));//耗时：2740590
        //System.out.println(romanToInt2("MCMXCIV"));//耗时：98765
        long e = System.nanoTime();
        System.out.println(e - s);
    }
}
