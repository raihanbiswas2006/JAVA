import java.util.*;

public class input_output {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give your name: ");
        String name = scanner.nextLine();
        System.out.print("Give your age: ");
        int age = scanner.nextInt();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }
}