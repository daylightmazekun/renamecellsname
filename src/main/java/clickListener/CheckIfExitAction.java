package clickListener;

import gUI.ExitGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckIfExitAction implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        ExitGUI exitGUI = new ExitGUI();
    }
}
