package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {

    private String city_name;
    private String country_code;
    private double temp;
    private int clouds;
    private int precip;
    private int snow;
    private String icon;





    @Override
    public String toString() {
        return "Актуальна погода у місті " + city_name + " \uD83C\uDF03"
                + "\nКраїна " + country_code
                + "\nТемпература " + temp + " \u2103"
                + "\nХмарність " + clouds + "% "
                + icon;
    }
}
