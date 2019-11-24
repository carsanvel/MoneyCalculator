package moneycalculator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDisplay extends JPanel{

    private JTextField resultField;
    
    public MoneyDisplay() {
        resultField = new JTextField(20);
        add(new JLabel("Result:  "));
        add(resultField);
    }
    
    public JTextField getTextField() {
        return resultField;
    }
    
}
