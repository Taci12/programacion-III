import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        SmartPhone sm1 = new SmartPhone("hola", "hola", "chau", 345, 2);
        SmartPhone sm2 = new SmartPhone("hola", "hola", "chau", 245, 2);
        System.out.println(sm1.equals(sm2));
    }
}