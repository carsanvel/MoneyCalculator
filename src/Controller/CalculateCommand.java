package Controller;



import ViewSwingImplementation.SwingMoneyDialog;
import ViewSwingImplementation.SwingMoneyDisplay;
import Model.Currency;
import Model.ExchangeRate;
import Model.Money;
import View.MoneyDialog;
import View.MoneyDisplay;
import java.util.HashMap;
import View.RestExchangeRateLoader;

public class CalculateCommand implements Command {

    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final HashMap<String, Currency> currencies;
    private final RestExchangeRateLoader exchangeRateLoader;
    
    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, HashMap<String, Currency> currencies, RestExchangeRateLoader exchangeRateLoader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.currencies = currencies;
        this.exchangeRateLoader = exchangeRateLoader;
    }
    
    @Override
    public void execute() {
        try {
            double amount = Double.parseDouble(moneyDialog.getText());
            Currency currencyTo = currencies.get(moneyDialog.getCurrencyToCode());
            Currency currencyFrom = currencies.get(moneyDialog.getCurrencyFromCode());
            if(currencyTo.getCode().equals(currencyFrom.getCode())) {
                moneyDisplay.setText("" + amount * 1);
            } else {
                Money money = new Money(amount, currencyFrom);
                ExchangeRate exchangeRate = exchangeRateLoader.load(currencyFrom, currencyTo);
                moneyDisplay.setText("" + money.getAmount() * exchangeRate.getRate());
            }
        }
        catch(java.lang.NumberFormatException e) {
            System.out.println("Not a number");
            moneyDialog.setText("");
        }
    }
}
