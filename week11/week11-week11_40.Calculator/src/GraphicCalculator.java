
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private JTextField tfOutput;
    private JTextField tfInput;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        tfOutput = new JTextField("0");
        tfOutput.setEnabled(false);
        
        tfInput = new JTextField();
        
        container.add(tfOutput);
        container.add(tfInput);
        container.add(createPanel());
        
    }
    
    private JPanel createPanel(){
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnZ = new JButton("Z");
        btnZ.setEnabled(false);
        
        btnPlus.addActionListener(new ButtonListener(btnPlus.getText().charAt(0), tfOutput, tfInput, btnZ));
        btnMinus.addActionListener(new ButtonListener(btnMinus.getText().charAt(0), tfOutput, tfInput, btnZ));
        btnZ.addActionListener(new ButtonListener(btnZ.getText().charAt(0), tfOutput, tfInput, btnZ));
        
        panel.add(btnPlus);
        panel.add(btnMinus);
        panel.add(btnZ);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
