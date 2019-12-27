package com.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem;
    Object vehicle;
    ParkingLotOwner owner;
    AirportSecurity security = new AirportSecurity();

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem(2);
        vehicle = new Object();
        owner = new ParkingLotOwner();
    }

    @Test
    public void givenParkingLot_WhenVehicleParked_shouldReturnTrue() {
        try {
            boolean isVehicleParked = parkingLotSystem.park(new Object());
            Assert.assertTrue(isVehicleParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLot_WhenVehicleParked_shouldUnparked() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isVehicleParked = false;
            isVehicleParked = parkingLotSystem.unPark(vehicle);
            Assert.assertTrue(isVehicleParked);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenParkingLot_WhenVehicleIsNotParked_shouldReturnFalse() {
        try {
            boolean isVehicleParked = false;
            isVehicleParked = parkingLotSystem.unPark(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(e.getMessage(), "Such Type Vehicle Not Found");
        }
    }

    @Test
    public void givenParkingLot_WhenAttemptToUnparkDifferentVehicle_shouldReturnFalse() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isVehicleParked = false;
            isVehicleParked = parkingLotSystem.unPark(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Such Type Vehicle Not Found", e.getMessage());
        }
    }

    @Test
    public void givenParkingLot_WhenParkingLotGetFull_ShouldThrowException() {
        try {
            parkingLotSystem.park(vehicle);
            Object vehicle2 = new Object();
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", e.getMessage());
        }
    }

    @Test
    public void givenParkingLot_WhenParkingLotGetFull_ShouldInformOwner() {
        Boolean asd;
        try {
            parkingLotSystem.RegisterOwner(owner);
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle);
            asd = owner.isParkingLotFull();
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
        }
        asd = owner.isParkingLotFull();
        Assert.assertTrue(asd);
    }

    @Test
    public void givenParkingLot_WhenParkingLotGetFull_ShouldInformAirportSecurity() {
        Boolean asd;
        try {
            parkingLotSystem.RegisterOwner(owner);
            parkingLotSystem.RegisterAirportSecurity(security);
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle);
            asd = owner.isParkingLotFull();
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
        }
        asd = owner.isParkingLotFull();
        boolean asdf = security.isParkingLotFull();
        Assert.assertTrue(asd && asdf);
    }

}
