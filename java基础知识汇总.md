## java基础知识汇总

### 1、小算法题

### java计算素数

```java
public class SuShu
{
    public static void main(String[] args){
        java.util.Scanner s=new java.util.Scanner(System.in);
        int i=s.nextInt();
        boolean isSuShu=true; //标记；
        for(int j=2;j<i;j++)
        {
            if(i%j==0)
            {
                isSuShu=false;
                break;
            }
        }    
        System.out.println(isSuShu ? i+"是素数" : i+"是非素数");
    }
}
```



### **变量中的数据交换**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
       int x = 3, y= 5, t;
       t = x; //先把x的值赋值给t
       x = y; // 将y的值赋值给x
       y = t; // 再将t中存放的值，赋值给y

        System.out.println("x:" + x + "y:" + y); // 输出结果x:5y:3



    }

}
```

**计算10的阶乘和**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
       long sum, f;
       int i;
       sum = 0;
       f = 1;
       for(i = 1; i<= 10; i++){
           f = f*i;
           sum = sum + f;
       }
        System.out.println("阶乘和为" + sum); // 阶乘和为4037913


    }

}
```





### 2、 数组相关

#### **Java中使用关键字new创建数组对象，格式为：数组名 = new 数组元素的类型 [数组元素的个数]**

```java
        // 创建数组，如果在创建的同时不初始化数组则必须指定其大小
        int[] intArray0 = new int [3];
        // 错误的创建数组的方式，如果创建数组时不指定大小则必须初始化
        // intArray1 = new int[];
        // 创建数组时，不指定数组大小则必须在创建的同时初始化数组
        int intArray1[] = new int []{0,1,2};
        //其他声明方式
        int intArray2[] = {0};
```

#### **基础代码讲解**

```java
package com.company;

import java.util.Arrays;
import java.util.Random;

public class TestArray {

    public static void main(String[] args) {
        //声明一个长度为10的一维数组
        //数组的下标为 0， 1， 2， 3， 4，5， 6，7，8，9
        //数组的下标都是整形的，不能为其他类型
        int size = 10;
        int[] arr = new int [size];
        //创建一个随机数对象
        Random random = new Random();
        //为每一个元素赋值
        for(int i = 0; i < 10; i++){
            // 给数组赋值
            arr[i] = random.nextInt(10) ;
        }
        //获取它的第一个元素
        int first = arr[0];
        System.out.println(first);

        //获取第三个元素
        int three = arr[2];
        System.out.println(three);

        //获取最后一个元素
        int last = arr[9]; //注意： 错误的写法为 arr[10], 数组的角标是从0开始的，如果数据长度为十，则最后一个角标为9
        System.out.println(last);

        // 获取数组长度
        int arrLen = arr.length;
        System.out.println(arrLen);
        //这里面需要注意，数组在初始化的时候，长度已经固定，所有在改变数组长度的值，是没有任何作用的，举例如下：
        size = 20;
        System.out.println(arrLen); //输出的值都是10， 而不会变为20

        //打印数组元素
        System.out.println(Arrays.toString(arr));
    }
}

```

#### **案例讲解**

```java
package com.company;


public class ExampleArray {

    public static void main(String[] args) {
        //声明一个数组
        int[] a = {1, 4, 2, 6, 2, 6, 7, 7, 6, 10};
        //计算数组长度
        int len = a.length;
        System.out.println(len);
        //获取数值为10的元素
        int ten = a[9];
        System.out.println(ten);

        // 多变量同时声明
        int i, j[]  = {1, 4, 2, 6, 2, 6, 7, 7, 6, 10};
        for(i = 0; i < 4; i += 2){
            System.out.println(j[i]);
        }
        
    }
}

```

#### **求数组元素中的最小值**

```java
package com.company;


public class ExampleArray {

    public static void main(String[] args) {
        //声明一个数组
        int[] a = {5, 4, 2, 6, 2, 6, 7, 7, 6, 10};
        //定义一个临时变量
        int temp = a[0];

        for(int i = 1; i < a.length; i++){
            if(a[i] < temp){ // 如果后一个元素数值，比temp中的数值小
                temp = a[i];  // 将更小的数值赋值给临时变量
            }
        }
        //输出最小值
        System.out.println(temp);
    }
}

```

#### **计算数组下标不能被3 整除的元素的和**

```java
package com.company;


public class ExampleArray {

    public static void main(String[] args) {
        //声明一个数组
        int[] a = {20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
        int i, s = 0;
        for(i = 0; i < a.length; i++){
            if(i % 3 == 0){
                continue;
            }
            s += a[i];
        }
        System.out.println(s); //结果为510

    }
}

```

#### **求一维数组的和与平均值**

```java
package com.company;


public class ExampleArray {

    public static void main(String[] args) {
        //声明一个数组
        int[] a = {20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        int i, s = 0;
        for(i = 0; i < a.length; i++){
            //将数组中的数值相加
            s += a[i];
        }
        //计算平均值
        int avg =  s / a.length; // 没有考虑精度问题
        System.out.println("一维数组的和为：" + s);
        System.out.println("平均值为" + avg);

    }
}
```



### 2、 循环相关

#### **计算从0开始7以内，奇数的和**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int i = 0, s = 0;
        do {
            if( i % 2 == 0){
                i++;
                continue;
            }
            i++;
            s = s+ i;

        }while (i < 7);

        System.out.println(s); // 最终结果为12
    }
}
```

#### **不带break的switch的执行**

例子1：

```java
package com.company;


public class Example {

    public static void main(String[] args) {
       int a = 0;
       while (a < 5){
           switch (a){
               case 0:
               case 3: a = a + 2;
               case 1:
               case 2: a = a + 3;
               default: a = a+ 5;
           }
       }
        System.out.println(a); // 最终结果为10

    }
}

```

例子2：

```java
package com.company;


public class Example {

    public static void main(String[] args) {

         int result = getValue(2);
        System.out.println(result); // 结果为10

    }

    public static int getValue(int a){
        int result = 0;
            switch (a){
                case 1:
                    result = result + a;
                case 2:
                    result = result + a*2;
                case 3:
                    result = result + a*3;
            }

        return result;
    }
}
```





#### **continue和break的区别**

#### **案例一**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
       int total = 0;
       for(int i = 0; i < 4; i++){
           if(i == 1){
               continue; // 跳过此次循环，直接进入到下次循环
           }
           if(i == 2){
               break;  // 直接跳出循环
           }

           total += i;
       }

        System.out.println(total); // 最后结果为0

    }
}

```



#### **案例二**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 30; i++){
            if(i % 3 == 0){
                sum += i;
            }else{
                if(sum > 30){
                    break;
                }
            }

        }
        System.out.println(sum); // 输出结果为45
    }

}
```





### 3、**i++等相关操作**

#### **基础讲解**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        System.out.println(a++); // a++ 先赋值，在自增， 输出结果为 0
        System.out.println(a); // 输出结果为 1

        System.out.println(++b); // ++b先自增，在赋值，输出结果为1
        System.out.println(b); // 输出结果为1

        System.out.println(a--);// a-- 先赋值，在自减， 输出结果为 1
        System.out.println(a); // 输出结果为0


        System.out.println(--b); // --b先自减，在赋值，输出结果为0
        System.out.println(b); // 输出结果为0
    }

}
```

#### **案例讲解1：**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int a, b, c;
        a = 1;
        b = 3;

        c = (a + b > 3 ? ++a : b++);

        System.out.println("a的值：" + a + " b的值：" + b + " c的值：" + c); // a的值：2 b的值：3 c的值：2

    }

}
```

#### **案例讲解2：**

````java
package com.company;


public class Example {

    public static void main(String[] args) {
        int a = 2;
        System.out.print(a++);
        System.out.print(a);
        System.out.print(++a);

        //输出结果为 234

    }

}
````

#### **案例讲解3：**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int i = 4, j = 5, k = 9, m = 5;
        if(i > j && m < k++){
            k++;
        }else{
            k--;
        }
        System.out.println(k); //输出结果为8
    }

}
```

#### **案例讲解4：**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int k, m = 1;
        k = m++;
        System.out.println(k); // 结果为1
    }

}
```

#### **案例讲解5：**

```java
package com.company;


public class Example {

    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        x += z--/++y;
        System.out.println(x); // 输出结果为2
    }

}
```



### 4、其他相关基础知识

http://note.youdao.com/s/MqZyzD7Z

[参考](http://note.youdao.com/s/MqZyzD7Z)



