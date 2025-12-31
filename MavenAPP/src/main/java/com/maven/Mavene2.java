package com.maven;

class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    void engine() {
        System.out.println("Car has an engine");
    }
}


class ElectricCar extends Car {
    void energy() {
        System.out.println("Electric car saves energy");
    }
}

public class Mavene2 {
    public static void main(String[] args) {

        ElectricCar ec = new ElectricCar();

        ec.start();   
        ec.engine();  
        ec.energy();  
    }
}


				
				
	


