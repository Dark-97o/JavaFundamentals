public class OverloadingExample{
    OverloadingExample() {
        System.out.println("Default Constructor: No parameters.");
    }

    OverloadingExample(String name) {
        System.out.println("Parameterized Constructor: Name = " + name);
    }

    OverloadingExample(String name, int age) {
        System.out.println("Parameterized Constructor: Name = " + name + ", Age = " + age);
    }

    void show() {
        System.out.println("Method with no parameters.");
    }

    void show(int num) {
        System.out.println("Method with one int parameter: " + num);
    }

    void show(String message, int count) {
        System.out.println("Method with two parameters: Message = " + message + ", Count = " + count);
    }

    public static void main(String[] args) {
        OverloadingExample obj1 = new OverloadingExample();
        OverloadingExample obj2 = new OverloadingExample("Alice");
        OverloadingExample obj3 = new OverloadingExample("Bob", 25);

        obj1.show();
        obj1.show(5);
        obj1.show("Hello", 3);
    }
}

