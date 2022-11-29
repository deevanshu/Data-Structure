package com.java.designpatterns;

abstract class vehicless{

	public abstract int getWheel();

	@Override
	public String toString() {
		return "vehicless [getWheel()=" + getWheel() + "]";
	}
}

class Bikess extends vehicless{

	int wheel;
	@Override
	public int getWheel() {

		return this.wheel;
	}
	public Bikess(int wheel) {

		this.wheel=wheel;	
	}
}

class Carss extends vehicless{

	int wheel;
	@Override
	public int getWheel() {

		return this.wheel;
	}
	public Carss(int wheel) {

		this.wheel=wheel;	
	}
}

class VehicleFactory{

	public static vehicless buildVehicleFactory(String type , int wheel) {

		if(type.equalsIgnoreCase("Carss")) {

			return new Carss(wheel);
		}
		if(type.equalsIgnoreCase("Bikess")) {

			return new Bikess(wheel);
		}
		return null;
	}
}

public class FactoryDesign {
	public static void main(String args[]) {

		vehicless car = VehicleFactory.buildVehicleFactory("Carss", 4);
		vehicless bike = VehicleFactory.buildVehicleFactory("Bikess", 2);
		
		System.out.println(car);
		System.out.println(bike);
	}
}