package com.parkinglot;

public class ParkingLotSystem {
    private int parkingLotCapacity;
    private Object vehicle;
    private int currentParkingLotSize;
    ParkingLotOwner owner;
    private AirportSecurity security;


    public ParkingLotSystem(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public void RegisterOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public void RegisterAirportSecurity(AirportSecurity security) {
        this.security = security;
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (this.currentParkingLotSize == this.parkingLotCapacity) {
            owner.parkingLotIsFull();
            security.parkingLotIsFull();
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
