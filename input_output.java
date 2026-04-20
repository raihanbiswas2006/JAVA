import java.util.*;

public class input_output {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give your Name: ");
        String name = scanner.nextLine();
        System.out.print("Give your Age: ");
        int age = scanner.nextInt();
        System.out.println("Hello, " + name + "! You are " + age + " Years Old.");
    }
}