package gUI;


import clickListener.CheckIfExitAction;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class RenameGUI extends JFrame{

    public static void main(String[] args) {
        RenameGUI window = new RenameGUI();
    }

    public RenameGUI() {
        initialize();
    }

    private void initialize() {
        JFrame jFrame = new JFrame();
        // 菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuStart = new JMenu("打开");
        // 快捷键 alt R
        jMenuStart.setMnemonic('R');
        JMenu jMenuDescription = new JMenu("说明");
        JMenuItem jMenuItem1 = new JMenuItem("打开文件路径");
        JMenuItem jMenuItem2 = new JMenuItem("退出");
        JMenuItem jMenuItem3 = new JMenuItem("使用说明");
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke('O'));
        //jMenuItem1.setMnemonic('O');
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        // 退出监听事件
        jMenuItem2.addActionListener(new CheckIfExitAction());
        jMenuStart.add(jMenuItem1);
        jMenuStart.addSeparator();
        jMenuStart.add(jMenuItem2);
        jMenuDescription.add(jMenuItem3);
        menuBar.add(jMenuStart);
        menuBar.add(jMenuDescription);

        //按钮初始化
        JPanel contentPane=new JPanel();
        contentPane.setLayout(null);
        jFrame.setContentPane(contentPane);
        // 打开文件按钮
        JButton openFileButton = new JButton("打开文件");
        openFileButton.setBounds(100, 20, 100, 20);
        contentPane.add(openFileButton);
        // 打开文件路径txtfield
        JLabel openPathTxt = new JLabel("路径:");
        openPathTxt.setFont(new Font("宋体",Font.BOLD, 16));

        // openPathTxt.setHorizontalAlignment(JTextField.CENTER);
        openPathTxt.setBounds(0, 45, 300, 20);
        openPathTxt.setForeground(Color.BLACK);
        contentPane.add(openPathTxt);
        // 替换选项
        JLabel optionTxt = new JLabel("类型:");
        optionTxt.setFont(new Font("宋体",Font.BOLD, 16));
        optionTxt.setBounds(0, 70, 48, 20);
        optionTxt.setForeground(Color.BLACK);
        contentPane.add(optionTxt);
        // 开始按钮
        JButton startFileButton = new JButton("开始");
        startFileButton.setBounds(100, 100, 100, 20);
        contentPane.add(startFileButton);
        // 退出按钮
        JButton exitFileButton = new JButton("退出");
        exitFileButton.setBounds(100, 160, 100, 20);
        exitFileButton.setForeground(Color.BLACK);
        exitFileButton.setBackground(Color.red);
        contentPane.add(exitFileButton);
        exitFileButton.addActionListener(new CheckIfExitAction());
        // 组件组合
        jFrame.setJMenuBar(menuBar);
        // 不显示边框
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.setSize(300,250);
        jFrame.setLocationRelativeTo(null);
        this.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
