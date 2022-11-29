package com.java.designpatterns;

abstract class vehicles{

	public abstract int getWheel();

	
	public String toString() {
		return "vehicles [getWheel()=" + getWheel() + "]";
	}
}

class Bike extends vehicles {

	private int wheels;
	
	public int getWheel() {
		return wheels;
	}
	public Bike(int wheels) {
		
		this.wheels = wheels ;
	}
}

class Car  extends vehicles {

	private int wheels;
	
	public int getWheel() {
		return wheels;
	}
	public Car(int wheels) {
		
		this.wheels = wheels ;
	}
}

abstract class vehicles1{

	public abstract int getWheel1();

	
	public String toString() {
		return "vehicles [getWheel()=" + getWheel1() + "]";
	}
}

class Bike1 extends vehicles1 {

	private int wheels;
	
	public int getWheel1() {
		return wheels;
	}
	public Bike1(int wheels) {
		
		this.wheels = wheels ;
	}
}

class Car1  extends vehicles1 {

	private int wheels;
	
	public int getWheel1() {
		return wheels;
	}
	public Car1(int wheels) {
		
		this.wheels = wheels ;
	}
}

abstract class abstractfactory{
	
	abstract  vehicles1 getvehicles1(String type   , int wheels)  ;
	abstract  vehicles  gevehicles  (String type   , int wheels)  ;
}

class VehicleFactor extends abstractfactory{

	
	vehicles1 getvehicles1(String type, int wheels) {
		
		return null;
	}

	
	vehicles gevehicles(String type, int wheels) {
		
		if(type.equalsIgnoreCase("Car")) {

			return new Car(wheels);
		}
		if(type.equalsIgnoreCase("Bike")) {

			return new Bike(wheels);
		}
		return null;
	}

}

class VehicleFactor1 extends abstractfactory{

	vehicles1 getvehicles1(String type, int wheels) {
		
		if(type.equalsIgnoreCase("Car")) {

			return new Car1(wheels);
		}
		if(type.equalsIgnoreCase("Bike")) {

			return new Bike1(wheels);
		}
		return null;
	}

	
	vehicles gevehicles(String type, int wheels) {
		
		return null;
	}
}

class abstractVehicleFactory{

	public static abstractfactory buildabstractVehicleFactory(String type) {

		if(type.equalsIgnoreCase("vehicle")) {

			return new VehicleFactor();
		}
		if(type.equalsIgnoreCase("vehicle1")) {

			return new VehicleFactor1();
		}
		return null;
	}
}

public class AbstractFactoryDesign {

	
	public static void main(String args[]) {

		VehicleFactor  v  = (VehicleFactor)  abstractVehicleFactory.buildabstractVehicleFactory("vehicle");
		VehicleFactor1 v1 = (VehicleFactor1) abstractVehicleFactory.buildabstractVehicleFactory("vehicle1");
		
		
		vehicles car = v.gevehicles("Car", 4);
		vehicles bike = v.gevehicles("Bike", 2);
		
		System.out.println(car);
		System.out.println(bike);
		
		vehicles1 car1 = v1.getvehicles1("Car", 4);
		vehicles1 bike1 = v1.getvehicles1("Bike", 2);
		
		System.out.println(car1);
		System.out.println(bike1);
	}
	
	//  https://pediaa.com/what-is-the-difference-between-factory-pattern-and-abstract-factory-pattern/
	
	
}
