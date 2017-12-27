package clickListener;

import action.actionImp.RenameItImp;
import bean.Cells;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class StartActionListener implements ActionListener,PropertyChangeListener {
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

    private void initBar(){
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
        cells.setPath("");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
