package com.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem;
    Object vehicle;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    public void givenParkingLot_WhenVehicleParked_shouldReturnTrue() {
        boolean isVehicleParked = parkingLotSystem.park(new Object());
        Assert.assertTrue(isVehicleParked);
    }

    @Test
    public void givenParkingLot_WhenVehicleParked_shouldUnparked() {
        parkingLotSystem.park(vehicle);
        boolean isVehicleParked = parkingLotSystem.unPark(vehicle);
        Assert.assertTrue(isVehicleParked);
    }

}
