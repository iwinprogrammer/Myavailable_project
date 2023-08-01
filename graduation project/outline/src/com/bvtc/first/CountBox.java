package com.bvtc.first;

import java.util.Arrays;

/**
 * @Coding utf-8
 * @File CountBox.java
 * @Date 2022-11 29 14:09
 * @Author king
 * @Software IntelliJ IDEA
 */
public class CountBox {

    private int totalNumber;
    private int a;

    private int result;


    public CountBox() {

    }

    public CountBox(int totalNumber, int a ,String yn) {
        this.totalNumber = totalNumber;
        this.a =a ;
        if (yn.equals("增加")) {
            result = cumulativeAdd(totalNumber,a);
        } else if (yn.equals("衰减")) {
            result = cumulativeSub(totalNumber,a);
        }
    }


    private int cumulativeAdd(int totalNumber, int a) {
        return totalNumber + a;
    }

    private int cumulativeSub(int totalNumber, int a) {
        if (totalNumber >= a) {
            return totalNumber - a;
        } else return -1;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CountBox{" +
                "totalNumber=" + totalNumber +
                ", a=" + a +
                ", result=" + result +
                '}';
    }
}
