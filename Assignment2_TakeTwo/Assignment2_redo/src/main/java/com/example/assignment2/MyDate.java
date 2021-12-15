
package com.example.assignment2;

public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year){

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonthShortForm(){ return getMonthShortForm();}

    public String getMonthLongForm(){
        return getMonthLongForm();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        String s = "<------- Birthday ------->";
        s += "\nDay of birth:" + day;
        s += "\nMonth of birth: " + month;
        s += "\nYear of birth: " + year;
        return s;
    }
}
