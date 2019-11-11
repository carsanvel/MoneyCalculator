package moneycalculator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoneyCalculator {

    
    private final Map<String, Currency> currencies;
    private Currency currencyTo;
    private Money money;
    private ExchangeRate exchangeRate;

    public MoneyCalculator() throws IOException {
        currencies = new HashMap<>();
        FileCurrencyLoader.load(currencies, "C:\\Users\\carvsk\\Documents\\universidad\\Cuarto ano\\Primer cuatrimestre\\Ingeniería del software 2\\fichero divisas JSON2.txt");
    }   
    
    public static void main(String[] args) throws IOException{
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        moneyCalculator.control();
    }
    
    private void control() throws IOException{
        input();
        process();
        output();
    }
        
    private void input() {
        System.out.println("Introduzca cantidad");
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.next());
        System.out.println("Introduzca divisa de origen");
        money = new Money(amount, currencies.get(scanner.next()));
        System.out.println("Introduzca divisa de destino");
        currencyTo = currencies.get(scanner.next());
    }

    private void process() throws IOException{
        exchangeRate = RestExchangeRateLoader.load("https://api.exchangeratesapi.io/latest?base=", money.getCurrency(), currencyTo);
    }

    private void output() {
        System.out.println(money.getAmount() + " " + money.getCurrency().getSymbol() + " equivalen a: " +
                            money.getAmount()*exchangeRate.getRate() +  currencyTo.getSymbol());
    }
}
