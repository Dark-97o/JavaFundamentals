import java.util.Scanner;

class Vehicle {
    void run() {
        System.out.println("The vehicle is running.");
    }
}

class Car extends Vehicle {
    @Override
    void run() {
        System.out.println("The car is running on four wheels.");
    }
}

class Bike extends Vehicle {
    @Override
    void run() {
        System.out.println("The bike is running on two wheels.");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        myVehicle.run();

        Vehicle myCar = new Car();
        myCar.run();

        Vehicle myBike = new Bike();
        myBike.run();
    }
}

