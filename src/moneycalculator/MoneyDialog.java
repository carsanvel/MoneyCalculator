package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialog extends JPanel {

    private JComboBox originCurrencies;
    private JComboBox destinyCurrencies;
    private JTextField amountField;
    private JPanel boxPanel;
    private JPanel textPanel;
    private Map<String, Currency> currencies;
    
    public MoneyDialog(Map<String, Currency> currencies) {
        boxPanel = new JPanel();
        textPanel = new JPanel();
        this.currencies = currencies;
        originCurrencies = new JComboBox();
        destinyCurrencies = new JComboBox();
        for (String String : currencies.keySet()) {
            originCurrencies.addItem(String);
            destinyCurrencies.addItem(String);
        }
        amountField = new JTextField(20);
        setLayout(new BorderLayout());
        boxPanel.add(new JLabel("Origin currencies  "));
        boxPanel.add(originCurrencies);
        boxPanel.add(new JLabel("Destiny currencies  "));
        boxPanel.add(destinyCurrencies);
        textPanel.add(new JLabel("Amount:  "));
        textPanel.add(amountField);
        add(boxPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
    }
    
    public JTextField getTextField() {
        return amountField;
    }
    
    public String getCurrencyFromCode() {
        return (String) originCurrencies.getSelectedItem();
    }
    
    public String getCurrencyToCode() {
        return (String) destinyCurrencies.getSelectedItem();
    }
}
