package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class MoneyCalculator {

    
    private Map<String, Currency> currencies = new HashMap<String, Currency>();
    private Currency currencyTo;
    private Money money;
    private ExchangeRate exchangeRate;

    public MoneyCalculator() throws IOException {

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
        exchangeRate = new ExchangeRate(money.getCurrency(), currencyTo, LocalDate.MIN, getExchangeRate(money.getCurrency().getCode(), currencyTo.getCode()));
    }

    private void output() {
        System.out.println(money.getAmount() + " " + money.getCurrency().getSymbol() + " equivalen a: " +
                            money.getAmount()*exchangeRate.getRate() +  currencyTo.getSymbol());
    }
    
    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + from );
        URLConnection connection = url.openConnection();
        try(BufferedReader reader = new BufferedReader
                                    (new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            JsonParser parser = new JsonParser();
            JsonObject gsonObject = parser.parse(line).getAsJsonObject();
            JsonPrimitive toPrimitive = gsonObject.getAsJsonObject("rates").getAsJsonPrimitive(to);
            double exchangeRate = toPrimitive.getAsDouble();
            reader.close();
            return exchangeRate;
        }
    }
    
}
