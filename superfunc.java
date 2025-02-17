public class superfunc {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}

class Parent {
    String name;
    Parent(String name) {
        this.name = name;
        System.out.println("Parent class parameterized constructor called: " + this.name);
    }
    void display() {
        System.out.println("Parent Name: " + this.name);
    }
}

class Child extends Parent {
    int age;
     Child() {
        super("PARENT");
        this.age = 19;
        System.out.println("Child class constructor called");
    }
    void show() {
        super.display();
        System.out.println("Child Age: " + this.age);
    }
}