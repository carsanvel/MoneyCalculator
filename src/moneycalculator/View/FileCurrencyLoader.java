package moneycalculator.View;

import moneycalculator.Model.Currency;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileCurrencyLoader implements CurrencyLoader{

    private final File file;
    
    public FileCurrencyLoader(String path) {
        file = new File(path);
    }
    
    @Override
    public void load(Map<String, Currency> currencies){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine().replaceAll("\n", "");
            JsonObject obj = new JsonParser().parse(line).getAsJsonObject();
            Set<Entry<String, JsonElement>>  set = obj.entrySet();
            for (Entry<String, JsonElement> entry : set) {
                JsonObject currency = entry.getValue().getAsJsonObject();
                String name = currency.getAsJsonPrimitive("name").getAsString();
                String code = currency.getAsJsonPrimitive("code").getAsString();
                String symbol = currency.getAsJsonPrimitive("symbol").getAsString();
                currencies.put(code, new Currency(code, name, symbol));
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
