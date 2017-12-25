package gUI;


import action.actionImp.RenameItImp;
import bean.Cells;
import clickListener.CheckIfExitAction;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;


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
        // 打开文件夹路径监听
        Cells cells = new Cells();
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    JFileChooser chooser = new JFileChooser();
                    // 只能选文件夹
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
                    // 得到用户根目录
                    FileSystemView fileSystemView = FileSystemView.getFileSystemView();
                    chooser.setCurrentDirectory(fileSystemView.getHomeDirectory());
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            "xls & xlsx Files", "xls", "xlsx");
                    // 文件过滤器
                    chooser.setFileFilter(filter);
                    int returnVal = chooser.showOpenDialog(null);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        File flie = chooser.getSelectedFile();
                        JOptionPane.showMessageDialog(null, "选择的文件路径..." + flie.getAbsolutePath());
                        cells.setPath(flie.getAbsolutePath());
                    }

                }
            }
        });
        contentPane.add(openFileButton);

        // 打开文件路径txtfield
        JLabel openPathTxt = new JLabel("替换:");
        openPathTxt.setFont(new Font("宋体",Font.BOLD, 16));

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
        textAreaFrom1.setBounds(45,48,120,20);
        textAreaFrom1.setForeground(Color.BLACK);
        textAreaTo1.setBounds(170,48,120,20);
        textAreaTo1.setForeground(Color.BLACK);
        textAreaFrom2.setBounds(45,70,120,20);
        textAreaFrom2.setForeground(Color.BLACK);
        textAreaTo2.setBounds(170,70,120,20);
        textAreaTo2.setForeground(Color.BLACK);
        textAreaFrom3.setBounds(45,92,120,20);
        textAreaFrom3.setForeground(Color.BLACK);
        textAreaTo3.setBounds(170,92,120,20);
        textAreaTo3.setForeground(Color.BLACK);
        // 替换文本监听事件
            textAreaFrom1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                    textAreaFrom1.setBackground(new Color(193, 210, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaFrom1.setBackground(new Color(255, 255, 255));
            }
        });
        textAreaTo1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textAreaTo1.setBackground(new Color(0, 255, 128));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaTo1.setBackground(new Color(255, 255, 255));
            }
        });
        // 替换文本监听事件
        textAreaFrom2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textAreaFrom2.setBackground(new Color(193, 210, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaFrom2.setBackground(new Color(255, 255, 255));
            }
        });
        textAreaTo2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textAreaTo2.setBackground(new Color(0, 255, 128));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaTo2.setBackground(new Color(255, 255, 255));
            }
        });
        // 替换文本监听事件
        textAreaFrom3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textAreaFrom3.getText().equals("替换源")) {
                    textAreaFrom3.setText("");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textAreaFrom3.setBackground(new Color(193, 210, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaFrom3.setBackground(new Color(255, 255, 255));
            }
        });
        textAreaTo3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textAreaTo3.getText().equals("替换先")) {
                    textAreaTo3.setText("");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textAreaTo3.setBackground(new Color(0, 255, 128));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //textAreaFrom1.setBorder(null);
                textAreaTo3.setBackground(new Color(255, 255, 255));
            }
        });
        contentPane.add(textAreaFrom1);
        contentPane.add(textAreaTo1);
        contentPane.add(textAreaFrom2);
        contentPane.add(textAreaTo2);
        contentPane.add(textAreaFrom3);
        contentPane.add(textAreaTo3);
        // 替换选项
        JLabel optionTxt = new JLabel("类型:");
        optionTxt.setFont(new Font("宋体",Font.BOLD, 16));
        optionTxt.setBounds(0, 114, 48, 20);
        optionTxt.setForeground(Color.BLACK);
        contentPane.add(optionTxt);
        // 开始按钮
        JButton startFileButton = new JButton("开始");
        startFileButton.setBounds(100, 140, 100, 20);
        startFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> changeMap= new HashMap<String, String>();
                changeMap.put(textAreaFrom1.getText(),textAreaTo1.getText());
                changeMap.put(textAreaFrom2.getText(),textAreaTo2.getText());
                changeMap.put(textAreaFrom3.getText(),textAreaTo3.getText());
                cells.setHashMap(changeMap);
                RenameItImp renameItImp = new RenameItImp();
                renameItImp.traverseFolder(cells);
            }
        });
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
        jFrame.setSize(300,250);
        jFrame.setLocationRelativeTo(null);
        this.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
