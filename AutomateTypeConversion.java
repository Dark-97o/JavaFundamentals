package Lab3;

public class AutomateTypeConversion {
    void show(double a) {
        System.out.println("Double method called: " + a);
    }

    public static void main(String[] args) {
        AutomateTypeConversion obj = new AutomateTypeConversion();
        obj.show(10);
        obj.show(10.5);
        obj.show('A');
    }
}
