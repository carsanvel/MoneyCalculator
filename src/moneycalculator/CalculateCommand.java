package moneycalculator;

import com.sun.javafx.collections.MappingChange.Map;
import java.util.HashMap;

public class CalculateCommand implements Command {

    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private HashMap<String, Currency> currencies;
    private RestExchangeRateLoader exchangeRateLoader;
    
    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, HashMap<String, Currency> currencies, RestExchangeRateLoader exchangeRateLoader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.currencies = currencies;
        this.exchangeRateLoader = exchangeRateLoader;
    }
    
    @Override
    public void execute() {
        double amount = Double.parseDouble(moneyDialog.getTextField().getText());
        Currency currencyTo = currencies.get(moneyDialog.getCurrencyToCode());
        Currency currencyFrom = currencies.get(moneyDialog.getCurrencyFromCode());
        if(currencyTo.getCode().equals(currencyFrom.getCode())) {
            moneyDisplay.getTextField().setText("" + amount * 1);
        } else {
            Money money = new Money(amount, currencyFrom);
            ExchangeRate exchangeRate = exchangeRateLoader.load(currencyFrom, currencyTo);
            moneyDisplay.getTextField().setText("" + money.getAmount() * exchangeRate.getRate());
        }
    }

    @Override
    public String getName() {
        return("Calculate");
    }

    
}
