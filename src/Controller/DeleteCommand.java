package Controller;

import View.MoneyDisplay;

public class DeleteCommand implements Command{

    private final MoneyDisplay moneyDisplay;
    
    public DeleteCommand(MoneyDisplay moneyDisplay) {
        this.moneyDisplay = moneyDisplay;
    }
    
    @Override
    public void execute() {
        moneyDisplay.setText("");
    }
}
