package moneycalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MoneyCalculator {

    

    private Map<String, Currency> currencies = new HashMap<String, Currency>();
    private Currency currencyTo;
    private Money money;

    public MoneyCalculator() {
    
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
        
        System.out.println("Introduzca divisa de destino");
        
    }

    private void process() {
        
    }

    private void output() {
        
    }
    
}
