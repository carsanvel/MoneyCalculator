package moneycalculator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoneyCalculator {
        
    public static void main(String[] args) throws IOException{
        RestExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader("https://api.exchangeratesapi.io/latest?base=");
        FileCurrencyLoader currencyLoader =  new FileCurrencyLoader("C:\\Users\\carvsk\\Documents\\universidad\\Cuarto ano\\Primer cuatrimestre\\Ingeniería del software 2\\fichero divisas JSON2.txt");
        Map<String, Currency> currenciesList = new HashMap<>();
        currencyLoader.load(currenciesList);
        MainFrame mainFrame = new MainFrame(currenciesList);
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), (HashMap<String, Currency>) currenciesList, exchangeRateLoader));
        mainFrame.add(new DeleteCommand(mainFrame.getMoneyDisplay()));
    }
    
}
