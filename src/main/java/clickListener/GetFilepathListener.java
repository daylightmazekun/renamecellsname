package clickListener;

import bean.Cells;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GetFilepathListener implements ActionListener {
    Cells cells;

    public GetFilepathListener(Cells cells) {
        this.cells = cells;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File flie = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "选择的文件路径..." + flie.getAbsolutePath());
            cells.setPath(flie.getAbsolutePath());

        }
    }
}