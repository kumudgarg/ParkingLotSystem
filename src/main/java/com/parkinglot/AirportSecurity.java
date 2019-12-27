package com.parkinglot;

public class AirportSecurity implements ParkingLotObserver{

    private Boolean parkingLotIsFull;


    public Boolean isParkingLotFull() {
        return parkingLotIsFull;
    }

    public void parkingLotIsFull() {
        parkingLotIsFull = true;
    }
}
