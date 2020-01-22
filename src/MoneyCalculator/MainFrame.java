package MoneyCalculator;

import Model.Currency;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.Command;
import ViewSwingImplementation.SwingMoneyDialog;
import ViewSwingImplementation.SwingMoneyDisplay;
import java.awt.Component;

public class MainFrame extends JFrame {

    private final Map<String, Command> commands;
    private final Map<String, Currency> currencies;
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay moneyDisplay;
    
    public MainFrame(Map<String, Currency> currencies) {
        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 200);
        commands = new HashMap<>();
        this.currencies = currencies;
        getContentPane().setLayout(new BorderLayout());
        initializeMoneyDialog();
        initializeMoneyDisplay();
        initializeButtons();
        
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private void initializeMoneyDialog() {
        getContentPane().add(moneyDialog(), BorderLayout.NORTH);
    }
    
    private JPanel moneyDialog() {
        SwingMoneyDialog dialog  = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;
    }
    
    private void initializeMoneyDisplay() {
        getContentPane().add(moneyDisplay(), BorderLayout.SOUTH);
    }
    
    private Component moneyDisplay() {
        SwingMoneyDisplay display  = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }
    
    public void addCommand(Command command, String name) {
        commands.put(name, command);
    }
    
    public SwingMoneyDialog getMoneyDialog() {
        return moneyDialog;
    }
    
    public SwingMoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    
    private void initializeButtons() {
        JPanel buttonPanel = new JPanel();
        JButton acceptButton = new JButton("Accept");
        JButton deleteButton = new JButton("Delete");
        acceptButton.addActionListener(accept());
        deleteButton.addActionListener(delete());
        buttonPanel.add(acceptButton);
        buttonPanel.add(deleteButton);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    private ActionListener accept() {
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
        
    }

    private ActionListener delete() {
        return new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Delete").execute();
            }
        };
        
    }


}
