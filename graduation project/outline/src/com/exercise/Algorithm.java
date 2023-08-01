package com.exercise;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Coding utf-8
 * @File Algorithm.java
 * @Date 2022-12 22 12:17
 * @Author king
 * @Software IntelliJ IDEA
 */
public class Algorithm {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.YangHui(6);
        algorithm.nineNineMul();
//        System.out.println(algorithm.addTwoNumbers(new ListNode(211), new ListNode(213)));

    }


    public boolean isValidWalk(String walk) {
        if (walk.length() != 10) {
            return false;
        } else {
            if (!walk.equals( 'w' ) ) {
                return false;
            }
            return true;
        }
    }

    public void YangHui(int length) {
        int[][] arr = new int[length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }

//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    System.out.print(arr[i][j] + "\t");
                } else {
                    System.out.print(arr[i - 1][j] + " + " + arr[i - 1][j - 1] + " = " + arr[i][j] + "\t");
                }
            }
            System.out.println();
        }

    }

    public void nineNineMul() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }

    public void xiuJingQian() {
        System.out.println(162/41.5);
    }

    public int mul() {

        return -1;
    }

    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要创建的数组长度:");
        int arrayLength = sc.nextInt();
        int[] nums = new int[arrayLength];
        for (int i = 0; i < nums.length; i++) {
            System.out.print("请输入数组中第" + (i+1) + "数字:");
            nums[i] = sc.nextInt();
        }
        System.out.print("请输入目标综合数");
        int target = sc.nextInt();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[i] + nums[j] == target) {
                        System.out.println("[" + i + "," + j + "]");
                        return;
                    }
                }
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


}

