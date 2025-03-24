import java.util.Scanner;

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Single-Level & Multi-Level Inheritance:");
        Puppy myPuppy = new Puppy();
        myPuppy.eat();
        myPuppy.bark();
        myPuppy.weep();


        System.out.println("Hierarchical Inheritance:");
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();

    }
}

class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("The puppy weeps.");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("The cat meows.");
    }
}


