package com.atguigu.java;

import org.junit.Test;
import sun.applet.Main;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * -*- coding: utf-8 -*-
 * File:sfs.java
 * Date:2022-06-13 10:30
 * Author:king
 * Software:IntelliJ IDEA
 */
public class sfs {


    /**
     * Tom--18[台球, 乒乓球]
     * Jerry--20
     * [台球, 乒乓球]
     *
     */
    @Test
    public void Main() {
        /*
        人生九练：
        1练脸皮，放下面子才有面子。
        2练自信，自己不自信别人怎么会相信你。
        3练气场，一定要抬头挺直腰板儿
        4练胆识，要敢和任何人对视。
        5练沉稳，再大的事情也要表现淡定。
        6练心智，不生气不计较，不容易被激怒。
        7练口才，成功者都是演讲高手。
        8练情商，要学会赞美，要学会拒绝，要学会幽默。
        9练阅历，要学会说话，要学会办事，更要学会做人
         */
        String name = "Jerry";
        int age = 20;
        String[] 爱好 = {"羽毛球","乒乓球"};
        d(name,age,爱好);
        System.out.println(name + "--" + age);
        System.out.println(Arrays.toString(爱好));
    }
    public void d(String name,int age,String[] 爱好){
        name = "Tom";
        age = 18;
        爱好[0] = "台球";
        System.out.println(name + "--" + age + Arrays.toString(爱好));
    }

    @Test
    public void Tes() {

        String a = "123";
        String b = "qwe";
        String c = a + "qwe";
        String d = a + "qwe";
        String e = a + b;
        String f = "123qwe";
        System.out.println(c == d);//false
        System.out.println(e);//123qwe
        System.out.println(e == f);//false
        S s = new S("123qwe","yy");
        S s1 = new S("123qwe","yy");
        System.out.println(s.s == f);//true
        String g = (a + b).intern();
        String h = a + b.intern();
        System.out.println(s.s == g);//true
        System.out.println(s.s == h);//false
        System.out.println(s == s1);//false
        System.out.println(s.t == s1.t);//true
        System.out.println(s.t.equals(s1.t));//true
        String i = "123" + "qwe";
        System.out.println(i == f);//true
        System.out.println(i == g);//true
        System.out.println(f == g);//true

    }

    @Test
    public void Sd() {
        /**String abc = new String("abc");
        abc = "sdf";
        String sc = "sdf";
        System.out.println(abc);//adf
        System.out.println(abc == sc);//true*/

        /*
        这里呢也体现了String的final不可变性，即使把abc1的值
         */
        S s = new S("abc", "def");

        String abc1 = new String("abc");

        String abc = "abc";
        String def = "def";
        String h = "h";

        System.out.println(s.s == abc1);//false     ：s.s是"abc"在字符串常量池中的地址值，
                                                    // abc1是"abc"在字符串常量池中的地址值储存在在堆中的地址值

        String abc2 = new String("abc");
        System.out.println(abc2 == abc1);//false    :abc2是在堆中的地址值  abc1也是

        abc1 = "def";//还有这里
        System.out.println(s.t == abc1);//true      :s.t-->在堆中存的"def"在字符串池的地址值    abc1-->在字符串池中的地址值
        System.out.println(s.s);//abc

    }
}

class S {
    String s;
    String t;

    public S(String s, String t) {
        this.s = s;
        this.t = t;
    }



}
