package com.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver{

    private Boolean parkingLotIsFull;


    public Boolean isParkingLotFull() {
        return parkingLotIsFull;
    }

    @Override
    public void parkingLotIsFull() {
        parkingLotIsFull = true;
    }

    @Override
    public void parkingLotIsEmpty() {
        parkingLotIsFull = false;
    }

    public Boolean isParkingLotEmpty() {
        return parkingLotIsFull;
    }
}
