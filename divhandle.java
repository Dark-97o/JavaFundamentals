public class divhandle {
    void div(int a, int b) {
        try {
            int c = a / b;
            System.out.println("Division: " + c);
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    public static void main(String[] args) {
        divhandle obj = new divhandle();
        obj.div(10, 2);
        obj.div(20,5);
        obj.div(0,10);
        obj.div(5,0);
        obj.div(30,10);
    }
}
