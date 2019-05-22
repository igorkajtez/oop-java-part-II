package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container){
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel lbl1 = new JLabel("Are you?");
        JCheckBox cbYes = new JCheckBox("Yes!");
        JCheckBox cbNo = new JCheckBox("No!");
        
        JLabel lbl2 = new JLabel("Why?");
        JRadioButton rb1 = new JRadioButton("No reason.");
        JRadioButton rb2 = new JRadioButton("Because it is fun!");
        
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rb1);
        btnGroup.add(rb2);
        
        JButton btnDone = new JButton("Done!");
        
        container.add(lbl1);
        container.add(cbYes);
        container.add(cbNo);
        container.add(lbl2);
        container.add(rb1);
        container.add(rb2);
        container.add(btnDone);
    }


    public JFrame getFrame() {
        return frame;
    }
}
