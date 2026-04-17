import java.util.Scanner;

public class sum_and_average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum = sum + a[i];
        }

        double avg = sum / (double) n;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}