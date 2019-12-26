package moneycalculator.Controller;

import moneycalculator.Controller.Command;
import moneycalculator.View.MoneyDisplay;

public class DeleteCommand implements Command{

    private MoneyDisplay moneyDisplay;
    
    public DeleteCommand(MoneyDisplay moneyDisplay) {
        this.moneyDisplay = moneyDisplay;
    }
    
    @Override
    public void execute() {
        moneyDisplay.getTextField().setText("");
    }
}
