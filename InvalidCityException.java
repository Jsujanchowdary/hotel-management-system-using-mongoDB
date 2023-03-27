package com.vit.hms.util;

public class InvalidCityException extends Exception {
    String s;
    public  InvalidCityException(String s) {
        super(s);
        this.s=s;
    }
    public String toString(){
        
        return s.toString();
    }
}
