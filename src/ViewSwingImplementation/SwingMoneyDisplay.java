package ViewSwingImplementation;

import View.MoneyDisplay;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{

    private final JTextField resultField;
    
    public SwingMoneyDisplay() {
        resultField = new JTextField(20);
        add(new JLabel("Result:  "));
        add(resultField);
    }
    
    @Override
    public String getText() {
        return resultField.getText();
    }
    
    @Override
    public void setText(String text) {
        resultField.setText(text);
    }
    
}
