package com.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem;
    Object vehicle;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem(2);
        vehicle = new Object();
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
            Assert.assertEquals(e.getMessage(),"Such Type Vehicle Not Found");

            }

        }

    @Test
    public void givenParkingLot_WhenAttemptToUnparkDifferentVehicle_shouldReturnFalse() {
        try {
        parkingLotSystem.park(vehicle);
        boolean isVehicleParked = false;
        isVehicleParked = parkingLotSystem.unPark(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals( "Such Type Vehicle Not Found",e.getMessage());
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
            Assert.assertEquals("Parking lot is full" , e.getMessage() );
        }
    }


}
