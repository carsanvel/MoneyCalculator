package moneycalculator;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class RestExchangeRateLoader {
    
                
    public static ExchangeRate load(String link, Currency currencyFrom, Currency currencyTo) throws IOException {
        URLConnection connection = new URL(link + currencyFrom.getCode()).openConnection();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            reader.close();
            JsonParser parser = new JsonParser();
            JsonObject gsonObject = parser.parse(line).getAsJsonObject();
            JsonPrimitive toPrimitive = gsonObject.getAsJsonObject("rates").getAsJsonPrimitive(currencyTo.getCode());
            String dateString = gsonObject.getAsJsonPrimitive("date").getAsString();
            LocalDate date = LocalDate.of(Integer.parseInt(dateString.substring(0,4)), Integer.parseInt(dateString.substring(5,7)),
                                          Integer.parseInt(dateString.substring(8,10)));
            ExchangeRate exchangeRate = new ExchangeRate(currencyFrom, currencyTo, date, toPrimitive.getAsDouble());
            return exchangeRate;
        }
    }
}
