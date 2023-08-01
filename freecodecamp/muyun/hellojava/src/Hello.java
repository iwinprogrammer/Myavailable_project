import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);

        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel();

//        jLabel.setText("Hello 世界");
        jFrame.add(jLabel);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入你的名字：");
        String yourName = null;
        try {
            yourName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String showText = "你好，" + yourName;

        System.out.println(showText);

        jLabel.setText(showText);

        jFrame.setSize(300,300);
        jFrame.setVisible(true);*/

        double 年收入 = 12;
        double 年消费 = 2.4;
        int 年份 = 30;

        Scanner scanner = new Scanner(System.in);
        年收入 = scanner.nextFloat();
        年消费 = scanner.nextFloat();
        年份 = scanner.nextInt();

//        double 年结余 = 年收入 - 年消费;
//        System.out.println(年结余);

        double 年息 = 0.05;
        double 年收入涨幅 = 0.08;
        double 年消费涨幅 = 0.03;

        double 存款 = 0;

        for (int i = 0; i < 年份; i++) {
            System.out.println("在第" + (i + 1) + "年后");

            double 年结余 = 年收入 - 年消费;
            System.out.println("年结余" + 年结余);

            存款 = 存款*(1+年息)+年结余;

            System.out.println("现在的存款：" + 存款);

            存款 = 存款;

            年收入 = 年收入 * (1 + 年收入涨幅);
            年消费 = 年消费 * (1 + 年消费涨幅);
        }


    }


}