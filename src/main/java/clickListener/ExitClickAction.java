package clickListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitClickAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JOptionPane.showMessageDialog(null,"程序即将退出...");

        System.exit(0);
    }
}
