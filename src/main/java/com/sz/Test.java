package com.sz;

/**
 * @author ding
 * @date 2019/11/13
 */
public class Test extends Father {
    private String name = "test";

    static int a = 10;

    static {
        a += 5;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getName());

        //5
        System.out.println("a=" + a);

    }

    static {
        a /= 3;
    }
}
