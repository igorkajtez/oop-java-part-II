
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonListener implements ActionListener{
    private JTextField tfOutput;
    private JTextField tfInput;    
    private char operation;
    private JButton btnZ;

    public ButtonListener(char operation, JTextField tfOutput, JTextField tfInput, JButton btnZ) {
        this.operation = operation;
        this.tfOutput = tfOutput;
        this.tfInput = tfInput;
        this.btnZ = btnZ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(operation == '+'){
            int output = getValue(tfOutput);
            int number = getValue(tfInput);
            output += number;
            
            tfOutput.setText(output + "");
            tfInput.setText("");   
            
            btnZ.setEnabled(getValue(tfOutput) != 0);
            
        }else if(this.operation == '-'){
            int output = getValue(tfOutput);
            int number = getValue(tfInput);
            output -= number;
            
            tfOutput.setText(output + "");
            tfInput.setText("");
            
            btnZ.setEnabled(getValue(tfOutput) != 0);
            
        }else if(this.operation == 'Z'){
            
            tfOutput.setText("0");
            tfInput.setText("");
            
            btnZ.setEnabled(getValue(tfOutput) != 0);
        }
    }
    
    public int getValue(JTextField field){
        try{
            return Integer.parseInt(field.getText());
        }catch(Exception exc){
            return 0;
        }
    }

}
