package com.example.calendardatecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    CalendarView cal;
    Calendar c1 = new GregorianCalendar(), c2 = new GregorianCalendar();
    Button b1, b2, menu;
    TextView firstDate, secDate, daysNum;
    public static String d1;
    DateC date1, date2;
    int dayCt = 0;

    //To get to day value, divide away the miliseconds (That's what getTime() returns)
    public int daysBetween(Date date1, Date date2){
        return (int)( (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView)findViewById(R.id.cal);
        b1 = (Button)findViewById(R.id.first);
        b2 = (Button)findViewById(R.id.sec);
        firstDate = (TextView)findViewById(R.id.firstDate);
        secDate = (TextView)findViewById(R.id.secDate);
        daysNum = (TextView)findViewById(R.id.daysBt);

        //if didnt change calendar value
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstDate.setText("8/10/21");
            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            //i = year, i1 = month, i2 = day
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                //Selected date
                d1 = (i1 + 1) + "/" + i2 + "/" + i;

                //First button, sets text
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firstDate.setText(d1);
                    }
                });
                //Second button, sets text and determines days between dates
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        secDate.setText(d1);

                        //Objects of DateC class, store date
                        date1 = new DateC(firstDate.getText().toString());
                        date2 = new DateC(secDate.getText().toString());

                        c1.set(date1.getYear(),date1.getMonth(),date1.getDay());
                        c2.set(date2.getYear(),date2.getMonth(),date2.getDay());

                        dayCt = daysBetween(c1.getTime(),c2.getTime());

                        daysNum.setText(Integer.toString(dayCt) + " days");


                    }
                });
            }
        });
    }
}