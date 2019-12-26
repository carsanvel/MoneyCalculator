package moneycalculator.View;

import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class RestExchangeRateLoader implements ExchangeRateLoader{
    
    private String link;
    
    public RestExchangeRateLoader(String link) {
        this.link = link;
    }
                
    @Override
    public ExchangeRate load(Currency currencyFrom, Currency currencyTo)  {
        try {
            URLConnection connection = new URL(link + currencyFrom.getCode()).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();
            reader.close();
            JsonObject gsonObject = new JsonParser().parse(line).getAsJsonObject();
            JsonPrimitive toPrimitive = gsonObject.getAsJsonObject("rates").getAsJsonPrimitive(currencyTo.getCode());
            String dateString = gsonObject.getAsJsonPrimitive("date").getAsString();
            LocalDate date = LocalDate.of(Integer.parseInt(dateString.substring(0,4)), Integer.parseInt(dateString.substring(5,7)),
                                          Integer.parseInt(dateString.substring(8,10)));
            ExchangeRate exchangeRate = new ExchangeRate(currencyFrom, currencyTo, date, toPrimitive.getAsDouble());
            return exchangeRate;
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }   
}
