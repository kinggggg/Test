package com.shengsiyuan.java8;

import javax.swing.*;

/**
 * @ClassName SwingTest
 * @Description
 * @Date 2019/9/27 10:34 AM
 * @Version v1.0
 **/
public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");

        // e的类型可以由Lambda表达式自动推断出来；当Lambda表达式无法自动推断的时候需要显示进行声明
        jButton.addActionListener(e -> System.out.println("Button Pressed!"));
        //完整的Lambda表达式写法
//        jButton.addActionListener((ActionEvent actionEvent) -> System.out.println("Button Pressed!"));

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
