import java.util.Scanner;

public class Main {
    public static void main()
    {
        System.out.println("Завдання 1: ");
        task1();
        System.out.println("Завдання 2: ");
        task2();
        System.out.println("Завдання 3: ");
        task3();
        System.out.println("Завдання 4: ");
        task4();
    }

    public static double calculate(double a, double b)
    {
        return (a * b - (a + b) * (a - b)) / (Math.pow(b, 4) + Math.pow(a, 3)) + 5 * b;
    }

    public static void task1 ()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть a: ");
        double a = sc.nextDouble();
        System.out.print("Введіть b: ");
        double b = sc.nextDouble();

        System.out.println("Результат (double → double): " + calculate(a, b));

        int aInt = (int) a;
        int bInt = (int) b;
        System.out.println("Результат (int → double): " + calculate(aInt, bInt));

        System.out.println("Результат (double → int): " + (int) calculate(a, b));



    }
    public static void task2 ()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть n (n <= 200): ");
        int n = sc.nextInt();

        if (n > 200 || n <= 0) {
            System.out.println("Некоректне значення n!");
            return;
        }

        double[] A = new double[2 * n];

        System.out.println("Введіть " + (2 * n) + " елементів масиву:");
        for (int i = 0; i < 2 * n; i++) {
            A[i] = sc.nextDouble();
        }

        double sumFirstHalf = 0;
        for (int i = 0; i < n; i++) {
            sumFirstHalf += A[i];
        }
        double avg = sumFirstHalf / n;

        double sumSecondHalf = 0;
        for (int i = n; i < 2 * n; i++) {
            if (A[i] > avg) {
                sumSecondHalf += A[i];
            }
        }

        // Вивід результату
        System.out.println("Середнє перших n елементів: " + avg);
        System.out.println("Сума чисел другої половини > середнього: " + sumSecondHalf);



    }
    public static void task3 ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть n (n <= 20): ");
        int n = sc.nextInt();

        if (n > 20 || n <= 0) {
            System.out.println("Некоректне значення n!");
            return;
        }

        double[][] A = new double[n][n];
        double[] B = new double[n];

        System.out.println("Введіть елементи матриці " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += A[i][j];
            }
            B[i] = sum / n;
        }

        System.out.println("Вектор B:");
        for (int i = 0; i < n; i++) {
            System.out.print(B[i] + " ");
        }


    }

    public static String processWord(String word) {
        if (word.isEmpty()) return word;

        char first = word.charAt(0);
        char firstLower = Character.toLowerCase(first);

        StringBuilder result = new StringBuilder();
        result.append(first);

        char prevAppended = first; // останній доданий символ (для згортання дубліката)

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);

            // пропускаємо всі входження першої літери (без регістру)
            if (Character.toLowerCase(c) == firstLower) continue;

            // якщо поточний символ однаковий з останнім доданим (без регістру) — пропускаємо
            if (Character.toLowerCase(c) == Character.toLowerCase(prevAppended)) continue;

            result.append(c);
            prevAppended = c;
        }

        return result.toString();
    }

    public static void task4 ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст:");
        String text = sc.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                currentWord.append(c); // збираємо слово
            } else {
                // кінець слова — обробляємо і додаємо розділові символи як є
                if (!currentWord.isEmpty()) {
                    result.append(processWord(currentWord.toString()));
                    currentWord.setLength(0);
                }
                result.append(c); // пробіл або розділовий знак
            }
        }

        // останнє слово, якщо є
        if (!currentWord.isEmpty()) {
            result.append(processWord(currentWord.toString()));
        }

        System.out.println("Результат:");
        System.out.println(result);
        sc.close();
    }
}
