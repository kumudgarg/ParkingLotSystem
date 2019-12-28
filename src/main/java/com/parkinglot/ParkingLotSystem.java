package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ParkingLotSystem {
    private int parkingLotCapacity;
    List<ParkingLotObserver> parkingLotObserver;
    private List<Object> vehicles;
    Map<Integer,Object> vehicleSlotMap = new HashMap<>();

    public ParkingLotSystem(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
        parkingLotObserver = new ArrayList();
        vehicles = new ArrayList<>();
    }

     public void RegisterObserver(ParkingLotObserver owner) {
        parkingLotObserver.add(owner);
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.parkingLotCapacity) {
            for ( ParkingLotObserver observer : parkingLotObserver )
                observer.parkingLotIsFull();
            throw new ParkingLotException("Parking lot is full");
        }
        vehicles.add(vehicle);
        return true;
    }


    private void park(int slot, Object vehicle) throws ParkingLotException {
        if (this.vehicleSlotMap.size() == this.parkingLotCapacity) {
            for ( ParkingLotObserver observer : parkingLotObserver )
                observer.parkingLotIsFull();
            throw new ParkingLotException("Parking lot is full");
        }
        vehicleSlotMap.put(slot,vehicle);
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

    public ParkingLotAttendant getParkingLotAttendant(ParkingLotAttendant attendantWithVehicle) throws ParkingLotException {

        ParkingLotOwner parkingLotOwner = (ParkingLotOwner) parkingLotObserver.get(0);
        park(parkingLotOwner.getParkingSlot(),attendantWithVehicle.getVehicle());
        return attendantWithVehicle;
    }

    public ParkingLotAttendant getMyVehicle(ParkingLotAttendant parkingLotAttendant) throws ParkingLotException {
        if( vehicleSlotMap.containsValue(parkingLotAttendant.getVehicle()))
            return parkingLotAttendant;
        throw new ParkingLotException("Such Type of Attendant Not Found");

    }
}
