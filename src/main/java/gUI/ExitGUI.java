package gUI;

import clickListener.ExitClickAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitGUI {
    public ExitGUI() {
        initialize1();
    }
    private void initialize1() {
        JFrame jFrame = new JFrame();
        //按钮初始化
        JPanel contentPane=new JPanel();
        contentPane.setLayout(null);
        jFrame.setContentPane(contentPane);
        // 退出按钮
        JButton exitFileButton = new JButton("退出");
        exitFileButton.setBounds(20, 15, 60, 30);
        exitFileButton.setForeground(Color.BLACK);
        exitFileButton.setBackground(Color.red);
        contentPane.add(exitFileButton);
        exitFileButton.addActionListener(new ExitClickAction());
        // 关闭当前窗口按钮
        JButton backFileButton = new JButton("取消");
        // backFileButton.setFont(new Font("宋体",Font.BOLD, 16));
        backFileButton.setBounds(115, 15, 60, 30);
        backFileButton.setForeground(Color.BLACK);
        contentPane.add(backFileButton);
        backFileButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.dispose();
                    }
                });
        // 不显示边框
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.setSize(200,90);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        //jFrame.setAlwaysOnTop(true);
    }
}
