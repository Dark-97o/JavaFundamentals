public class thisfunction{
    public static void main(String[] args) {
        Something s1 = new Something();
        Something s2 = new Something("Manas", 19);
    }
}

class Something{
    String name;
    int age;
    Something(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Name: " + name + "\nAge: " + age);
        System.out.println("Parameterized constructor called");
    }
    Something(){
        this("Subhranil", 20);
        System.out.println("Default constructor called");
    }
}