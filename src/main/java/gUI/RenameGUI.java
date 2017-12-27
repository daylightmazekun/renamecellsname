package gUI;


import action.actionImp.RenameItImp;
import bean.Cells;
import clickListener.CheckIfExitAction;
import clickListener.GetFilepathListener;
import clickListener.StartActionListener;
import clickListener.TextFileBilngListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RenameGUI extends JFrame {
    Cells cells;
    RenameItImp renameItImp;
    public static void main(String[] args) {
        RenameGUI window = new RenameGUI();
    }

    public RenameGUI() {
        cells = new Cells();
        renameItImp = new RenameItImp();
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
        jMenuItem1.addActionListener(new GetFilepathListener(cells));
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
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        jFrame.setContentPane(contentPane);
        // 打开文件按钮
        JButton openFileButton = new JButton("打开文件");
        openFileButton.setBounds(100, 20, 100, 20);
        // 打开文件夹路径监听

        openFileButton.addActionListener(new GetFilepathListener(cells));
        contentPane.add(openFileButton);

        // 打开文件路径txtfield
        JLabel openPathTxt = new JLabel("替换:");
        openPathTxt.setFont(new Font("宋体", Font.BOLD, 16));

        // openPathTxt.setHorizontalAlignment(JTextField.CENTER);
        openPathTxt.setBounds(0, 45, 60, 20);
        openPathTxt.setForeground(Color.BLACK);
        contentPane.add(openPathTxt);
        JTextField textAreaFrom1 = new JTextField();
        JTextField textAreaTo1 = new JTextField();
        JTextField textAreaFrom2 = new JTextField();
        JTextField textAreaTo2 = new JTextField();
        JTextField textAreaFrom3 = new JTextField();
        JTextField textAreaTo3 = new JTextField();
        textAreaFrom1.setBounds(45, 48, 120, 20);
        textAreaFrom1.setForeground(Color.BLACK);
        textAreaTo1.setBounds(170, 48, 120, 20);
        textAreaTo1.setForeground(Color.BLACK);
        textAreaFrom2.setBounds(45, 70, 120, 20);
        textAreaFrom2.setForeground(Color.BLACK);
        textAreaTo2.setBounds(170, 70, 120, 20);
        textAreaTo2.setForeground(Color.BLACK);
        textAreaFrom3.setBounds(45, 92, 120, 20);
        textAreaFrom3.setForeground(Color.BLACK);
        textAreaTo3.setBounds(170, 92, 120, 20);
        textAreaTo3.setForeground(Color.BLACK);
        // 替换文本监听事件
        textAreaFrom1.addMouseListener(new TextFileBilngListener(textAreaFrom1));
        textAreaTo1.addMouseListener(new TextFileBilngListener(textAreaTo1));
        // 替换文本监听事件
        textAreaFrom2.addMouseListener(new TextFileBilngListener(textAreaFrom2));
        textAreaTo2.addMouseListener(new TextFileBilngListener(textAreaTo2));
        // 替换文本监听事件
        textAreaFrom3.addMouseListener(new TextFileBilngListener(textAreaFrom3));
        textAreaTo3.addMouseListener(new TextFileBilngListener(textAreaTo3));
        contentPane.add(textAreaFrom1);
        contentPane.add(textAreaTo1);
        contentPane.add(textAreaFrom2);
        contentPane.add(textAreaTo2);
        contentPane.add(textAreaFrom3);
        contentPane.add(textAreaTo3);
        // 替换选项
        JLabel optionTxt = new JLabel("类型:");
        optionTxt.setFont(new Font("宋体", Font.BOLD, 16));
        optionTxt.setBounds(0, 114, 48, 20);
        optionTxt.setForeground(Color.BLACK);
        contentPane.add(optionTxt);
        // 开始按钮
        JButton startFileButton = new JButton("开始");
        startFileButton.setBounds(100, 140, 100, 20);
        startFileButton.addActionListener(new StartActionListener(cells, renameItImp, textAreaFrom1, textAreaTo1, textAreaFrom2, textAreaTo2, textAreaFrom3, textAreaTo3));
        contentPane.add(startFileButton);
        // 退出按钮
        JButton exitFileButton = new JButton("退出");
        exitFileButton.setBounds(100, 200, 100, 20);
        exitFileButton.setForeground(Color.BLACK);
        exitFileButton.setBackground(Color.red);
        contentPane.add(exitFileButton);
        exitFileButton.addActionListener(new CheckIfExitAction());
        // 组件组合
        jFrame.setJMenuBar(menuBar);
        // 不显示边框
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.setSize(300, 250);
        jFrame.setLocationRelativeTo(null);
        this.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
