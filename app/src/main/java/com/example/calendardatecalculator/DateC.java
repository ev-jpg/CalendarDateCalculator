package com.example.calendardatecalculator;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DateC {

    private int month, day, year;
    private ArrayList<Integer> cDays = new ArrayList<>();

    //Constructor reads from date string into month, day, year setters
    public DateC(@NonNull String text) {
        int ctr = 0;
        for(int i = 0; i < text.length(); i++) {

            if(text.charAt(i) == '/') {
                ctr++;
                cDays.clear();
            }

            else if(text.charAt(i) != '/' && ctr == 0)
                setMonth(text.charAt(i));

            else if(text.charAt(i) != '/' && ctr == 1)
                setDay(text.charAt(i));

            else if(text.charAt(i) != '/' && ctr == 2)
                setYear(text.charAt(i));

        }

    }

    public void setMonth(char month) {
        cDays.add(Character.getNumericValue(month));
        if(cDays.size() > 1) {
            this.month = (cDays.get(0) * 10) + cDays.get(1);
        }
        else {
            this.month = cDays.get(0);
        }

    }
    public void setDay(char day) {
        cDays.add(Character.getNumericValue(day));
        if(cDays.size() > 1) {
            this.day = (cDays.get(0) * 10) + cDays.get(1);
        }
        else {
            this.day = cDays.get(0);
        }
    }
    public void setYear(char year) {
        cDays.add(Character.getNumericValue(year));
        if(cDays.size() > 1) {
            this.year = (cDays.get(cDays.size()-2) * 10) + cDays.get(cDays.size()-1);
        }
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }

}
