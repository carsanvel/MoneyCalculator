package moneycalculator;

public class DeleteCommand implements Command{

    private MoneyDisplay moneyDisplay;
    
    public DeleteCommand(MoneyDisplay moneyDisplay) {
        this.moneyDisplay = moneyDisplay;
    }
    
    @Override
    public void execute() {
        moneyDisplay.getTextField().setText("");
    }

    @Override
    public String getName() {
        return "Delete";
    }

    
}
