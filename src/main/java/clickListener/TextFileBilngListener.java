package clickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFileBilngListener implements MouseListener {
    JTextField textfield;

    public TextFileBilngListener(JTextField textfield) {
        this.textfield = textfield;
    }

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
        textfield.setBackground(new Color(193, 210, 240));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //textAreaFrom1.setBorder(null);
        textfield.setBackground(new Color(255, 255, 255));
    }

}
