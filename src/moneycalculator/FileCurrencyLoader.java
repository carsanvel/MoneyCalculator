package moneycalculator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileCurrencyLoader {

    
    public static void load(Map<String, Currency> currencies, String directory) throws IOException{
        try(BufferedReader reader = new BufferedReader
                                    (new FileReader(new File(directory)))) {
            String line = reader.readLine();
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(line).getAsJsonArray();
            for (JsonElement elem : array) {
                JsonObject obj = elem.getAsJsonObject();
                String name = obj.getAsJsonPrimitive("Name").getAsString();
                String code = obj.getAsJsonPrimitive("Code").getAsString();
                String symbol = obj.getAsJsonPrimitive("Symbol").getAsString();
                currencies.put(code, new Currency(code, name, symbol));
            }
            reader.close();
        }
    }
}
