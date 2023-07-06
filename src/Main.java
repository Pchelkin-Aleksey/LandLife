import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите размеры острова: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        System.out.println("Введите количество дней жизни острова: ");
        in = new Scanner(System.in);
        int day = in.nextInt();
        Start start = new Start(size, day);
        start.start();
    }
}