package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ClickListener implements ActionListener{
    private Calculator calculator;
    private JLabel lbl;

    public ClickListener(Calculator calculator, JLabel lbl) {
        this.calculator = calculator;
        this.lbl = lbl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        lbl.setText(calculator.giveValue() + "");        
    }

}
