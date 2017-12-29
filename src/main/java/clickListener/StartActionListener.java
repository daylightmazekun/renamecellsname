package clickListener;

import action.actionImp.RenameItImp;
import bean.Cells;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartActionListener implements ActionListener, PropertyChangeListener {
    Cells cells;
    RenameItImp renameItImp;
    JTextField textAreaFrom1;
    JTextField textAreaTo1;
    JTextField textAreaFrom2;
    JTextField textAreaTo2;
    JTextField textAreaFrom3;
    JTextField textAreaTo3;


    public StartActionListener(Cells cells, RenameItImp renameItImp, JTextField textAreaFrom1, JTextField textAreaTo1, JTextField textAreaFrom2, JTextField textAreaTo2, JTextField textAreaFrom3, JTextField textAreaTo3) {
        this.cells = cells;
        this.renameItImp = renameItImp;
        this.textAreaFrom1 = textAreaFrom1;
        this.textAreaTo1 = textAreaTo1;
        this.textAreaFrom2 = textAreaFrom2;
        this.textAreaTo2 = textAreaTo2;
        this.textAreaFrom3 = textAreaFrom3;
        this.textAreaTo3 = textAreaTo3;
        initBar();
    }

//    public JProgressBar jProgressBarStart() {
//        JProgressBar jProgressBar = new JProgressBar();
//        jProgressBar.setTitle("进度条的使用");
//        jProgressBar.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        jProgressBar.setBounds(100, 100, 250, 100);
//        JPanel contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        jProgressBar.setContentPane(contentPane);
//        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//        final JProgressBar progressBar = new JProgressBar();
//        progressBar.setStringPainted(true);
//        return progressBar;
//    }

    private void initBar() {
        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setVisible(true);
        jProgressBar.setStringPainted(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, String> changeMap = new HashMap<String, String>();
        changeMap.put(textAreaFrom1.getText(), textAreaTo1.getText());
        changeMap.put(textAreaFrom2.getText(), textAreaTo2.getText());
        changeMap.put(textAreaFrom3.getText(), textAreaTo3.getText());
        cells.setHashMap(changeMap);
        RenameItImp renameItImp = new RenameItImp();


        renameItImp.traverseFolder(cells);
//        JProgressBar jProgressBar = jProgressBarStart();
//        jProgressBar.setValue(100);
        JFrame jFrame = new JFrame();
        // 不显示边框
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.setSize(200, 80);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel contentPane = new JPanel();

        contentPane.setLayout(null);
        jFrame.setContentPane(contentPane);
        // 打开文件按钮
        JButton openFileButton = new JButton("替换完成");
        openFileButton.setBounds(50, 20, 100, 40);
        // 打开文件夹路径监听

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        jFrame.setContentPane(contentPane);
        contentPane.add(openFileButton);
        cells.setPath("");

    }

//    public int getFileAndDirectory(String filePath) {
//        File file = new File(filePath);
//        int countFile = 0;
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (File fileIndex : files) {
//                if (fileIndex.isDirectory()) {
//                    getFileAndDirectory(fileIndex.getAbsolutePath());
//                } else {
//                    countFile++;
//                }
//            }
//        }
//        return countFile;
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
