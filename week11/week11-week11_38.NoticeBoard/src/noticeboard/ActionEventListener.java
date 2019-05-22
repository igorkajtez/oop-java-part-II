package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionEventListener implements ActionListener{
    private JTextField tf;
    private JLabel lbl;

    public ActionEventListener(JTextField tf, JLabel lbl) {
        this.tf = tf;
        this.lbl = lbl;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lbl.setText(this.tf.getText());
        this.tf.setText("");
    }

}
