package Currency.entity;

import java.util.Date;

public class CurrencyH {

    private String cc;
    private float rate;
    private String exchangedate;

    @Override
    public String toString() {
        return "Currency{" +
                "cc='" + cc + '\'' +
                ", rate=" + rate +
                ", exchangedate=" + exchangedate +
                '}';
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }
}
