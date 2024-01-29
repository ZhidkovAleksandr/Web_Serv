package Currency;

import Currency.entity.CurrencyH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] strings = {"USD", "EUR", "GBP"};
        String reqUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=@&json";

        Requetster requetster = new Requetster();

        for (String s:strings) {
            String rUrl = reqUrl.replaceAll("@", s);
            CurrencyH nCur = requetster.getAndCreateCurrency(rUrl);
            System.out.println(nCur);
            System.out.println("---------------------");
        }


    }
}