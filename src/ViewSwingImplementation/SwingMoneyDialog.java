package ViewSwingImplementation;

import Model.Currency;
import View.MoneyDialog;
import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{

    private JComboBox originCurrencies;
    private JComboBox destinyCurrencies;
    private JTextField amountField;
    
    public SwingMoneyDialog(Map<String, Currency> currencies) {
        setLayout(new BorderLayout());
        initializeBoxPanel(currencies);
        initializeTextPanel();
    }
    
    private void initializeBoxPanel(Map<String, Currency> currencies) {
        JPanel boxPanel = new JPanel();
        boxPanel.add(new JLabel("Origin currency  "));
        initializeComboBox(currencies);
        boxPanel.add(originCurrencies);
        boxPanel.add(new JLabel("Destiny currency  "));
        boxPanel.add(destinyCurrencies);
        add(boxPanel, BorderLayout.NORTH);
    }
    

    
    private void initializeComboBox(Map<String, Currency> currencies) {
        originCurrencies = new JComboBox();
        destinyCurrencies = new JComboBox();
        for (String String : currencies.keySet()) {
            originCurrencies.addItem(String);
            destinyCurrencies.addItem(String);
        }
    }
    
    private void initializeTextPanel() {
        JPanel textPanel =  new JPanel();
        amountField = new JTextField(20);
        textPanel.add(new JLabel("Amount:  "));
        textPanel.add(amountField);
        add(textPanel, BorderLayout.CENTER);
    }
    
    @Override
    public String getText() {
        return amountField.getText();
    }
    
    @Override
    public void setText(String text) {
        amountField.setText(text);
    }
    
    @Override
    public String getCurrencyFromCode() {
        return (String) originCurrencies.getSelectedItem();
    }
    
    @Override
    public String getCurrencyToCode() {
        return (String) destinyCurrencies.getSelectedItem();
    }

}
