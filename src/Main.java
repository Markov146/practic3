import java.util.Scanner;
import java.util.ArrayList;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу:");
        System.out.println("1. Array132");
        System.out.println("2. Matrix17");

        int choice = scanner.nextInt();

        if (choice == 1) {
            array132Task();
        } else if (choice == 2) {
            matrix17Task();
        } else {
            System.out.println("Неверный выбор.");
        }

        scanner.close();
    }
    public static void array132Task() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();

        // Заполните список точек вашими значениями координат x и y
        int n;
        System.out.print("Введите количество точек N: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите координату x для точки " + (i + 1) + ": ");
            int x = scanner.nextInt();
            System.out.print("Введите координату y для точки " + (i + 1) + ": ");
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        Point farthestPoint = null;
        double maxDistance = 0;

        for (Point point : points) {
            if (point.x < 0 && point.y < 0) { // Проверяем, что точка лежит во второй четверти
                double distance = point.distanceToOrigin();
                if (distance > maxDistance) {
                    maxDistance = distance;
                    farthestPoint = point;
                }
            }
            }

        if (farthestPoint != null) {
            System.out.println("Наиболее удаленная точка во второй четверти: (" + farthestPoint.x + ", " + farthestPoint.y + ")");
        } else {
            System.out.println("Во второй четверти нет точек.");
        }

        scanner.close();
    }
    public static void matrix17Task() {
        Scanner scanner = new Scanner(System.in);

        // Ввод размеров матрицы M и N
        System.out.print("Введите количество строк M: ");
        int M = scanner.nextInt();
        System.out.print("Введите количество столбцов N: ");
        int N = scanner.nextInt();

        int[][] matrix = new int[M][N];

        // Заполнение матрицы
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("Введите элемент матрицы [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Ввод номера строки K
        System.out.print("Введите номер строки K (1 ≤ K ≤ M): ");
        int K = scanner.nextInt();

        if (K >= 1 && K <= M) {
            int sum = 0;
            int product = 1;

            for (int j = 0; j < N; j++) {
                sum += matrix[K - 1][j];
                product *= matrix[K - 1][j];
            }

            System.out.println("Сумма элементов " + K + "-й строки: " + sum);
            System.out.println("Произведение элементов " + K + "-й строки: " + product);
        } else {
            System.out.println("Неверный номер строки K.");
        }

        scanner.close();
    }


}
