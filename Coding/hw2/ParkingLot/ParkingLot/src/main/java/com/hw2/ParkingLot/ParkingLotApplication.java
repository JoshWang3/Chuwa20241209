package com.hw2.ParkingLot;

import com.hw2.ParkingLot.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {
	public class Main {
		public static void main(String[] args) {
			SpringApplication.run(ParkingLotApplication.class, args);

			ParkingLot parkingLot = new ParkingLot(3, 10); // 3 levels, 10 spots each

			Vehicle car1 = new Car("ABC123");
			Vehicle truck1 = new Truck("XYZ789");
			Vehicle motorcycle1 = new Motorcycle("MNO456");

			parkingLot.parkVehicle(car1);
			parkingLot.parkVehicle(truck1);
			parkingLot.parkVehicle(motorcycle1);

			parkingLot.releaseVehicle(1, 1); // Release car from level 1, spot 1
		}
	}
}
