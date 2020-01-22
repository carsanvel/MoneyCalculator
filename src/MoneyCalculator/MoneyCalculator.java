package MoneyCalculator;



import Controller.CalculateCommand;
import Controller.DeleteCommand;
import Model.Currency;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import View.FileCurrencyLoader;
import View.RestExchangeRateLoader;

public class MoneyCalculator {
        
    public static void main(String[] args) throws IOException{
        RestExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader("https://api.exchangeratesapi.io/latest?base=");
        FileCurrencyLoader currencyLoader =  new FileCurrencyLoader("fichero divisas JSON2.txt");
        Map<String, Currency> currenciesList = new HashMap<>();
        currencyLoader.load(currenciesList);
        MainFrame mainFrame = new MainFrame(currenciesList);
        mainFrame.addCommand(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), (HashMap<String, Currency>) currenciesList, exchangeRateLoader), "Calculate");
        mainFrame.addCommand(new DeleteCommand(mainFrame.getMoneyDisplay()), "Delete");
        mainFrame.execute();
    }
    
}
