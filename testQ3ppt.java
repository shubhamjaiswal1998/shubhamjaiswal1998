import java.util.Scanner;

public class testQ3ppt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements");
        int num = scanner.nextInt();
        int sum = 0;
        int count = 0;
           System.out.println("enter num ");
        do {
            int number = scanner.nextInt();
            sum += number;
            count++;
        } while (count < num);

        double average = (double) sum / num;
        System.out.println("The average is " + average);
    }

}
