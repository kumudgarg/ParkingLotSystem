package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    private int parkingLotCapacity;
    private Object vehicle;
    private int currentParkingLotSize;
    List<ParkingLotObserver> parkingLotObserver;
    private List<Object> vehicles;

    public ParkingLotSystem(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
        parkingLotObserver = new ArrayList();
        vehicles = new ArrayList<>();
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
        vehicles.add(vehicle);
        currentParkingLotSize++;
        return true;
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null ) return false;
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            for ( ParkingLotObserver observer : parkingLotObserver )
                observer.parkingLotIsEmpty();
        }
        return true;
    }
}
