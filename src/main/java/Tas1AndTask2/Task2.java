package Tas1AndTask2;

public class Task2 {

    public static double countFactorial(int n, int i) {
        if (i < n) {
            return countFactorial(n, i + 1) * i;
        }
        return i;
    }

    public static double calculateFunction( int n) {
        double start = 1 / countFactorial(n, 1);
        double un = 0;
        for (int i = 1; i < n + 1; i++) {
            un += countFactorial(i, 1);
        }
        return start * un;
    }

    public static void main(String[] args) {
        System.out.println(calculateFunction(170));// Результат стремится к 1(проверено на Python с использованием
                                                      // n до 50000), при значениях n
                                                      // примерно > 170 факториал не влазит в тип double
    }
}