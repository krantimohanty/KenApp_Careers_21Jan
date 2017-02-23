package com.swashconvergence.apps.user.app_model;

/**
 * Created by suchismita.p on 11/4/2016.
 */

public class Form2 {

    String headline, address1, address2, city, state, country, pin, phoneno ;
    public Form2()
    {

    }
    public Form2(String headline, String address1, String address2, String city, String state, String country, String pin, String phoneno)
    {   this.headline=headline;
        this.address1=address1;
        this.address2=address2;
        this.city=city;
        this.state=state;
        this.country=country;
        this.pin=pin;
        this.phoneno=phoneno;
    }

    public String getAddress1() {
        return address1;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
