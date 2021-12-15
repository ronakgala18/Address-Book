
package com.example.assignment2;

public class Address {
    public String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String province;
    public String country;

    public Address(String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country)
    {
        this.streetInfo1 = streetInfo1;
        this.streetInfo2 = streetInfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public String toString(){
        String s = "<------- Address ------->";
        s += "\nStreet Info 1: " + streetInfo1;
        s += "\nStreet Info 2: " + streetInfo2;
        s += "\nCity: " +city;
        s += "\nPostal Code: " + postalCode;
        s += "\nProvince: " + province;
        s += "\nCountry: " + country;
        return s;
    }
}

