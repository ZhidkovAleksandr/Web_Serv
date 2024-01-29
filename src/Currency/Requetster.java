package Currency;

import Currency.entity.CurrencyH;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Requetster {

//    private String reqUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=@value@&json";
//    private String mCurrency;

    public Requetster(){

    }

    public CurrencyH getAndCreateCurrency(String rUrl) throws IOException {
        CurrencyH cur = new CurrencyH();
        StringBuilder result = new StringBuilder();
        URL url = new URL(rUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int respCode = connection.getResponseCode();

        if(respCode == HttpURLConnection.HTTP_OK){

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }

                String message = result.toString();
                Gson gson = new Gson();
                cur = gson.fromJson(message.substring(1,message.length()-1), CurrencyH.class);

            }

        }



        return cur;
    }

}
