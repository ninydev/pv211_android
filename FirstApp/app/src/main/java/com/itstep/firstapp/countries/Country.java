package com.itstep.firstapp.countries;

import androidx.annotation.NonNull;

public class Country {
    private String name;
    private String flagUrl;
    private String capital;
    private int population;
    private double area;
    private String currency;
    private int clickCount;

    public Country(String name, String flagUrl, String capital, int population, double area, String currency) {
        this.name = name;
        this.flagUrl = flagUrl;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.currency = currency;
        clickCount = 0;
    }


    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }


    public void incrementClickCount() {
        clickCount++;
    }

    public int getClickCount() {
        return clickCount;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getCurrency() {
        return currency;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " (" + capital + ")";
    }
}
