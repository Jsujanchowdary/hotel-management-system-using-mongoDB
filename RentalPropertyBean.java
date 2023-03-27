package com.vit.hms.bean;

public class RentalPropertyBean {
    private float rentalAmount=0;
    private int noOfBedRooms=0;
    private String location=null;
    private String city=null;
    private String propertyId=null;
    // public RentalPropertyBean(float amt,int num,)
    public void setrentalAmount(float amt){
        rentalAmount=amt;
    }
    public void setnoOfBedRooms(int num){
        noOfBedRooms=num;
    }
    public void setlocation(String loc){
        location=loc;
    }
    public void setcity(String city){
        this.city=city;
    }
    public void setpropertyId(String id){
        propertyId=id;
    }

    public float getRentalAmount() {
        return rentalAmount;
    }
    public int getnoOfBedRooms() {
        return noOfBedRooms;
    }
    public String getlocation() {
        return location;
    }
    public String getcity() {
        return city;
    }
    public String getpropertyId() {
        return propertyId;
    }
}
