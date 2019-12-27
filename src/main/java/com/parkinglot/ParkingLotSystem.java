package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    private int parkingLotCapacity;
    private Object vehicle;
    private int currentParkingLotSize;
    List<ParkingLotObserver> parkingLotObserver;

    public ParkingLotSystem(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
        parkingLotObserver = new ArrayList();
    }

     public void RegisterObserver(ParkingLotObserver owner) {
        parkingLotObserver.add(owner);
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (this.currentParkingLotSize == this.parkingLotCapacity) {
            for ( ParkingLotObserver observer : parkingLotObserver )
                observer.parkingLotIsFull();
            throw new ParkingLotException("Parking lot is full");
        }
        this.vehicle = vehicle;
        currentParkingLotSize++;
        return true;
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (this.vehicle != null && this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        throw new ParkingLotException("Such Type Vehicle Not Found");
    }
}
