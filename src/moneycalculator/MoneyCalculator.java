package moneycalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MoneyCalculator {

    

    private Map<String, Currency> currencies = new HashMap<String, Currency>();
    private Currency currencyFrom;
    private Currency currencyTo;
    private Money money;

    public MoneyCalculator() {
        currencies.put("EUR", new Currency("EUR", "Euro", "€"));
        currencies.put("GBP", new Currency("USD", "Dollar americano", "$"));
        currencies.put("GBP", new Currency("GBP", "Libra", "£"));
    }
    
    public static void main(String[] args) {
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        moneyCalculator.control();
    }
    
    private void control() {
        input();
        process();
        output();
    }
        
    private void input() {
        System.out.println("Introduzca cantidad");
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.next());
        System.out.println("Introduzca divisa de origen");
        currencyFrom = currencies.get(scanner.next());
        System.out.println("Introduzca divisa de destino");
        currencyTo = currencies.get(scanner.next());
    }

    private void process() {
        
    }

    private void output() {
        
    }
    
    private static double getExchangeRate(String from, String to) {
        URL url = new URL("")
    }
    
}
