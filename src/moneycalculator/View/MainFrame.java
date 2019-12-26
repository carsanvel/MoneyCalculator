package moneycalculator.View;

import moneycalculator.Model.Currency;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.Controller.Command;

public class MainFrame extends JFrame {

    private Map<String, Command> commands;
    private Map<String, Currency> currencies;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private JPanel buttonPanel;
    private JButton acceptButton;
    private JButton deleteButton;
    
    public MainFrame(Map<String, Currency> currencies) {
        commands = new HashMap<>();
        this.currencies = currencies;
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        initializeMoneyDialog(pane);
        initializeMoneyDisplay(pane);
        initializeButtons(pane);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public void add(Command command, String name) {
        commands.put(name, command);
    }
    
    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }
    
    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    private void initializeMoneyDialog(Container pane) {
        moneyDialog = new MoneyDialog(currencies);
        pane.add(moneyDialog, BorderLayout.NORTH);
    }
    
    private void initializeMoneyDisplay(Container pane) {
        moneyDisplay = new MoneyDisplay();
        pane.add(moneyDisplay, BorderLayout.SOUTH);
    }
    
    private void initializeButtons(Container pane) {
        buttonPanel = new JPanel();
        acceptButton = new JButton("Accept");
        deleteButton = new JButton("Delete");
        buttonPanel.add(acceptButton);
        buttonPanel.add(deleteButton);
        pane.add(buttonPanel, BorderLayout.CENTER);
        
        
        acceptButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                commands.get("Calculate").execute();
                                            }
                                        });
        deleteButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                commands.get("Delete").execute();
                                            }
                                        });
    }
}
