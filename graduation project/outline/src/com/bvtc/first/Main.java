package com.bvtc.first;

import java.util.Scanner;

/**
 * @Coding utf-8
 * @File Main.java
 * @Date 2022-11 29 14:11
 * @Author king
 * @Software IntelliJ IDEA
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        boolean isFlag = true;
        do {
            main.second();
            System.out.println("结束本程序吗？");
            String s = sc.nextLine();
            if (!s.equals("n")) {
                isFlag = false;
            }
        } while (isFlag);
    }

    private int first() {
        System.out.println("请输入一共需要合计多少张：");
        int a = sc.nextInt();
        int[] array = new int[a];
        int totalNumber = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入第" + (i + 1) +  "张的含框量：");
            array[i] = sc.nextInt();
            totalNumber += array[i];
        }
        return totalNumber;
    }

    private void second() {
        System.out.println("请输入要改变的框数");
        int i = sc.nextInt();
        System.out.println("请输入要增加还是衰减");
        sc.nextLine();
        String  yn = sc.nextLine();
        CountBox countBox = new CountBox(first(), i, yn);

        System.out.println(countBox.getResult());
        sc.nextLine();
    }
}
